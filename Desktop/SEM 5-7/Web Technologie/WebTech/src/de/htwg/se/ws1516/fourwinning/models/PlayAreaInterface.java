package de.htwg.se.ws1516.fourwinning.models;

public interface PlayAreaInterface {
	void buildArea(int rows, int columns);
	int setChip(int column, Player p);
	int getColumns();
	int getRows();
	void setFeld(Feld[][] zusatzfeld);
	Feld[][] getFeld();
}
