/*
    Aufgabe2) Tagesablaufplan

    Auf der Insel Mirsanmir unterliegt ein großer Teil des Tages einem
    fixen Ablauf, z.B. "Sonnenaufgang betrachten" von 1.95.0 bis 2.5.0
    (neue Uhrzeit entsprechend Aufgabe1), "Frühstück" von 2.15.0 bis
    2.30.0, "Muschelsammeln" von 3.0.0 bis 3.50.0, "Sonnenhut tragen"
    von 2.0.0 bis 6.0.0 und so weiter. Ein elektronischer Plan des
    Tagesablaufs soll Touristen vorgeblich helfen, sich einfacher
    anzupassen. Tatsächlich machen sich die Einwohner einen Spaß
    daraus, Fremde beim Anpassungsversuch zu beobachten. Daher kann
    man im Plan nur durch Eingabe der genauen Tätigkeit
    (z.B. "Sonnenaufgang betrachten") den dazugehörigen Zeitraum
    finden. Für zusätzliche Verwirrung sorgen unterschiedliche Pläne
    für unterschiedliche Touristen.

    Objekte der Klasse Aufgabe2 sollen Tagesablaufpläne für Touristen
    darstellen. Folgende Methoden werden benötigt:

    - from: hat einen Parameter vom Typ String, der einer Tätigkeit
            entspricht, und gibt die Beginn-Zeit der Tätigkeit als
            String (enthält eine neue Zeit) zurück; das Ergebnis ist
            null falls die Tätigkeit nicht vorgesehen ist.

    - to: hat einen Parameter vom Typ String, der einer Tätigkeit
            entspricht, und gibt die Ende-Zeit der Tätigkeit als
            String zurück; das Ergebnis ist null falls die Tätigkeit
            nicht vorgesehen ist.

    - add: wird für den schrittweisen Aufbau des Tagesablaufplans
            benötigt; der erste Parameter vom Typ String gibt eine
            Tätigkeit an, der zweite Parameter vom Typ Period (siehe
            unten) den Zeitaum dieser Tätigkeit; als Ergebnis kommt
            false zurück wenn für diese Tätigkeit vor Aufruf von add
            noch kein Zeitraum vorgesehen war, true wenn schon ein
            Zeitraum vorgesehen war, der durch den Aufruf von add
            ersetzt wird.

    Es soll möglich sein, mehrere Objekte mit der Klasse Aufgabe2 zu
    erstellen. Die Anzahl der Tätigkeiten in einem Tagesablaufplan
    darf nicht beschränkt sein (außer durch die Größe des
    Computer-Speichers).

    Objekte der Klasse Period stellen einen Zeitraum innerhalb eines
    Tages dar und enthalten die Beginn- und die Ende-Zeit jeweils als
    Objekte vom Typ String. Erzeugt werden Objekte von Period nur über
    einen Konstruktor, und zugegriffen wird nur über die folgenden
    parameterlosen Methoden:

    - from: gibt die Beginn-Zeit zurück.
    - to:   gibt die Ende-Zeit zurück.

    Hinweis: Sie können den Tagesablaufplan als Map/TreeMap realisieren.

    [fortgeschritten]
    Erstellen Sie eine zusätzliche Methode getPlan:

    - printPlan: bekommt als Parameter eine Uhrzeit; die Methode
                  listet alle Tätigkeiten auf, die zu dieser Zeit
                  stattfinden.  Verwenden Sie System.out.println()
                  um alle Tätigkeiten auszugeben.

    Zusatzfragen:
    1. Wozu benötigt man in dieser Aufgabe eine Klasse wie Period?
    2. Wodurch unterscheidet sich ein Array von einer Map?
    3. Muss man in jeder Klasse einen Konstruktor schreiben? Wenn
       nein, welche Konsequenzen hat es, wenn man keinen Konstruktor
       schreibt?
    4. [optional] Könnte man die Beginn- und Ende-Zeit statt durch
       einen String auch durch ein Objekt vom Typ Aufgabe1 darstellen?
       Was würde dafür oder dagegen sprechen?
*/

import java.util.Map;
import java.util.TreeMap;


class Period {
    private String from, to;

    public Period(String from, String to) {
        this.from = from;
        this.to = to;
    }
    public String from() { return this.from; }
    public String to() { return this.to; }
}

class NeueUhrzeitPeriod {
    private NeueUhrzeit from, to;

    public NeueUhrzeitPeriod(NeueUhrzeit from, NeueUhrzeit to) {
        this.from = from;
        this.to = to;
    }
    public NeueUhrzeit from() { return this.from; }
    public NeueUhrzeit to() { return this.to; }
}

public class Aufgabe2 {

    Map<String, NeueUhrzeitPeriod> plan = new TreeMap<>();

    public NeueUhrzeit from(String task) {
        return plan.get(task).from();
    }

    public NeueUhrzeit to(String task) {
        return plan.get(task).to();
    }

    public boolean add(String task, NeueUhrzeitPeriod period) {
        boolean contained = false;
        if (plan.containsKey(task))
            contained = true;

        plan.put(task, period);

        return contained;
    }

    public void printPlan(NeueUhrzeit time) {
        for (Map.Entry<String, NeueUhrzeitPeriod> entry: plan.entrySet()) {
            NeueUhrzeitPeriod period = entry.getValue();
            if (period.from().compareTo(time) <= 0 &&
                    period.to().compareTo(time) >= 0) {
                System.out.println(period.from().get() + " - " + period.to().get() + " : " + entry.getKey());
            }
        }
    }

    // just for testing ...
    public static void main(String[] args) {
        // Implementierung von main soll Testfälle beinhalten

        Aufgabe2 test = new Aufgabe2();

        test.add("Wäsche waschen", new NeueUhrzeitPeriod(new NeueUhrzeit(1, 0), new NeueUhrzeit(1, 50)));
        test.add("Morgengymnastik", new NeueUhrzeitPeriod(new NeueUhrzeit(1, 51), new NeueUhrzeit(2, 60)));
        test.add("Fischen", new NeueUhrzeitPeriod(new NeueUhrzeit(2, 61), new NeueUhrzeit(5, 30)));
        test.add("Essen", new NeueUhrzeitPeriod(new NeueUhrzeit(5, 31), new NeueUhrzeit(6, 00)));
        test.add("Pfeifen", new NeueUhrzeitPeriod(new NeueUhrzeit(1, 10), new NeueUhrzeit(2, 30)));

        test.printPlan(new NeueUhrzeit(1, 12));
    }
}
