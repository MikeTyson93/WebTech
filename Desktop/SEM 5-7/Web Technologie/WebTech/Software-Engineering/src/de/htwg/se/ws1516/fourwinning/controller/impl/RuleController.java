package de.htwg.se.ws1516.fourwinning.controller.impl;

import de.htwg.se.ws1516.fourwinning.models.*;
import de.htwg.se.ws1516.fourwinning.controller.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class RuleController implements RuleInterface {
    private static final Logger LOGGER = Logger.getLogger(RuleController.class.getName());
    
	private int column;
	private int row;
	int fourInRowCounter = 1;
	int fourInColumnCounter = 1;
	int fourInDiagonalCounterOne = 1;
	int fourInDiagonalCounterTwo = 1;
	String ausnahme = "Exception";

	/* Konstruktor um die Klasse zu initialisieren */
	public RuleController(int row, int column) {
		this.row = row;
		this.column = column;
	}

	/*
	 * Methode berechnet 4 nebeneinander liegende Chips und gibt false bzw. true
	 * zurück wenn 4 nebeneinander liegende Chips existieren bzw. nicht
	 * existieren.
	 */
	@Override
	public int fourInRow(int currentRow, Feld[][] feld, Player p) {
        LOGGER.setLevel(Level.INFO);
		int numbers = 1;
		int i = 0;
		try {
			while (i + 1 < column) {
				if (feld[currentRow][i].getOwner() != null
						&& feld[currentRow][i + 1].getOwner() != null) {
					if (feld[currentRow][i].getOwner().equals(p)
							&& feld[currentRow][i + 1].getOwner().equals(p)) {
						numbers++;
						i++;
						if (numbers > fourInRowCounter) {
							fourInRowCounter = numbers;
						}
						continue;
					} else {
						numbers = 1;
						i++;
						continue;
					}
				} else {
					numbers = 1;
					i++;
					continue;
				}

			}

			if (numbers > fourInRowCounter) {
				fourInRowCounter = numbers;
			}
		} catch (java.lang.ArrayIndexOutOfBoundsException e) {LOGGER.log(Level.SEVERE, ausnahme, e);
		}
		return fourInRowCounter;
	}

	/*
	 * Methode berechnet 4 aufeinander liegende Chips und gibt false bzw. true
	 * zurück wenn 4 aufeinander liegende Chips existieren bzw. nicht
	 * existieren.
	 */
	@Override
	public int fourInColumn(int currentColumn, Feld[][] feld, Player p) {
        LOGGER.setLevel(Level.INFO);
		int numbers = 1;
		int i = 0;
		try {
			while (i + 1 < row) {
				if (feld[i][currentColumn].getOwner() != null
						&& feld[i + 1][currentColumn].getOwner() != null) {
					if (feld[i][currentColumn].getOwner().equals(p)
							&& feld[i + 1][currentColumn].getOwner().equals(p)) {
						numbers++;
						i++;
						if (numbers > fourInColumnCounter) {
							fourInColumnCounter = numbers;
						}
						continue;
					} else {
						numbers = 1;
						i++;
						continue;
					}
				} else {
					numbers = 1;
					i++;
					continue;
				}

			}

			if (numbers > fourInColumnCounter) {
				fourInColumnCounter = numbers;
			}
		} catch (java.lang.ArrayIndexOutOfBoundsException e) {LOGGER.log(Level.SEVERE, ausnahme, e);
		}
		return fourInColumnCounter;
	}

	@Override
	public boolean fourDiagonal(Feld[][] f, Player p, int currentRow,
			int currentColumn) {
		if (fourDiagLeftToRight(f, p, currentRow, currentColumn) >= 4
				|| fourDiagRightToLeft(f, p, currentRow, currentColumn) >= 4) {
			return true;
		}
		
		return false;
		
	}

	@Override
	public int fourDiagLeftToRight(Feld[][] feld, Player p, int currentRow,
			int currentColumn) {
        LOGGER.setLevel(Level.INFO);
		int numbers = 1;
		int i = currentRow;
		int j = currentColumn;
		try {

			while (i - 1 >= 0 && j - 1 >= 0) {
				if (feld[i - 1][j - 1].getOwner() != null) {
					if (feld[i - 1][j - 1].getOwner().equals(p)) {
						i--;
						j--;
					} else {
						break;
					}
				} else {
					break;
				}
			}
			while (i + 1 < row && j + 1 < column) {
				if (feld[i][j].getOwner() != null
						&& feld[i + 1][j + 1].getOwner() != null) {
					if (feld[i][j].getOwner().equals(p)
							&& feld[i + 1][j + 1].getOwner().equals(p)) {
						numbers++;
						i++;
						j++;
						if (numbers > fourInDiagonalCounterOne)
							fourInDiagonalCounterOne = numbers;
						continue;
					} else {
						numbers = 1;
						break;
					}
				} else {
					numbers = 1;
					break;
				}
			}
			if (numbers > fourInDiagonalCounterOne) {
				fourInDiagonalCounterOne = numbers;
			}
		} catch (java.lang.ArrayIndexOutOfBoundsException e) {LOGGER.log(Level.SEVERE, ausnahme, e);
		}
		return fourInDiagonalCounterOne;
	}

	@Override
	public int fourDiagRightToLeft(Feld[][] feld, Player p, int currentRow,
			int currentColumn) {
        LOGGER.setLevel(Level.INFO);
		int numbers = 1;
		int i = currentRow;
		int j = currentColumn;
		try {
			while (i - 1 >= 0 && j + 1 < column) {
				if (feld[i - 1][j + 1].getOwner() != null) {
					if (feld[i - 1][j + 1].getOwner().equals(p)) {
						i--;
						j++;
					} else {
						break;
					}
				} else {
					break;
				}
			}
			while (i + 1 < row && j - 1 >= 0) {
				if (feld[i][j].getOwner() != null
						&& feld[i + 1][j - 1].getOwner() != null) {
					if (feld[i][j].getOwner().equals(p)
							&& feld[i + 1][j - 1].getOwner().equals(p)) {
						numbers++;
						i++;
						j--;
						if (numbers > fourInDiagonalCounterTwo) {
							fourInDiagonalCounterTwo = numbers;
						}
						continue;
					} else {
						numbers = 1;
						break;
					}
				} else {
					numbers = 1;
					break;
				}

			}
			if (numbers > fourInDiagonalCounterTwo) {
				fourInDiagonalCounterTwo = numbers;
			}
		} catch (java.lang.ArrayIndexOutOfBoundsException e) {LOGGER.log(Level.SEVERE, ausnahme, e);
		}
		return fourInDiagonalCounterTwo;
	}

	@Override
	public boolean getDraw(Feld[][] f) {
		int i = 0;
		boolean rueckgabe = false;
		while (i < column) {
			if (f[0][i].getOwner() != null) {
				rueckgabe = true;
				i++;
			} else {
				rueckgabe = false;
				break;
			}
		}
		return rueckgabe;
	}

	@Override
	public boolean getWin(Feld[][] f, Player p, int currentRow,
			int currentColumn) {
        LOGGER.setLevel(Level.INFO);
		try {
			if (fourInRow(currentRow, f, p) >= 4
					|| fourInColumn(currentColumn, f, p) >= 4
					|| fourDiagonal(f, p, currentRow, currentColumn)) {
				return true;
			}
		} catch (java.lang.ArrayIndexOutOfBoundsException e) {LOGGER.log(Level.SEVERE, ausnahme, e);
		}
		return false;
	}
	
	public int getColumn(){
		return column;
	}
	
	public int getRow(){
		return row;
	}
}
