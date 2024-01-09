package monster;

import java.util.Random;

import entity.Entity;
import main.GamePanel;

public class m_Boss extends Entity {
    GamePanel gp;
    public static final String monName = "Skeleton Lỏd";


    public m_Boss(GamePanel gp) {
        super(gp);
        this.gp = gp;

        type = 2;
        name = monName;
        speed = 1;
        life = 50;
        attack = 10;
        defense = 2;

        int size = gp.tileSize * 5;
        solidArea.x = 48;
        solidArea.y = 48;
        solidArea.width = size - 48*2;
        solidArea.height = size - 48;
        solidAreaDefaultX = solidArea.x;
        solidAreaDefaultY = solidArea.y;
        attackArea.width = 170;
        attackArea.height = 170;
        
        getImage();
        //getAttackImage();

    }
    public void getImage() {
        int scale = 5;

        up1 = setUp("/res/monster/Boss/skeletonlord_up_1",gp.tileSize * scale,gp.tileSize * scale);
        up2 = setUp("/res/monster/Boss/skeletonlord_up_2",gp.tileSize * scale,gp.tileSize * scale);
        down1 = setUp("/res/monster/Boss/skeletonlord_down_1",gp.tileSize * scale,gp.tileSize * scale);
        down2 = setUp("/res/monster/Boss/skeletonlord_down_2",gp.tileSize * scale,gp.tileSize * scale);
        left1 = setUp("/res/monster/Boss/skeletonlord_left_1",gp.tileSize * scale,gp.tileSize * scale);
        left2 = setUp("/res/monster/Boss/skeletonlord_left_2",gp.tileSize * scale,gp.tileSize * scale);
        right1 = setUp("/res/monster/Boss/skeletonlord_right_1",gp.tileSize * scale,gp.tileSize * scale);
        right2 = setUp("/res/monster/Boss/skeletonlord_right_2",gp.tileSize * scale,gp.tileSize * scale);
    }
    public void getAttackImage () {
        int scale = 5;
       /* attackUp1 = setUp("/res/monster/Boss/skeletonlord_up_1",gp.tileSize * scale,gp.tileSize * scale);
        attackUp2 = setUp("/res/monster/Boss/skeletonlord_up_2",gp.tileSize * scale,gp.tileSize * scale);
        down1 = setUp("/res/monster/Boss/skeletonlord_down_1",gp.tileSize * scale,gp.tileSize * scale);
        down2 = setUp("/res/monster/Boss/skeletonlord_down_2",gp.tileSize * scale,gp.tileSize * scale);
        left1 = setUp("/res/monster/Boss/skeletonlord_left_1",gp.tileSize * scale,gp.tileSize * scale);
        left2 = setUp("/res/monster/Boss/skeletonlord_left_2",gp.tileSize * scale,gp.tileSize * scale);
        right1 = setUp("/res/monster/Boss/skeletonlord_right_1",gp.tileSize * scale,gp.tileSize * scale);
        right2 = setUp("/res/monster/Boss/skeletonlord_right_2",gp.tileSize * scale,gp.tileSize * scale);
    */
    }
    public void setAction(){
        actionLockCounter ++;
        
        if(actionLockCounter == 120){
            Random random = new Random();
            int i = random.nextInt(100)+1; //Random from 1 to 100

            if(i<=25){
                direction = "up";
            }
            if(i>25 && i<= 50){
                direction = "down";
            }
            if(i>50 && i<=75){
                direction = "left";
            }
            if(i>75 && i<=100){
                direction = "right";
            }

            actionLockCounter = 0;
        } 
    }
    
}
