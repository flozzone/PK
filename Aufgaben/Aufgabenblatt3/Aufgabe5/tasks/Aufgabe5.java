/*
    Aufgabe5) Vervollständigung von Methoden

    Vervollständigen Sie die Methoden, sodass sie sich den Kommentaren
    entsprechend verhalten. Verändern Sie dabei nur Ausdrücke, die in einem
    Kommentar mit TODO: gekennzeichnet sind. Lassen Sie andere Teile der Klasse
    unverändert. Von dieser Einschränkung ausgenommen ist nur die Methode main,
    die Sie beliebig zum Testen verwenden können.

    Hinweis: Die automatischen Überprüfungen erkennen nicht, ob die
    Programmteile, die unverändert bleiben sollten, tatsächlich unverändert
    sind. Wenn Sie solche Änderungen vornehmen, ist die Lösung falsch, auch
    wenn das System keine Fehlermeldung liefert.

    Zusatzfragen:
    1. Warum können viele einfache rekursive Methoden durch nur eine einzige 
       Return-Anweisung implementiert werden?
    2. In welchen Fällen sind die Ausdrücke (i & 1) und (i % 2) äquivalent, 
       in welchen nicht?
    3. Wodurch unterscheiden sich die Operatoren >> und >>> in Java?
*/
public class Aufgabe5 {

    // Returns the largest remainder (Rest) of all divisions a / b where
    // a ranges from 1 to x (including 1 and x);
    // returns 0 if x or b is smaller than 1.
    private static int largestRemainder(final int x, final int b) {
        if (false /* TODO: Ausdruck anpassen */) {
            return (-1 /* TODO: Ausdruck anpassen */);
        }
        final int rem = largestRemainder((-1 /* TODO: Ausdruck anpassen */), (-1 /* TODO: Ausdruck anpassen */));
        return (-1 /* TODO: Ausdruck anpassen */);
    }

    // Returns (x * (2 to the power of n)) if n >= 0, 
    // returns (x / (2 to the power of -n)) if n <= 0;
    // only predefined operators in Java shall be used to compute these values.
    private static int toThePower(final int x, final int n) {
         return (-1 /* TODO: Ausdruck anpassen */);
    }

    // Returns the factorial of i if i > 0, returns i otherwise.
    // Avoids overflow of int, but does not avoid overflow of long.
    private static long fact(final int i) {
        return (-1L /* TODO: Ausdruck anpassen */);
    }

    // Returns a string containing i followed by i dots if i > 0; 
    // e.g., recString(4) returns "4....";
    // returns just -i dots if i <= 0; e.g., recString(-4) gives "....".
    private static String recString(final int i) {
        return ("" /* TODO: Ausdruck anpassen */);
    }

    // Returns the sum of odd numbers in the range from 'left' to 'right' 
    // (including 'left' and 'right'),
    // returns 0 if 'right' is smaller than 'left'.
    private static int oddSum(final int left, final int right) {
        return (-1 /* TODO: Ausdruck anpassen */);
    }

    // just for testing ...
    public static void main(String[] args) {
        // Den Rumpf dieser Methode können Sie ohne Auswirkung auf die 
        // Korrektheit der Lösung beliebig verändern.
    }
}
