/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package final_project;

//Importing the Packages Required
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import java.awt.FlowLayout;
import java.lang.Math.*;
import javax.swing.*;

/**
 *
 * @author Peter Standing - UP817277
 */
public class gameOne extends Canvas implements MouseListener {
    
    private ArrayList<Integer> cardOne;
    private ArrayList<Integer> correctCards;
    private ArrayList<String> randomQ;
    public String operation,diff,currName;
    public int qNum,width,redrawX,redrawY;
    public Graphics g;
    public int update,card,again,reset,correct,answer,score;
    public Boolean check;
    public Color darkGreen,gold,brown;
    public static JLabel timer;
    
     /**
     * A method to call for the canvas to be constructed so that game can successfully run
     * 
     * @param op Operation that the user would like to work on
     * @param m Number of questions that the system should generate
     * @param k Difficulty that the user has selected from the homePage
     * @param name Name of the student
     */
    public static void main(String op, int m, String k, String name){
        Canvas canvas = new gameOne(op,m,k,name);
    }
    
    /**
     * A method that creates all the variables and assigns a value to them
     * Also begins a thread which is used as a timer for the game to be completed before.
     * 
     * @param testString Operation that the user would like to work on
     * @param number Number of questions that the system should generate
     * @param difficulty Difficulty that the user has selected from the homePage
     * @param name Name of the student
     */
    public gameOne (String testString, int number, String difficulty, String name){
        operation = testString;
        qNum = number;
        diff = difficulty;
        currName = name;
        width = 0;
        redrawX = 0;
        redrawY = 0;
        card = 0;
        update = 0;
        again = 0;
        reset = 0;
        correct = 0;
        check = true;
        score = 0;
        //Colors
        darkGreen = new Color(17,138,45);
        gold = new Color(245,194,66);
        brown = new Color(74,35,0);
        
        cardOne = new ArrayList<Integer>();
        randomQ = new ArrayList<String>();
        correctCards = new ArrayList<Integer>();

        randomQ = ks1Functions.randomLayout(qNum,operation);
        
        System.out.print(randomQ);
        if (diff.equals("easy")){
            width = 850;
        }
        if (diff.equals("medium")){
            width = 1050;
        }
        if (diff.equals("hard")) {
            width = 1250;
        }
        
        JFrame frame = new myMouse(width);
        
        timeCounter timer = new timeCounter();
        timer.start();
                
        this.setSize(width,1300);
        //Uses This Code to register a mouse Click event on the Canvas
        this.addMouseListener(new MouseAdapter(){
            public void mousePressed(MouseEvent e){
                int mouseX = e.getX();
                int mouseY = e.getY();
                
                if (diff.equals("easy")){
                    chooseCardEasy(mouseX,mouseY);
                }
                if (diff.equals("medium")){
                    chooseCardMedium(mouseX,mouseY);
                }
                if (diff.equals("hard")) {
                    chooseCardHard(mouseX,mouseY);
                }
                //System.out.println(mouseX+","+mouseY);
                //System.out.println(roundedX+","+roundedY);
            }
        });
        frame.add(this);
        //frame.pack();  
    }
      
