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
import java.util.Iterator;

public class Aufgabe4 {

    private final static char OPERAND = '%';

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

    public static boolean isOperand(char c) {
        return (c == OPERAND) ? true : false;
    }

    public static boolean isNumeric(char c) {
        return (c >= '0' && c <= '9') ? true : false;
    }

    public static int readNumber(String text, int at) {
        int counter = 0;

        for (int i = at; i < text.length(); i++) {
            if (isNumeric(text.charAt(i)))
                counter++;
            else
                break;
        }

        return counter;
    }

    private static void printStack(Deque<Character> stack) {
        Iterator<Character> it = stack.descendingIterator();
        System.out.print("Stack: ");
        while (it.hasNext()) {
            char c = it.next();
            System.out.print(c);
        }
        System.out.println();
    }

    public static boolean check(String text) {
        Deque<Character> stack = new ArrayDeque<>();

        int i = 0;
        while (i < text.length()) {
            char c = text.charAt(i++);

            //System.out.println(c);

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

                if (isOperand(d)) {
                    if (stack.isEmpty())
                        return false;

                    d = stack.removeFirst();
                }

                if (c == ')' && d != '(')
                    return false;

                if (c == ']' && d != '[') {
                    return false;
                }

                if (c == '}' && d != '{')
                    return false;

                stack.addFirst(OPERAND);
            }

            if (isVariable(c)) {

                if (!stack.isEmpty()) {
                    char d = stack.getFirst();

                    if (isOperator(d)) {
                        stack.removeFirst();
                    }

                    if (!isOperator(d) && !isOpening(d))
                        return false;
                }

                stack.addFirst(OPERAND);
            }

            if (isNumeric(c)) {
                int jump = readNumber(text, i);
                i += jump;

                if (!stack.isEmpty()) {
                    char d = stack.getFirst();

                    if (isOperator(d)) {
                        stack.removeFirst();
                        stack.addFirst(OPERAND);
                    }
                }
            }

            if (isOperator(c)) {

                if (stack.isEmpty())
                    return false;

                char d = stack.removeFirst();

                if (!isClosing(d) && !isOperand(d) && !isVariable(d))
                    return false;

                stack.addFirst(c);
            }
        }

        if (!stack.isEmpty()) {
            char d = stack.removeFirst();
            if (d == OPERAND) {
                if (!stack.isEmpty())
                    return false;
            } else return false;
        }

        return true;
    }

    public static boolean test(String text, boolean expect) {
        boolean ret;

        System.out.println("---------------------");
        System.out.println("Test ("+String.valueOf(expect)+"): '" + text + "'");

        ret = Aufgabe4.check(text);

        System.out.println();

        if (ret != expect) {
            System.out.println("Test FAILED (ret: " + String.valueOf(ret)+" !=  expect: " + String.valueOf(expect) + ")");

            assert false;
        } else System.out.println("Test PASSED");

        return ret;
    }

    // just for testing ...
    public static void main(String[] args) {
        // Implementierung von main soll (zusätzliche) Testfälle beinhalten

        test("", true);
        test("a*[a+12]", true);
        test("a+(b)-c", true);
        test("a+{b+8+(b+c)}/a", true);
        test("[", false);
        test("(}", false);
        test("a)[]", false);
        test("([)]", false);
        test("][", false);
        test("[a+1231233566*3/1]-(a+{123})", true);

    }
}
