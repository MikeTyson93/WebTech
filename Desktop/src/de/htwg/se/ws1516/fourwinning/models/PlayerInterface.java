package de.htwg.se.ws1516.fourwinning.models;

public interface PlayerInterface {
	String getName();
	void setActive(boolean zustand);
	boolean getActive();
	void chipSetted();
	int getMenge();
}
