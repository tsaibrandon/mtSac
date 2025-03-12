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
    
    public Die(int totalFaces) {
        this(0, totalFaces);
        rollDie();
    }

    public Die() {
        this(6);
    }

    public int getFace() {
        return face + 1;
    }

    public int getTotalFaces() {
        return totalFaces;
    }

    public void rollDie() {
        face = rnd.nextInt(totalFaces);
    }

    public String toString() {
        return "Face: " + (face + 1);  
    }

    private boolean isValidFace(int face, int totalFaces) {
        return face < totalFaces;
    }
}

