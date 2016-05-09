/*
    Aufgabe5) Vervollständigung von Methoden

    Vervollständigen Sie die Methoden, sodass sie sich den Kommentaren
    entsprechend verhalten. Verändern Sie dabei nur Ausdrücke, die in einem
    Kommentar mit TODO: gekennzeichnet sind. Lassen Sie andere Teile der Klasse
    unverändert. Von dieser Einschränkung ausgenommen ist nur die Methode main,
    die Sie beliebig zum Testen verwenden können.

    Zusatzfragen: 
    1. Welche Möglichkeiten bietet Java um Programmverzweigungen
    (bzw. bedingte Ausführung) auszudrücken? 
    2. Häufig ergeben sich auch schon
    in kleinen Programmen viele Fallunterscheidungen, die zu berücksichtigen
    sind. Einige vorgegebene Strukturen der Methoden in Aufgabe5 helfen dabei,
    Programme trotzdem klein und überschaubar zu halten. Welche Strukturen sind
    das, und wodurch helfen sie dabei?
*/
public class Aufgabe5 {

    // returns true if (and only if) both x and y are in the range from 1 to 20
    // (including 1 and 20) and x is larger than y.
    private static boolean inRangeAndOrdered(int x, int y) {
        return (false /* TODO: modify this expression */);
    }

    // returns 1 if both a and b are true, 0 if a differs from b, and -1 if 
    // both a and b are false
    private static int wiredLogic(boolean a, boolean b) {
        return (a && b ? (-1 /* TODO: modify this expression */) : (-1 /* TODO: modify this expression */)) +
                (a || b ? (-1 /* TODO: modify this expression */) : (-1/* TODO: modify this expression */));
    }

    // returns 3 if a and b are true, 2 if a is true and be is false,
    // 1 if a is false and b is true, 0 otherwise.
    private static int combinedLogic(boolean a, boolean b) {
        int result = 0;
        if (false /* TODO: modify this expression */) {
            result += 1;
        }
        if (false /* TODO: modify this expression */) {
            result += 2;
        }
        return result;
    }

    // returns true if (and only if) i is 1, 2, 3 or 4;
    // 'useSwitch' is invoked only with values i in the range from 1 to 5.
    private static boolean useSwitch(int i) {
        switch(i * i + i) {
            case (-1 /* TODO: modify this expression */):
                return (false /* TODO: modify this expression */);
        }
        return (false /* TODO: modify this expression */);
    }

    // returns the number of square numbers in the range from 'left' to 'right'
    // (including 'left' and 'right'), // where a square number is a number 
    // that is the square of some (other) number.
    private static int squareNumbers(int left, int right) {
        int count = 0;
        for (int i = 1; (i < left /* TODO: modify this expression */); i++) {
            if (true /* TODO: modify this expression */) {
                count++;
            }
        }
        return count;
    }

    // just for testing ...
    public static void main(String[] args) {
        // den Rumpf dieser Methode können Sie beliebig verändern


    }
}
