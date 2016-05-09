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
    1. Warum sind Überprüfungen auf null im Zusammenhang mit Arrays wichtig?
    2. Welchen Zweck erfüllt der Parameter x in sum bzw. n in primes? Lassen
    sich rekursive Methoden auf Arrays wie sum und primes auch ohne solche
    Parameter leicht implementieren?
    3. In welchen Fällen sind forEach-Schleifen auf Arrays wie in span
    vorteilhaft, in welchen nicht?
    4. Welchen Zweck erfüllen Arrays in Methoden wie div?
    5. Wie funktioniert primes?
*/
public class Aufgabe5 {

    // Returns the sum of all elements with an index smaller than or equal to x
    // in the array; 0 is returned if the array equals null or x is not within
    // the index range of the array.
    private static int sum(int[] array, int x) {
        if (true /* TODO: modify expression*/) {
            return (-1 /* TODO: modify expression*/);
        }
        return sum(array, (-1 /* TODO: modify expression*/)) + (-1 /* TODO: modify expression*/);
    }

    // Returns the non-negative difference between the largest and smallest
    // element in the two-dimensional array; -1 is returned if the array or any
    // part of it equals null or the array contains no element
    private static int span(int[][] array) {
        // TODO: add lines here if necessary
        for (int[] subarray : array) {
            // TODO: add lines here if necessary
            for (int elem : subarray) {
                // TODO: add lines here if necessary
            }
        }
        return (-1 /* TODO: modify expression*/);
    }

    // Fills the array with the first array.length prime numbers;
    // assumes that each array entry at an index below n is 
    // already correctly set
    private static void primes(int[] array, int n) {
        if (true /* TODO: modify expression - array exists, but not yet completely filled */) {
            if (true /* TODO: modify expression - no array entry correctly set */) {
                array[0] = 2;
                primes((null /* TODO: modify expression */), (-1 /* TODO: modify expression */));
            } else {
                int check = array[n - 1];
                boolean isPrime;
                do {
                    check++;
                    isPrime = true;
                    for (int i = 0; i < n; i++) {
                        isPrime = isPrime && (check % array[i] != 0);
                    }
                } while (! isPrime);
                array[n] = check;
                primes((null /* TODO: modify expression */), (-1 /* TODO: modify expression */));
            }
        }
    }

    // Returns an array containing the result of the division of x by y at
    // index 0 and the remainder at index 1
    private static int[] div(int x, int y) {
        return (null /* TODO: modify expression */);
    }

    // just for testing ...
    public static void main(String[] args) {
        // den Rumpf dieser Methode können Sie beliebig verändern
    }
}
