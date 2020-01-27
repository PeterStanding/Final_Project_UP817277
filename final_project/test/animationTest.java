/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 *
 * @author up817277
 * 
 * Source: https://www.youtube.com/watch?v=I3usNR8JrEE
 * Credit: John Gizdich
 */
public class animationTest extends JPanel implements ActionListener {
    
    Timer tm = new Timer(5,this);
    //x = Position 
    //velX = Speed 
    int x = 0, velX = 2;
    
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        
        g.setColor(Color.RED);
        g.fillRect(x,30,50,30);
        
        tm.start();
    }
    
    public void actionPerformed(ActionEvent e){
        if (x < 0 || x > 550){
            velX = -velX;
        }
        
        x = x + velX;
        repaint();
    }
    
    public static void main(){
        animationTest t = new animationTest();
        JFrame jf = new JFrame();
        jf.setTitle("Animation Test");
        jf.setSize(600,400);
        jf.setVisible(true);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.add(t);
    }
}
