public class Player extends Entity {

    private int lifePoints;          // start: 1000
    private int score;
    private int packedLaserCount;    // count of @: human player uses (can be zero for robots)

    private int movePeriodTicks; //for human it's 1, for robots it's 44

    public Player(int row, int col, char symbol, int lifePoints, int movePeriodTicks) {
        super(row, col, symbol);
        this.lifePoints = lifePoints;
        this.movePeriodTicks = movePeriodTicks;
        this.score = 0;
        this.packedLaserCount = 0;
    }

    public int getLifePoints() {
        return lifePoints;
    }

    public void setLifePoints(int lifePoints) {
        this.lifePoints = lifePoints;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getPackedLaserCount() {
        return packedLaserCount;
    }

    public void setPackedLaserCount(int packedLaserCount) {
        this.packedLaserCount = packedLaserCount;
    }

    public int getMovePeriodTicks() {
        return movePeriodTicks;
    }

    public void setMovePeriodTicks(int movePeriodTicks) {
        this.movePeriodTicks = movePeriodTicks;
    }
}