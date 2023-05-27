package onePiece.devilFruits.devilFruitAbilitiesHolder;

import necesse.engine.save.SaveData;

public class DevilFruitAbilities
{
    public static String FRUIT;
    public static boolean HASFRUIT;

    public int id;

    private String name;
    private float damage;
    private int numAttacks;

    public DevilFruitAbilities()
    {
        name = "Ability";
        damage = 0;
        numAttacks = 0;
    }
    public DevilFruitAbilities(String name, float damage)
    {
        this.name = name;
        this.damage = damage;
        numAttacks = 0;
    }

    public String getName() { return name; }
    public void setName(String n) { name = n; }

    public float getDamage() { return damage; }
    public void setDamage(float d) { damage = d; }

    public int getNumAttacks() { return numAttacks; }
    public void setNumAttacks(int n) { numAttacks = n; }
    public void addAttack() { numAttacks++; }

    public void addSaveData(SaveData data)
    {
        data.addInt("id", id);
        if (damage == 0) data.addInt("damage", -1);
        else
        {
            data.addInt("damage", 1);
            //data.addSafeString("damage", );
        }
    }
}