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

        Arrays müssen wie Objekte mit new angelegt werden und sind ansonsten
        null.

    2. Welchen Zweck erfüllt der Parameter x in sum bzw. n in primes? Lassen
    sich rekursive Methoden auf Arrays wie sum und primes auch ohne solche
    Parameter leicht implementieren?

        Es wird ein solcher Parameter benötigt um den Index im Array in der
        Rekursion mitzugeben. Ansonsten würden die Parameter nicht geändert
        werden und die Rekursion endet nie.

    3. In welchen Fällen sind forEach-Schleifen auf Arrays wie in span
    vorteilhaft, in welchen nicht?

        Wenn nur lesend darauf zugegriffen wird, ansonsten werden übliche
        Schleifen verwendet um auf das Array Element direkt zuzugreifen.

    4. Welchen Zweck erfüllen Arrays in Methoden wie div?

        So können mehrere Rückgabewerte zurück gegeben werden.

    5. Wie funktioniert primes?

        Primes nimmt das n-1 Element und findet die nächstgrößere Primzahl,
        trägt diese in n ein und fährt mit n+1 fort.

*/
public class Aufgabe5 {

    // Returns the sum of all elements with an index smaller than or equal to x
    // in the array; 0 is returned if the array equals null or x is not within
    // the index range of the array.
    private static int sum(int[] array, int x) {
        if ((array == null) || (x >= array.length) || (x < 0)) {
            return 0;
        }
        return sum(array, x - 1) + array[x];
    }

    // Returns the non-negative difference between the largest and smallest
    // element in the two-dimensional array; -1 is returned if the array or any
    // part of it equals null or the array contains no element
    private static int span(int[][] array) {
        int smallest = Integer.MAX_VALUE;
        int greatest = 0;

        if (array == null)
            return 0;

        for (int[] subarray : array) {
            for (int elem : subarray) {
                if (elem < smallest)
                    smallest = elem;

                if (elem > greatest)
                    greatest = elem;
            }
        }
        return Math.abs(greatest - smallest);
    }

    // Fills the array with the first array.length prime numbers;
    // assumes that each array entry at an index below n is 
    // already correctly set
    private static void primes(int[] array, int n) {
        if (array != null && n < array.length) {
            if (n < 1) {
                array[0] = 2;
                primes(array, 1);
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
                primes(array, n + 1);
            }
        }
    }

    // Returns an array containing the result of the division of x by y at
    // index 0 and the remainder at index 1
    private static int[] div(int x, int y) {
        if (y == 0)
            return null;

        return new int[]{(x/y), x % y};
    }

    private static void printArray(int[] array) {
        System.out.print("array: ");
        for (int elem: array) {
            System.out.print(String.valueOf(elem) + ",");
        }
        System.out.println();
    }

    private static int printArray (int[][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.print(String.valueOf(array[i][j]) + ",");
            }
            System.out.println();
        }
        return array.length;
    }

    // just for testing ...
    public static void main(String[] args) {
        // den Rumpf dieser Methode können Sie beliebig verändern
        {
            System.out.println("sum test");

            int[] array = new int[5];

            primes(array, 0);
            printArray(array);

            int sum = sum(array, 0);
            assert (sum == 2);
            System.out.println("sum: " + String.valueOf(sum));

            sum = sum(array, 1);
            assert (sum == 5);
            System.out.println("sum: " + String.valueOf(sum));

            sum = sum(array, 2);
            assert (sum == 10);
            System.out.println("sum: " + String.valueOf(sum));

            sum = sum(array, -1);
            assert (sum == 0);
            System.out.println("sum: " + String.valueOf(sum));

            array = null;
            sum = sum(array, 2);
            assert (sum == 0);
            System.out.println("sum: " + String.valueOf(sum));
        }
        System.out.println("------------");
        {
            System.out.println("primes test");

            int[] array = new int[5];

            primes(array, 0);
            printArray(array);

            primes(array, -1);
            printArray(array);

            array = null;
            primes(array, 0);
        }
        System.out.println("------------");
        {
            System.out.println("span test");
            int[][] array;
            int span;

            array = new int[][]{{1, 3, 7, 2, 4}, {4, 10, -3, 5}};
            printArray(array);
            span = span(array);
            assert (span == 13);

            array = null;
            span = span(array);
            assert (span == 0);

            array = new int[][]{{1, 10, 7, 2, 4}, {4, 3, -3, 5}};
            printArray(array);
            span = span(array);
            assert (span == 13);

            System.out.println("span: " + String.valueOf(span));
        }
        System.out.println("------------");
        {
            System.out.println("div test");
            int[] result;

            result = div(1, 2);

            printArray(result);

            result = div(4, 2);

            printArray(result);

            result = div(8, 3);

            printArray(result);

            result = div(8, 0);

            assert (result == null);
        }
    }
}
