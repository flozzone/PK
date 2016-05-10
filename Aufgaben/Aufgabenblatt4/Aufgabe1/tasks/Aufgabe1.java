import java.util.Arrays;

/******************************************************************************

    AUFGABENBLATT 4 - Allgemeine Informationen

    Das Projekt Aufgabenblatt4 besteht aus fünf Aufgaben in den Klassen
    Aufgabe1 bis Aufgabe5, die Sie erweitern sollen. 
    Lassen Sie alle anderen Klassen des Projekts unverändert.
    Die Aufgaben behandeln die Themen, die in der entsprechenden Übungseinheit 
    geprüft werden (ad-hoc Fragen). 

    Achten Sie bei der Implementierung von Aufgabe1 bis Aufgabe5 auf folgende
    Punkte:

    - Bei jeder Aufgabe finden Sie Zusatzfragen. Diese Zusatzfragen
    beziehen sich thematisch auf das erstellte Programm. Sie sollten diese
    Zusatzfragen in der Übung beantworten können. 
    - Verwenden Sie zur Ausgabe immer System.out.println(). 
    - Verwenden Sie keine speziellen Aufrufe aus
    der Java- API, die die Aufgaben vereinfachen würden.

    Abgabe:  Alle Änderungen am Projekt in der Übungsumgebung, die bis zur 
    gegebenen Deadline von Ihnen vorgenommen wurden, werden als Abgabe 
    betrachtet.

******************************************************************************/


/*
    Aufgabe1) Mehrfache Rekursion versus einfache Iteration

    Implementieren Sie in Aufgabe1 je eine iterative (iter) und eine rekursive
    (rec) statische Methode, die für eine ganze nicht-negative Zahl n die Zahl
    L(n) berechnet. L(n) ist definiert durch:

        L(0) = 1
        L(1) = 1
        L(n) = L(n - 1) + L(n - 2) + 1  wenn  n > 1

    Rufen Sie in main die Methoden iter und rec mit allen Zahlen von 0 bis 30
    auf und geben Sie die Ergebnisse aus.

    Zusatzfragen: 
    1. Welche Vor- und Nachteile hat iter im Vergleich zu rec?

        rec: Leichter zu implementieren aber wird zu einen Stack-Overflow führen
        wenn es zu viele Rekursionen gibt. Speicherverbrauch ist nicht linear.

        iter: Schwieriger zu imeplementieren. Absehbarer Resourcenverbrauch.

    2. Ist int als Ergebnistyp zur Lösung dieser Aufgabe geeignet? Warum? Welche
    Alternative(n) gibt es?

        Ein int typ kann ganze Zahlen bis 2^32-1 speichern, sollte dies nicht
        ausreichen, kann auf long (bis 2^64-1) umgestiegen werden.

    3. Warum ist double kein geeigneter Ergebnistyp für diese Aufgabe?

        double ist ein floating data type und wird somit nicht benötigt und würde
        bloß ein Overhead darstellen.

    4. Vermutlich enthält Ihre erste Implementierung
    von rec zwei rekursive Aufrufe. Versuchen Sie rec so abzuändern, dass nur
    ein rekursiver Aufruf nötig ist. Wie wirkt sich die Änderung auf die Vor-
    und Nachteile aus? 
    5. In der Implementierung von iter sind keine
    Arrays nötig. Man könnte sie aber (auf unterschiedliche Arten) verwenden.
    Welche Vor- und Nachteile ergeben sich in dieser Aufgabe aus der Verwendung
    von Arrays?

        Array Längen sind in Java statisch, sodass wenn ein Element hinzugefügt wird,
        ein komplett neues Array erstellt werden muss. Oder man allokiert das
        Array bereits für eine gewisse Anzahl an Elementen und erstellt ein neues
        wenn die Grenze erreicht wird.

        Arrays können aber beim Lösen der Aufgabe hilfreich sein, da somit der
        rekursive Pseudocode am einfachsten iterativ nachgebaut werden kann.
*/

public class Aufgabe1 {

    public static int rec (int n) {
        if (n < 0)
            return 0;

        if ((n == 0) || (n == 1))
            return 1;

        return rec(n - 1) + rec(n - 2) + 1;
    }

    public static int iter (int n) {
        int[] array = new int[1];
        int last = 0;
        array[0] = n;

        for (int i = 0; i < array.length; i++) {
            if (array[i] > 1) {
                array = Arrays.copyOf(array, array.length + 2);
                array[last+1] = array[i] - 1;
                array[last+2] = array[i] - 2;
                last += 2;
            }
        }

        return array.length;
    }

    // invokes iter as well as rec with all integers from 0 to 30 and prints
    // the results (without empty lines or other output)
    public static void main(String[] args) {

        for (int i = 0; i <= 30; i++) {
            int rec_res = rec(i);

            System.out.println("rec (" + String.valueOf(i) + "): " + String.valueOf(rec_res));
        }

        for (int i = 0; i <= 30; i++) {
            int rec_res = iter(i);

            System.out.println("iter (" + String.valueOf(i) + "): " + String.valueOf(rec_res));
        }
    }
}
