package onePiece.devilFruits;

import java.util.ArrayList;
import java.util.Iterator;

import necesse.engine.commands.CommandLog;
import necesse.engine.network.client.Client;
import necesse.engine.network.server.Server;
import necesse.engine.network.server.ServerClient;
import necesse.entity.mobs.hostile.*;
import necesse.inventory.InventoryItem;
import necesse.inventory.item.Item;
import necesse.inventory.item.toolItem.ToolItem;
import necesse.inventory.lootTable.lootItem.LootItem;
import necesse.inventory.recipe.Tech;
import onePiece.devilFruits.devilFruitAbilitiesHolder.*;

import static onePiece.ModInitiation.DEVILFRUITSTATION;
//import devilFruits.DevilFruitAbilities;

public class FireFruit extends DevilFruit
{
    ArrayList<ToolItem> abilities;

    public FireFruit(Client client, ServerClient serverClient)
    {
        super("Fire Fruit");
        abilities = new ArrayList<ToolItem>();
        abilities.add(new FireFist(10, Item.Rarity.EPIC, 2, 2, 1, 100, this));
        abilities.add(new FireSpear(25, Item.Rarity.EPIC, 2, 3, 2, 150, this));
    }
    public FireFruit(ArrayList<ToolItem> a)
    {
        super("Fire Fruit");
        this.abilities = a;
    }

    public ArrayList<ToolItem> getAbilities() { return abilities; }
    public void addAbility(ToolItem ability) { abilities.add(ability); }
    //PRECONDITION: index is a valid index in unlockedAbilities.
    public void removeAbility(int index) { abilities.remove(index); }
    public void setAbilities(ArrayList<ToolItem> a) { abilities = a; }

    public Tech[] replaceCraftingTechs(Tech newTechs)
    {
        DEVILFRUITSTATION = newTechs;
        return new Tech[]{DEVILFRUITSTATION};
    }
}