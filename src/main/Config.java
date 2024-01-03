package main;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Config {
    GamePanel gp;
    public Config(GamePanel gp){
        this.gp = gp;
    }
    public GamePanel getGp() {
        return gp;
    }
    public void setGp(GamePanel gp) {
        this.gp = gp;
    }
public void saveConfig(){
    
    try {
        BufferedWriter bw = new BufferedWriter(new FileWriter("config.txt"));
        //Full screen
        if(gp.fullScrennOn == true){
            bw.write("On");
        }
        if(gp.fullScrennOn == false) {
             bw.write("Off");
        }
        bw.newLine();

        //Music
        bw.write(String.valueOf(gp.music.volumeScale));
        bw.newLine();


        //SE
        bw.write(String.valueOf(gp.se.volumeScale));
        bw.newLine();

        bw.close();

    } catch (IOException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }
}
public void loadConfig(){
    try {
        BufferedReader br = new BufferedReader(new FileReader("config.txt"));

        String s = br.readLine();

        //Full Screen
        if(s.equals("On")){
            gp.fullScrennOn = true;
        }
        if(s.equals("Off")){
            gp.fullScrennOn = false;
        }
        //Music
        s = br.readLine();
        gp.music.volumeScale = Integer.parseInt(s);


        //SE
        s = br.readLine();
        gp.se.volumeScale = Integer.parseInt(s);

        br.close();
    } catch (Exception e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }
}
}
