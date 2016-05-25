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

        this.numerator = num;
        this.denominator = denom;

        reduce();
    }

    // Die Methode "addFrac" bekommt ein Fraction Objekt, addiert
    // beide Brüche und retourniert ein neues Fraction Objekt mit dem
    // Ergebnis.
    // Sollte kein Objekt übergeben werden wird ein neues Fraction
    // Objekt erzeugt mit Zähler und Nenner 0.
    public Fraction addFrac(Fraction frac){
        if(frac == null){
            return this;
        }

        if (this.denominator == frac.denominator) {
            return new Fraction(this.numerator + frac.numerator, frac.denominator);
        }

        return new Fraction((this.numerator * frac.denominator) + (this.denominator * frac.numerator), this.denominator * frac.denominator);
    }

    public boolean compareFrac(Fraction other) {
        if (this.numerator/this.denominator == other.numerator/other.denominator)
            return true;
        return false;
    }

    public Fraction mulFrac(Fraction other) {
        return new Fraction(this.numerator * other.numerator, this.denominator * other.denominator);
    }

    public Fraction divFrac(Fraction other) {
        return new Fraction(this.numerator * other.denominator, this.denominator * other.numerator);
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

        int gcd = gcd(this.numerator, this.denominator);
        if (gcd > 1) {
            this.numerator = this.numerator / gcd;
            this.denominator = this.denominator / gcd;
        }

    }

    // Die Methode wird von reduce verwendet um den Bruch zu
    // kürzen. Stellen Sie fest, welche Funktionalität benötigt wird
    // um den Bruch mit reduce zu kürzen und vervollständigen Sie
    // entsprechend den Code.
    private int gcd(int a, int b) {
        int r = a % b;
        while(b != 0) {
            r = a % b;
            a = b;
            b = r;
        }
        return a;
    }

    public String toString() {
        if (numerator == 0)
            return "0";

        if (numerator == denominator)
            return String.valueOf(numerator);

        if (Math.abs(numerator) == Math.abs(denominator))
            return "-"+String.valueOf(Math.abs(numerator));

        if (denominator == 1)
            return String.valueOf(numerator);

        return String.valueOf(numerator) + "/" + String.valueOf(denominator);
    }

}

public class Aufgabe5 {

    // just for testing ...
    public static void main(String[] args) {
        // den Rumpf dieser Methode können Sie beliebig verändern
        testAdd(1, 2, 1, 2);
        testAdd(1, 3, 1, 3);
        testAdd(1, 2, 1, 3);
        testAdd(1, 2, 2, 4);
        testAdd(-1, 1, 1, 1);
        testAdd(-1, 2, 2, 4);
        testAdd(1, -2, 2, 4);
        testAdd(1, 7, 5, 14);

        testCompare(1, 4, 2, 8);
        testCompare(-1, 2, 1, -2);

        testMult(1, 2, 1, 4);
        testMult(1, 2, -1, 4);

        testDiv(1, 2, 1, 4);
        testDiv(1, 2, 1, -4);
    }

    public static void testAdd(int num1, int denom1, int num2, int denom2) {
        Fraction a, b, ret;
        a = new Fraction(num1, denom1);
        b = new Fraction(num2, denom2);
        ret = a.addFrac(b);
        System.out.println(a.toString()+" + "+b.toString()+" = "+ret.toString());
    }

    public static void testCompare(int num1, int denom1, int num2, int denom2) {
        Fraction a, b;
        boolean ret;

        a = new Fraction(num1, denom1);
        b = new Fraction(num2, denom2);
        ret = a.compareFrac(b);

        if (ret) {
            System.out.println(a.toString()+" == "+b.toString());
        } else {
            System.out.println(a.toString()+" != "+b.toString());
        }
    }

    public static void testMult(int num1, int denom1, int num2, int denom2) {
        Fraction a, b, ret;
        a = new Fraction(num1, denom1);
        b = new Fraction(num2, denom2);
        ret = a.mulFrac(b);
        System.out.println(a.toString()+" * "+b.toString()+" = "+ret.toString());
    }

    public static void testDiv(int num1, int denom1, int num2, int denom2) {
        Fraction a, b, ret;
        a = new Fraction(num1, denom1);
        b = new Fraction(num2, denom2);
        ret = a.divFrac(b);
        System.out.println(a.toString()+" / "+b.toString()+" = "+ret.toString());
    }

    // Die statische Methode "addFractions" addiert zwei Brüche, die
    // mit Zähler und Nenner der Methode übergeben werden.
    // Das Ergebnis wird mittels int array zurückgegeben. Sollte ein
    // Nenner 0 sein wird {0,0} zurückgeliefert.
    public static int[] addFractions(int num1, int denom1, int num2, int denom2) {
        assert (denom1 != 0);
        assert (denom2 != 0);

        Fraction a, b;
        a = new Fraction(num1, denom1);
        b = a.addFrac(new Fraction(num2, denom2));

        return new int[]{b.getNumerator(), b.getDenominator()};
    }

}

