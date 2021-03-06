/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package final_project;

import java.awt.Dimension;
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
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.Timer;
import java.util.TimerTask;

/**
 *
 * @author Peter Standing - UP817277
 */
public class gameTwo extends Canvas {
    
    private ArrayList<Integer> values;
    private static ArrayList<Integer> positions;
    private static ArrayList<String> questions;
    public static String diff, skill, currName;
    public static Color red,green,blue,gold,wood,skyBlue,lightGray,nightBlue,mars;
    public static Color darkOrange,orangeShade,martianGreen,goldBuild,silver,lightBlue;
    public static Color pluto,venus,neptune,brown,nepBuild,rocketBody,rocketWin,bgColor;
    public static int width, height, buttonPressed, posLoc,qq, score, bg;
    public static int xRocket, yRocket,levelInc,active,once;
    public static JButton ans1,ans2,ans3,ans4,updateButton,closeTab,nextLevel;
    public static JLabel question,scoreRocket,levelText,timerTag;
    public static Boolean update,stars;
    public static JFrame frame;
    
    /**
     * Main function of the game
     * 
     * @param difficulty Difficulty that the user has chosen to implement
     * @param sk Skill that the user has chosen to implement
     * @param stuName Name of the current student
     */
    public static void main(String difficulty, String sk, String stuName){
        frame = new gameFrame();
        Canvas canvas = new gameTwo(difficulty,sk,stuName);
        canvas.setSize(1000,1000);
        frame.add(canvas);
        frame.pack();
        frame.setVisible(true);
    }
    /**
     * Implements the variables used in the class, and assigns a value to them
     * 
     * @param difficulty Difficulty that the user has chosen to implement
     * @param sk Skill that the user has chosen to implement
     * @param stuName Name of the current student
     */
    public gameTwo (String difficulty, String sk, String stuName){
        diff = difficulty;
        skill = sk;
        currName = stuName;
        width = height = 1000;
        posLoc = qq = bg = buttonPressed = active = score = 0;
        levelInc = once = 1;
        xRocket = 380;
        yRocket = 312;
        update = false;
        stars = true;
        
        values = new ArrayList<Integer>();
        positions = new ArrayList<Integer>();
        questions = new ArrayList<String>();
         //Colours
        red = new Color(255,0,0);
        blue = new Color(0,0,255);
        green = new Color(0,255,0);
        gold = new Color(184,169,59);
        goldBuild = new Color(128,89,0);
        wood = new Color(117,86,50);
        skyBlue = new Color(111,185,227);
        lightGray = new Color(227,227,227);
        nightBlue = new Color(32,41,71);
        mars = new Color(156,78,5);
        darkOrange = new Color(200,103,28);
        orangeShade= new Color(89,33,1);
        martianGreen = new Color(0,112,6);
        silver = new Color(153,153,153);
        lightBlue = new Color(117,255,255);
        pluto = new Color(49,0,89);
        neptune = new Color(38,38,84);
        venus = new Color(237,142,74);
        brown = new Color(82,44,14);
        nepBuild = new Color(83,29,145);
        rocketBody = new Color(130,18,18);
        rocketWin= new Color(1,120,122);
        
        if (skill.equals("Addition")){
        questions = ks2Functions.generateQ(12,"+");
        }
        if (skill.equals("Subtraction")){
            questions = ks2Functions.generateQ(12,"-");
        }
        if (skill.equals("Multiplication")){
            questions = ks2Functions.generateQ(12,"*");
        }
        if (skill.equals("Division")){
            questions = ks2Functions.generateQ(12,"/");
        }
        if (skill.equals("Rounding")){
            questions = ks2Functions.generateQ(12,"^");
        }
        if (skill.equals("Algebra")){
            questions = ks2Functions.generateQ(12,"Alg");
        }
        if (skill.equals("Percentages")){
            questions = ks2Functions.generateQ(12,"%");
        }
        if (skill.equals("Ratio")){
            questions = ks2Functions.generateQ(12,":");
        }
        if (skill.equals("Fraction")){
            questions = ks2Functions.generateQ(12,"//");
        }

        for (int i = 0; i < 8; i++){
            int pp = ks2Functions.randomPosition();
            positions.add(pp);
        }
        
        timeCounter timer = new timeCounter();
        timer.start();
        
        bg = ks2Functions.randomNumberAlg();
    }
     
