/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package final_project;
import java.util.*;
import java.lang.Math.*;
/**
 *
 * @author Peter Standing - UP817277
 */
public class ks2Functions extends keyFunctions{
    private static ArrayList<Double> roundQuestion;
    private static ArrayList<Integer> roundAnswers;
    private static ArrayList<String> bothList;
    
    public static ArrayList<Double> rounding(){
        roundQuestion = new ArrayList<Double>();
        for (int k=0;k<12;k++){
            Double rand = randomDecimal();
            roundQuestion.add(rand);
        }
        return roundQuestion;
    }
    
    public static int randomRound(){
        int max = 1000;
        int min = 0;
        int range = max-min+1;
        
        int randNum = (int)(Math.random()*range) + min;
        return randNum;
    }
    public static Double randomDecimal(){
        int max = 1000;
        int min = 0;
        int range = max-min+1;
        
        int randNum = (int)(Math.random()*range) + min;
        
        double randDec = (randNum/100.0);
        
        return randDec;
        
    }    
    public static String randomFraction(){
        int denom = randomNumber();
        int numer = randomNumber();
        String fraction = "";
        
        if (numer>denom){
            fraction = numer+"/"+denom;
        }
        else {
            fraction = denom+"/"+numer;
        }
        
        return fraction;
    }
    public static int randomNumber(){
        int max = 10;
        int min = 0;
        int range = max-min+1;
        
        int randNum = (int)(Math.random()*range) + min;
        
        return randNum;
    }
    public static int randomPosition(){
        int max = 4;
        int min = 1;
        int range = max-min+1;
        
        int randNum = (int)(Math.random()*range) + min;
        int pos = randNum;
        
        return pos;
    }
    
    public static ArrayList<String> generateQ(int num, String op){
        //Calls the RandomQuestion from the KeyFunctions Class
        //Rounding      -> "^"
        //Algebra       -> "Alg"
        //Percentages   -> "%"
        //Ratio         -> ":"
        //Fraction      -> "//"
        
        bothList = new ArrayList<String>();
        if (op.equals("+")||op.equals("-")||op.equals("*")||op.equals("/")){
            for (int i = 1; i <= num; i++){
                String[] x = randomQuestion(op);

                bothList.add(x[0]);
                bothList.add(x[1]);
        }}
        
        if (op.equals("^")||op.equals("Alg")||op.equals("%")||op.equals(":")||op.equals("//")){
            for (int i = 1; i <= num; i++){
                String[] x = randomQuestions(op);
                
                bothList.add(x[0]);
                bothList.add(x[1]);
        }}
        
        //System.out.print(questionList);
        //System.out.print(answerList);
        //System.out.print(bothList);
        return bothList;
                
    }
  
    public static String[] randomQuestions(String op){
        String question = "";
        String ansStr = "";
        
        int part1 = randomNumber();
        int part2 = randomNumber();
        int ans = 0;
        double roundAns = 0.0;
        
        if (op.equals("^")){
            //Round to Closest Whole Number
            roundAns = (randomDecimal());
            double k = Math.round(roundAns);
            
            question = Double.toString(roundAns);
            ansStr = Double.toString(k);
            
            //System.out.println(question);
            //System.out.println(ansStr);
        }
        /*
        else if (op.equals("Alg")){
            //Algebraic Formula - Find x
            ans = part1 - part2;
        }
        else if (op.equals("%")){
            //Precentages
            ans = part1 * part2;
        }
        else if (op.equals(":")){
            //Ratio
            ans = part1 / part2;
        }
        else if (op.equals("//")){
            //Fractions
            
        }
*/
        
        String x[] = new String[2];
        x[0] = question;
        x[1] = ansStr;
        
        return x;
    }

}
 