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
 * @author Peter Standing - UP817277
 */
public class gameTwo extends Canvas {
    
    private ArrayList<Integer> values;
    private static ArrayList<Integer> positions;
    private static ArrayList<String> questions;
    public static String diff, skill;
    public Color red,green,blue,gold,wood;
    public static int width, height, buttonPressed, posLoc, active, qq, score, bg;
    public static int xRocket, yRocket;
    public static JButton ans1,ans2,ans3,ans4;
    public static JLabel question;
    public static Boolean update;
    public static JFrame frame;
    
    public static void main(String difficulty, String sk){
        frame = new gameFrame();
        Canvas canvas = new gameTwo(difficulty,sk);
        canvas.setSize(1000,1000);
        frame.add(canvas);
        frame.pack();
        frame.setVisible(true);
    }
    public gameTwo (String difficulty, String sk){
        diff = difficulty;
        skill = sk;
        width = height = 1000;
        posLoc = qq = bg = buttonPressed = active = score = 0;
        xRocket = 380;
        yRocket = 312;
        update = false;
        
        values = new ArrayList<Integer>();
        positions = new ArrayList<Integer>();
        questions = new ArrayList<String>();
         //Colours
        red = new Color(255,0,0);
        blue = new Color(0,0,255);
        green = new Color(0,255,0);
        gold = new Color(184,169,59);
        wood = new Color(117,86,50);

        if (skill.equals("Addition")){
        questions = ks2Functions.generateQ(10,"+");
        }
        if (skill.equals("Subtraction")){
            questions = ks2Functions.generateQ(10,"-");
        }
        if (skill.equals("Multiplication")){
            questions = ks2Functions.generateQ(10,"*");
        }
        if (skill.equals("Division")){
            questions = ks2Functions.generateQ(10,"/");
        }
        if (skill.equals("Rounding")){
            questions = ks2Functions.generateQ(10,"^");
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

        for (int i = 0; i < 8; i++){
            int pp = ks2Functions.randomPosition();
            positions.add(pp);
        }
        
        //bg = ks2Functions.randomNumberAlg();
        bg = 0;
    }
     
    public void paint(Graphics g){
        //Selects the background based on and random number between 0 and 10
        if (bg <= 1){
            //Earth
            Color bgColor = blue;
            drawEarth(g,bgColor);
            drawRocket(g,xRocket,yRocket,bgColor);
            drawFuelGauge(g,score);
        } else if (bg > 1 && bg <= 3){
            //Mars
            Color bgColor = blue;
            drawMars(g);
            drawRocket(g,xRocket,yRocket,Color.BLACK);
            drawRocket(g,xRocket,yRocket,bgColor);
            drawFuelGauge(g,score);
        } else if (bg > 3 && bg <= 5){
            //Venus
            Color bgColor = blue;
            drawVenus(g);
            drawRocket(g,xRocket,yRocket,Color.BLACK);
            drawRocket(g,xRocket,yRocket,bgColor);
            drawFuelGauge(g,score);
        } else if (bg > 5 && bg <= 7){
            //Pluto
            Color bgColor = blue;
            drawPluto(g);
            drawRocket(g,xRocket,yRocket,Color.BLACK);
            drawRocket(g,xRocket,yRocket,bgColor);
            drawFuelGauge(g,score);
        } else if (bg > 7 && bg <= 9){
            //Neptune
            Color bgColor = blue;
            drawNeptune(g);
            drawRocket(g,xRocket,yRocket,Color.BLACK);
            drawRocket(g,xRocket,yRocket,bgColor);
            drawFuelGauge(g,score);
        } else if (bg == 10){
            //Golden City
            Color bgColor = gold;
            drawGoldenCity(g);
            drawRocket(g,xRocket,yRocket,Color.BLACK);
            drawRocket(g,xRocket,yRocket,bgColor);
            drawFuelGauge(g,score);
        }
                
        question.setText(questions.get(qq));
        if (positions.get(posLoc) == 1){
            ans1.setText(questions.get(qq+1));

            ans2.setText(questions.get(qq+1)+1);
            ans3.setText(questions.get(qq));
            ans4.setText(questions.get(qq+3));
        }
        if (positions.get(posLoc) == 2){
            ans2.setText(questions.get(qq+1));
            
            ans1.setText(questions.get(qq+1)+1);
            ans3.setText(questions.get(qq));
            ans4.setText(questions.get(qq+3));
        }
        if (positions.get(posLoc) == 3){
            ans3.setText(questions.get(qq+1));
            
            ans2.setText(questions.get(qq+1)+1);
            ans1.setText(questions.get(qq));
            ans4.setText(questions.get(qq+3));
        }
        if (positions.get(posLoc) == 4){
            ans4.setText(questions.get(qq+1));
            
            ans2.setText(questions.get(qq+1)+1);
            ans3.setText(questions.get(qq));
            ans1.setText(questions.get(qq+3));
        }
        
        if (buttonPressed == positions.get(posLoc)){
            //System.out.println("Correct");
            posLoc +=1;
            qq += 2;
            score += 1;
            //System.out.print(score);
            if (posLoc == positions.size()||qq==questions.size()){
                posLoc = 0;
                qq = 0;
            }
            
            if (score == 8){
                bg = ks2Functions.randomNumberAlg();
                //frame.dispose();
            }
            repaint();
        } else {}
    }
     
    private void drawRocket(Graphics g,int sX, int sY, Color clr){
        //Rocket Legs
        g.setColor(Color.GRAY);
        g.fillOval(sX+180,sY+350,80,230);
        g.fillOval(sX+5,sY+350,80,230);
        
        g.setColor(clr);
        g.fillOval(sX+145,sY+450,90,180);
        g.fillOval(sX+35,sY+450,90,180);
        
        //Rocket point
        g.setColor(Color.GRAY);
        int xPoints[] = {sX+60,sX+130,sX+200};
        int yPoints[] = {sY+80,sY-70,sY+80};
        g.fillPolygon(xPoints,yPoints,3);
        
        //Rocket Body
        g.setColor(green);
        g.fillOval(sX+20,sY+20,220,480);
    }
    private void drawFuelGauge(Graphics g, int sc){
        g.setColor(wood);
        g.fillRect(0, 890, width, 200);
        g.setColor(Color.ORANGE);
        g.fillOval(150,905,75,75);
        g.fillOval((width-225),905,75,75);
        g.setColor(wood);
        g.fillRect(186,905,40,75);
        g.fillRect((width-225),905,40,75);
        g.setColor(Color.ORANGE);
        if (sc >= 1){
            g.fillRect(200,910,60,65);
            if (sc >= 2){
               g.fillRect(277,910,60,65);        
                if (sc >= 3){
                    g.fillRect(354,910,60,65);        
                    if (sc >= 4){
                    g.fillRect(431,910,60,65);        
                        if (sc >= 5){
                         g.fillRect(508,910,60,65);
                            if (sc >= 6){
                              g.fillRect(585,910,60,65);
                                if (sc >= 7){
                                g.fillRect(662,910,60,65);
                                    if (sc >= 8){
                                    g.fillRect(739,910,60,65);
        }}}}}}}}        
    }
    private void drawEarth(Graphics g,Color clr){
        g.setColor(clr);
        g.fillRect(0, 0, width, height);
    }
    private void drawVenus(Graphics g){
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, width, height);
    }
    private void drawMars(Graphics g){
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, width, height);
    }
    private void drawPluto(Graphics g){
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, width, height);
    }
    private void drawNeptune(Graphics g){
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, width, height);
    }
    private void drawGoldenCity(Graphics g){
        g.setColor(Color.BLACK);
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
            
            ans1 = new JButton("Answer 1");
            ans2 = new JButton("Answer 2");
            ans3 = new JButton("Answer 3");
            ans4 = new JButton("Answer 4");
            JButton updateButton = new JButton("update");
            question = new JLabel("Question",JLabel.CENTER);
            
            ans1.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    buttonPressed = 1;
                    System.out.println("Button 1");
                }
            });
            ans2.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    buttonPressed = 2;
                    System.out.println("Button 2");
                }
            });
            ans3.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    buttonPressed = 3;
                    System.out.println("Button 3");
                }
            });
            ans4.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    buttonPressed = 4;
                    System.out.println("Button 4");
                }
            });
            updateButton.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    update = true;
                }
            });
            
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