    /**
     * A method to illustrate the game
     * 
     * @param g Graphic package to illustrate the game
     */
    public void paint(Graphics g){
        if (score == 8){
            //timer.stop();
            levelInc += 1;
            
            //Defines Which JComponents are Visible
            question.setVisible(false);
            ans1.setVisible(false);
            ans2.setVisible(false);
            ans3.setVisible(false);
            ans4.setVisible(false);
            updateButton.setVisible(false);
            scoreRocket.setVisible(false);
            timerTag.setVisible(false);
            
            closeTab.setVisible(true);
            nextLevel.setVisible(true);
            levelText.setVisible(true);
            if (once == 1){
                animation.main();
            }
            once = 0;
            /*
            drawEarth(g,bgColor);
            drawRocket(g,xRocket,yRocket,bgColor,bgColor);
            drawFuelGauge(g,score);
            */
            //If Next Level Button is pressed enter this Loop
            if (active == 1){
                score = 0;
                active = 0;
                once = 1;
                bg = ks2Functions.randomNumberAlg();
                stars = true;
                
                timeCounter timer = new timeCounter();
                timer.start();
                
                repaint();
            }
        } else {
            //Defines Which JComponents are Visible
            question.setVisible(true);
            ans1.setVisible(true);
            ans2.setVisible(true);
            ans3.setVisible(true);
            ans4.setVisible(true);
            updateButton.setVisible(true);
            scoreRocket.setVisible(true);
            timerTag.setVisible(true);
            
            closeTab.setVisible(false);
            nextLevel.setVisible(false);
            levelText.setVisible(false);
            
            //Selects the background based on and random number between 0 and 10
            if (bg <= 1){
                //Earth
                bgColor = nightBlue;
                drawEarth(g,bgColor);
                drawRocket(g,xRocket,yRocket,bgColor,bgColor);
                drawFuelGauge(g,score);
            } else if (bg > 1 && bg <= 3){
                //Mars
                bgColor = mars;
                drawMars(g,bgColor);
                drawRocket(g,xRocket,yRocket,orangeShade,orangeShade);
                drawFuelGauge(g,score);
            } else if (bg > 3 && bg <= 5){
                //Venus
                bgColor = venus;
                drawVenus(g,bgColor);
                drawRocket(g,xRocket,yRocket,bgColor,bgColor);
                drawFuelGauge(g,score);
            } else if (bg > 5 && bg <= 7){
                //Pluto
                bgColor = pluto;
                drawPluto(g,bgColor);
                drawRocket(g,xRocket,yRocket,bgColor,bgColor);
                drawFuelGauge(g,score);
            } else if (bg > 7 && bg <= 9){
                //Neptune
                bgColor = neptune;
                drawNeptune(g,bgColor);
                drawRocket(g,xRocket,yRocket,bgColor,bgColor);
                drawFuelGauge(g,score);
            } else if (bg == 10){
                //Golden City
                bgColor = gold;
                drawGoldenCity(g,bgColor);
                drawRocket(g,xRocket,yRocket,bgColor,bgColor);
                drawFuelGauge(g,score);
            }

            question.setText(questions.get(qq));
            if (positions.get(posLoc) == 1){
                ans1.setText(questions.get(qq+1));

                ans2.setText(questions.get(qq+1)+1);
                ans3.setText("None Of Them");
                ans4.setText(questions.get(qq+3));
            }
            if (positions.get(posLoc) == 2){
                ans2.setText(questions.get(qq+1));

                ans1.setText(questions.get(qq+1)+1);
                ans3.setText("None Of Them");
                ans4.setText(questions.get(qq+3));
            }
            if (positions.get(posLoc) == 3){
                ans3.setText(questions.get(qq+1));

                ans2.setText(questions.get(qq+1)+1);
                ans1.setText("None Of Them");
                ans4.setText(questions.get(qq+3));
            }
            if (positions.get(posLoc) == 4){
                ans4.setText(questions.get(qq+1));

                ans2.setText(questions.get(qq+1)+1);
                ans3.setText("None Of Them");
                ans1.setText(questions.get(qq+3));
            }

            //If Correct Answer
            if (buttonPressed == positions.get(posLoc)){
                //System.out.println("Correct");
                posLoc +=1;
                qq += 2;
                score += 1;
                scoreRocket.setText(Integer.toString(score)+" / 8");
                //System.out.print(score);
                if (posLoc == positions.size()||qq==questions.size()){
                    posLoc = 0;
                    qq = 0;
                }
                repaint();
            } else {
    }}}
    
