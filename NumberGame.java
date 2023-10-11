import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class NumberGame {
    Scanner scanner = new Scanner(System.in);
    Random random = new Random();
    int amountOfTries;
    protected boolean playAgain;

    public NumberGame() {
        startGame();
    }

    public void startGame() {

        playAgain = true;

        while (playAgain) {

            int userGuess = 0;
            int randomNumber;

            randomNumber = random.nextInt(100) + 1;

            System.out.println(randomNumber);
            System.out.print("Välkommen till spelet. Gissa ett tal mellan 1-100: ");

            while (userGuess != randomNumber) {

                try {
                    amountOfTries++;
                    userGuess = scanner.nextInt();

                    System.out.println("Gissning " + amountOfTries + ": " + userGuess);

                    if (userGuess < randomNumber) {
                        System.out.print("Fel, talet är större. Gissa igen: ");

                    }

                    else if (userGuess > randomNumber) {
                        System.out.print("Fel, talet är mindre. Gissa igen: ");

                    }

                    else if (userGuess == randomNumber) {
                        System.out.println("Grattis! Du gissade rätt på " + amountOfTries + " försök");

                        playAgainOrNot();
                    }

                } catch (InputMismatchException e) {
                    System.out.print("Du kan bara skriva ett tal med siffror. Försök igen: ");
                    scanner.next();
                }

            }

            /*
             * 
             * System.out.print("Vill du spela igen? (ja/nej): ");
             * String restartGame = scanner.next().toLowerCase();
             * 
             * if (restartGame.equalsIgnoreCase("nej")) {
             * playAgain = false;
             * }
             * 
             * else {
             * playAgain = true;
             * amountOfTries = 0;
             * }
             */

        }

    }

    public void playAgainOrNot() {
        System.out.print("Vill du spela igen? (ja/nej): ");
        String restartGame = scanner.next().toLowerCase();

        if (restartGame.equalsIgnoreCase("ja")) {
            amountOfTries = 0;
            startGame();
        }

        else if (restartGame.equalsIgnoreCase("nej")) {
            System.out.println("Tack för att du spelade!");
            playAgain = false;

        }

        else if (!restartGame.equalsIgnoreCase("ja") || !restartGame.equalsIgnoreCase("nej")) {
            System.out.println("Du måste svara (ja/nej): ");
            playAgainOrNot();
        }
    }

}
