package onePiece.devilFruits.devilFruitAbilitiesHolder;

import necesse.engine.network.Packet;
import necesse.engine.network.PacketReader;
import necesse.engine.network.PacketWriter;
import necesse.engine.save.LoadData;
import necesse.engine.save.SaveData;
import onePiece.devilFruits.devilFruitAbilitiesHolder.*;
import onePiece.devilFruits.*;
import onePiece.DevilFruitStation.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class DevilFruitAbilitiesInfo
{
    public ArrayList<DevilFruitAbilities> abilities;

    boolean hasFruit;
    DevilFruit fruit;

    public DevilFruitAbilitiesInfo()
    {
        hasFruit = false;
        fruit = null;
        abilities = new ArrayList<DevilFruitAbilities>();
    }
    public DevilFruitAbilitiesInfo(boolean h, DevilFruit d)
    {
        hasFruit = h;
        fruit = d;
        abilities = new ArrayList<DevilFruitAbilities>();
    }

    public void addAbility(DevilFruitAbilities d)
    {
        abilities.add(d);
    }
    public void removeAbility(DevilFruitAbilities d)
    {
        abilities.remove(d);
    }

    /*public SaveData getSaveData()
    {
        SaveData save = new SaveData("DEVILFRUITABILITIESINFO");

        SaveData unlocked = new SaveData("UNLOCKED");
        for (DevilFruitAbilities d : unlockedAbilities)
        {
            SaveData abilityData = new SaveData("ABILITY");
            //TOD need to make the addSaveData() in the DevilFruitAbilities class.
            unlocked.addSaveData(abilityData);
        }

        SaveData locked = new SaveData("LOCKED");
        for (DevilFruitAbilities d : lockedAbilities)
        {
            SaveData abilityData = new SaveData("ABILITY");
            //TOD need to make the addSaveData() in the DevilFruitAbilities class.
            locked.addSaveData(abilityData);
        }

        save.addSaveData(unlocked);
        save.addSaveData(locked);

        return save;
    }
    public void applyLoadData(LoadData save)
    {
        LoadData data = save.getFirstLoadDataByName("DEVILFRUITABILITIESINFO");

        LoadData unlocked = data.getFirstLoadDataByName("UNLOCKED");
        unlockedAbilities.clear();
        for (LoadData abilityData : unlocked.getLoadDataByName("ABILITY"))
        {
            //unlockedAbilities.add()
            //TOD need to make the fromLoadData() method in the DevilFruitAbilities class.
        }

        LoadData locked = data.getFirstLoadDataByName("LOCKED");
        lockedAbilities.clear();
        for (LoadData abilityData : locked.getLoadDataByName("ABILITY"))
        {
            //lockedAbilities.add()
            //TOD need to make the fromLoadData() method in the DevilFruitAbilities class.
        }
    }*/
}
