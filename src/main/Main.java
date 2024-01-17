package main;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class Main {
    
    public static JFrame window;
    public static void main(String[] args) {
        
        window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.setTitle("Escigma");
        //window.setUndecorated(true);
        //new Main().setIcon();
        GamePanel panel = new GamePanel();
        window.add(panel);
       
        panel.config.loadConfig();
        if(panel.fullScrennOn == true){
            window.setUndecorated(true);
        }

        window.pack();
        
        window.setLocationRelativeTo(null);
        window.setVisible(true);

        panel.setupGame();
        panel.startGameThread();

    }

}
