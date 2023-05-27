package onePiece.devilFruits;

public class DevilFruit
{
    public static String FRUIT;

    String name;
    double damageUpgradeOT;
    int experience;

    public DevilFruit()
    {
        name = "None";
        damageUpgradeOT = 0.0;
        experience = 0;
    }

    public DevilFruit(String name)
    {
        this.name = name;
        damageUpgradeOT = 0.0;
        experience = 0;
    }

    public String getName() { return name; }
    public void setName(String n) { name = n; }

    public double getDamageUpgradeOT() { return damageUpgradeOT; }
    public void setDamageUpgradeOT(double d) { damageUpgradeOT = d; }

    public int getExperience() { return experience; }
    public void setExperience(int e) { experience = e; }
}