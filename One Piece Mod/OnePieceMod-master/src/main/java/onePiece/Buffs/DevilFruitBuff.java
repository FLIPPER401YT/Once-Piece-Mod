package onePiece.Buffs;

import necesse.engine.localization.Localization;
import necesse.engine.localization.message.GameMessage;
import necesse.engine.localization.message.StaticMessage;
import necesse.entity.mobs.buffs.ActiveBuff;
import necesse.entity.mobs.buffs.staticBuffs.Buff;
import necesse.gfx.gameTooltips.ListGameTooltips;
import onePiece.devilFruits.devilFruitAbilitiesHolder.DevilFruitAbilities;

public class DevilFruitBuff extends Buff
{
    protected GameMessage displayName;

    public DevilFruitBuff()
    {
        this.canCancel = true;
        this.isVisible = true;
        this.shouldSave = true;
    }

    @Override
    public void init(ActiveBuff activeBuff)
    {
        this.canCancel = false;
        this.overrideSync = true;
        this.displayName = new StaticMessage("FireFruit");
    }

    /*@Override
    public ListGameTooltips getTooltip(ActiveBuff activeBuff)
    {
        ListGameTooltips tooltips = super.getTooltip(activeBuff);
        tooltips.add(Localization.translate("buff", "devilfruitindicatortooltip"));
        return tooltips;
    }*/
}