    /**
     * A method to draw the cards for the game on Easy Difficulty
     * 
     * @param x X coordinates for the drawing location
     * @param y Y coordinates for the drawing location
     */
    private void chooseCardEasy(int x, int y){
        //First Row Of Cards
        if (y>=15 && y<=235){
            redrawY = 15;
            if (x>=15 && x<=190){
                redrawX = 15;
                card = 0;
                update = 1;
                repaint();
            }
            if (x>=215 && x<=390){
                redrawX = 215;
                card = 1;
                update = 1;
                repaint();
            }
            if (x>=415 && x<=590){
                redrawX = 415;
                card = 2;
                update = 1;
                repaint();
            } 
        }
        //Second Row Of Cards
        if (y>=265 && y<=485){
            redrawY = 265;
            if (x>=15 && x<=190){
                redrawX = 15;
                card = 3;
                update = 1;
                repaint();
            }
            if (x>=215 && x<=390){
                redrawX = 215;
                card = 4;
                update = 1;
                repaint();
            }
            if (x>=415 && x<=590){
                redrawX = 415;
                card = 5;
                update = 1;
                repaint();
            }             
        }
        //Third Row Of Cards
        if (y>=515 && y<=735){
            redrawY = 515;
            if (x>=15 && x<=190){
                redrawX = 15;
                card = 6;
                update = 1;
                repaint();
            }
            if (x>=215 && x<=390){
                redrawX = 215;
                card = 7;
                update = 1;
                repaint();
            }
            if (x>=415 && x<=590){
                redrawX = 415;
                card = 8;
                update = 1;
                repaint();
            }
        }
        //Forth Row Of Cards
        if (y>=765 && y<=985){
            redrawY = 765;
            if (x>=15 && x<=190){
                redrawX = 15;
                card = 9;
                update = 1;
                repaint();
            }
            if (x>=215 && x<=390){
                redrawX = 215;
                card = 10;
                update = 1;
                repaint();
            }
            if (x>=415 && x<=590){
                redrawX = 415;
                card = 11;
                update = 1;
                repaint();
            }
        }
    }
    /**
     * A method to draw the cards for the game on Medium Difficulty
     * 
     * @param x X coordinates for the drawing location
     * @param y Y coordinates for the drawing location
     */
    private void chooseCardMedium(int x, int y){
        //First Row Of Cards
        if (y>=15 && y<=235){
            redrawY = 15;
            if (x>=15 && x<=190){
                redrawX = 15;
                card = 0;
                update = 1;
                repaint();
            }
            if (x>=215 && x<=390){
                redrawX = 215;
                card = 1;
                update = 1;
                repaint();
            }
            if (x>=415 && x<=590){
                redrawX = 415;
                card = 2;
                update = 1;
                repaint();
            } 
            if (x>=615 && x<=790){
                redrawX = 615;
                card = 3;
                update = 1;
                repaint();
            }
        }
        //Second Row Of Cards
        if (y>=265 && y<=485){
            redrawY = 265;
            if (x>=15 && x<=190){
                redrawX = 15;
                card = 4;
                update = 1;
                repaint();
            }
            if (x>=215 && x<=390){
                redrawX = 215;
                card = 5;
                update = 1;
                repaint();
            }
            if (x>=415 && x<=590){
                redrawX = 415;
                card = 6;
                update = 1;
                repaint();
            } 
            if (x>=615 && x<=790){
                redrawX = 615;
                card = 7;
                update = 1;
                repaint();
            }           
        }
        //Third Row Of Cards
        if (y>=515 && y<=735){
            redrawY = 515;
            if (x>=15 && x<=190){
                redrawX = 15;
                card = 8;
                update = 1;
                repaint();
            }
            if (x>=215 && x<=390){
                redrawX = 215;
                card = 9;
                update = 1;
                repaint();
            }
            if (x>=415 && x<=590){
                redrawX = 415;
                card = 10;
                update = 1;
                repaint();
            }
            if (x>=615 && x<=790){
                redrawX = 615;
                card = 11;
                update = 1;
                repaint();
            }
        }
        //Forth Row Of Cards
        if (y>=765 && y<=985){
            redrawY = 765;
            if (x>=15 && x<=190){
                redrawX = 15;
                card = 12;
                update = 1;
                repaint();
            }
            if (x>=215 && x<=390){
                redrawX = 215;
                card = 13;
                update = 1;
                repaint();
            }
            if (x>=415 && x<=590){
                redrawX = 415;
                card = 14;
                update = 1;
                repaint();
            }
            if (x>=615 && x<=790){
                redrawX = 615;
                card = 15;
                update = 1;
                repaint();
            }
        }
    }
    /**
     * A method to draw the cards for the game on Hard Difficulty
     * 
     * @param x X coordinates for the drawing location
     * @param y Y coordinates for the drawing location
     */
    private void chooseCardHard(int x, int y){
        //First Row Of Cards
        if (y>=15 && y<=235){
            redrawY = 15;
            if (x>=15 && x<=190){
                redrawX = 15;
                card = 0;
                update = 1;
                repaint();
            }
            if (x>=215 && x<=390){
                redrawX = 215;
                card = 1;
                update = 1;
                repaint();
            }
            if (x>=415 && x<=590){
                redrawX = 415;
                card = 2;
                update = 1;
                repaint();
            } 
            if (x>=615 && x<=790){
                redrawX = 615;
                card = 3;
                update = 1;
                repaint();
            }
            if (x>=815 && x<=990){
                redrawX = 815;
                card = 4;
                update = 1;
                repaint();
            } 
        }
        //Second Row Of Cards
        if (y>=265 && y<=485){
            redrawY = 265;
            if (x>=15 && x<=190){
                redrawX = 15;
                card = 5;
                update = 1;
                repaint();
            }
            if (x>=215 && x<=390){
                redrawX = 215;
                card = 6;
                update = 1;
                repaint();
            }
            if (x>=415 && x<=590){
                redrawX = 415;
                card = 7;
                update = 1;
                repaint();
            } 
            if (x>=615 && x<=790){
                redrawX = 615;
                card = 8;
                update = 1;
                repaint();
            }
            if (x>=815 && x<=990){
                redrawX = 815;                
                card = 9;
                update = 1;
                repaint();
            }             
        }
        //Third Row Of Cards
        if (y>=515 && y<=735){
            redrawY = 515;
            if (x>=15 && x<=190){
                redrawX = 15;
                card = 10;
                update = 1;
                repaint();
            }
            if (x>=215 && x<=390){
                redrawX = 215;
                card = 11;
                update = 1;
                repaint();
            }
            if (x>=415 && x<=590){
                redrawX = 415;
                card = 12;
                update = 1;
                repaint();
            }
            if (x>=615 && x<=790){
                redrawX = 615;
                card = 13;
                update = 1;
                repaint();
            }
            if (x>=815 && x<=990){
                redrawX = 815;
                card = 14;
                update = 1;
                repaint();
            } 
        }
        //Forth Row Of Cards
        if (y>=765 && y<=985){
            redrawY = 765;
            if (x>=15 && x<=190){
                redrawX = 15;
                card = 15;
                update = 1;
                repaint();
            }
            if (x>=215 && x<=390){
                redrawX = 215;
                card = 16;
                update = 1;
                repaint();
            }
            if (x>=415 && x<=590){
                redrawX = 415;
                card = 17;
                update = 1;
                repaint();
            }
            if (x>=615 && x<=790){
                redrawX = 615;
                card = 18;
                update = 1;
                repaint();
            }
            if (x>=815 && x<=990){
                redrawX = 815;
                card = 19;
                update = 1;
                repaint();
            } 
        }
    }
    
