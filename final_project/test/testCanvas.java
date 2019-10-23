/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JFrame;

/**
 *
 * @author peter
 */
public class testCanvas extends Canvas {
    public static void main(String[] args){
        JFrame frame = new JFrame("Test");
        Canvas canvas = new testCanvas();
        canvas.setSize(400,400);
        frame.add(canvas);
        frame.pack();
        frame.setVisible(true);
    }
    
    public void paint(Graphics g){
        g.fillOval(100, 100, 200, 200);
        drawRect(g);
    }
    
    private void drawRect(Graphics g){
        g.setColor(Color.red);
        g.fillRect(100,50,200,100); 
    }
 
}
