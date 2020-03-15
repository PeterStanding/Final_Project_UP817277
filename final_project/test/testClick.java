/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author peter
 * https://www.youtube.com/watch?v=CajXXmhIndI
 * Credit: Telusko (2015)
 */

import javax.swing.JFrame;
import java.awt.FlowLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class testClick {
    
    public static void main(String[] args){
        Xyz obj = new Xyz();
    }
}
class Xyz extends JFrame{
    public Xyz(){
        addMouseListener(new MouseAdapter(){
            public void mousePressed(MouseEvent e){
                int x = e.getX();
                int y = e.getY();
                
                System.out.println(x+","+y);
            }
        });
        
        setLayout(new FlowLayout());
        setVisible(true);
        setSize(400,400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
    }
}
