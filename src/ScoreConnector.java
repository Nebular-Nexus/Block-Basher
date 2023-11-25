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
}

