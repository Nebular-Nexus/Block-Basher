package org.example;

public class DifficultyManager {
    private int level;
    private boolean gameBeat;

    public DifficultyManager(int level) {
        this.level = level;
        this.gameBeat = false;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public boolean isGameBeat() {
        return gameBeat;
    }

    public void incrementLevel() {
        // Add logic to handle level increments
        level++;

        if (level >= 3) {
            // Set the gameBeat flag to true
            gameBeat = true;
        }
        // You may want to include additional logic, such as setting a maximum level
        // or adjusting other parameters based on the new level
    }
}
