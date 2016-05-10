/*
    Aufgabe2) Eindimensionales Array

    Implementieren Sie folgende statische Methoden:

    - 'createArray' gibt ein neues Array zurück, dessen Länge gleich dem
    Argument der Methode ist. Das Array enthält Zufallszahlen größer oder
    gleich 0.0 und kleiner 100.0 (des Literales entsprechenden Typs). Zur
    Erzeugung von Zufallszahlen können Sie Math.random() verwenden:
    http://docs.oracle.com/javase/8/docs/api/java/lang/Math.html#random--

    - 'printArray' hat zwei Parameter, gibt aber kein Ergebnis zurück. Der
    erste Parameter A ist ein Array, das z.B. durch 'createArray' erzeugt
    wurde. Der zweite Parameter N ist eine ganze Zahl mit N > 0. 'printArray'
    zerlegt den Wertebereich [0.0, 100.0) in N gleich große Teilbereiche (z.B.
    für N gleich 4 in [0.0, 25.0), [25.0, 50.0), [50.0, 75.0) und [75.0, 100.0)
    ) und zählt die Zahlen im Array A, die in jeden dieser Wertebereiche
    fallen. Schließlich gibt 'printArray' für jeden dieser Teilbereiche eine
    Zeile aus, welche die Anzahl der Zahlen im entsprechenden Teilbereich
    enthält. Beispielsweise gibt 'printArray' für ein A der Länge 5 mit den
    Zahlen 10.0, 60.0, 20.0, 80.0 und 70.0 und N gleich 4 folgende Zeilen aus:

            2
            0
            2
            1

    Hinweise: Verwenden Sie zum Zählen der Zahlen in den Teilbereichen am
    besten ein weiteres Array. Am einfachsten ist es, die Zuordnung einer Zahl
    zu einem Teilbereich in die Berechnung des Indexes für dieses Array
    einzubauen. A und N dienen zur Beschreibung der Methode. In Ihrer
    Implementierung können die Parameter anders heißen.

    - 'halveArray' hat ein Array (wie von 'createArray' zurückgegeben) als
    Parameter und gibt nichts zurück. Jeder Wert im Array wird halbiert.

    Zusatzfragen:
    1. Warum kann man in 'printArray' forEach-Schleifen (also Schleifen der
    Form for(... : ...) ...) verwenden, in 'createArray' und 'halveArray' aber
    nicht?

        Weil bei forEach nicht direkt auf das Element des Array zugegriffen wird,
        sondern auf eine Kopie des Elements. Verändert man nun dieses Element,
        ändert sich bloß die Kopie.

    2. Warum ist es möglich, dass 'halveArray' kein Ergebnis zurückgibt, die
    Auswirkungen der Methode aber dennoch sichtbar werden?

        Das Array wird als Referenzparameter übergeben und wird somit von der
        Funktion direkt geändert.

    3. Woran könnte man feststellen, ob die Lösung richtig ist, obwohl jeder
    Testlauf andere Ergebnisse liefert?

        Man erzeugt random Nummern aus einem statischem Seed, so kann man
        die Zahlenfolge immer wieder wiederholen.
        Siehe auch Aufgabe2.DEBUG und die auskommentierte Zeile mit
        'java.lang.Math.random()'.
*/

import java.util.Random;

public class Aufgabe2 {

    public static final boolean DEBUG = false;

    public static float[] createArray (int n) {
        float[] array = new float[n];

        Random rand_gen = (Aufgabe2.DEBUG) ? new Random(0) : new Random();

        for (int i = 0; i < n; i++) {

            //float rand = (float) java.lang.Math.random();
            float rand = rand_gen.nextFloat();

            array[i] = ((int) (rand * 1000)) / 10.0f;
        }

        return array;
    }

    public static void printArray (float[] array, int n) {
        int[] count = new int[n];

        float size = 100.0f / n;

        for (float elem: array) {
            int index = (int) (elem / size);
            count[index] += 1;

            if (Aufgabe2.DEBUG)
                System.out.println("DEBUG: elem: " + String.valueOf(elem) + " index: " + String.valueOf(index));
        }

        for (int i = 0; i < n; i++) {
            float start = i * size;
            float end = (i * size) + size;

            System.out.println("[" + String.valueOf(start) + ", " + String.valueOf(end) + "): " + String.valueOf(count[i]));
        }
    }

    // just for testing ...
    public static void main(String[] args) {
        // Implementierung von main wird nicht beurteilt

        float[] array = createArray(4);
        printArray (array, 5);
    }
}
