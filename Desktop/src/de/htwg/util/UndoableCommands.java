package de.htwg.util;

import de.htwg.se.ws1516.fourwinning.models.Feld;

public interface UndoableCommands {
	
	public Feld[][] undoCommand();
	
	public void doCommand(Feld[][] source, int column);
	
	public int redoCommand();
	

}
