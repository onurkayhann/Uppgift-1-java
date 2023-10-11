import java.util.Random;

public class App {

    public static void main(String[] args) {
        NumberGame numberGame = new NumberGame();
    }
}

/*
 * Exempel

 * Krav för godkänt
 * 
 * 
 * Programmet ska använda de texter som finns i exemplet ovan.
 * 
 * Programmet ska välja olika slumptal varje gång genom att använd klassen
 * Random.
 * 
 * Slumptalet ska kunna vara alla tal från 1 till och med 100 men inte 0 och
 * inte 101.
 * 
 * Skriver användaren in något som inte är ett tal ska de få uppmaningen att
 * försöka igen tills de skriver in ett tal med siffror.
 * 
 * Programmet ska bara räkna gissningar som är heltal. I exemplet ovan skriver
 * användaren ”Fyra” vilket inte är ett heltal och får då försöka igen.
 * 
 * Efter varje gissning ska en ledtråd visas om talet är större eller mindre.
 * 
 * Gissar man rätt ska man få reda på hur många gissningar det tog och en fråga
 * om man vill spela igen.
 * 
 * Svara man Ja ska spelet starta om från början med ett helt nytt slumptal.
 * Svara man Nej så avslutas programmet. Vid alla andra svar ställs frågan om
 * man vill spela om igen.
 * 
 * Felhantering – inte krascha vid felaktig inmatning i menyer etc etc och andra
 * felmeddelanden för användaren
 */
