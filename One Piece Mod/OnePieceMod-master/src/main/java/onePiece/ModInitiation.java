package onePiece;

import necesse.engine.Settings;
import necesse.engine.network.client.Client;
import necesse.engine.network.server.Server;
import necesse.engine.network.server.ServerClient;
import necesse.inventory.item.Item;
import necesse.inventory.item.toolItem.ToolItem;
import onePiece.devilFruits.devilFruitAbilitiesHolder.*;
import onePiece.devilFruits.*;
import onePiece.DevilFruitStation.*;
import necesse.engine.GameEventListener;
import necesse.engine.GameEvents;
import necesse.engine.commands.CommandsManager;
import necesse.engine.events.worldGeneration.GeneratedCaveOresEvent;
import necesse.engine.modLoader.annotations.ModEntry;
import necesse.engine.registries.*;
import necesse.entity.mobs.HumanTextureFull;
import necesse.entity.mobs.friendly.human.humanShop.GunsmithHumanMob;
import necesse.gfx.gameTexture.GameTexture;
import necesse.inventory.recipe.Ingredient;
import necesse.inventory.recipe.Recipe;
import necesse.inventory.recipe.Recipes;
import necesse.inventory.recipe.Tech;
import necesse.level.gameObject.ProcessingForgeObject;
import necesse.level.gameObject.RockObject;
import necesse.level.gameObject.RockOreObject;
import necesse.level.maps.biomes.Biome;
import necesse.level.maps.biomes.forest.ForestBiome;
import necesse.level.maps.levelData.settlementData.settler.GenericSettler;
import necesse.level.maps.levelData.settlementData.settler.MageSettler;
import necesse.level.maps.levelData.settlementData.settler.Settler;
import java.util.ArrayList;

import static necesse.engine.registries.RecipeTechRegistry.registerTech;

@ModEntry
public class ModInitiation
{
    public static Tech DEVILFRUITSTATION;

    public void init()
    {
        DEVILFRUITSTATION = registerTech("devilfruitstation");

        ArrayList<ToolItem> abilities = new ArrayList<ToolItem>();
        FireFruit fruit = new FireFruit(abilities);
        abilities.add(new FireFist(15, Item.Rarity.EPIC, 2, 2, 1, 100, fruit));
        fruit.setAbilities(abilities);
        abilities.add(new FireSpear(25, Item.Rarity.EPIC, 2, 3, 2, 150, fruit));
        fruit.setAbilities(abilities);

        DevilFruitStationObject.registerDevilFruitAbilityStation();
    }

    public void postInit()
    {
        System.out.println("fortnite raid boss");
    }
}