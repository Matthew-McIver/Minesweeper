public class Board {
    //Attributes
    private Tile[][] boardGame;
    private int boardLength;
    private int numOfBombs;
    private int numOfFlags;

    //Constructor
    Board(int boardSize) {
        this.boardLength = boardSize;
        this.boardGame = new Tile[boardLength][boardLength];
        this.numOfBombs = (int) ((boardLength * boardLength) * 0.3);
        setTiles();
        setBombs();
    }

    //Method
    public void setTiles() {
        for (int i = 0; i < boardLength; i++) {
            for (int j = 0; j < boardLength; j++) {
                boardGame[i][j] = new Tile();
            }
        }
    }

    public void setBombs() {
        int i, j;
        while (numOfBombs != 0) {
            i = (int) (Math.random() * boardLength);
            j = (int) (Math.random() * boardLength);
            if (!boardGame[i][j].getBomb()) {
                boardGame[i][j].setBomb();
                setNums(i, j);
                numOfBombs--;
            }
        }
    }

    public String displayScreen() {
        String toReturn = "";
        for (int i = 0; i < boardLength; i++) {
            for (int j = 0; j < boardLength; j++) {
                toReturn += boardGame[i][j].showSymbol();
            }
            toReturn += "\n";
        }
        return toReturn;
    }

    public void showSingleTile(int x, int y) {
        boardGame[x][y].changeVisibility();
    }

    public boolean checkBomb(int x, int y) {
        return boardGame[x][y].getBomb();
    }

    public boolean checkVisibility(int x, int y){
        return boardGame[x][y].getVisibility();
    }

    private void setNums(int i, int j) {
        boolean i_over, j_over;
        int new_i, new_j;
        for (int a = -1; a < 2; a++) {
            for (int b = -1; b < 2; b++) {
                i_over = j_over = true;
                new_i = i + a;
                new_j = j + b;
                if (new_i < boardLength && new_i >= 0) {
                    i_over = false;
                }
                if (new_j < boardLength && new_j >= 0) {
                    j_over = false;
                }
                if (a == 0 && b == 0) {
                    continue;
                }
                if (i_over || j_over) {
                    continue;
                }
                if (boardGame[new_i][new_j].getBomb()) {
                    continue;
                }
                boardGame[new_i][new_j].addCnt();
            }
        }
    }

    public void revealingRecursion(int i, int j) {
        boolean i_over, j_over;
        int new_i, new_j;
        boardGame[i][j].changeVisibility();
        if (boardGame[i][j].getNearbyBombCnt() == 0) {
            for (int a = -1; a < 2; a++) {
                for (int b = -1; b < 2; b++) {
                    i_over = j_over = true;
                    new_i = i + a;
                    new_j = j + b;
                    if (new_i < boardLength && new_i >= 0) {
                        i_over = false;
                    }
                    if (new_j < boardLength && new_j >= 0) {
                        j_over = false;
                    }
                    if (a == 0 && b == 0) {
                        continue;
                    }
                    if (i_over || j_over) {
                        continue;
                    }
                    if (boardGame[new_i][new_j].getBomb()) {
                        continue;
                    }
                    if (boardGame[new_i][new_j].getVisibility()) {
                        continue;
                    }
                    boardGame[i][j].changeVisibility();
                    revealingRecursion(new_i, new_j);
                }
            }
        }
    }



    //public void checkWin(int i, int j){
        //for (i = 0; i < boardLength; i++){
            //for (j = 0; j < boardLength; j++){
                //if (boardGame[i][j].getVisibility()){

               //}

           //}
       //}
  //}
}
