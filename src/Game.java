public class Game {
    //static is to make it true of all Game objects
    //final is const so the name will be in all caps
    public static final int MAX_MISSES = 7;

    private String answer;
    private String hits;
    private String misses;

    public Game(String answer) {
        this.answer = answer.toLowerCase();
        hits = "";
        misses = "";
    }

    private char normalizeGuess(char letter) {
        //checks if input is a letter
        boolean isLetter = Character.isLetter(letter);


        //changes letter to lowercase if input is a letter
        if(isLetter) {
            letter = Character.toLowerCase(letter);

        } else {
            //if input is not a letter, throw an exception
            throw new IllegalArgumentException("That isn't a letter, try again.");
        }
        return letter;
    }

    public boolean applyGuess(String letters) {
        if(letters.length() == 0) {
            throw new IllegalArgumentException("No letter found");
        }

        char firstLetter = letters.charAt(0);
        return applyGuess(firstLetter);
    }

    public boolean applyGuess(char letter) {
        letter = normalizeGuess(letter);
        boolean isHit = answer.indexOf(letter) != -1;
        //checks to see if letter has already been guessed
        if(hits.indexOf(letter) != -1 || misses.indexOf(letter) != -1) {
            throw new IllegalArgumentException("You already guessed " + letter + ", try again.");
        } else {
            //if it hasnt been guessed, add the letter to either hits or misses
            if(isHit) {
                hits += letter;
            } else {
                misses += letter;
            }
        }
        return isHit;
    }

    public int getRemainingTries() {
        return MAX_MISSES - misses.length();
    }

    public String getCurrentProgress() {
        String progress = "";

        for(char letter : answer.toCharArray()) {
            char display = '-';

            if(hits.indexOf(letter) != -1) {
                display = letter;
            }
            progress += display;
        }
        return progress;
    }
}
