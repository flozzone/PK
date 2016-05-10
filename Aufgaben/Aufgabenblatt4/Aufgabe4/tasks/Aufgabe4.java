/*
    Aufgabe4) Rekursion und Termination

    Die Methoden f, g, h, p und q sind vorgegeben. Rufen Sie in main jede
    dieser Methoden mit allen Argumenten im Bereich von [-10, 10] (in
    aufsteigender Reihenfolge) auf und geben sie die Ergebnisse aus, wenn die
    Aufrufe mit diesen Argumenten terminieren. Aufrufe, die nicht terminieren
    würden, sind auszulassen. Vermeiden Sie Exceptions.

    Hinweis: Für diese Aufgabe ist es besonders wichtig, die Zusatzfragen
    beantworten zu können.

    Zusatzfragen:
    1. Nennen Sie für jeden nicht terminierenden Aufruf von f, g, h, p und q im
    Intervall -10, 10] einen Grund für die Endlosrekursion (im Hinblick auf
    Fundiertheit und Fortschritt).
    2. Beschreiben Sie überblicksartig, was die Methoden f, g, h, p und q
    berechnen.
    3. Bedeutet ein StackOverflowError immer, dass eine Endlosrekursion
    vorhanden ist?
    4. Ist die Aufgabe überhaupt lösbar (wegen der
    Unentscheidbarkeit des Halteproblems der Turing-Maschine)?
*/
public class Aufgabe4 {

    private static int f(int x) {
        return x * x > 10 ? 0 : f(x - 1) + 1;
    }

    // - Bei g(0) wird der Parameter vor dem Rekursionsaufruf nicht verändert also
    // ist kein Fortschritt gewährleistet.
    // - Bei g(>0) ist die Fundiertheit nicht gegeben, weil eine positive Zahl niemals durch
    // Halbieren negativ wird.
    private static int g(int x) {
        return x < 0 ? 0 : g(x / 2) + 1;
    }

    // - Das Quadrat der Zahlen (0, 1, -1) wird niemals 10 übersteigen, also
    // ist die Termination nicht gesichert.
    private static int h(int x) {
        return x > 10 ? 0 : h(x * x) + 1;
    }

    private static int p(int x) {
        return x == 0 ? 0 : x % 2 == 1 ? p(x / 2) + 2 : p(- x - 1) + 1;
    }

    private static int q(int x) {
        return x % 3 == 0 ? 0 : q(x + x % 3 + 1) + 1;
    }

    private static boolean contains (int[] skip, int value) {
        for (int i = 0; i < skip.length; i++) {
            if (skip[i] == value)
                return true;
        }
        return false;
    }

    // to be implemented by you
    public static void main(String[] args) {
        int ret;

        System.out.println("Ergebnisse für f:");
        // print results of all terminating invocations 
        // of f with arguments in the range [-10, 10]
        {
            int[] skip = {};
            for (int i = -10; i <= 10; i++) {
                if (contains(skip, i)) {
                    System.out.println("Skipping " + String.valueOf(i));
                    continue;
                }
                ret = f(i);
                System.out.println("f(" + String.valueOf(i) + ") = " + String.valueOf(ret));
            }
        }

        System.out.println("Ergebnisse für g:");
        // print results of all terminating invocations 
        // of g with arguments in the range [-10, 10]
        {

            int[] skip = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
            for (int i = -10; i <= 10; i++) {
                if (contains(skip, i)) {
                    System.out.println("Skipping " + String.valueOf(i));
                    continue;
                }
                ret = g(i);
                System.out.println("g(" + String.valueOf(i) + ") = " + String.valueOf(ret));
            }
        }

        System.out.println("Ergebnisse für h:");
        // print results of all terminating invocations 
        // of h with arguments in the range [-10, 10]
        {

            int[] skip = {-1, 0, 1};
            for (int i = -10; i <= 10; i++) {
                if (contains(skip, i)) {
                    System.out.println("Skipping " + String.valueOf(i));
                    continue;
                }
                ret = h(i);
                System.out.println("h(" + String.valueOf(i) + ") = " + String.valueOf(ret));
            }
        }

        System.out.println("Ergebnisse für p:");
        // print results of all terminating invocations 
        // of p with arguments in the range [-10, 10]
        {
            int[] skip = {-10, -9, -7, -6, -5, -3, 2, 4, 5, 6, 8, 9, 10};
            for (int i = -10; i <= 10; i++) {
                if (contains(skip, i)) {
                    System.out.println("Skipping " + String.valueOf(i));
                    continue;
                }
                ret = p(i);
                System.out.println("p(" + String.valueOf(i) + ") = " + String.valueOf(ret));
            }
        }


        System.out.println("Ergebnisse für q:");
        // print results of all terminating invocations
        // of q with arguments in the range [-10, 10]
        {
            int[] skip = {-10, -7, -4, -1, 2, 5, 8};
            for (int i = -10; i <= 10; i++) {
                if (contains(skip, i)) {
                    System.out.println("Skipping " + String.valueOf(i));
                    continue;
                }
                ret = q(i);
                System.out.println("q("+ String.valueOf(i) +") = " + String.valueOf(ret));
            }
        }
    }
}
