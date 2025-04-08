package model;

public class PlayerPosition {

    public static final int DEFAULT_POSITION = 0;

    private Player player;

    private int position;

    public PlayerPosition(Player player) {
        this(player, DEFAULT_POSITION);
    }

    public PlayerPosition(Player player, int position) {
        setPlayer(player);
        setPosition(position);
    }

    public Player getPlayer() {
        return player;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {

        if(position < 0)
            throw new RuntimeException("Position cannot be negative");
        this.position = position;
    }

    
    private void setPlayer(Player player) {
        if(player == null)
            throw new RuntimeException("Name must not be null");
        
        this.player = player;

    }
}
