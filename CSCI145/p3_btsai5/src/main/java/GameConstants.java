public class GameConstants {
    // Board dimensions
    public static final int BOARD_SIZE = 8;
    
    // Guard counts
    public static final int FODDER_GUARD_COUNT = 4;
    public static final int REGULAR_GUARD_COUNT = 3;
    public static final int ATEAM_GUARD_COUNT = 2;
    
    // Movement probabilities
    public static final double FODDER_MOVE_PROBABILITY = 0.15;
    public static final double REGULAR_MOVE_PROBABILITY = 0.50;
    public static final double ATEAM_MOVE_PROBABILITY = 0.80;
    
    // Symbols
    public static final char FODDER_SYMBOL = 'F';
    public static final char REGULAR_SYMBOL = 'R';
    public static final char ATEAM_SYMBOL = 'A';
    public static final char OPERATOR_SYMBOL = 'O';
    
    // Board positions
    public static final int SHUTTLE_BAY_ROW = 0;
    public static final int SHUTTLE_BAY_COL = 0;
    
    // Center room bounds
    public static final int CENTER_START = 3;
    public static final int CENTER_END = 4;
} 