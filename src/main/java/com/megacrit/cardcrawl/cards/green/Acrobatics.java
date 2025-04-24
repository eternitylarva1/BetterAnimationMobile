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
import com.megacrit.cardcrawl.actions.common.DiscardAction;
import com.megacrit.cardcrawl.actions.common.DrawCardAction;
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

public class Acrobatics extends AbstractCard {
    public static final String ID = "Acrobatics";
    private static final CardStrings cardStrings;

    public Acrobatics() {
        super("Acrobatics", cardStrings.NAME, "green/skill/acrobatics", 1, cardStrings.DESCRIPTION, CardType.SKILL, CardColor.GREEN, CardRarity.COMMON, CardTarget.NONE);
        this.baseMagicNumber = 3;
        this.magicNumber = this.baseMagicNumber;
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        GeneralHelper.addToBot((AbstractGameAction)new VFXAction((AbstractGameEffect)new JumpEffect(p, 0.7F, 300.0F), 0.0F));
        GeneralHelper.addToBot((AbstractGameAction)new VFXAction((AbstractGameEffect)new BackFlipEffect(p, false), 0.0F));
        this.addToBot(new DrawCardAction(p, this.magicNumber));
        this.addToBot(new DiscardAction(p, p, 1, false));
    }

    public void upgrade() {
        if (!this.upgraded) {
            this.upgradeName();
            this.upgradeMagicNumber(1);
        }

    }

    public AbstractCard makeCopy() {
        return new Acrobatics();
    }

    static {
        cardStrings = CardCrawlGame.languagePack.getCardStrings("Acrobatics");
    }
}
