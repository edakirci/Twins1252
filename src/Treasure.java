public class Treasure extends Entity {

    private int type;              // 1,2,3
    private int playerPoints;      // 3,10,30
    private int computerPoints;    // 9,30,90

    public Treasure(int row, int col, int type) {
        super(row, col, '?');   // temp symbol just for now
        setType(type);
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;

        if (type == 1) {
            setSymbol('1');
            playerPoints = 3;
            computerPoints = 9;
        } else if (type == 2) {
            setSymbol('2');
            playerPoints = 10;
            computerPoints = 30;
        } else { //later add error handling for other wrong values!!!!!!!
            setSymbol('3');
            playerPoints = 30;
            computerPoints = 90;
        }
    }

    public int getPlayerPoints() {
        return playerPoints;
    }

    public void setPlayerPoints(int playerPoints) {
        this.playerPoints = playerPoints;
    }

    public int getComputerPoints() {
        return computerPoints;
    }

    public void setComputerPoints(int computerPoints) {
        this.computerPoints = computerPoints;
    }
}