

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
        int sX = 380;
        int sY = 312; 
        
        Color rocketBody = new Color(130,18,18);
        Color rocketWin= new Color(1,120,122);
        Color lightGray = new Color(227,227,227);
        
        public void paintComponent(Graphics g){
            super.paintComponent(g);
/*
            g.setColor(Color.RED);
            g.fillRect(30,x,50,30);
  */          
            g.setColor(Color.RED);
            g.fillOval(sX+180,(sY+350)+x,80,230);
            g.fillOval(sX+5,(sY+350)+x,80,230);
            
            g.setColor(Color.BLUE);
            g.fillOval(sX+145,(sY+450)+x,90,180);
            g.setColor(Color.BLUE);
            g.fillOval(sX+35,(sY+450)+x,90,180);
            
            g.setColor(Color.RED);
            int xPoints[] = {sX+60,sX+130,sX+200};
            int yPoints[] = {(sY+80)+x,(sY-70)+x,(sY+80)+x};
            g.fillPolygon(xPoints,yPoints,3);
            
            g.setColor(rocketBody);
            g.fillOval(sX+20,(sY+20)+x,220,480);
            g.setColor(Color.GRAY);
            g.fillOval(sX+80,(sY+60)+x,100,100);
            g.setColor(rocketWin);
            g.fillOval(sX+88,(sY+68)+x,85,85);
            g.setColor(Color.DARK_GRAY);
            g.fillOval(sX+127,(sY+61)+x,7,7);
            g.fillOval(sX+127,(sY+152)+x,7,7);
            g.fillOval(sX+172,(sY+106)+x,7,7);
            g.fillOval(sX+81,(sY+106)+x,7,7);
            g.fillOval(sX+94,(sY+74)+x,7,7);
            g.fillOval(sX+94,(sY+139)+x,7,7);
            g.fillOval(sX+159,(sY+139)+x,7,7);
            g.fillOval(sX+159,(sY+74)+x,7,7);
            
            tm.start();
        }
        public void actionPerformed(ActionEvent e){
            x = x - velX;
            repaint();
        }
        public static void main(){
            animationTest t = new animationTest();
            JFrame jf = new JFrame();
            jf.setTitle("Animation Test");
            jf.setSize(1000,1000);
            jf.setVisible(true);
            jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            jf.add(t);
        }
    }
