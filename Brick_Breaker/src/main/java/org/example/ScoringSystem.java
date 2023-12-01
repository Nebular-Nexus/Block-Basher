package org.example;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
public class ScoringSystem {
    private int score;

    public ScoringSystem(int score) {
        this.score = score;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void displayScore(Graphics2D g)
    {
        g.setColor(Color.black);
        g.setFont(new Font("serif", Font.BOLD, 25));
        g.drawString("Score " + score, 650, 30);
    }
}

