/*  Aufgabe2) Rekursion in Iteration ändern

    Stellen Sie fest, was die Methode 'rec' macht. Schreiben Sie eine statische
    Methode 'iter', die das Gleiche macht wie 'rec' (gleiches Input-Output-
    Verhalten), aber ohne Rekursion auskommt.

    Zusatzfragen: 
    1. Was berechnet 'rec'? 
    2. Warum ist es notwendig, negative Parameterwerte getrennt zu behandeln? 
    3. Warum ist es notwendig, 0 als Sonderfall zu behandeln? 
    4. Ist es immer vernünftig, sich an die Hinweise einer IDE zu halten?
*/
public class Aufgabe2 {

    // what does rec compute?
    private static int rec(int x, int y) {
        if (x < 0) {
            return rec(-x, y);
        }
        if (y < 0) {
            return rec(x, -y);
        }
        if (x == 0) {
            return 0;
        }
        if (x > y) {
            return rec(y, x);
        }
        if (x == y) {
            return x;
        }
        return rec(x, y - x);
    }

    // just for testing ...
    public static void main(String[] args) {
        // Implementierung von main wird nicht beurteilt
    }
}
