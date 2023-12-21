package main;

import javax.swing.JFrame;

public class Main {
    public static void main(String[] args) {
        JFrame window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.setTitle("Treasure hunting");

        GamePanel panel = new GamePanel();
        window.add(panel);

        window.pack();
        
        window.setLocationRelativeTo(null);
        window.setVisible(true);

        panel. setupGame();
        panel.startGameThread();
    }
}
