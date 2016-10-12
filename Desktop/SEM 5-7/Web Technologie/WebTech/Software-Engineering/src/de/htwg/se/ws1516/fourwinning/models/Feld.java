package de.htwg.se.ws1516.fourwinning.models;

public class Feld implements FeldInterface
{
    boolean isSet = false;
    Player owner;
    private int x;
    private int y;
    
    public Feld(int x, int y, Player owner)
    {
        this.owner = owner;
        this.x = x;
        this.y = y;
    }
    
    public int getX(){
    	return x;
    }
    
    public int getY(){
    	return y;
    }
    
    @Override
    public boolean getSet(){
        return isSet;    
    }
    
    @Override
    public Player getOwner(){
        return owner;
    }
    
    @Override
    public void setOwner(Player owner){
        this.owner = owner;
        isSet = true;
    }
}
