#Vier Gewinnt

##1.) Allgemeine Infos

Das Spiel "Vier Gewinnt" ist als Projekt im Rahmen der Vorlesung Software-Technik
im Studiengang Angewandte Informatik an der Hochschule Konstanz im Wintersemester
2015/2016 enstanden. Ziel dieser Lehrveranstaltung ist die Erlernung grundlegender
Methoden und Werkzeuge des Software-Engineerings sowie das Kennenlernen elementarer
Konzepte der Software-Architektur. Das vorliegende Spiel basiert auf dem allgemein
bekannten Gesellschaftsspiel "Vier Gewinnt" und verfuegt ueber eine Model-View-
Controller-Architektur. Das Spiel ist in der Programmiersprache Java programmiert
und laesst sich auf jedem Computer ausfuehren, auf dem die Java-Laufzeitumgebung
installiert ist.


##2.) Spielprinzip und Spielregeln

Die Grundprinzipien des Spiels sind sehr einfach. Da das Spiel vollstaendig 
skalierbar ist, muessen zuerst die Anzahl der Spalten sowie die Anzahl der Reihen
gewaehlt werden. Es spielen zwei Spieler abwechselnd gegeneinader. Anschliessend 
muessen beide Spieler ihren Namen angeben.

Beide Spieler erhalten zu Beginn des Spiels eine gleich groﬂe Anzahl von Spielchips 
unterschiedlicher Farbe. Ist ein Spieler am Zug, kann dieser mithilfe der Buttons 
oberhalb des Spielfelds seinen Chip in die gewuenschte Spalte einwerfen. Gewonnen 
hat derjenige, der zuerst 4 Chips seiner Farbe entweder in Reihe, horizontal oder 
diagonal gelegt hat. Gibt es auf dem Spielfeld keinen freien Platz mehr, so ist
das Spiel unentschieden und es wird eine entsprechende Meldung ausgegben.

Eine Besonderheit des Spiels ist die Moeglichkeit, w‰hrend
des Spiels Eingaben sowohl ueber die grafische Benutzeroberflaeche als auch rein
textuell ueber die Kommandozeile zu machen. Die Meisten werden natuerlich die 
Grafik-Oberflaeche bevorzugen, dennoch kann fuer jeden einzelnen Zug des Spiels 
die Eingabe sowohl ueber die GUI als auch ueber die Textoberlaeche erfolgen.
Ermoeglich wurde dies durch eine spezielle Architektur unter der Verwendung des
Observer-Pattern.

Nutzer der Konsole erhalten textuell die Anweisung, die fuer den jeweilgen
Spielzug notwendig ist.

##3.) Mitwirkende

Programmiert wurde das Spiel von den beiden Studenten Michael Merkle und Sebastian
Gerstmeier. Betreuer des Projekts war Prof. Dr. Marko Boger.