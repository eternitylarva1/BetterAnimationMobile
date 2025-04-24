//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.megacrit.cardcrawl.cards.green;

import Helper.GeneralHelper;
import VFX.BackFlipEffect;
import VFX.JumpEffect;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.animations.VFXAction;
import com.megacrit.cardcrawl.actions.common.DrawCardAction;
import com.megacrit.cardcrawl.actions.common.GainBlockAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.AbstractCard.CardColor;
import com.megacrit.cardcrawl.cards.AbstractCard.CardRarity;
import com.megacrit.cardcrawl.cards.AbstractCard.CardTarget;
import com.megacrit.cardcrawl.cards.AbstractCard.CardType;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.localization.CardStrings;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.vfx.AbstractGameEffect;

public class Backflip extends AbstractCard {
    public static final String ID = "Backflip";
    private static final CardStrings cardStrings;

    public Backflip() {
        super("Backflip", cardStrings.NAME, "green/skill/backflip", 1, cardStrings.DESCRIPTION, CardType.SKILL, CardColor.GREEN, CardRarity.COMMON, CardTarget.SELF);
        this.baseBlock = 5;
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        GeneralHelper.addToBot((AbstractGameAction)new VFXAction((AbstractGameEffect)new JumpEffect(p, 0.7F, 300.0F), 0.0F));
        GeneralHelper.addToBot((AbstractGameAction)new VFXAction((AbstractGameEffect)new BackFlipEffect(p, false), 0.0F));
        this.addToBot(new GainBlockAction(p, p, this.block));
        this.addToBot(new DrawCardAction(p, 2));
    }

    public void upgrade() {
        if (!this.upgraded) {
            this.upgradeName();
            this.upgradeBlock(3);
        }

    }

    public AbstractCard makeCopy() {
        return new Backflip();
    }

    static {
        cardStrings = CardCrawlGame.languagePack.getCardStrings("Backflip");
    }
}
