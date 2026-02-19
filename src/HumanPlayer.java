public class HumanPlayer extends Player {

    private char playerId;     // A or B
    private boolean vulnerable; // A=true B=false
    private int twinMode;       // just for B (1 or -1)

    public HumanPlayer(int row, int col, char playerId, boolean vulnerable) {
        super(row, col, playerId, 1000, 1);
        this.playerId = playerId;
        this.vulnerable = vulnerable;
        this.twinMode = 1;
    }

    public char getPlayerId() {
        return playerId;
    }

    public void setPlayerId(char playerId) {
        this.playerId = playerId;
        setSymbol(playerId); // for sync??? is it necessary
    }

    public boolean isVulnerable() {
        return vulnerable;
    }

    public void setVulnerable(boolean vulnerable) {
        this.vulnerable = vulnerable;
    }

    public int getTwinMode() {
        return twinMode;
    }

    public void setTwinMode(int twinMode) {
        //maybe we can add a restriction like just 1 or -1
        this.twinMode = twinMode;
    }
}