    /**
     * A method to illustrate the game
     * 
     * @param g Graphic package to illustrate the game
     */
    public void paint(Graphics g){
        int x = 15;
        int y = 15;
        int count = 0;
        int pos = 0;
        //Method to Draw the Easy Card Layout
        if (diff.equals("easy")){
            drawBackground(g,diff,score);
            for (int i = 0; i<= 11; i++){
                drawCard(g,x,y,pos,randomQ);
                drawPatt(g,x,y);
                drawBoarder(g,x,y);
                                
                pos +=1;
                x+= 200;
                count += 1;
                
                if (count == 3 || count == 6 || count == 9){
                    y += 250;
                    x = 15;
                }
            }
            //Method To redraw the Correct Squares
            if (correct == 1){
                int length = (correctCards.size())/3;
                
                drawCard(g,correctCards.get(0),correctCards.get(1),correctCards.get(2),randomQ);
                drawCard(g,correctCards.get(3),correctCards.get(4),correctCards.get(5),randomQ);
                if(length >= 4){
                    drawCard(g,correctCards.get(6),correctCards.get(7),correctCards.get(8),randomQ);
                    drawCard(g,correctCards.get(9),correctCards.get(10),correctCards.get(11),randomQ); 
                }
                if(length >= 6){
                    drawCard(g,correctCards.get(12),correctCards.get(13),correctCards.get(14),randomQ);
                    drawCard(g,correctCards.get(15),correctCards.get(16),correctCards.get(17),randomQ); 
                }
                if(length >= 8){
                    drawCard(g,correctCards.get(18),correctCards.get(19),correctCards.get(20),randomQ);
                    drawCard(g,correctCards.get(21),correctCards.get(22),correctCards.get(23),randomQ); 
                }
                if(length >= 10){
                    drawCard(g,correctCards.get(24),correctCards.get(25),correctCards.get(26),randomQ);
                    drawCard(g,correctCards.get(27),correctCards.get(28),correctCards.get(29),randomQ); 
                }
                if(length >= 12){
                    drawCard(g,correctCards.get(30),correctCards.get(31),correctCards.get(32),randomQ);
                    drawCard(g,correctCards.get(33),correctCards.get(34),correctCards.get(35),randomQ); 
                }
            }
            //Reaveals the First Card
            if (update == 1){
                    drawCard(g,redrawX,redrawY,card,randomQ);
                    
                    cardOne.add(redrawX);
                    cardOne.add(redrawY);
                    cardOne.add(card);
                    //Reveals the Second Card
                    if (again == 1){
                        drawCard(g,cardOne.get(0),cardOne.get(1),cardOne.get(2),randomQ);
                        //Method to check the contents of Card 1 with Card 2
                        int firstQ = 0;
                        int secQ = 0;
                        String firstCard = randomQ.get(cardOne.get(2));
                        int fCL = firstCard.length();
                        String secondCard = randomQ.get(card);
                        int sCL = secondCard.length();
                        
                        //First Card Answer
                        if (fCL == 1||fCL ==2){
                            answer = Integer.parseInt(firstCard); 
                            firstQ = 1;
                        }
                        //Second Card Answer
                        if (sCL == 1||sCL == 2){
                            answer = Integer.parseInt(secondCard);
                            secQ = 1;
                        }
                        
                        //FirstCard == Question and Second Card == Answer
                        if (firstQ == 0 && secQ == 1){
                            check = checkQuestion.main(firstCard,answer);
                        //Second Card == Question and First Card == Answer
                        }else if (firstQ == 1 && secQ ==0){
                            check = checkQuestion.main(firstCard,answer);
                        }else{
                            check = false;
                        }
                        
                        if (check){
                            correctCards.add(cardOne.get(0));
                            correctCards.add(cardOne.get(1));
                            correctCards.add(cardOne.get(2));
                            correctCards.add(redrawX);
                            correctCards.add(redrawY);
                            correctCards.add(card);
                            
                            correct = 1;
                            score += 1;
                            cardOne.clear();
                        }else{
                            reset = 1;  
                        }

                    }
                    update = 0;
                    
                    if (again == 0){
                        again = 1;
                    }else{
                        again = 0;
                    }
                }
            //Resets the Board On an Incorrect Input
            if (reset == 1){
                if (cardOne.isEmpty() && correctCards.isEmpty()){
                }else{
                    cardOne.clear();
                    correctCards.clear();
                }
                score = 0;
                update = 0;
                again = 0;
                reset = 0;
                correct = 0;
                check = true;
                repaint();
            }
            //Method for Saving Coins
            if (score == 12){
                ArrayList <String> nameList = keyFunctions.readFile("db/names.txt");
                ArrayList <String> coinList = keyFunctions.readFile("db/coins.txt");
                ArrayList <String> sumList = keyFunctions.readFile("db/sumSnapScores.txt");
                
                int k = nameList.indexOf(currName);
                int oldC = Integer.parseInt(coinList.get(k));
                int newC = oldC + 12;
                String newDiff = "";
                
                String coinWrite = Integer.toString(newC);
                if (sumList.get(k).equals("Medium")){
                    newDiff = "Medium";
                }
                if (sumList.get(k).equals("Hard")){
                    newDiff = "Hard";
                }
                keyFunctions.writeFile("db/coins.txt",coinWrite,k);
                keyFunctions.writeFile("db/sumSnapScores.txt",newDiff,k);
            }
        }
        //Method to Draw the Medium Card Layout
        if (diff.equals("medium")){
            drawBackground(g,diff,score);
            for (int i = 0; i<= 15; i++){
                drawCard(g,x,y,pos,randomQ);
                pos +=1;
                drawPatt(g,x,y);
                drawBoarder(g,x,y);
                
                x+= 200;
                count += 1;
                
                if (count == 4 || count == 8 || count == 12){
                    y += 250;
                    x = 15;
                }
            }
            //Method To redraw the Correct Squares
            if (correct == 1){
                int length = (correctCards.size())/3;
                
                drawCard(g,correctCards.get(0),correctCards.get(1),correctCards.get(2),randomQ);
                drawCard(g,correctCards.get(3),correctCards.get(4),correctCards.get(5),randomQ);
                if(length >= 4){
                    drawCard(g,correctCards.get(6),correctCards.get(7),correctCards.get(8),randomQ);
                    drawCard(g,correctCards.get(9),correctCards.get(10),correctCards.get(11),randomQ); 
                }
                if(length >= 6){
                    drawCard(g,correctCards.get(12),correctCards.get(13),correctCards.get(14),randomQ);
                    drawCard(g,correctCards.get(15),correctCards.get(16),correctCards.get(17),randomQ); 
                }
                if(length >= 8){
                    drawCard(g,correctCards.get(18),correctCards.get(19),correctCards.get(20),randomQ);
                    drawCard(g,correctCards.get(21),correctCards.get(22),correctCards.get(23),randomQ); 
                }
                if(length >= 10){
                    drawCard(g,correctCards.get(24),correctCards.get(25),correctCards.get(26),randomQ);
                    drawCard(g,correctCards.get(27),correctCards.get(28),correctCards.get(29),randomQ); 
                }
                if(length >= 12){
                    drawCard(g,correctCards.get(30),correctCards.get(31),correctCards.get(32),randomQ);
                    drawCard(g,correctCards.get(33),correctCards.get(34),correctCards.get(35),randomQ); 
                }
                if(length >= 14){
                    drawCard(g,correctCards.get(36),correctCards.get(37),correctCards.get(38),randomQ);
                    drawCard(g,correctCards.get(39),correctCards.get(40),correctCards.get(41),randomQ); 
                }
                if(length >= 16){
                    drawCard(g,correctCards.get(42),correctCards.get(43),correctCards.get(44),randomQ);
                    drawCard(g,correctCards.get(45),correctCards.get(46),correctCards.get(47),randomQ); 
                }
            }
            //Reaveals the First Card
            if (update == 1){
                    drawCard(g,redrawX,redrawY,card,randomQ);
                    
                    cardOne.add(redrawX);
                    cardOne.add(redrawY);
                    cardOne.add(card);
                    //Reveals the Second Card
                    if (again == 1){
                        drawCard(g,cardOne.get(0),cardOne.get(1),cardOne.get(2),randomQ);
                        //Method to check the contents of Card 1 with Card 2
                        int firstQ = 0;
                        int secQ = 0;
                        String firstCard = randomQ.get(cardOne.get(2));
                        int fCL = firstCard.length();
                        String secondCard = randomQ.get(card);
                        int sCL = secondCard.length();
                        
                        //First Card Answer
                        if (fCL == 1||fCL ==2){
                            answer = Integer.parseInt(firstCard); 
                            firstQ = 1;
                        }
                        //Second Card Answer
                        if (sCL == 1||sCL == 2){
                            answer = Integer.parseInt(secondCard);
                            secQ = 1;
                        }
                        
                        //FirstCard == Question and Second Card == Answer
                        if (firstQ == 0 && secQ == 1){
                            check = checkQuestion.main(firstCard,answer);
                        //Second Card == Question and First Card == Answer
                        }else if (firstQ == 1 && secQ ==0){
                            check = checkQuestion.main(firstCard,answer);
                        }else{
                            check = false;
                        }
                        
                        if (check){
                            correctCards.add(cardOne.get(0));
                            correctCards.add(cardOne.get(1));
                            correctCards.add(cardOne.get(2));
                            correctCards.add(redrawX);
                            correctCards.add(redrawY);
                            correctCards.add(card);
                            
                            correct = 1;
                            score += 1;
                            cardOne.clear();
                        }else{
                            reset = 1;  
                        }

                    }
                    update = 0;
                    
                    if (again == 0){
                        again = 1;
                    }else{
                        again = 0;
                    }
                }
            //Resets the Board On an Incorrect Input
            if (reset == 1){
                if (cardOne.isEmpty() && correctCards.isEmpty()){
                }else{
                    cardOne.clear();
                    correctCards.clear();
                }
                score = 0;
                update = 0;
                again = 0;
                reset = 0;
                correct = 0;
                check = true;
                repaint();
            } 
            //Method for Saving Coins
            if (score == 16){
                ArrayList <String> nameList = keyFunctions.readFile("db/names.txt");
                ArrayList <String> coinList = keyFunctions.readFile("db/coins.txt");
                ArrayList <String> sumList = keyFunctions.readFile("db/sumSnapScores.txt");
                
                int k = nameList.indexOf(currName);
                int oldC = Integer.parseInt(coinList.get(k));
                int newC = oldC + 16;
                String newDiff = "Easy";
                
                String coinWrite = Integer.toString(newC);
                if (sumList.get(k).equals("Easy")){
                    newDiff = "Medium";
                }
                if (sumList.get(k).equals("Medium")){
                    newDiff = "Medium";
                }
                if (sumList.get(k).equals("Hard")){
                    newDiff = "Hard";
                }
                keyFunctions.writeFile("db/coins.txt",coinWrite,k);
                keyFunctions.writeFile("db/sumSnapScores.txt",newDiff,k);
            }
        }
        //Method to Draw the Hard Card Layout
        if (diff.equals("hard")){
            drawBackground(g,diff,score);
            for (int i = 0; i<= 19; i++){
                drawCard(g,x,y,pos,randomQ);
                pos +=1;
                drawPatt(g,x,y);
                drawBoarder(g,x,y);
                
                x+= 200;
                count += 1;
                
                if (count == 5 || count == 10 || count == 15){
                    y += 250;
                    x = 15;
                }
            }
            //Method To redraw the Correct Squares
            if (correct == 1){
                int length = (correctCards.size())/3;
                
                drawCard(g,correctCards.get(0),correctCards.get(1),correctCards.get(2),randomQ);
                drawCard(g,correctCards.get(3),correctCards.get(4),correctCards.get(5),randomQ);
                if(length >= 4){
                    drawCard(g,correctCards.get(6),correctCards.get(7),correctCards.get(8),randomQ);
                    drawCard(g,correctCards.get(9),correctCards.get(10),correctCards.get(11),randomQ); 
                }
                if(length >= 6){
                    drawCard(g,correctCards.get(12),correctCards.get(13),correctCards.get(14),randomQ);
                    drawCard(g,correctCards.get(15),correctCards.get(16),correctCards.get(17),randomQ); 
                }
                if(length >= 8){
                    drawCard(g,correctCards.get(18),correctCards.get(19),correctCards.get(20),randomQ);
                    drawCard(g,correctCards.get(21),correctCards.get(22),correctCards.get(23),randomQ); 
                }
                if(length >= 10){
                    drawCard(g,correctCards.get(24),correctCards.get(25),correctCards.get(26),randomQ);
                    drawCard(g,correctCards.get(27),correctCards.get(28),correctCards.get(29),randomQ); 
                }
                if(length >= 12){
                    drawCard(g,correctCards.get(30),correctCards.get(31),correctCards.get(32),randomQ);
                    drawCard(g,correctCards.get(33),correctCards.get(34),correctCards.get(35),randomQ); 
                }
                if(length >= 14){
                    drawCard(g,correctCards.get(36),correctCards.get(37),correctCards.get(38),randomQ);
                    drawCard(g,correctCards.get(39),correctCards.get(40),correctCards.get(41),randomQ); 
                }
                if(length >= 16){
                    drawCard(g,correctCards.get(42),correctCards.get(43),correctCards.get(44),randomQ);
                    drawCard(g,correctCards.get(45),correctCards.get(46),correctCards.get(47),randomQ); 
                }
                if(length >= 18){
                    drawCard(g,correctCards.get(46),correctCards.get(47),correctCards.get(48),randomQ);
                    drawCard(g,correctCards.get(49),correctCards.get(50),correctCards.get(51),randomQ); 
                }
                if(length >= 20){
                    drawCard(g,correctCards.get(52),correctCards.get(53),correctCards.get(54),randomQ);
                    drawCard(g,correctCards.get(55),correctCards.get(56),correctCards.get(57),randomQ); 
                }
            }
            //Reaveals the First Card
            if (update == 1){
                    drawCard(g,redrawX,redrawY,card,randomQ);
                    
                    cardOne.add(redrawX);
                    cardOne.add(redrawY);
                    cardOne.add(card);
                    //Reveals the Second Card
                    if (again == 1){
                        drawCard(g,cardOne.get(0),cardOne.get(1),cardOne.get(2),randomQ);
                        //Method to check the contents of Card 1 with Card 2
                        int firstQ = 0;
                        int secQ = 0;
                        String firstCard = randomQ.get(cardOne.get(2));
                        int fCL = firstCard.length();
                        String secondCard = randomQ.get(card);
                        int sCL = secondCard.length();
                        
                        //First Card Answer
                        if (fCL == 1||fCL ==2){
                            answer = Integer.parseInt(firstCard); 
                            firstQ = 1;
                        }
                        //Second Card Answer
                        if (sCL == 1||sCL == 2){
                            answer = Integer.parseInt(secondCard);
                            secQ = 1;
                        }
                        
                        //FirstCard == Question and Second Card == Answer
                        if (firstQ == 0 && secQ == 1){
                            check = checkQuestion.main(firstCard,answer);
                        //Second Card == Question and First Card == Answer
                        }else if (firstQ == 1 && secQ ==0){
                            check = checkQuestion.main(firstCard,answer);
                        }else{
                            check = false;
                        }
                        
                        if (check){
                            correctCards.add(cardOne.get(0));
                            correctCards.add(cardOne.get(1));
                            correctCards.add(cardOne.get(2));
                            correctCards.add(redrawX);
                            correctCards.add(redrawY);
                            correctCards.add(card);
                            
                            correct = 1;
                            score += 1;
                            cardOne.clear();
                        }else{
                            reset = 1;  
                        }

                    }
                    update = 0;
                    
                    if (again == 0){
                        again = 1;
                    }else{
                        again = 0;
                    }
                }
            //Resets the Board On an Incorrect Input
            if (reset == 1){
                if (cardOne.isEmpty() && correctCards.isEmpty()){
                }else{
                    cardOne.clear();
                    correctCards.clear();
                }
                score = 0;
                update = 0;
                again = 0;
                reset = 0;
                correct = 0;
                check = true;
                repaint();
            }
            //Method for Saving Coins
            if (score == 20){
                ArrayList <String> nameList = keyFunctions.readFile("db/names.txt");
                ArrayList <String> coinList = keyFunctions.readFile("db/coins.txt");
                ArrayList <String> sumList = keyFunctions.readFile("db/sumSnapScores.txt");
                
                int k = nameList.indexOf(currName);
                int oldC = Integer.parseInt(coinList.get(k));
                int newC = oldC + 20;
                String newDiff = "Hard";
                
                String coinWrite = Integer.toString(newC);
                keyFunctions.writeFile("db/coins.txt",coinWrite,k);
                keyFunctions.writeFile("db/sumSnapScores.txt",newDiff,k);
            }
        }
    }
    
