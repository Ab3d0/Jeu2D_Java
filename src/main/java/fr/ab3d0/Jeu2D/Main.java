package fr.ab3d0.Jeu2D;


import javax.swing.*;

public class Main {
    public static void main(String[] args) {

        JFrame window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.setTitle("2D Adventure");

        GamePanel gamePanel = new GamePanel();
        window.add(gamePanel);
        window.pack();

        gamePanel.startGameThread();
        gamePanel.setupGame();

        window.setLocationRelativeTo(null);
        window.setVisible(true);



    }
}