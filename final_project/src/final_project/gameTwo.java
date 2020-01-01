/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package final_project;

import java.awt.event.MouseEvent;
import java.awt.Dimension;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.util.ArrayList;
import javax.swing.*;
import java.awt.FlowLayout;
import java.lang.Math.*;
import java.util.ArrayList;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

/**
 *
 * @author peter
 */
public class gameTwo extends Canvas {
    
    private ArrayList<Integer> values;
    private ArrayList<String> questions;
    public String diff, skill;
    public Color red,green,blue;
    public int width, height;
    
    public static void main(String difficulty, String sk){
        JFrame frame = new gameFrame();
        Canvas canvas = new gameTwo(difficulty,sk);
        canvas.setSize(1000,1000);
        frame.add(canvas);
        frame.pack();
        frame.setVisible(true);
    }
    
    public gameTwo (String difficulty, String sk){
        diff = difficulty;
        skill = sk;
        width = 1000;
        height = 1000;
        values = new ArrayList<Integer>();
        questions = new ArrayList<String>();
         //Colours
        red = new Color(255,0,0);
        blue = new Color(0,0,255);
        green = new Color(0,255,0);
        if (skill.equals("Addition")){
            questions = ks2Functions.generateQ(8,"+");
        }
        if (skill.equals("Subtraction")){
            questions = ks2Functions.generateQ(8,"-");
        }
        if (skill.equals("Multiplication")){
            questions = ks2Functions.generateQ(8,"*");
        }
        if (skill.equals("Division")){
            questions = ks2Functions.generateQ(8,"/");
        }
        if (skill.equals("Rounding")){
            questions = ks2Functions.generateQ(8,"^");
        }
        if (skill.equals("Algebra")){
            questions = ks2Functions.generateQ(8,"Alg");
        }
        if (skill.equals("Percentages")){
            questions = ks2Functions.generateQ(8,"%");
        }
        if (skill.equals("Ratio")){
            questions = ks2Functions.generateQ(8,":");
        }
        if (skill.equals("Fraction")){
            questions = ks2Functions.generateQ(8,"//");
        }
    }
     
    public void paint(Graphics g){
        drawBackground(g);
        drawRocket(g); 
    }
     
    private void drawRocket(Graphics g){
        g.setColor(red);
        g.fillRect(0,0,150,150);
    }
    private void drawBackground(Graphics g){
        g.setColor(Color.CYAN);
        g.fillRect(0, 0, width, height);
    }
        
    private static class gameFrame extends JFrame{
        public gameFrame()
        { 
            setLayout(new FlowLayout());
            setSize(1200,200);
            setResizable(false);
            setVisible(true);
            setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
            
            JButton ans1 = new JButton("Answer 1");
            JButton ans2 = new JButton("Answer 2");
            JButton ans3 = new JButton("Answer 3");
            JButton ans4 = new JButton("Answer 4");
            JButton updateButton = new JButton("update");
            JLabel question = new JLabel("Question",JLabel.CENTER);
            
            ans1.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    question.setText("Answer 1");
                }
            });
            ans2.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    question.setText("Answer 2");
                }
            });
            ans3.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    question.setText("Answer 3");
                }
            });
            ans4.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    question.setText("Answer 4");
                }
            });
            updateButton.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    question.setText("It works");
                }
            });

            //ans1.setLocation(50,100);
            //ans2.setLocation(50,400);
            
            JPanel panel = new JPanel();
            panel.setPreferredSize(new Dimension(450,1000));
            panel.setLayout(null);
            
            question.setFont(new Font("Serif",Font.BOLD,30));
            question.setLocation(50,125);
            question.setSize(375,42);
            
            ans1.setBounds(50,200,150,75);
            ans2.setBounds(275,200,150,75);
            ans3.setBounds(50,300,150,75);
            ans4.setBounds(275,300,150,75);
            updateButton.setBounds(50,450,150,75);
            
            panel.add(ans1);
            panel.add(ans2);
            panel.add(ans3);
            panel.add(ans4);
            panel.add(updateButton);
            panel.add(question);
            
            
            this.getContentPane().add(panel);
            
        } 
    }
}