    /**
     * A method to draw the cards and the text
     * 
     * @param g Graphic package to illustrate the game
     * @param x X coordinates for the drawing location
     * @param y Y coordinates for the drawing location
     * @param pos Position within the list that will be written to the card
     * @param qs A list of random questions
     */
    private void drawCard(Graphics g,int x,int y,int pos,ArrayList<String> qs){
        g.setColor(Color.white);
        g.fillRect(x, y, 175, 220);
        String text = qs.get(pos);
        g.setColor(Color.black);
        g.drawString(text,x+50,y+100);
    }
    /**
     * A method to draw the patterns on the back of the cards
     * 
     * @param g Graphic package to illustrate the game
     * @param x X coordinates for the drawing location
     * @param y Y coordinates for the drawing location
     */
    private void drawPatt(Graphics g,int x, int y){
        g.setColor(Color.WHITE);
        g.fillRect(x,y,175,220);
        int xNew = x + 15;
        for (int i = 0; i<=3; i++){
            g.setColor(Color.RED);
            g.fillRect(xNew,y,10,220);
            xNew += 20;
            g.fillRect(xNew, y, 10, 220);
            xNew += 20;
        }
        y = y+15;
        for (int a = 0; a<=4; a++){
            g.setColor(Color.RED);
            g.fillRect(x,y,175,10);
            y += 20;
            g.fillRect(x, y, 175, 10);
            y += 20;
        }
        
    }
    /**
     * A method to draw the borders around the cards
     * 
     * @param g Graphic package to illustrate the game
     * @param x X coordinates for the drawing location
     * @param y Y coordinates for the drawing location
     */
    private void drawBoarder(Graphics g, int x, int y){
        g.setColor(Color.BLACK);
        g.drawLine(x,y,x+175,y);
        g.drawLine(x,y,x,y+220);
        g.drawLine(x+175,y,x+175,y+220);
        g.drawLine(x,y+220,x+175,y+220);
    }
    /**
     * A method to draw the background of the game
     * 
     * @param g Graphic package to illustrate the game
     * @param diff Difficulty of the game the user has selected
     * @param score Current score the user has
     */ 
    private void drawBackground (Graphics g,String diff,int score){
        g.setColor(Color.CYAN);
        g.fillRect(0, 0, width, 1300);
        //Draws Hills
        g.setColor(darkGreen);
        g.fillOval(0,800,700,400);
        g.setColor(Color.green);
        g.fillOval(-300,900,600,400);
        g.fillOval(200,850,650,400);
        //Draws Sun
        g.setColor(gold);
        g.fillOval(600,100,100,100);
        drawCloud(g,100,240);
        drawCloud(g,300,500);
        drawCloud(g,250,5);
        drawCloud(g,650,45);
        drawCloud(g,500,740);
        
        drawScore(g,diff,score);
    } 
    /**
     * A method to draw the score on the background of the game so the user can keep track
     * 
     * @param g Graphic package to illustrate the game
     * @param diff Difficulty of the game the user has selected
     * @param score Current score the user has
     */
    private void drawScore(Graphics g,String diff,int score){
        g.setColor(Color.BLACK);
        //Functions to redraw the scores for the Student
        if (diff.equals("easy")){
            String scr = String.valueOf(score);
            Font f = new Font("SanSerif",Font.PLAIN,30);
            g.setFont(f);
            g.drawString(score+"/6 Pairs", 650, 325);
        }
        if (diff.equals("medium")){
            String scr = String.valueOf(score);
            Font f = new Font("SanSerif",Font.PLAIN,30);
            g.setFont(f);
            g.drawString(score+"/8 Pairs", 650, 325);
        }
        if (diff.equals("hard")) {
            String scr = String.valueOf(score);
            Font f = new Font("SanSerif",Font.PLAIN,30);
            g.setFont(f);
            g.drawString(score+"/10 Pairs", 650, 325);
        }
    }
    /**
     * A method to draw the clouds in the background
     * 
     * @param g Graphic package to illustrate the game
     * @param x X coordinates for the drawing location
     * @param y Y coordinates for the drawing location
     */
    private void drawCloud(Graphics g,int x, int y){
        g.setColor(Color.WHITE);
        g.fillOval(x,y-20,100,50);
        g.fillOval(x+50,y,75,50);
        g.fillOval(x+100,y,60,50);
    }
    
