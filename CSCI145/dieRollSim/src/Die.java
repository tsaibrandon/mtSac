import java.util.Random;

public class Die {
    private int face;
    private int totalFaces;
    Random rnd;
    
        
    public Die(int face, int totalFaces) {
        if(totalFaces < 1) throw new RuntimeException("Invalid Face Count");

        this.totalFaces = totalFaces;

        if(!isValidFace(face, totalFaces))
            throw new RuntimeException("invalid face count");

        this.face = face;

        rnd = new Random();
    }
    
    public Die(int face) {
        this(face, 6);
    }

    public int getFace() {
        return face;
    }

    public int getTotalFaces() {
        return totalFaces;
    }

    public void rollDie() {
        face = rnd.nextInt(totalFaces);
    }

    private boolean isValidFace(int face, int totalFaces) {
        return face < totalFaces;
    }
}

