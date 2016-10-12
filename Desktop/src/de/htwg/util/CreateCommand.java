package de.htwg.util;

import java.util.Deque;
import java.util.LinkedList;

import de.htwg.se.ws1516.fourwinning.models.Feld;

public class CreateCommand implements UndoableCommands{
	
	private Deque<Feld[][]> undoStack;
	private Deque<Integer> redoStack;
	
	public CreateCommand(){
		undoStack = new LinkedList<>();
		redoStack = new LinkedList<>();
	}
	
	@Override
	public Feld[][] undoCommand(){
		return undoStack.remove();
	}
	
	@Override
	public void doCommand(Feld[][] source, int column){
		undoStack.addFirst(cloneArray(source));
	    redoStack.addFirst(column);
	}
	
	@Override
	public int redoCommand(){
		if(!redoStack.isEmpty())
			return redoStack.remove();
		return 0;
	}
	

	public Feld[][] cloneArray(Feld[][] array){
		Feld[][] clonearray = new Feld[array.length][array[0].length];
		for (int i = 0; i < array.length; i++)
			clonearray[i] = array[i].clone();
		return clonearray;
	}
}
