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
    public static int randomNumberAlg(){
        int max = 10;
        int min = 1;
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
        
    public static int HCF(int a, int b){
        int x, i, hcf = 0;
        
        for(i = 1; i<=a || i<=b; i++){
            if(a%i == 0 && b%i == 0){
                hcf = i;
        }}   
        System.out.print(hcf);
        return hcf;
    }
    public static int LCM(int a, int b){
        int lowest = a * b / GCD(a,b);
        System.out.print(lowest);
        return lowest;
    }
    public static int GCD(int a, int b){
        if (b == 0){
            return a;
        }
        return GCD(b,a%b);
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
        }
        else if (op.equals("Alg")){
            //Algebraic Formula - Find x/y
            int coeff = randomNumberAlg();
            int layout = randomNumber();
            part1 = randomNumberAlg();
            part2 = randomNumberAlg();
            
            if (layout < 3){
                //?x = int
                ans = part1 * coeff;
                
                question = coeff+"x = "+ ans;
                ansStr = Integer.toString(part1);
                
            } else if (layout > 3 && layout <= 7){
                //?x+num = int || ?x-num = int
                if (layout == 4||layout == 5){
                    ans = (part1 * coeff) + part2;
                    
                    question = coeff+"x + "+part2+" = "+ans;
                    ansStr = Integer.toString(part1);
                } else if (layout == 6||layout == 7){
                    ans = (part1 * coeff) - part2;
                    
                    question = coeff+"x - "+part2+" = "+ans;
                    ansStr = Integer.toString(part1);
                }                
            } else if (layout > 7 && layout <= 10){
                //?x/num = int 
                ans = (part1 * coeff)/part2;
                
                question = coeff+"x/"+part2+" = "+ ans;
                ansStr = Integer.toString(part1);
            } 
        }
        else if (op.equals("%")){
            //Precentages - Covert Fractiojn to Percentage
            int div = HCF(part1, part2);
            int finalp1 = part1 % div;
            int finalp2 = part2 % div;
            
            int fract = finalp1/finalp2;
            int perc = fract * 100;
            
            question = finalp1+"/"+finalp2;
            ansStr = Integer.toString(perc);
            
        }
        else if (op.equals(":")){
            //Ratio - Simplifying
            int div = HCF(part1, part2);
            int finalp1 = part1 % div;
            int finalp2 = part2 % div;
            
            question = part1+":"+part2;
            ansStr = finalp1+":"+finalp2;
        }

        else if (op.equals("//")){
            //Fractions - Simplifying
            int div = HCF(part1, part2);
            int finalp1 = part1 % div;
            int finalp2 = part2 % div;
            
            question = part1+"/"+part2;
            ansStr = finalp1+"/"+finalp2;
            
        }
        
        String x[] = new String[2];
        x[0] = question;
        x[1] = ansStr;
        
        return x;
    }

}
 