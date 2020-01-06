public class Main {

    public static void main(String[] args) {
        Game game = new Game("Treehouse");
        Prompt prompter = new Prompt(game);

        while(game.getRemainingTries() > 0) {
            prompter.displayProgress();
            prompter.promptForGuess();
        }
    }
}
