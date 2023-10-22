import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class NumberGame {

    // instansvariabler
    protected int amountOfTries;
    protected int userGuess;
    protected int randomNumber;

    protected boolean playAgain;

    protected Scanner scanner = new Scanner(System.in);
    protected Random random = new Random();

    public NumberGame() {
        startGame();
    }

    public void startGame() {

        playAgain = true;
        randomNumber = random.nextInt(100) + 1; // här slumpas korrekta numret från datorn

        // Så länge playAgain är true så kommer spelet köras
        while (playAgain) {

            // här printas korrekt nummer ut så att läraren kan felsöka spelet
            System.out.println("This is the secret number for the teacher: " + randomNumber);
            
            System.out.print("Välkommen till spelet. Gissa ett tal mellan 1-100: ");

            while (userGuess != randomNumber) {

                // för att säkerställa att användaren matar in int istället för sträng, så
                // använde jag mig av try/catch
                try {
                    amountOfTries++; // här startar användarens räknare från 1.
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
                        playAgainOrNot(); // anropar metoden för att fråga användaren om den vill köra igen eller inte
                    }

                    // kontrollen sker här huruvida det är en sträng eller int som matas in.
                } catch (InputMismatchException e) {
                    amountOfTries--; // felaktig inmatning räknas ej som gissning, därav amountOfTries--
                    System.out.print("Du kan bara skriva ett tal med siffror. Försök igen: ");
                    scanner.next();
                }

            }

        }

    }

    public void playAgainOrNot() {
        System.out.print("Vill du spela igen? (ja/nej): ");
        String restartGame = scanner.next().toLowerCase();

        if (restartGame.equalsIgnoreCase("ja")) {
            amountOfTries = 0; // Här blev jag tvungen att nollställa så att gissningen startar från 1
                               // igen
            startGame();
        }

        else if (restartGame.equalsIgnoreCase("nej")) {
            System.out.println("Tack för att du spelade. Välkommen åter!");
            playAgain = false;

        }

        else if (!restartGame.equalsIgnoreCase("ja") || !restartGame.equalsIgnoreCase("nej")) {
            System.out.println("Du måste svara (ja/nej): ");
            playAgainOrNot();
        }
    }

}
