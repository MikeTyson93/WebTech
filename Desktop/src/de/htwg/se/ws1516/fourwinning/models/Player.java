package de.htwg.se.ws1516.fourwinning.models;

public class Player implements PlayerInterface
{
    String name;
    int menge;
    boolean active;
    boolean gewonnen = false;
    public Player(String name, int menge){
        this.name = name;
        this.menge = menge;
    }
    
    @Override
    public String getName(){
        return name;
    }

    @Override
    public void setActive(boolean zustand){
        active = zustand;
    }

    @Override
    public boolean getActive(){
        return active;
    }

    @Override
    public void chipSetted(){
        menge--;
    }

    @Override
    public int getMenge(){
        return menge;
    }

    
}
