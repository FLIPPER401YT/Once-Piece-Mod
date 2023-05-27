package onePiece.ModControls;

import necesse.engine.control.*;
import necesse.engine.localization.message.*;

public class Controls
{
    public static boolean isControlsLoaded;
    public static Control DEVIL_FRUIT_MENU;

    public static void loadControls()
    {
        if (!isControlsLoaded)
        {
            Control.ControlGroup ONE_PIECE_MOD = new Control.ControlGroup(7, new LocalMessage("controls", "grouponepiecemod"));
            DEVIL_FRUIT_MENU = Control.addModControl(new Control(84, "devilfruitmenu"));
        }
    }
}
