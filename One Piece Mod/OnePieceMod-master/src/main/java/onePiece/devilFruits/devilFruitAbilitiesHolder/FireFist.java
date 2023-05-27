package onePiece.devilFruits.devilFruitAbilitiesHolder;

import necesse.engine.network.PacketReader;
import necesse.entity.levelEvent.toolItemEvent.ToolItemEvent;
import necesse.entity.mobs.PlayerMob;
import necesse.inventory.InventoryItem;
import necesse.inventory.PlayerInventorySlot;
import necesse.inventory.item.Item;
import necesse.inventory.item.toolItem.spearToolItem.CustomSpearToolItem;
import necesse.level.maps.Level;
import onePiece.Items.FireFruitPoints;
import onePiece.devilFruits.FireFruit;

public class FireFist extends CustomSpearToolItem
{
    String name;
    FireFruit fruit;

    public FireFist(int d, Item.Rarity rarity, int animSpeed, int range, int knockBack, int enchantCost, FireFruit f)
    {
        super(rarity, animSpeed, d, range, knockBack, enchantCost);

        name = "Fire Fist";
        fruit = f;
    }

    public InventoryItem onAttack(Level level, int x, int y, PlayerMob player, int attackHeight, InventoryItem item, PlayerInventorySlot slot, int animAttack, int seed, PacketReader contentReader)
    {
        if (animAttack == 0)
        {
            int animSpeed = this.getAnimSpeed(item, player);
            ToolItemEvent event = new ToolItemEvent(player, seed, item, x - player.getX(), y - player.getY() + attackHeight, animSpeed, animSpeed / 2);
            level.entityManager.addLevelEventHidden(event);

            // Adds an experience point item to the inventory.
            Item experience = new FireFruitPoints();
            InventoryItem inventoryItem = experience.getDefaultItem(player, 2);
            player.getInv().addItem(inventoryItem, true, "give", null);
        }

        return item;
    }
}
