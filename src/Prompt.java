import java.util.Scanner;

public class Prompt {
    private Game game;

    public Prompt(Game game) {
        this.game = game;
    }

    public boolean promptForGuess() {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a letter");
        String guessInput = scanner.nextLine();

        boolean isHit = false;
        //boolean isLetter = false;

        try {
            isHit = game.applyGuess(guessInput);
        } catch(IllegalArgumentException iae){
            System.out.println(iae.getMessage());
        }

        return isHit;
    }

    public void displayProgress() {
        System.out.printf("You have %d misses left to solve %s. %n", game.getRemainingTries(), game.getCurrentProgress());
    }
}
