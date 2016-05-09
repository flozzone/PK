/*
    Aufgabe3) Methode nachvollziehen und umschreiben

    Die Methode 'unknown' erzeugt aus einer Zahl einen String bestehend aus
    Ziffern. Stellen Sie fest, was 'unknown' genau macht. Schreiben Sie zwei
    statische Methoden namens 'nullen' und 'einsen', die je eine Zahl vom Typ
    long als Argument nehmen und eine Zahl vom Typ int zurückgeben. Die
    Rückgabewerte enthalten die Anzahl aller Vorkommen von '0' (für die Methode
    'nullen') bzw. die Anzahl aller Vorkommen von '1' (für die Methode
    'einsen'). Der Eingabewert für die Methoden 'nullen' und 'einsen' ist der
    Ausgabewert von 'unknown'. In den Implementierungen von 'nullen' und
    'einsen' darf 'unknown' nicht aufgerufen werden. Die Ergebnisse sollen
    direkt aus den Parametern errechnet werden, ohne einen String zu verwenden.
    Falls Schleifen nötig sind, sollen in 'nullen' nur (eine) for-Schleife(n)
    und in
    'einsen' nur (eine) while-Schleife(n) vorkommen.

    Zusatzfragen:
    1. Was gibt 'unknown' zurück?
    2. Wozu dient der bedingte Ausdruck in 'unknown'?
    3. Warum können in 'unknown' Literale wie 0 und 2 verwendet werden, obwohl
    mit Zahlen vom Typ long gerechnet wird?
    4. Sind verschiedene Arten von Schleifen gegeneinander austauschbar? 
    Wenn ja, wie?
*/
public class Aufgabe3 {

    // was macht 'unknown'?
    private static String unknown(long n) {
        String s = "";
        n = n < 0 ? -n : n;
        do {
            s = (n % 2) + s;
        } while ((n /= 2) != 0);
        return s;
    }

    // just for testing ...
    public static void main(String[] args) {
        // den Rumpf dieser Methode können Sie beliebig verändern

    }
}
