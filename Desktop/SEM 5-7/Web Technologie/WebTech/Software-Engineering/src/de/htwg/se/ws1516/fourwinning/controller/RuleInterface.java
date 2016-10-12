package de.htwg.se.ws1516.fourwinning.controller;

import de.htwg.se.ws1516.fourwinning.models.Feld;
import de.htwg.se.ws1516.fourwinning.models.Player;

public interface RuleInterface {
	int fourInRow(int currentRow, Feld[][] feld, Player p);
	int fourInColumn(int currentColumn, Feld[][] feld, Player p);
	boolean fourDiagonal(Feld[][] f, Player p, int currentRow,
			int currentColumn);
	int fourDiagLeftToRight(Feld[][] feld, Player p, int currentRow,
			int currentColumn);
	int fourDiagRightToLeft(Feld[][] feld, Player p, int currentRow,
			int currentColumn);
	public boolean getDraw(Feld[][] f);
	public boolean getWin(Feld[][] f, Player p, int currentRow,
			int currentColumn);
}
