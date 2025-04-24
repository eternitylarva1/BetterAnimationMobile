package Helper;

import com.badlogic.gdx.math.Vector2;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.core.Settings;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.relics.AbstractRelic;
import com.megacrit.cardcrawl.vfx.AbstractGameEffect;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class GeneralHelper {
  private static final Logger logger = LogManager.getLogger(GeneralHelper.class);
  
  public static void addToBot(AbstractGameAction action) {
    AbstractDungeon.actionManager.addToBottom(action);
  }
  
  public static void addToTop(AbstractGameAction action) {
    AbstractDungeon.actionManager.addToTop(action);
  }
  
  public static void addEffect(AbstractGameEffect effect) {
    AbstractDungeon.effectList.add(effect);
  }
  
  public static void addEffectQueue(AbstractGameEffect effect) {
    AbstractDungeon.effectsQueue.add(effect);
  }
  
  public static void GainRelic(AbstractRelic r) {
    AbstractDungeon.player.relics.add(r);
    r.onEquip();
    AbstractDungeon.player.reorganizeRelics();
  }
  
  public static boolean isAlive(AbstractCreature c) {
    return (c != null && !c.isDeadOrEscaped() && !c.isDead);
  }
  
  public static void info(String s) {
    logger.info(s);
  }
  
  public static AbstractCard makeStatEquivalentCopy(AbstractCard c) {
    AbstractCard card = c.makeStatEquivalentCopy();
    card.retain = c.retain;
    card.selfRetain = c.selfRetain;
    card.purgeOnUse = c.purgeOnUse;
    card.isEthereal = c.isEthereal;
    card.exhaust = c.exhaust;
    card.glowColor = c.glowColor;
    card.rawDescription = c.rawDescription;
    card.cardsToPreview = c.cardsToPreview;
    card.initializeDescription();
    return card;
  }
  
  public static AbstractMonster getRandomMonsterSafe() {
    AbstractMonster m = AbstractDungeon.getRandomMonster();
    if (m != null && !m.isDeadOrEscaped() && !m.isDead)
      return m; 
    return null;
  }
  
  public static float CreateEffectRatio(float duration, float start) {
    return Math.abs(duration / start * 2.0F - 1.0F);
  }
  
  public static Vector2 GetMonsterPosition() {
    return new Vector2(Settings.WIDTH * 0.75F, AbstractDungeon.floorY);
  }
}
