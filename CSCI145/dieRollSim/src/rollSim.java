public class RollSim {
    private Die d;
    private final int TOTAL_FACES = 6;
    private int sampleSize;
    private int[] faceFrequency;

    public RollSim(int sampleSize) {
        this.sampleSize = sampleSize;
    }

    public RollSim() {
        this(100_000);
        
    }

    public void startSimulation() {
        init(sampleSize);

        for(int i = 0; i < sampleSize; i++) {
            d.rollDie();
            faceFrequency[d.getFace()]++;
        }
    }

    public void printReport() {
        System.out.printf("Face Freq Distro\n");

        for(int i = 1; i < faceFrequency.length; i++) {
            System.out.printf("%d: %6d %.4f%%\n"
                , i, faceFrequency[i], (double)faceFrequency[i] / sampleSize * 100);
        }
    }

    private void init (int sampleSize) {
        this.sampleSize = sampleSize;
        d = new Die(TOTAL_FACES);
        faceFrequency = new int[TOTAL_FACES + 1];

        for(int i = 1; i < faceFrequency.length; i++) {
            faceFrequency[i] = 0;
        }
    }
}

