package onePiece.Items;

import necesse.entity.mobs.PlayerMob;
import necesse.inventory.InventoryItem;
import necesse.inventory.item.placeableItem.consumableItem.food.FoodConsumableItem;
import necesse.inventory.item.toolItem.ToolItem;
import necesse.inventory.recipe.Ingredient;
import necesse.inventory.recipe.Recipe;
import necesse.inventory.recipe.Recipes;
import necesse.inventory.recipe.Tech;
import necesse.level.maps.Level;
import necesse.level.maps.levelData.settlementData.settler.Settler;
import onePiece.devilFruits.DevilFruit;
import onePiece.devilFruits.FireFruit;
import onePiece.devilFruits.devilFruitAbilitiesHolder.DevilFruitAbilities;
import onePiece.devilFruits.devilFruitAbilitiesHolder.FireFist;
import necesse.engine.registries.RecipeTechRegistry;
import onePiece.devilFruits.devilFruitAbilitiesHolder.FireSpear;

import java.util.ArrayList;

import static necesse.engine.registries.RecipeTechRegistry.registerTech;

public class FireFruitItem extends FoodConsumableItem
{
    public static Tech FIREFRUITTECHS;

    public void init()
    {
        super.init();

        FIREFRUITTECHS = registerTech("firefruit");

        Recipes.registerModRecipe(new Recipe("firefist", 1, FIREFRUITTECHS, new Ingredient[]{new Ingredient("firefruitpoint", 0)}));
        Recipes.registerModRecipe(new Recipe("firespear", 1, FIREFRUITTECHS, new Ingredient[]{new Ingredient("firefruitpoint", 250)}));
    }

    public FireFruitItem()
    {
        super(500, Rarity.EPIC, Settler.FOOD_SIMPLE, 0, 0);
    }

    @Override
    public boolean consume(Level level, PlayerMob player, InventoryItem item)
    {
        boolean consumed = super.consume(level, player, item);

        if (consumed && player.isServerClient())
        {
            DevilFruit.FRUIT = "FireFruit";

            ArrayList<ToolItem> abilities = new ArrayList<ToolItem>();
            FireFruit fruit = new FireFruit(abilities);
            abilities.add(new FireFist(15, Rarity.EPIC, 2, 2, 1, 100, fruit));
            fruit.setAbilities(abilities);
            abilities.add(new FireSpear(25, Rarity.EPIC, 2, 3, 2, 150, fruit));
            fruit.setAbilities(abilities);

            fruit.replaceCraftingTechs(FIREFRUITTECHS);
        }

        return consumed;
    }
}
