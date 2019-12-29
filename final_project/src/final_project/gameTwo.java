/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package final_project;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.util.ArrayList;
import javax.swing.JFrame;
import java.awt.FlowLayout;
import java.lang.Math.*;

/**
 *
 * @author peter
 */
public class gameTwo extends Canvas {
    
    public String diff;
    public Color red,green,blue;
    public static int canWidth, canHeight;
    
    public static void main(String difficulty){
        JFrame frame = new gameFrame();
        Canvas canvas = new gameTwo(difficulty);
        canWidth = frame.getContentPane().getWidth();
        canHeight = frame.getContentPane().getHeight();
        canvas.setSize(canWidth-200,canHeight);
        frame.add(canvas);
        frame.pack();
        frame.setVisible(true);
    }
    
    public gameTwo (String difficulty){
        diff = difficulty;
         //Colours
        red = new Color(255,0,0);
        blue = new Color(0,0,255);
        green = new Color(0,255,0);
    }
     
    public void paint(Graphics g){
        drawRocket(g); 
    }
     
    private void drawRocket(Graphics g){
        g.setColor(red);
    }
    
    
    private static class gameFrame extends JFrame{
        public gameFrame()
        { 
            setLayout(new FlowLayout());
            setExtendedState(this.MAXIMIZED_BOTH);
            setResizable(false);
            setVisible(true);
            setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        }    
    }
}
