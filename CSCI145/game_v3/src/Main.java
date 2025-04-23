import java.math.RoundingMode;

public class Main {

    private static final int ROW_QTY = 8;
    private static final int COL_QTY = 8;
    private static final char USER_SYMBOL = 'U';

    private static int userPos = 0;
 
    public static void main(String[] args) {

        for (int row = 0; row < ROW_QTY; row++) {
            printLine();
            printRow(row);
        }
        
        printLine();
    }

    private static void printLine() {
        for (int col = 0; col < COL_QTY; col++)
            System.out.print("-----");

        System.out.println("-");
    }

    private static void printRow(int row) {

        User2DPos uPos = new User2DPos(userPos, COL_QTY);

        int userRow = userPos / COL_QTY;
        int userCol = userPos % COL_QTY;
        char symbol;

        for (int col = 0; col < COL_QTY; col++) {
            symbol = (uPos.userRow == row && userCol == col) ? USER_SYMBOL : ' ';
            System.out.printf("| %c  ", symbol);
        }
        
        System.out.println("|");
    }

    
    
}
