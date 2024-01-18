package main;

public interface GameConstants {
    int originalTileSize = 16;
    int scale = 3;

    int tileSize = originalTileSize * scale;
    int maxScreenCol = 20;
    int maxScreenRow = 12;
    int screenWidth = tileSize * maxScreenCol;
    int screenHeight = tileSize * maxScreenRow;

    // WORLD SETTING
    int maxWorldCol = 120;
    int maxWorldRow = 120;
    int maxMap = 10;

    int worldWidth = tileSize * maxWorldCol;
    int worldHeight = tileSize * maxWorldRow;

    // FULL SCREEN
    int screenWidth2 = screenWidth;
    int screenHeight2 = screenHeight;

    // FPS
    int FPS = 60;

    // Game state
    int titleState = 0, playState = 1, pauseState = 2, dialogueState = 3, characterState = 4, optionState = 5,
        youLostState = 6, guideState = 7, menuOptionState = 8, mapState = 10, cutScene = 11;

    boolean bossBattleOn = false;
}
