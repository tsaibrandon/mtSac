public class BoardState {

    private static final int ROWS = 8;
    private static final int COLS = 8;
    private static final int MAX_DETECTIONS = 3; // R, V, W
    
    // private ScanDetect[] rooms = new ScanDetect[64];
    private ScanDetect[][][] boardState = new ScanDetect[ROWS][COLS][MAX_DETECTIONS];

    public void addDetection(int row, int col, ScanDetect detection) {
        for (int i = 0; i < MAX_DETECTIONS; i++) {
            if (boardState[row][col][i] == null) {
                boardState[row][col][i] = detection;
                break;
            }
        }
    }

    public ScanDetect[] getDetections(int row, int col) {
        return boardState[row][col];
    }

    public void clearDetections(int row, int col) {
        boardState[row][col] = new ScanDetect[MAX_DETECTIONS];
    }
}
