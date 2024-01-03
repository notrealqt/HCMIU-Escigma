package main;

import java.net.URL;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;

public class Sound {
    Clip clip;
    URL soundURL[] = new URL[30];
    FloatControl fc;
    int volumeScale = 3;
    float volume;


    public Sound(){
        soundURL[0] = getClass().getResource("/res/sound/theme_test.wav");
        soundURL[1] = getClass().getResource("/res/sound/pickup.wav");
        soundURL[2] = getClass().getResource("/res/sound/yay.wav");
        soundURL[3] = getClass().getResource("/res/sound/click.wav");
    }

    public void setFile(int i){
        try {
            AudioInputStream ais = AudioSystem.getAudioInputStream(soundURL[i]);
            clip = AudioSystem.getClip();
            clip.open(ais);
            fc = (FloatControl)clip.getControl(FloatControl.Type.MASTER_GAIN);
            CheckVolume();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void play(){
        clip.start();
    }

    public void loop(){
        clip.loop(Clip.LOOP_CONTINUOUSLY);
    }

    public void stop(){
        clip.stop();
    }
    public void CheckVolume(){
        switch (volumeScale) {
            case 0: volume = -80f ; break;
            case 1: volume = -20f ; break;
            case 2: volume = -15f ; break;
            case 3: volume = -10f ; break;
            case 4: volume = -5f ; break;  
            case 5: volume = 2f ; break;     
        }
        fc.setValue(volume);
    }
}
