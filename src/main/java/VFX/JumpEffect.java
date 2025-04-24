package VFX;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Interpolation;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.vfx.AbstractGameEffect;

public class JumpEffect extends AbstractGameEffect {
  private AbstractPlayer player;
  
  private float height;
  
  private float oriY;
  
  public JumpEffect(AbstractPlayer player, float duration, float height) {
    this.player = player;
    this.height = height;
    this.startingDuration = this.duration = duration;
    this.oriY = player.animY;
  }
  
  public void update() {
    this.duration -= Gdx.graphics.getDeltaTime();
    if (this.duration <= 0.0F) {
      this.isDone = true;
      this.player.animY = this.oriY;
      return;
    } 
    float tmp = this.duration / this.startingDuration * 2.0F - 1.0F;
    if (tmp > 0.0F) {
      this.player.animY = this.oriY + Interpolation.exp10In.apply(0.0F, this.height, 1.0F - tmp);
    } else {
      this.player.animY = this.oriY + Interpolation.exp10Out.apply(0.0F, this.height, 1.0F + tmp);
    } 
  }
  
  public void render(SpriteBatch spriteBatch) {}
  
  public void dispose() {}
}
