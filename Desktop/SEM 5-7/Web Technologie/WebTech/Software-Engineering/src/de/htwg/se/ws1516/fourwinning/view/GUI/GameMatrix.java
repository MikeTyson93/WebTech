/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package de.htwg.se.ws1516.fourwinning.view.GUI;


import java.io.IOException;
import javax.swing.*;
import java.awt.*;

import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

public class GameMatrix extends JPanel {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1896725534521179915L;
	//JPanel gameMatrix;
    private int rows;
    private int columns;
    private BufferedImage leer;
    private BufferedImage rot;
    private BufferedImage gelb;
    private int columnWidth;
    private int rowHeight;
    private int [] [] feldZustand;
    public GameMatrix(int rows, int columns) throws IOException{
        this.feldZustand = new int [rows][columns];
        this.rows = rows;
        this.columns = columns;
        //this.setLayout(null);
         leer = ImageIO.read(GameMatrix.class.getResource("leer.gif"));
         rot = ImageIO.read(GameMatrix.class.getResource("rot.gif"));
         gelb = ImageIO.read(GameMatrix.class.getResource("gelb.gif"));
         columnWidth = leer.getWidth();
         rowHeight = leer.getHeight();
        //gameMatrix = new JPanel();
        this.setLayout(null);
        this.setPreferredSize(new Dimension(columns * columnWidth, rows * rowHeight));
        //this.setResizable(true);
        //l1.setIcon(bildLeer);
        //this.add(l1);
        
        setVisible(true);
    }

    public void setLeer(int rows, int columns) {
        this.feldZustand[rows][columns] = 0;
    }
    
    public void setRot(int rows, int columns) {
        this.feldZustand[rows][columns] = 1;
    }
    
     public void setGelb(int rows, int columns) {
        this.feldZustand[rows][columns] = 2;
    }
    
    
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        int x = 0;
        int y = 0;
        
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (feldZustand[i][j] == 0) {
                    g.drawImage(leer,x,y,this);
                } else if (feldZustand[i][j] == 1) {
                    g.drawImage(rot,x,y,this);
                } else if (feldZustand[i][j] == 2) {
                    g.drawImage(gelb,x,y,this);
                }
                
                x+=columnWidth;
            }
            x = 0;
            y  += rowHeight;
        }
        
    }
    
    
}