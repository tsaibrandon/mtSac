public class Game {
    Board board = new Board();
    BoardState boardState = new BoardState();
    Player player = new Player();
    ScanTool tool = new ScanTool();
    Menu menu = new Menu();

    private Scanner scan = new Scanner(System.in);

    public void startGame() {
        menu.printBoard();
    }

    // after position is updated generate the board again with the new position

    public void playerMove() {
        if(validMove()) {
            player.updateCurrPos();
        }
    }

    private void validMove(char input) {
        /**
         * accepts upper/lower case for R U D L P
         * throws an error if not any of these letters
         * throws an error for P if there is nothing to pick up
         */
    }

    
}
