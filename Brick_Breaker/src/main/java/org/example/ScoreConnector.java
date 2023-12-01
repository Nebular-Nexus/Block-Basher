package org.example;

import java.awt.Graphics2D;

public class ScoreConnector {
    private ScoringSystem scoringSystem;
    
    public ScoreConnector(ScoringSystem scoringSystem) {
        this.scoringSystem = scoringSystem;
    }

    
    public void updateScore(int val) {
        // Update score through ScoringSystem
        int currenet_sc = getScore();
        scoringSystem.setScore(val+currenet_sc);
    }


    public int getScore()
    {
        return this.scoringSystem.getScore();
    }

    public void scoreDisplay(Graphics2D g){
        this.scoringSystem.displayScore(g);
    }
}