    /**
     * Method to draw the Rocket
     * 
     * @param g Graphic package to illustrate the game
     * @param sX baseline X coordinate for the rocket
     * @param sY baseline Y coordinate for the rocket
     * @param clr Defines the colour used within the drawing
     * @param des Defines another colour used within the drawing
     */
    private static void drawRocket(Graphics g,int sX, int sY, Color clr, Color des){
        //Rocket Legs
        g.setColor(lightGray);
        g.fillOval(sX+180,sY+350,80,230);
        g.fillOval(sX+5,sY+350,80,230);
        
        g.setColor(clr);
        g.fillOval(sX+145,sY+450,90,180);
        g.setColor(des);
        g.fillOval(sX+35,sY+450,90,180);
        
        //Rocket point
        g.setColor(lightGray);
        int xPoints[] = {sX+60,sX+130,sX+200};
        int yPoints[] = {sY+80,sY-70,sY+80};
        g.fillPolygon(xPoints,yPoints,3);
        
        //Rocket Body
        g.setColor(rocketBody);
        g.fillOval(sX+20,sY+20,220,480);
        g.setColor(Color.GRAY);
        g.fillOval(sX+80,sY+60,100,100);
        g.setColor(rocketWin);
        g.fillOval(sX+88,sY+68,85,85);
        g.setColor(Color.DARK_GRAY);
        g.fillOval(sX+127,sY+61,7,7);
        g.fillOval(sX+127,sY+152,7,7);
        g.fillOval(sX+172,sY+106,7,7);
        g.fillOval(sX+81,sY+106,7,7);
        g.fillOval(sX+94,sY+74,7,7);
        g.fillOval(sX+94,sY+139,7,7);
        g.fillOval(sX+159,sY+139,7,7);
        g.fillOval(sX+159,sY+74,7,7);
        
        //Martians For Mars and Neptune
        if (clr.equals(orangeShade)){
            int marX = 0;
            int marY = 829;
            for (int mar = 0; mar <= 15; mar++){
                drawMartian(g, marX, marY);
                int change = ks2Functions.randomNumber100();
                marX += change;
        }} else if (clr.equals(neptune)){
            int marX = 0;
            int marY = 829;
            for (int mar = 0; mar <= 15; mar++){
                drawMartian(g, marX, marY);
                int change = ks2Functions.randomNumber100();
                marX += change;
        }}
    }
    /**
     * Method to draw the Fuel gauge, which gets updated based on the current score
     * 
     * @param g Graphic package to illustrate the game
     * @param sc score values in the game
     */
    private static void drawFuelGauge(Graphics g, int sc){
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
    /**
     * Method to draw the stars within the background
     * 
     * @param g Graphic package to illustrate the game
     * @param starX baseline X coordinate for the star
     * @param starY baseline Y coordinate for the star
     */
    private static void drawStar(Graphics g, int starX, int starY){
        g.setColor(Color.WHITE);
        int xPoints[] = {starX+60,starX+70,starX+80};
        int yPoints[] = {starY+80,starY+70,starY+80};
        int xPointsInv[] = {starX+60,starX+70,starX+80};
        int yPointsInv[] = {starY+80,starY+90,starY+80};
        g.fillPolygon(xPoints,yPoints,3);
        g.fillPolygon(xPointsInv,yPointsInv,3);
    }
    /**
     * Method to draw multiple stars for the background
     * 
     * @param g Graphic package to illustrate the game
     */
    private static void drawMultiStar(Graphics g){  
        int starX = 0;
        int starY = 0;
        for (int u = 0; u <= 15; u++){
            for (int xx = 0; xx <=10; xx++){
                drawStar(g,starX,starY);
                starX += ks2Functions.randomNumber100();
                if (starX >= 1000){
                    starX = 0;
                }
            }
            starY += ks2Functions.randomNumber100();
            if (starY >= 1000){
                starY = 0;
            }  
        }
        
    }
    /**
     * Method to draw the aliens on the launch pad
     * 
     * @param g Graphic package to illustrate the game
     * @param marX baseline X coordinate for the martian
     * @param marY baseline Y coordinate for the martian
     */
    private static void drawMartian(Graphics g, int marX, int marY){
        g.setColor(martianGreen);
        g.fillOval(marX+10,marY+10,25,25);
        g.fillOval(marX+15,marY+15,15,50);
        g.fillOval(marX-3,marY+55,50,10);
        g.fillOval(marX+7,marY+35,30,10);
    }
    /**
     * Method to draw the Moon in the background 
     * 
     * @param g Graphic package to illustrate the game
     * @param bg Defines the colour used within the drawing
     */
    private static void drawMoon(Graphics g, Color bg){
        g.setColor(silver);
        g.fillOval(700,10,100,100);
        g.setColor(bg);
        g.fillOval(740,10,75,100);
    }
    /**
     * Method to draw the asteroids on a handful of the levels
     * 
     * @param g Graphic package to illustrate the game
     * @param astX baseline X coordinate for the asteroids
     * @param astY baseline Y coordinate for the asteroids
     */
    private static void drawAsteroid(Graphics g, int astX, int astY){
        //Asteroid
        g.setColor(brown);
        g.fillOval(astX+100,astY+400,75,75);
        g.setColor(Color.BLACK);
        g.fillOval(astX+110,astY+420,20,20);
        g.fillOval(astX+150,astY+460,10,10);
        g.fillOval(astX+165,astY+440,10,10);
        g.fillOval(astX+135,astY+450,10,10);
    }
    
    /**
     * Method to draw the Earth level for the game
     * 
     * @param g Graphic package to illustrate the game
     * @param clr Defines the colour used within the drawing
     */
    private static void drawEarth(Graphics g,Color clr){
        g.setColor(clr);
        g.fillRect(0, 0, width, height);
        if (stars){
            drawMultiStar(g);
        }
        g.setColor(Color.GRAY);
        g.fillRect(0,350,30,700);
        g.fillRect(30,500,125,400);
        g.fillRect(155,600,125,400);
        g.fillRect(755,525,300,700);
        
        g.fillRect(275,350,100,550);
        g.fillRect(650,350,100,550);
        g.fillRect(295,400,450,75);
    }
    /**
     * Method to draw the Mars level for the game
     * 
     * @param g Graphic package to illustrate the game
     * @param clr Defines the colour used within the drawing
     */
    private static void drawMars(Graphics g, Color clr){
        g.setColor(clr);
        g.fillRect(0, 0, width, height);
        if (stars){
            drawMultiStar(g);
        }
        
        g.setColor(orangeShade);
        g.fillOval(20,550,500,600);
        g.fillOval(300,350,500,1100);
        g.fillOval(800,850,100,100);
        g.fillOval(900,750,100,200);
        
        g.setColor(darkOrange);
        g.fillOval(100,650,75,75);
        g.fillOval(220,850,75,75);
        g.fillOval(275,725,75,75);
        g.fillOval(365,500,75,75);
        g.fillOval(550,600,75,75);
        g.fillOval(600,450,75,75);
        g.fillOval(625,820,75,75);
        g.fillOval(810,875,50,50);
        g.fillOval(900,850,25,25);
        g.fillOval(925,755,25,25);
        g.fillOval(950,800,25,25);
    }
    /**
     * Method to draw the Venus level for the game
     * 
     * @param g Graphic package to illustrate the game
     * @param clr Defines the colour used within the drawing
     */
    private static void drawVenus(Graphics g,Color clr){
        g.setColor(clr);
        g.fillRect(0, 0, width, height);
        if (stars){
            drawMultiStar(g);
        }
        drawMoon(g,clr);
        drawAsteroid(g,0,0);
        drawAsteroid(g,300,150);
        drawAsteroid(g,150,350);
        drawAsteroid(g,800,100);
        drawAsteroid(g,200,200);
        drawAsteroid(g,500,300);
        drawAsteroid(g,700,400);
        drawAsteroid(g,650,250);
        drawAsteroid(g,-50,300);
    }
    /**
     * Method to draw the Pluto level for the game
     * 
     * @param g Graphic package to illustrate the game
     * @param clr Defines the colour used within the drawing
     */
    private static void drawPluto(Graphics g, Color clr){
        g.setColor(clr);
        g.fillRect(0, 0, width, height);
        if (stars){
            drawMultiStar(g);
        }
        g.setColor(Color.GRAY);
        g.fillOval(0,750,100,400);
        g.fillOval(300,750,100,400);
        g.fillOval(100,550,200,500);
        g.setColor(Color.BLACK);
        g.fillOval(125,750,40,250);
        g.fillOval(230,750,40,250);
        g.fillOval(25,800,50,500);
        g.fillOval(325,800,50,500);
        g.setColor(Color.DARK_GRAY);
        g.fillOval(0,850,400,100);
        g.setColor(wood);
        g.fillOval(750,700,100,400);
        g.setColor(brown);
        g.fillOval(700,850,100,100);
        g.fillOval(825,750,100,300);
    }
    /**
     * Method to draw the Neptune level for the game
     * 
     * @param g Graphic package to illustrate the game
     * @param clr Defines the colour used within the drawing
     */
    private static void drawNeptune(Graphics g, Color clr){
        g.setColor(clr);
        g.fillRect(0, 0, width, height);
        if (stars){
            drawMultiStar(g);
        }
        drawMoon(g,clr);
        g.setColor(nepBuild);
        g.fillRect(100,700,250,300);
        g.fillOval(100,650,250,250);
        g.fillRect(700,700,250,300);
        g.fillOval(700,650,250,250);
        g.setColor(Color.BLACK);
        g.fillRect(175,800,45,300);
        g.fillOval(175,780,45,50);
        g.fillRect(775,800,45,300);
        g.fillOval(775,780,45,50);
    }
    /**
     * Method to draw the GoldenCity level for the game
     * 
     * @param g Graphic package to illustrate the game
     * @param clr Defines the colour used within the drawing
     */
    private static void drawGoldenCity(Graphics g, Color clr){
        g.setColor(clr);
        g.fillRect(0, 0, width, height);
        drawMoon(g,clr);
        g.setColor(goldBuild);
        g.fillOval(-300,150,450,500);
        g.fillOval(90,550,100,200);
        g.setColor(clr);
        g.fillOval(-250,150,355,500);
        g.fillOval(90,560,80,180);
        g.setColor(goldBuild);
        g.fillRect(10,150,35,800);
        g.fillRect(100,550,35,800);
        g.fillRect(800,600,100,300);
        g.fillRect(900,400,100,600);
        int xPoints[] = {750,900,900};
        int yPoints[] = {600,400,600};
        g.fillPolygon(xPoints,yPoints,3);
        
        g.setColor(Color.yellow);
        g.fillRect(850,600,50,50);
       
    }
    
    /**
     * Class that creates the animation once the game has reached the relevant scores
     */
    public static class animation extends JPanel implements ActionListener{
        javax.swing.Timer tm = new javax.swing.Timer(5,this);
        //x = Position 
        //velX = Speed 
        int x = 0, velX = 2;
        int sX = 380;
        int sY = 312;  
        static JFrame jp = new JFrame();
        public void paintComponent(Graphics g){
            super.paintComponent(g);
            stars = false;
            if (bg <= 1){
                //Earth
                bgColor = nightBlue;
                drawEarth(g,bgColor);
            } else if (bg > 1 && bg <= 3){
                //Mars
                bgColor = mars;
                drawMars(g,bgColor);
            } else if (bg > 3 && bg <= 5){
                //Venus
                bgColor = venus;
                drawVenus(g,bgColor);
            } else if (bg > 5 && bg <= 7){
                //Pluto
                bgColor = pluto;
                drawPluto(g,bgColor);
            } else if (bg > 7 && bg <= 9){
                //Neptune
                bgColor = neptune;
                drawNeptune(g,bgColor);
            } else if (bg == 10){
                //Golden City
                bgColor = gold;
                drawGoldenCity(g,bgColor);
            }
            
            g.setColor(Color.RED);
            g.fillOval(sX+180,(sY+350)+x,80,230);
            g.fillOval(sX+5,(sY+350)+x,80,230);
            
            g.setColor(bgColor);
            g.fillOval(sX+145,(sY+450)+x,90,180);
            g.setColor(bgColor);
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
            
            drawFuelGauge(g,score);
            
            tm.start();
        }
        public void actionPerformed(ActionEvent e){
            x = x - velX;
            if (x < -1000){
                jp.hide();
            }
            repaint();
        }
        public static void main(){
            animation t = new animation();
            jp.setTitle("Animation Test");
            jp.setSize(1000,1000);
            jp.setVisible(true);
            jp.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            jp.add(t);
        }        
    }
    
    /**
     * Class that implements threads as a timer that stops the game once the time is finished
     */
    public class timeCounter extends Thread{
        public void run(){
            int i = 90;
            if (diff.equals("medium")){
                i = 75;
            }
            if (diff.equals("hard")){
                i = 60;
            }
            for (int j = i; j >=0;j--){
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(timeCounter.class.getName()).log(Level.SEVERE, null, ex);
                }
                //System.out.println(i);

                String time = String.valueOf(j);
                
                timerTag.setText(time);
                if (time.equals("0")){
                    System.out.println("Game Over");
                    question.setVisible(false);
                    ans1.setVisible(false);
                    ans2.setVisible(false);
                    ans3.setVisible(false);
                    ans4.setVisible(false);
                    updateButton.setVisible(false);
                    scoreRocket.setVisible(false);
                    timerTag.setVisible(false);

                    closeTab.setVisible(true);
                    nextLevel.setVisible(false);
                    levelText.setVisible(true);
                    
                    levelText.setText("Game Over - Time Ran Out");
                }
            }
        }
    }
    
