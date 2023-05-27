package onePiece.DevilFruitStation;

import necesse.engine.localization.Localization;
import necesse.engine.registries.ContainerRegistry;
import necesse.engine.registries.ObjectRegistry;
import necesse.engine.tickManager.TickManager;
import necesse.entity.mobs.PlayerMob;
import necesse.gfx.camera.GameCamera;
import necesse.gfx.drawOptions.DrawOptionsList;
import necesse.gfx.drawables.LevelSortedDrawable;
import necesse.gfx.drawables.OrderableDrawables;
import necesse.gfx.gameTexture.GameTexture;
import necesse.inventory.container.object.CraftingStationContainer;
import necesse.inventory.item.toolItem.ToolType;
import necesse.inventory.recipe.Recipe;
import necesse.inventory.recipe.Tech;
import necesse.level.gameObject.CraftingStationObject;
import necesse.level.maps.Level;
import necesse.level.maps.light.GameLight;
import necesse.level.maps.multiTile.MultiTile;
import necesse.level.maps.multiTile.SideMultiTile;
import java.awt.Rectangle;
import java.util.List;
import java.awt.Color;

import static onePiece.ModInitiation.DEVILFRUITSTATION;

public class DevilFruitStationObject extends CraftingStationObject
{
    protected int otherID;

    public GameTexture t;

    public DevilFruitStationObject()
    {
        super(new Rectangle(4, 4, 24, 24));
        toolType = ToolType.ALL;
        isLightTransparent = true;
        mapColor = new Color(150, 119, 70);
        drawDmg = false;
    }

    @Override
    public MultiTile getMultiTile(int rotation) { return new SideMultiTile(0, 1, 1, 2, rotation, true); }

    @Override
    public int getPlaceRotation(Level level, int levelX, int levelY, PlayerMob player, int playerDr)
    {
        return Math.floorMod(super.getPlaceRotation(level, levelX, levelY, player, playerDr) - 1, 4);
    }

    @Override
    public Rectangle getCollision(Level level, int x, int y, int rotation)
    {
        if (rotation == 0) return new Rectangle(x * 32 + 4, y * 32, 24, 26);
        if (rotation == 1) return new Rectangle(x * 32 + 6, y * 32 + 6, 26, 20);
        if (rotation == 2) return new Rectangle(x * 32 + 4, y * 32 + 4, 24, 28);

        return new Rectangle(x * 32, y * 32 + 6, 26, 20);
    }

    @Override
    public void loadTextures()
    {
        super.loadTextures();
        //TODO need to load texture here.

    }

    @Override
    public void addDrawables(List<LevelSortedDrawable> list, OrderableDrawables tileList, Level level, int tileX, int tileY, TickManager tickManager, GameCamera camera, PlayerMob perspective)
    {
        GameLight light = level.getLightLevel(tileX, tileY);
        int drawX = camera.getTileDrawX(tileX);
        int drawY = camera.getTileDrawY(tileY);
        int rotation = level.getObjectRotation(tileX, tileY);
        final DrawOptionsList options = new DrawOptionsList();

        if (rotation == 0) options.add(t.initDraw().sprite(1, 4, 32).light(light).pos(drawX, drawY));
        else if (rotation == 1)
        {
            options.add(t.initDraw().sprite(0, 0, 32).light(light).pos(drawX, drawY - 32));
            options.add(t.initDraw().sprite(0, 1, 32).light(light).pos(drawX, drawY));
        }
        else if (rotation == 2)
        {
            options.add(t.initDraw().sprite(0, 2, 32).light(light).pos(drawX, drawY - 32));
            options.add(t.initDraw().sprite(0, 3, 32).light(light).pos(drawX, drawY));
        }
        else
        {
            options.add(t.initDraw().sprite(0, 0, 32).light(light).pos(drawX, drawY - 32));
            options.add(t.initDraw().sprite(0, 1, 32).light(light).pos(drawX, drawY));
        }

        list.add(new LevelSortedDrawable(this, tileX, tileY)
        {
            @Override
            public int getSortY()
            {
                return 16;
            }

            @Override
            public void draw(TickManager tickManager)
            {
                options.draw();
            }
        });
    }

    @Override
    public void drawPreview(Level level, int tileX, int tileY, int rotation, float alpha, PlayerMob player, GameCamera camera)
    {
        int drawX = camera.getTileDrawX(tileX);
        int drawY = camera.getTileDrawY(tileY);

        if (rotation == 0)
        {
            t.initDraw().sprite(1, 1, 32).alpha(alpha).draw(drawX, drawY + 2);
            t.initDraw().sprite(1, 3, 32).alpha(alpha).draw(drawX, drawY - 30);
        }
        else if (rotation == 1)
        {
            t.initDraw().sprite(0, 2, 32).alpha(alpha).draw(drawX + 32, drawY - 24);
            t.initDraw().sprite(1, 2, 32).alpha(alpha).draw(drawX, drawY - 24);
            t.initDraw().sprite(0, 3, 32).alpha(alpha).draw(drawX + 32, drawY + 8);
            t.initDraw().sprite(1, 3, 32).alpha(alpha).draw(drawX, drawY + 8);
        }
        else if (rotation == 2)
        {
            t.initDraw().sprite(0, 0, 32).alpha(alpha).draw(drawX, drawY + 2);
            t.initDraw().sprite(0, 1, 32).alpha(alpha).draw(drawX, drawY + 34);
        }
        else
        {
            t.initDraw().sprite(0, 2, 32).alpha(alpha).draw(drawX - 32, drawY - 24);
            t.initDraw().sprite(1, 2, 32).alpha(alpha).draw(drawX, drawY - 24);
            t.initDraw().sprite(0, 3, 32).alpha(alpha).draw(drawX - 32, drawY + 8);
            t.initDraw().sprite(1, 3, 32).alpha(alpha).draw(drawX, drawY + 8);
        }
    }

    @Override
    public String getInteractTip(Level level, int x, int y, PlayerMob player, boolean debug)
    {
        return Localization.translate("controls", "opentip");
    }

    @Override
    public boolean canInteract(Level level, int x, int y, PlayerMob player) { return true; }

    @Override
    public void interact(Level level, int x, int y, PlayerMob player)
    {
        if (level.isServerLevel())
        {
            CraftingStationContainer.openAndSendContainer(ContainerRegistry.CRAFTING_STATION_CONTAINER, player.getServerClient(), level, x, y);
        }
    }

    public boolean isProcessingInventory(Level level, int x, int y)
    {
        return true;
    }

    public int getMaxCraftsAtOnce(Level level, int x, int y, Recipe recipe)
    {
        return 1;
    }

    public boolean canCurrentlyCraft(Level level, int x, int y, Recipe recipe)
    {
        return true;
    }

    public Tech[] getCraftingTechs()
    {
        return new Tech[]{DEVILFRUITSTATION};
    }

    /* @Override
    public ListGameTooltips getItemTooltips(InventoryItem item, PlayerMob perspective)
    {
        ListGameTooltips list = super.getItemTooltips(item, perspective);
        list.add(Localization.translate("ui", "Devil Fruit Ability Station"));
        return list;
    }*/

    public static int registerDevilFruitAbilityStation()
    {
        DevilFruitStationObject d = new DevilFruitStationObject();
        d.otherID = ObjectRegistry.registerObject("Devil Fruit Ability Station", d, 0.0F, true);
        return d.otherID;
    }
}
