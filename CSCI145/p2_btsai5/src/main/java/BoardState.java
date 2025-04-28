public class BoardState {

    private static final int ROWS = 8;
    private static final int COLS = 8;
    
    private String[][] scanResults = new String[ROWS][COLS];

    public BoardState() {
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                scanResults[i][j] = "   ";
            }
        }
    }

    public String getScanResults(int row, int col) {
        return scanResults[row][col];
    }

    public void updateScanResults(int row, int col, String result) {
        scanResults[row][col] = result;
    }

    public void clearScanResults() {
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                scanResults[i][j] = "   ";
            }
        }
    }
}
