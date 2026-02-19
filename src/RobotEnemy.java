public class RobotEnemy extends Player {

    public enum RobotType {
        C_SMART,   // 'C'
        X_RANDOM   // 'X'
    }

    private RobotType robotType;

    // C için: hedef koordinat tutmak işine yarar (en yakın hazineyi seçince buraya yazarsın)
    private int targetRow;
    private int targetCol;

    // X için: yön değiştirme olasılığı (0.25)
    private double directionChangeProbability;

    // dokümana göre: bilgisayar için hazine puanı 3 kat (istersen burada tut)
    private int treasureValueMultiplier;

    public RobotEnemy(int row, int col, RobotType robotType) {
        super(row, col, robotType == RobotType.C_SMART ? 'C' : 'X', 1000, 4);
        this.robotType = robotType;
        this.targetRow = row;
        this.targetCol = col;
        this.directionChangeProbability = 0.25;
        this.treasureValueMultiplier = 3;
    }

    public RobotType getRobotType() {
        return robotType;
    }

    public void setRobotType(RobotType robotType) {
        this.robotType = robotType;
        setSymbol(robotType == RobotType.C_SMART ? 'C' : 'X');
    }

    public int getTargetRow() {
        return targetRow;
    }

    public void setTargetRow(int targetRow) {
        this.targetRow = targetRow;
    }

    public int getTargetCol() {
        return targetCol;
    }

    public void setTargetCol(int targetCol) {
        this.targetCol = targetCol;
    }

    public double getDirectionChangeProbability() {
        return directionChangeProbability;
    }

    public void setDirectionChangeProbability(double directionChangeProbability) {
        this.directionChangeProbability = directionChangeProbability;
    }

    public int getTreasureValueMultiplier() {
        return treasureValueMultiplier;
    }

    public void setTreasureValueMultiplier(int treasureValueMultiplier) {
        this.treasureValueMultiplier = treasureValueMultiplier;
    }
}