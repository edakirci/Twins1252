public class Laser extends Entity {

    private char laserType;                 // @ or +
    private int lifeTimeTicksRemaining;     // 100 for +, -1 for @

    public Laser(int row, int col, char laserType) {
        super(row, col, laserType);
        setLaserType(laserType);
    }

    public char getLaserType() {
        return laserType;
    }

    public void setLaserType(char laserType) {
        this.laserType = laserType;
        setSymbol(laserType);

        if (laserType == '+') {
            lifeTimeTicksRemaining = 100;
        } else {
            lifeTimeTicksRemaining = -1;
        }
    }

    public int getLifeTimeTicksRemaining() {
        return lifeTimeTicksRemaining;
    }

    public void setLifeTimeTicksRemaining(int lifeTimeTicksRemaining) {
        this.lifeTimeTicksRemaining = lifeTimeTicksRemaining;
    }
}