    /**
     * Creates the gameFrame that the game runs in, with a canvas and some buttons to interact with
     */
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
            updateButton = new JButton("update");
            closeTab = new JButton("Close Tab");
            nextLevel = new JButton("Next Level"); 
            
            String levelNum = Integer.toString(levelInc);
            levelText = new JLabel("Congratulations, You Passed Level "+levelNum,JLabel.CENTER);
            question = new JLabel("Question",JLabel.CENTER);
            scoreRocket = new JLabel("Score",JLabel.CENTER);
            timerTag = new JLabel("Timer",JLabel.CENTER);
            
            ans1.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    buttonPressed = 1;
                    //System.out.println("Button 1");
                }
            });
            ans2.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    buttonPressed = 2;
                    //System.out.println("Button 2");
                }
            });
            ans3.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    buttonPressed = 3;
                    //System.out.println("Button 3");
                }
            });
            ans4.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    buttonPressed = 4;
                    //System.out.println("Button 4");
                }
            });
            updateButton.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    update = true;
                }
            });
            nextLevel.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    active = 1;
                }
            });
            closeTab.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    ArrayList <String> nameList = keyFunctions.readFile("db/names.txt");
                    ArrayList <String> rocketList = keyFunctions.readFile("db/rocketScores.txt");
                    ArrayList <String> coinList = keyFunctions.readFile("db/coins.txt");
                    
                    int k = nameList.indexOf(currName);
                    String scoreWrite = Integer.toString(score);
                    int c = Integer.parseInt(coinList.get(k));
                    int newC = 0;
                    
                    if(diff.equals("easy")){
                        //10 Coins per Level
                        newC = c+(10*levelInc);
                    }
                    if(diff.equals("medium")){
                        //20 Coins per Level
                        newC = c+(20*levelInc);
                    }
                    if(diff.equals("hard")){
                        //30 Coins per Level
                        newC = c+(30*levelInc); 
                    }
                    
                    String coinWrite = Integer.toString(newC);
                    keyFunctions.writeFile("db/rocketScores.txt",scoreWrite,k);
                    keyFunctions.writeFile("db/coins.txt",coinWrite,k);
                    
                    frame.dispose();
                }
            });
            
            JPanel panel = new JPanel();
            panel.setPreferredSize(new Dimension(450,1000));
            panel.setLayout(null);
            
            levelText.setFont(new Font("Serif",Font.BOLD,24));
            levelText.setLocation(50,30);
            levelText.setSize(375,42);
                        
            question.setFont(new Font("Serif",Font.BOLD,30));
            question.setLocation(50,125);
            question.setSize(375,42);
            
            scoreRocket.setFont(new Font("Serif",Font.BOLD,30));
            scoreRocket.setLocation(150,470);
            scoreRocket.setSize(375,42);
            
            timerTag.setFont(new Font("Serif",Font.BOLD,24));
            timerTag.setLocation(50,75);
            timerTag.setSize(375,42);
            
            ans1.setBounds(50,200,150,75);
            ans2.setBounds(275,200,150,75);
            ans3.setBounds(50,300,150,75);
            ans4.setBounds(275,300,150,75);
            updateButton.setBounds(50,450,150,75);
            nextLevel.setBounds(162,550,150,75);
            closeTab.setBounds(162,750,150,75);
            
            panel.add(ans1);
            panel.add(ans2);
            panel.add(ans3);
            panel.add(ans4);
            panel.add(updateButton);
            panel.add(question);
            panel.add(scoreRocket);
            panel.add(levelText);
            panel.add(nextLevel);
            panel.add(closeTab);
            panel.add(timerTag);
            
            this.getContentPane().add(panel);
        } 
    } 
}
