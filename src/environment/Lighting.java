package environment;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.RadialGradientPaint;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import main.GamePanel;

public class Lighting {
   GamePanel gp;
   BufferedImage darknessFilter;
   public int dayCounter;
   public float filterAlpha = 0.0F;
   public final int day = 0;
   public final int dusk = 1;
   public final int night = 2;
   public final int dawn = 3;
   public int dayState = 0;

   public Lighting(GamePanel gp) {
      this.gp = gp;
      this.setLightSource();
   }

   public void setLightSource() {
      this.gp.getClass();
      this.gp.getClass();
      this.darknessFilter = new BufferedImage(960, 576, 2);
      Graphics2D g2 = (Graphics2D)this.darknessFilter.getGraphics();
      if (this.gp.player.currentLight == null) {
         g2.setColor(new Color(0.0F, 0.0F, 0.1F, 0.96F));
      } else {
         int var10000 = this.gp.player.screenX;
         this.gp.getClass();
         int centerX = var10000 + 48 / 2;
         var10000 = this.gp.player.screenY;
         this.gp.getClass();
         int centerY = var10000 + 48 / 2;
         Color[] color = new Color[12];
         float[] fraction = new float[12];
         color[0] = new Color(0.0F, 0.0F, 0.1F, 0.1F);
         color[1] = new Color(0.0F, 0.0F, 0.1F, 0.42F);
         color[2] = new Color(0.0F, 0.0F, 0.1F, 0.52F);
         color[3] = new Color(0.0F, 0.0F, 0.1F, 0.61F);
         color[4] = new Color(0.0F, 0.0F, 0.1F, 0.69F);
         color[5] = new Color(0.0F, 0.0F, 0.1F, 0.76F);
         color[6] = new Color(0.0F, 0.0F, 0.1F, 0.82F);
         color[7] = new Color(0.0F, 0.0F, 0.1F, 0.87F);
         color[8] = new Color(0.0F, 0.0F, 0.1F, 0.91F);
         color[9] = new Color(0.0F, 0.0F, 0.1F, 0.92F);
         color[10] = new Color(0.0F, 0.0F, 0.1F, 0.93F);
         color[11] = new Color(0.0F, 0.0F, 0.1F, 0.94F);
         fraction[0] = 0.0F;
         fraction[1] = 0.4F;
         fraction[2] = 0.5F;
         fraction[3] = 0.6F;
         fraction[4] = 0.65F;
         fraction[5] = 0.7F;
         fraction[6] = 0.75F;
         fraction[7] = 0.8F;
         fraction[8] = 0.85F;
         fraction[9] = 0.9F;
         fraction[10] = 0.95F;
         fraction[11] = 1.0F;
         //RadialGradientPaint gPaint = new RadialGradientPaint((float)centerX, (float)centerY, (float)this.gp.player.currentLight.lightRadius, fraction, color);
         //g2.setPaint(gPaint);
      }

      this.gp.getClass();
      this.gp.getClass();
      g2.fillRect(0, 0, 960, 576);
      g2.dispose();
   }

   public void resetDay() {
      this.dayState = 0;
      this.filterAlpha = 0.0F;
   }

   public void update() {
      if (this.gp.player.lightUpdated) {
         this.setLightSource();
         this.gp.player.lightUpdated = false;
      }

      if (this.dayState == 0) {
         ++this.dayCounter;
         if (this.dayCounter > 3600) {
            this.dayState = 1;
            this.dayCounter = 0;
         }
      }

      if (this.dayState == 1) {
         this.filterAlpha += 5.0E-4F;
         if (this.filterAlpha > 1.0F) {
            this.filterAlpha = 1.0F;
            this.dayState = 2;
         }
      }

      if (this.dayState == 2) {
         ++this.dayCounter;
         if (this.dayCounter > 3600) {
            this.dayState = 3;
            this.dayCounter = 0;
         }
      }

      if (this.dayState == 3) {
         this.filterAlpha -= 5.0E-4F;
         if (this.filterAlpha < 0.0F) {
            this.filterAlpha = 0.0F;
            this.dayState = 0;
         }
      }

   }

   public void draw(Graphics2D g2) {
      int var10000 = this.gp.currentArea;
      this.gp.getClass();
      if (var10000 == 50) {
         g2.setComposite(AlphaComposite.getInstance(3, this.filterAlpha));
      }

      label14: {
         var10000 = this.gp.currentArea;
         this.gp.getClass();
         if (var10000 != 50) {
            var10000 = this.gp.currentArea;
            this.gp.getClass();
            if (var10000 != 52) {
               break label14;
            }
         }

         g2.drawImage(this.darknessFilter, 0, 0, (ImageObserver)null);
      }

      g2.setComposite(AlphaComposite.getInstance(3, 1.0F));
   }
}
