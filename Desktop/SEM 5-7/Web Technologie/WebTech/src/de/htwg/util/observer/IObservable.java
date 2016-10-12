package de.htwg.util.observer;

import java.util.List;

public interface IObservable {

	void addObserver (IObserver s);
	
	void removeObserver(IObserver s);
	
	void removeAllObservers();
	
	void notifyObservers();
	
	void notifyObservers(Event e);
	
	List<IObserver> getObserverList();
}
