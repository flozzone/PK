/*
    Aufgabe4) Iteration in Rekursion ändern

    Stellen Sie fest, was die Methode 'iter' macht. Schreiben Sie eine
    statische Methode 'rec', die das Gleiche macht wie 'iter' (gleiches Input-
    Output-Verhalten), aber ohne Schleife auskommt. In 'rec' dürfen weitere
    selbst geschriebene Methoden aufgerufen werden, die ebenfalls ohne Schleife
    auskommen. Alle Variablen und Parameter in 'rec'
    und den von 'rec' aufgerufenen Methoden sollen als 'final' deklariert sein.

    Hinweis: Wahrscheinlich ist es sinnvoll, für jede Schleife in 'iter' eine
    eigene rekursive Methode zu schreiben.

    Zusatzfragen:
    1. Was berechnet 'iter'?
    2. Wodurch kommt die Bedingung j * j <= i in 'iter' zustande?
    3. Warum beginnen die Schleifen in 'iter' erst bei 2, nicht schon bei 1?
    4. Warum können Parameter und Variablen in rekursiven Methoden meist 
       problemlos 'final' sein, in Methoden, die Schleifen enthalten, dagegen
       nicht?
*/
public class Aufgabe4 {

    // what does 'iter' do?
    private static int iter(final int n) {
        int count = 0;
        for (int i = 2; i <= n; i++) {
            boolean prime = true;
            for (int j = 2; prime && j * j <= i; j++) {
                prime = (i % j) != 0;
            }
            if (prime) {
                count++;
            }
        }
        return count;
    }

    // just for testing ...
    public static void main(String[] args) {
        /* Implementierung von main wirkt sich nicht auf die Korrektheit der 
           Lösung aus. */
    }
}
