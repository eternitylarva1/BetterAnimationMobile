package betterAnimation;

import com.badlogic.gdx.graphics.Color;
import com.megacrit.cardcrawl.android.mods.BaseMod;
import com.megacrit.cardcrawl.android.mods.interfaces.*;
import com.megacrit.cardcrawl.rooms.AbstractRoom;

public class BetterAnimation implements EditCardsSubscriber,
        PostInitializeSubscriber,
        EditStringsSubscriber,
        EditRelicsSubscriber,
        EditKeywordsSubscriber,PostBattleSubscriber {
    public static final String MOD_ID = "BetterAnimation";
    private static final Color YELLOW_COLOR = new Color(0.98F, 0.95F, 0.05F, 1.0F);

    public static void initialize() {
        new BetterAnimation();
    }

    public BetterAnimation() {
        BaseMod.subscribe(this);
    }

    public static String makeId(String name) {
        return MOD_ID + ":" + name;
    }


    @Override
    public void receiveEditCards() {

    }



    @Override
    public void receiveEditStrings() {
    }

    @Override
    public void receiveEditRelics() {

    }

    @Override
    public void receiveEditKeywords() {

    }

    @Override
    public void receivePostBattle(AbstractRoom abstractRoom) {

    }

    @Override
    public void receivePostInitialize() {

    }
}
