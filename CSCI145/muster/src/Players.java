public class Players {
    private String player1Name;
    private String player2Name;
    private int p1Score = 0;
    private int p2Score = 0;

    public void setP1Name(String name) {
        player1Name = name;
    }

    public void setP2Name(String name) {
        player2Name = name;
    }

    public String getP1Name() {
        return player1Name;
    }

    public String getP2Name() {
        return player2Name;
    }

    public int p1Score() {
        return p1Score;
    }

    public int p2Score() {
        return p2Score;
    }

    public void addP1Score(int points) {
        p1Score = p1Score + points;
    }

    public void addP2Score(int points) {
        p2Score = p2Score + points;
    }


}
