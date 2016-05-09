/*
    Aufgabe3) Zweidimensionales Array

    Implementieren Sie folgende statische Methoden:

    - 'fillArray' hat ein zweidimensionales int-Array als Parameter und gibt
    die Gesamtzahl aller Einträge im Array zurück. Außerdem werden alle
    Einträge im Array mit fortlaufenden Zahlen (beginnend mit 0) befüllt. Für
    jeden Index in der ersten Dimension können die Array-Längen in der zweiten
    Dimension unterschiedlich sein.

    - 'printArray' gibt das als Argument übergebene zweidimensionale int-Array
    aus und liefert die Anzahl der Zeilen (= Länge des Arrays in der ersten
    Dimension) zurück. Nach jeder ausgegebenen Zahl steht ein Beistrich.
    Beispiel für ein durch 'fillArray' befülltes Array:

            0,1,2,3,
            4,5,6,
            7,8,
            9,

    Wie 'fillArray' muss auch 'printArray' mit allen dem Typ entsprechenden
    Arrays umgehen können, nicht nur mit solchen in Dreiecks- und Rechtecks-
    Form.

    - 'transpose' hat als Parameter ein dreiecksförmiges zweidimensionales int-
    Array und vertauscht Werte im Array, sodass danach in einer durch
    'printArray' erzeugten Ausgabe Zeilen und Spalten vertauscht sind. Nach
    Anwendung von 'transpose' auf das Array in obigem Beispiel gibt
    'printArray' folgendes aus:

            0,4,7,9,
            1,5,8,
            2,6,
            3,

    In den Implementierungen dieser drei Methoden darf kein neues Array erzeugt
    werden.

    Zusatzfragen:
    1. Woran erkennt man an einem Variablenzugriff, ob auf das gesamte Array,
    einen Teil des Arrays oder einen einzelnen Wert im Array zugegriffen wird?
    2. Warum ist es sinnvoll, dass zwei der benötigten Methoden mit allen dem
    Typ entsprechenden Arrays umgehen können, obwohl eine Methode
    dreiecksförmige Arrays verlangt?
    5. In keiner der zu implementierenden Methoden darf ein Array erzeugt
    werden. Woher kommen die benötigten Arrays?
    4. Wie kann man Arrays mit mehreren Dimensionen (zwei, drei oder mehr)
    erzeugen? Geben Sie Beispiele dafür.
*/
public class Aufgabe3 {

    // just for testing ...
    public static void main(String[] args) {
        // Implementierung von main wird nicht beurteilt
    }
}
