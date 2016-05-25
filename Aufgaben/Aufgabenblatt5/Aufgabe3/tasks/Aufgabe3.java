/*
    Aufgabe3) Ausscheidungsspiele

    Auf Mirsanmir kann es durch die Eintönigkeit sehr langweilig
    sein. Daher vertreiben sich die Bewohner die Zeit mit kleinen
    wettbewerbsartigen Spielen wie "Steinweitwerfen",
    "Am-schnellsten-auf-Baum-klettern" und so weiter.  Allerdings sind
    die Bewohner sehr höflich und lassen gerne andere gewinnen. Das
    steht dem Wettbewerbs-Charakter der Spiele entgegen. Aus diesem
    Grund hat man eine unübliche Vorgehensweise entwickelt um Sieger
    zu ermitteln: Die Spieler stellen sich in einer Reihe auf, und
    einer nach dem anderen kommt dran und stellt sich danach wieder
    hinten in der Reihe an. Jeder n-te Spieler scheidet jedoch aus,
    wobei n eine vorher festgelegte Zahl ist. Ein Spieler, der
    ausscheidet wenn hinter ihm niemand mehr in der Reihe ist, wird
    zum Sieger des Spiels erkoren, der gleich danach seinen Sieg
    feiert und nicht mehr weiterspielt. Andere ausgeschiedenen Spieler
    reihen sich am Ende der Warteschlange eines anderen Spiels ein.

    Simulieren Sie in Aufgabe3 diese Spiele auf folgende Weise:
    Schreiben Sie eine neue Klasse Game, deren Objekte einzelne Spiele
    simulieren. Ein Konstruktor von Game nimmt als ersten Parameter
    einen String mit der Bezeichnung des Spiels und als zweiten
    Parameter einen int-Wert n größer 1, der den n-ten Spieler
    bestimmt, welcher ausscheidet. In Game werden folgende Methoden
    benötigt:

    - add: reiht einen Spieler (bestimmt durch den als String
      übergebenen Spielernamen) am Ende der Warteschlange ein.

    - next: lässt den nächsten Spieler das Spiel durchführen, wobei
      folgende Fälle auftreten können:

            . Wenn die Warteschlange leer ist, gibt next nur null zurück.

            . Sonst wird der nächste Spieler aus der Warteschlange
              genommen, der Zähler zur Bestimmung des n-ten Spielers
              weitergeschaltet und

              a) falls es sich um den n-ten Spieler handelt und
                 niemand mehr in der Warteschlange wartet, der Zähler
                 auf 0 zurückgesetzt und vor der Rückgabe von null als
                 Ergebnis folgende Zeile ausgegeben: X ist Sieger von
                 Y wobei X der Spielername und Y die Bezeichnung des
                 Spiels ist;

              b) falls es sich um den n-ten Spieler handelt und noch
                 jemand in der Warteschlange wartet, der Zähler
                 zurückgesetzt und der Spielername zurückgegeben;

              c) andernfalls dieser Spieler wieder am Ende der
                 Warteschlange eingereiht und null zurückgegeben.

    Verwenden Sie in Game kein Array, sondern eine Queue.

    Anmerkung: Ein Objekt von Game kann mehrmals oder nie einen Sieger
    ausgeben (wenn ein neuer Spieler in die Warteschlange kommt,
    nachdem schon ein Sieger bestimmt wurde, oder die Warteschlange
    leer bleibt).

    Objekte der Klasse Aufgabe3 stellen jeweils ein Gesamtszenario
    bestehend aus einer Menge von Spielen dar.  Über den Konstruktor
    bestimmt man die Spieler im ersten Parameter A (Array von
    Spielernamen), die Spiele im zweiten Parameter B (Array von
    Spielbezeichnungen) und die Zahlen n (für das Ausscheiden des
    n-ten Spielers) im dritten Parameter (int-Array, wobei der i-te
    Index im dritten Parameter zum i-ten Index des zweiten Parameters
    gehört).

    In Aufgabe3 wird folgende Methode benötigt:

    - play: konfiguriert die Spiele (Game) und führt sie durch (Game
            Objekte werden an dieser Stelle angelegt); jedes Spiel hat
            einen Index entsprechend dem in B; anfangs starten alle
            Spieler (in der Reihenfolge wie in A) mit dem Spiel mit
            Index 0; eine Spielrunde wird durch einen Aufruf von next
            in jedem Spiel (in der Reihenfolge der Indices) simuliert;
            ausgeschiedene Spieler machen (wenn möglich noch in der
            gleichen Runde) mit dem Spiel weiter, das einen um eins
            höheren Index hat, oder mit dem Spiel mit dem Index 0 wenn
            sie im höchsten Index ausgeschieden sind; play hat einen
            int-Parameter der bestimmt, wie viele Spielrunden zu
            spielen sind.

    Es soll möglich sein, play in einem Gesamtszenario mehrfach
    auszuführen. Mit demselben Parameter soll dabei auch dieselbe
    Ausgabe produziert werden.

    [fortgeschritten]

    Erstellen Sie eine Klasse Aufgabe3Array und verwenden Sie in Game
    ein Array.  Welche Unterschiede fallen Ihnen auf?

    Zusatzfragen:
    1. Was unterscheidet Queue von Map?
    2. Was versteht man unter dem FIFO-Prinzip?
    3. Eignet sich zur Simulation eines Gesamtszenarios eher ein Array
    oder eine Map? Warum?
    4. Wie stark hängen die Spielergebnisse von den verwendeten Parametern ab?
*/

import java.util.LinkedList;
import java.util.Queue;

class Game {


}

public class Aufgabe3 {

    // just for testing ...
    public static void main(String[] args) {
        // Implementierung von main soll (zusätzliche) Testfälle beinhalten
    }
}
