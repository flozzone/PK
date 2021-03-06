/**********************************************************************************************************************

 AUFGABENBLATT 5 für alle Übungsgruppen - Allgemeine Informationen

 Das Projekt Aufgabenblatt5 besteht aus fünf Aufgaben in den Klassen
 Aufgabe1 bis Aufgabe5, die Sie erweitern müssen und die in der
 entsprechenden Übungseinheit behandelt werden.

 Die mit [fortgeschritten] markierten Beispiele und Fragen sind für
 die fortgeschrittenen Gruppen gedacht, dürfen aber natürlich auch von
 Teilnehmern anderer Gruppen gelöst werden, was als Übung hilfreich
 für die Ad-Hoc-Aufgaben und den Test sein könnte.  Die
 Ad-Hoc-Aufgaben für die fortgeschrittenen Gruppen sind eventuell
 anspruchsvoller, bei den Tests gibt es keinen Unterschied zwischen den
 fortgeschrittenen und den anderen Gruppen.

 Achten Sie bei der Implementierung von Aufgabe1 bis Aufgabe5 auf
 folgende Punkte:
   
 - Ändern Sie Aufgabe1 bis Aufgabe5 entsprechend der Vorgaben.

 - Ihr Programm sollte sinnvolle Tests enthalten und bestehen.

 - Bei jeder Aufgabe finden Sie Zusatzfragen. Diese Zusatzfragen
   beziehen sich thematisch auf das erstellte Programm.  Sie sollten
   diese Zusatzfragen in der Übung beantworten können.

 - Verwenden Sie zur Ausgabe immer System.out.println().

 - Verwenden Sie keine speziellen Aufrufe aus der Java-API, die die
   Aufgaben vereinfachen würden.

 Abgabe: Alle Änderungen am Projekt in der Übungsumgebung, die bis zum
 gegebenen Termin von Ihnen vorgenommen wurden, werden als Abgabe
 betrachtet.

 ***********************************************************************************************************************/

/*
    Aufgabe1) Neue Uhrzeit

    Die Bewohner der fernen Insel Mirsanmir haben beschlossen, sich
    von der klassischen Uhrzeit zu verabschieden.  Stattdessen führen
    sie eine neue Uhrzeit ein, bei der ein Tag in 8 Achtel, ein Achtel
    in 100 Zentiachtel und ein Zentiachtel in 100 Ticks geteilt wird.

    Objekte der Klasse Aufgabe1 stellen eine Uhr für die neue Uhrzeit
    dar. Implementieren Sie folgende Methoden:

    - get: gibt die aktuelle Uhrzeit als String im Format "a.z.t"
    zurück, wobei a für die Achtel (0 bis 7), z für die Zentiachtel (0
    bis 99, ein oder zwei Stellen) und t für die Ticks (0 bis 99, ein
    oder zwei Stellen) steht.

    - inc:  erhöht die Uhrzeit um ein Tick

    - set: setzt die Uhrzeit auf das Achtel im ersten int-Parameter
    und Zentiachtel im zweiten int-Parameter; Tick wird dabei auf 0
    zurückgesetzt

    Es soll möglich sein, mehrere Uhren der Klasse Aufgabe1 zu
    erzeugen. Ein Konstruktor soll die Anfangszeit auf gleiche Weise
    wie die Methode set setzen. Der Konstruktor und die beschriebenen
    Methoden müssen von außerhalb der Klasse aufgerufen werden können,
    Variablen sollen von außerhalb der Klasse aber nicht direkt
    zugreifbar sein.

    [fortgeschritten]
    Erstellen Sie eine zusätzliche Klasse Datum. Implementieren Sie
    folgende Methoden:

    - get: gibt die aktuelle Datum als String im Format "d.m.j"
    zurück, wobei d für ein Tag, m Monat, j für Jahr steht. Monat und
    Jahr sind wie im gregorianischen Kalender zu implementieren.

    - inc: erhöht das Datum um einen Tag. 29. Februar gibt es nur dann
    wenn:

      - das Jahr durch 4 ganzzahlig teilbar ist.

      - es aber nicht durch 100 ganzzahlig teilbar ist (Ausnahme:
    durch 400 ganzzahlig teilbar).

    - set: setzt das Datum mit drei int-Parameter. Verändert das Datum
    nicht, wenn es ungültig werden würde (z.b. 32.8 oder 29.2.2001).

    Zusatzfragen:
    1. Welche Zwecke haben Objekte und Klassen?
    2. Wie unterscheiden sich Objekte von Klassen?
    3. Wird in dieser Aufgabe Datenkapselung verwendet?
    4. Welchen Sinn hat Datenkapselung generell und speziell in dieser Aufgabe?
    5. Wird in dieser Aufgabe Data-Hiding verwendet?
    6. Welchen Sinn hat Data-Hiding generell und speziell in dieser Aufgabe?
    7. [fortgeschritten] Wie könnte eine Methode aussehen, die eine
    Darstellung des Datums und Uhrzeit in konventioneller Form
    zurückgibt?

*/

