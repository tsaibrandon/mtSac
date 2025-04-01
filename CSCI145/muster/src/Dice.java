import java.util.Random;

public class Dice {
    private final int NUM_DICE = 6;
    private int[] diceValues;
    private Random rnd;

    public Dice() {
        diceValues = new int[NUM_DICE];
        rnd = new Random();
    }

    public void rollDice(int numRolls) {
        for(int roll = 0; roll < numRolls; roll++) {
            for(int i = 0; i < NUM_DICE; i++) {
                diceValues[i] = rnd.nextInt(6) + 1;
            }
        }
    }

    public int[] getDiceRolls() {
        return diceValues;
    }

    public void printRolls() {
        for(int i = 0; i < diceValues.length; i++) {
            System.out.print(diceValues[i] + " ");
        }
        System.out.println();
    }
}
