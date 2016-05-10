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

        int[][] array;
        int total_length = array.length;
        int length1 = array[1].length;
        int value = array[1][3]

    2. Warum ist es sinnvoll, dass zwei der benötigten Methoden mit allen dem
    Typ entsprechenden Arrays umgehen können, obwohl eine Methode
    dreiecksförmige Arrays verlangt?

        Da man die Verwendung der Funktionen nicht weiters eingeschränkt hat.

    5. In keiner der zu implementierenden Methoden darf ein Array erzeugt
    werden. Woher kommen die benötigten Arrays?

        Die Arrays existieren bereits, Werde werden bloß getauscht.

    4. Wie kann man Arrays mit mehreren Dimensionen (zwei, drei oder mehr)
    erzeugen? Geben Sie Beispiele dafür.

        int[][] array2 = new int[4][3];
        int[][][] array3 = new int[3][4][2];
*/
public class Aufgabe3 {

    public static int fillArray (int[][] array) {
        int counter = 0;

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                array[i][j] = counter++;
            }
        }

        return counter;
    }

    public static int printArray (int[][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.print(String.valueOf(array[i][j]) + ",");
            }
            System.out.println();
        }
        return array.length;
    }

    public static void transpose (int[][] array) {
        int tmp;

        for (int i = 0; i < array.length; i++) {
            for (int j = i+1; j < array[i].length; j++) {
                tmp = array[i][j];
                array[i][j] = array[j][i];
                array[j][i] = tmp;
            }
        }
    }

    // just for testing ...
    public static void main(String[] args) {
        // Implementierung von main wird nicht beurteilt

        int[][] array = new int[4][4];

        int count = fillArray(array);
        System.out.println("count: " + String.valueOf(count));

        int nr_lines = printArray(array);
        System.out.println("nr_lines: " + String.valueOf(nr_lines));

        transpose(array);

        printArray(array);
    }
}
