public class Scoring {

    public int calculateScore(int[] rolls) {
        int score = 0;

        if(checkStraight(rolls)) {
            return 300;
        }

        if(check3Pairs(rolls)) {
            return 150;
        } 

        if(check3OfKind(rolls, 6)) {
            return 60;
        }
        if(check3OfKind(rolls, 5)) {
            return 50;
        }
        if(check3OfKind(rolls, 4)) {
            return 40;
        }
        if(check3OfKind(rolls, 3)) {
            return 30;
        }
        if(check3OfKind(rolls, 2)) {
            return 20;
        }
        if(check3OfKind(rolls, 1)) {
            return 10;
        }

        score = check3Or5(rolls);
        
        return score;
    }

    private boolean checkStraight(int[] rolls) {
        boolean one = false;
        boolean two = false;
        boolean three = false;
        boolean four = false;
        boolean five = false;
        boolean six = false;

        for(int i = 0; i < rolls.length; i++) {
            if(rolls[i] == 1) {
                one = true;
            }else if(rolls[i] == 2) {
                two = true;
            }else if (rolls[i] == 3) {
                three = true;
            }else if(rolls[i] == 4) {
                four = true;
            }else if(rolls[i] == 5) {
                five = true;
            }else if(rolls[i] == 6) {
                six = true;
            }
        }

        if(one && two && three && four && five && six) {
            return true;
        }else {
            return false;
        }
    }

    private boolean check3Pairs(int[] rolls) {
        int[] pairs = new int[7];

        for(int i = 0; i < rolls.length; i++) {
            pairs[rolls[i]]++;
        }

        int pairAmt = 0;
        for(int i = 1; i <= 6; i++) {
            if(pairs[i] == 2) {
                pairAmt++;
            }else if(pairs[i] != 0) {
                return false;
            }
        }

        if(pairAmt == 3) {
            return true;
        }else {
            return false;
        }
    }

    private boolean check3OfKind(int[] rolls, int number) {
        int count = 0;

        for(int i = 0; i < rolls.length; i++) {
            if(rolls[i] == number) {
                count++;
            }
        }

        if(count >= 3) {
            return true;
        }else {
            return false;
        }
    }

    private int check3Or5(int[] rolls) {
        boolean three = false;
        boolean five = false;
        
        for(int i = 0; i < rolls.length; i++) {
            if(rolls[i] == 3) {
                three = true;
            }
        }
        
        for(int i = 0; i < rolls.length; i++) {
            if(rolls[i] == 5) {
                five = true;
            }
        }
        
        if(five) {
            return 5;
        } else if(three) {
            return 3;
        } else {
            return 0;
        }
    }
}
