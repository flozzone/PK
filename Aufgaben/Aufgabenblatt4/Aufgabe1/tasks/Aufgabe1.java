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
    2. Ist int als Ergebnistyp zur Lösung dieser Aufgabe geeignet? Warum? Welche
    Alternative(n) gibt es? 
    3. Warum ist double kein geeigneter Ergebnistyp für diese Aufgabe? 
    4. Vermutlich enthält Ihre erste Implementierung
    von rec zwei rekursive Aufrufe. Versuchen Sie rec so abzuändern, dass nur
    ein rekursiver Aufruf nötig ist. Wie wirkt sich die Änderung auf die Vor-
    und Nachteile aus? 
    5. In der Implementierung von iter sind keine
    Arrays nötig. Man könnte sie aber (auf unterschiedliche Arten) verwenden.
    Welche Vor- und Nachteile ergeben sich in dieser Aufgabe aus der Verwendung
    von Arrays?
*/
public class Aufgabe1 {

    // invokes iter as well as rec with all integers from 0 to 30 and prints
    // the results (without empty lines or other output)
    public static void main(String[] args) {
        // TODO: Implementation is your task
    }
}
