package VFX;


import Helper.GeneralHelper;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.esotericsoftware.spine.BoneData;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.vfx.AbstractGameEffect;

public class WhirlWindEffect extends AbstractGameEffect {
  private float oriX;
  
  private BoneData root;
  
  private AbstractPlayer player;
  
  public WhirlWindEffect(AbstractPlayer player, float duration) {
    this.player = player;
    this.duration = duration;
    this.startingDuration = duration;
    if (player.state != null) {
      this.root = player.state.getData().getSkeletonData().findBone("root");
      if (this.root != null)
        this.oriX = this.root.getScaleX(); 
    } 
  }
  
  public WhirlWindEffect(AbstractPlayer player) {
    this(player, 0.2F);
  }
  
  public void update() {
    this.duration -= Gdx.graphics.getDeltaTime();
    if (this.duration <= 0.0F) {
      this.isDone = true;
      if (this.root != null)
        this.root.setScaleX(this.oriX); 
      return;
    } 
    if (this.player.state != null) {
      this.root = this.player.state.getData().getSkeletonData().findBone("root");
      float ratio = GeneralHelper.CreateEffectRatio(this.duration, this.startingDuration) * 2.0F - 1.0F;
      this.root.setScaleX(ratio);
    } 
  }
  
  public void render(SpriteBatch spriteBatch) {}
  
  public void dispose() {}
}
