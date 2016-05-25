/*
    Aufgabe4) Klammerung

    Implementieren Sie in Aufgabe4 eine statische Methode check, die
    einen String als Parameter hat und genau dann true zurückgibt,
    wenn der String einen korrekt geklammerten Ausdruck enthält. Ein
    Ausdruck ist dann korrekt geklammert, wenn es zu jeder öffnenden
    Klammer '(', '[' oder '{' eine entsprechende schließende Klammer
    ')', ']' oder '}' gibt. Zwischen diesen Zeichen können beliebige
    andere Zeichen vorkommen.

    Beispiele für korrekt geklammerte Ausdrücke: "", "a*[a+12]",
    "a+(b)-c", "a+{b+8+(b+c)}/a"

    Beispiele für nicht korrekt geklammerte Ausdrücke: "[", "(}",
    "a)[]", "([)]", "]["

    Verwenden Sie einen Stack zur Überprüfung der Klammerung:
    Durchlaufen Sie die Zeichen im String von vorne nach hinten und
    legen Sie jede öffnende Klammer, die Sie dabei finden, auf den
    Stack. Wenn Sie auf eine schließende Klammer stoßen, nehmen Sie
    das oberste Element vom Stack; bei korrekter Klammerung muss die
    schließende Klammer mit der Klammer vom Stack
    zusammenpassen. Andere Zeichen werden einfach ignoriert. Bei
    korrekter Klammerung muss der Stack am Ende leer sein.

    Hinweis: Sie können als Stack z.B. ein Objekt des Typs
    Deque<String> verwenden.

    [fortgeschritten]
    Überprüfen Sie zudem ob die Ausdrücke ansonsten wohlgeformt
    sind. Es sollen dabei Zahlen, Variablen (a-z) und die Operatoren
    +, -, * und / erlaubt sein, wobei auf jeder Seite eines Operators
    ein Operand (eine Zahl, eine Variable, oder ein Klammerausdruck)
    sein muss, und Operanden nicht unmittelbar nebeneinander stehen
    duerfen; Klammerausdrücke enthalten wohlgeformte Ausdrücke.
    Beispiele für wohlgeformte Ausdrücke siehe oben.

    Beispiele für wohl geklammerte aber nicht wohl geformte Ausdrücke
    sind: "a(12)", "a--b", "003+5", "5-()", "!"

    Zusatzfragen:

    1. Was versteht man unter dem LIFO-Prinzip?

    2. Wie könnte man diese Aufgabe auch mit einem Array statt einem
       Stack lösen?  Welche Nachteile würden sich daraus ergeben?
*/

import java.util.Deque;
import java.util.LinkedList;

public class Aufgabe4 {

    // just for testing ...
    public static void main(String[] args) {
        // Implementierung von main soll (zusätzliche) Testfälle beinhalten
    }
}
