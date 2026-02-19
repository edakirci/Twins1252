public abstract class Entity {

        private int row;
        private int col;
        private char symbol;      // symbols that we see on the screen like A, B etc.
        private boolean active;   // is it on the screen?? we can be false when the player dies

        public Entity(int row, int col, char symbol) {
            this.row = row;
            this.col = col;
            this.symbol = symbol;
            this.active = true;
        }

        public int getRow() {
            return row;
        }

        public void setRow(int row) {
            this.row = row;
        }

        public int getCol() {
            return col;
        }

        public void setCol(int col) {
            this.col = col;
        }

        public char getSymbol() {
            return symbol;
        }

        public void setSymbol(char symbol) {
            this.symbol = symbol;
        }

        public boolean isActive() {
            return active;
        }

        public void setActive(boolean active) {
            this.active = active;
        }
    }
