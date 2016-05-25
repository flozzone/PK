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

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

public class Aufgabe4 {

    public static boolean isOpening(char c) {
        return (c == '(' || c == '[' || c == '{') ? true : false;
    }

    public static boolean isClosing(char c) {
        return (c == ')' || c == ']' || c == '}') ? true : false;
    }

    public static boolean isOperator(char c) {
        return (c == '+' || c == '-' || c == '*' || c == '/') ? true : false;
    }

    public static boolean isVariable(char c) {
        return (c >= 'a' && c <= 'z') ? true : false;
    }

    public static boolean isNumber(char c) {
        return (c == '%') ? true : false;
    }

    public static boolean isNumeric(char c) {
        return (c >= '0' && c <= '9') ? true : false;
    }

    public static int getNumber(String text, int at) {
        int counter = 0;

        for (int i = at; i < text.length(); i++) {
            if (isNumeric(text.charAt(i)))
                counter++;
            else
                break;
        }

        return counter;
    }

    public static boolean check(String text) {
        Deque<Character> stack = new ArrayDeque<>();

        System.out.println();
        System.out.println("check: " + text);

        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);

            System.out.print(c);

            if (isOpening(c)) {

                if (!stack.isEmpty()) {
                    char d = stack.removeFirst();

                    if (!isOperator(d))
                        return false;
                }

                stack.addFirst(c);
            }

            if (isClosing(c)) {
                if (stack.isEmpty())
                    return false;

                char d = stack.removeFirst();

                if (isNumber(d) || isVariable(d))
                    d = stack.removeFirst();

                if (c == ')' && d != '(')
                    return false;

                if (c == ']' && d != '[')
                    return false;

                if (c == '}' && d != '{')
                    return false;
            }

            if (isVariable(c)) {

                if (!stack.isEmpty()) {
                    char d = stack.removeFirst();

                    if (isOpening(d))
                        stack.addFirst(d);

                    if (!isOperator(d) && !isOpening(d))
                        return false;
                }

                stack.addFirst(c);
            }

            if (isNumeric(c)) {
                int jump = getNumber(text, i);
                stack.addFirst('%');
                i += jump - 1;
                continue;
            }

            if (isOperator(c)) {
                //if (stack.isEmpty())
                //    return false;

                char d = stack.removeFirst();

                if (!isClosing(d) && !isNumber(d) && !isVariable(d))
                    return false;

                /*
                char e = text.charAt(++i);
                if (isNumeric(e)) {
                    int jump = getNumber(text, i);
                    e = '%';
                    i += jump;
                }

                if (!isVariable(e) && !isNumber(e))
                    return false;
                    */
            }
        }

        if (stack.isEmpty())
            return true;

        return false;
    }

    // just for testing ...
    public static void main(String[] args) {
        // Implementierung von main soll (zusätzliche) Testfälle beinhalten

        assert (Aufgabe4.check("") == true);
        assert (Aufgabe4.check("a*[a+12]") == true);
        assert (Aufgabe4.check("a+(b)-c") == true);
        assert (Aufgabe4.check("a+{b+8+(b+c)}/a") == true);
        assert (Aufgabe4.check("[") == false);
        assert (Aufgabe4.check("(}") == false);
        assert (Aufgabe4.check("a)[]") == false);
        assert (Aufgabe4.check("([)]") == false);
        assert (Aufgabe4.check("][") == false);

    }
}
