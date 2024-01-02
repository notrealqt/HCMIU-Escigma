package main;

import javax.swing.JFrame;

public class Main {
    public static JFrame window;
    public static void main(String[] args) {
        //ITCSIU2223 
        window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.setTitle("Maze Runner");
        //window.setUndecorated(true);

        GamePanel panel = new GamePanel();
        window.add(panel);

        window.pack();
        
        window.setLocationRelativeTo(null);
        window.setVisible(true);

        panel.setupGame();
        panel.startGameThread();
    }
}