package Aufgabe1.tasks;

public class Aufgabe1 {

    // just for testing ...
    public static void main(String[] args) {
        // Implementierung von main soll Testfälle beinhalten

        {
            NeueUhrzeit clock = new NeueUhrzeit(0, 0);
            for (int i = 0; i < 80000; i++) {
                clock.inc();
                System.out.println(clock.get());
            }
        }

        {
            Datum date = new Datum();

            assert (date.set(29, 2, 2001) == false);

            date.set(1, 1, 2016);

            for (int i = 0; i < 60; i++) {
                System.out.println(date.get());
                date.inc();
            }

            // Check a few Schaltjahre
            int[] schaltjahre = new int[]{ 1904, 2004, 2104, 1912, 2016, 2116, 1936, 2148, 1960, 2172, 1984 };
            for (int schaltjahr: schaltjahre) {
                assert (date.set(29, 2, schaltjahr) == true);
            }
        }
    }
}

class NeueUhrzeit implements Comparable<NeueUhrzeit> {

    // Achtel
    private int a;

    // Zenti-Achtel
    private int z;

    // Ticks
    private int t;

    public NeueUhrzeit(int a, int z) {
        set(a, z);
    }

    public void set(int a, int z) {
        this.a = a;
        this.z = z;
        this.t = 0;
    }

    public String get() {
        return String.valueOf(this.a) + "." + String.valueOf(this.z) + "." + String.valueOf(this.t);
    }

    public void inc() {
        inc_t();
    }

    public int compareTo(NeueUhrzeit to) {

        int a = this.t + (this.z * 100) + (this.a * 100 * 100);
        int b = to.t + (to.z * 100) + (to.a * 100 * 100);

        if (a < b)
            return -1;

        if (a > b)
            return 1;

        return 0;
    }

    private void inc_t() {
        this.t++;

        if (t == 100) {
            this.t = 0;
            inc_z();
        }
    }

    private void inc_z() {
        this.z++;

        if (this.z == 100) {
            this.z = 0;
            inc_a();
        }
    }

    private void inc_a() {
        this.a++;

        if (this.a == 8) {
            this.a = 0;
        }
    }
}

class Datum {

    private int day;
    private int month;
    private int year;

    public boolean set(int day, int month, int year) {
        if (!check(day, month, year))
            return false;

        this.day = day;
        this.month = month;
        this.year = year;

        return true;
    }

    public String get() {
        return String.valueOf(this.day) + "." + String.valueOf(this.month) + "." + String.valueOf(this.year);
    }

    private boolean check(int day, int month, int year) {
        if (month < 1 || month > 12)
            return false;

        if (day < 1 || day > 31)
            return false;

        if (day > 30 && (month == 4 || month == 6 || month == 9 || month == 11))
            return false;

        if (month == 2) {
            if (day > 29)
                return false;

            if (day == 29) {
                if (year % 4 != 0)
                    return false;

                if (year % 400 != 0 && year % 100 == 0)
                    return false;
            }
        }

        return true;
    }

    public void inc() {
        do {
            inc_day();
        } while (!check(this.day, this.month, this.year));
    }

    private void inc_day() {
        this.day++;

        if (this.day > 31) {
            this.day = 1;
            inc_month();
        }
    }

    private void inc_month() {
        this.month++;

        if (this.month > 12) {
            this.month = 1;
            inc_year();
        }
    }

    private void inc_year() {
        this.year++;
    }
}