    /**
     * Methods to override the other mouseEvent rules
     * 
     * @param e Triggers when the mouse is clicked on the screen
     */
    @Override
    public void mouseClicked(MouseEvent e) {
    }
    @Override
    public void mousePressed(MouseEvent e) {
    }
    @Override
    public void mouseReleased(MouseEvent e) {
    }
    @Override
    public void mouseEntered(MouseEvent e) {   
    }
    @Override
    public void mouseExited(MouseEvent e) {   
    }
    
    /**
     * A method to create the game timer and implements threads to keep track 
     */
    public class timeCounter extends Thread{
        public void run(){
            for (int i = 90; i >=0;i--){
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(timeCounter.class.getName()).log(Level.SEVERE, null, ex);
                }
                //System.out.println(i);

                String time = String.valueOf(i);
                
                timer.setText(time);
                if (time.equals("0")){
                    timer.setText("Game Over");
                }
            }
        }
    }
    
    /**
     * A method to create a JFrame which makes use of the mouse Events allowing the user to interact with the game
     */
    private static class myMouse extends JFrame{
        /**
        * A method to create the game timer and implements threads to keep track 
        * @param width width of the JFrame
        */
        public myMouse(int width)
        {
            addMouseListener(new MouseAdapter(){
                public void mousePressed(MouseEvent e){
                    int x = e.getX();
                    int y = e.getY();
                    System.out.println(x + "," + y);
                }
            });
            
            setLayout(new FlowLayout());
            setSize(width,1300);
            setResizable(false);
            setVisible(true);
            setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
            
            timer = new JLabel("Timer",JLabel.CENTER);
            timer.setFont(new Font("Serif",Font.BOLD,24));
            timer.setLocation(50,30);
            timer.setSize(650,50);
            
            this.add(timer);
        }    
    }  
}