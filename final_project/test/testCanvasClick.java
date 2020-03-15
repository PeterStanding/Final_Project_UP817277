/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author peter
 * https://www.youtube.com/watch?v=NWqDmSowp3k&t=27s
 * Credit: thestartutor (2011)
 */

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.*;
import javax.swing.JFrame;

public class testCanvasClick extends Canvas implements MouseListener, MouseMotionListener {
    Color clr;
    String occured = "Nothing";
    Boolean update = true;
    
    testCanvasClick(){
        super();
        JFrame appWindow = new JFrame("Painting Window");
        appWindow.setSize(800,600);
        appWindow.setBackground(Color.GRAY);
        appWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        appWindow.setVisible(true);
        appWindow.setLayout(new GridLayout());
        
        appWindow.add(this);
        setVisible(true);
        clr = Color.WHITE;
        setBackground(clr);
        
        addMouseListener(this);
        addMouseMotionListener(this);
        
    }
    public void paint(Graphics g){
        if(update){
        g.drawString("Here is some text",200,200);
        g.drawRect(100,250,100,200);
        g.drawString(occured, 100, 300);
        update = false;
        }else{
            g.setColor(Color.RED);
            g.drawRect(100,300,200,100);
        }
    }
    
    public void mouseDragged(MouseEvent e){
        occured = "Dragged";
        repaint();
    }
    public void mouseMoved(MouseEvent e){
        occured = "Moved";
        repaint();
    }
    
    public void mouseClicked(MouseEvent e){
        occured = "Clicked";
        update = false;
        repaint();
    }
    public void mousePressed(MouseEvent e){
        occured = "Pressed";
        
        repaint();
    }
    public void mouseExited(MouseEvent e){
        occured = "Exited";
        repaint();
    }
    public void mouseEntered(MouseEvent e){
        occured = "Entered";
        repaint();
    }
    public void mouseReleased(MouseEvent e){
        occured = "Released";
        repaint();
    }

    
}
