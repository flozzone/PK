/*
    Aufgabe5) Klassen & Methoden

    Vervollständigen Sie die Methoden, sodass sie sich den Kommentaren
    entsprechend verhalten. Verändern Sie dabei nur Ausdrücke, die in
    einem Kommentar mit TODO: gekennzeichnet sind. Lassen Sie andere
    Teile der Klasse unverändert.  Von dieser Einschränkung
    ausgenommen ist nur die Methode main, die Sie beliebig zum Testen
    verwenden können.

    [fortgeschritten]
    Implementieren Sie zusätzlich:

    - boolean compareFrac(Fraction other) .. retourniert true wenn
      zwei Fraction die gleiche Zahl sind, z.B. 1/4 == 2/8

    - Fraction mulFrac(Fraction other) .. retourniert ein neues
      Fraction Object mit dem Multiplikationsergebnis

    - Fraction divFrac(Fraction other) .. retourniert ein neues
      Fraction Object mit dem Divisionsergebnis

    Zusatzfragen:

    1.  Wie unterscheiden sich this und this() voneinander?

    2.  Welche Vor- und Nachteile ergeben sich bei der Verwendung der
        statischen Klassenmethode "addFractions" und der Objektmethode
        "addFrac"?

*/
class Fraction {

    private int numerator;
    private int denominator;

    public Fraction(){
        this(0,0);
    }

    // Der Konstruktor bekommt Zähler und Nenner und speichert diese
    // in den entsprechenden Membervariablen ab.
    public Fraction(int num, int denom) {
        if (denom < 0) {
            num = -num;
            denom = -denom;
        }
        // TODO: add lines here if necessary
        reduce();
    }

    // Die Methode "addFrac" bekommt ein Fraction Objekt, addiert
    // beide Brüche und retourniert ein neues Fraction Objekt mit dem
    // Ergebnis.
    // Sollte kein Objekt übergeben werden wird ein neues Fraction
    // Objekt erzeugt mit Zähler und Nenner 0.
    public Fraction addFrac(Fraction frac){
        if(frac == null){
            // TODO: add lines here
        }
        return new Fraction(/* TODO: modify expression*/);
    }

    public int getNumerator() { return this.numerator; }

    public int getDenominator() {
        return this.denominator;
    }

    // Die Methode "reduce" versucht den Bruch falls möglich unter
    // Verwendung der Hilfsmethode "gcd" zu kürzen.
    private void reduce() {
        if (this.numerator == 0 || this.denominator == 0) {
            return;
        }

        int gcd = -1/* TODO: modify expression*/;

        // TODO: add lines here if necessary
    }

    // Die Methode wird von reduce verwendet um den Bruch zu
    // kürzen. Stellen Sie fest, welche Funktionalität benötigt wird
    // um den Bruch mit reduce zu kürzen und vervollständigen Sie
    // entsprechend den Code.
    private int gcd(int a, int b) {
        int r = a % b;
        while(true/* TODO: modify expression*/) {
            // TODO: add lines here
        }
        // TODO: add lines here
    }

}

public class Aufgabe5 {

    // just for testing ...
    public static void main(String[] args) {
        // den Rumpf dieser Methode können Sie beliebig verändern
    }

    // Die statische Methode "addFractions" addiert zwei Brüche, die
    // mit Zähler und Nenner der Methode übergeben werden.
    // Das Ergebnis wird mittels int array zurückgegeben. Sollte ein
    // Nenner 0 sein wird {0,0} zurückgeliefert.
    public static int[] addFractions(int num1, int denom1, int num2, int denom2) {
        // TODO: add lines here if necessary
        if(denom1 != 0 && denom2 != 0) {
            // TODO: add lines here if necessary
        }
        return new int[]{0,0}/* TODO: modify expression*/;
    }

}

