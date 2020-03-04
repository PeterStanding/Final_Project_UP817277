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
    
    /**
     * Method that generates a rounding list to be used 

     * @return List of rounded numbers for use in the revision function
     */
    public static ArrayList<Double> rounding(){
        roundQuestion = new ArrayList<Double>();
        for (int k=0;k<12;k++){
            Double rand = randomDecimal();
            roundQuestion.add(rand);
        }
        return roundQuestion;
    }
    
    /**
     * Method that rounds a random number

     * @return rounded number based on a random number
     */
    public static int randomRound(){
        int max = 1000;
        int min = 0;
        int range = max-min+1;
        
        int randNum = (int)(Math.random()*range) + min;
        return randNum;
    }
    /**
     * Method that generates a random decimal

     * @return random decimal
     */
    public static Double randomDecimal(){
        int max = 1000;
        int min = 0;
        int range = max-min+1;
        
        int randNum = (int)(Math.random()*range) + min;
        
        double randDec = (randNum/100.0);
        
        return randDec;
        
    }  
    /**
     * Method that generates a random fraction

     * @return generated fraction
     */
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
    /**
     * Method that generates a random number to be used between 0-10

     * @return random number
     */
    public static int randomNumber(){
        int max = 10;
        int min = 0;
        int range = max-min+1;
        
        int randNum = (int)(Math.random()*range) + min;
        
        return randNum;
    }
    /**
     * Method that generates a random number between 0-10 

     * @return random number 
     */
    public static int randomNumberRatio(){
        int max = 10;
        int min = 1;
        int range = max-min+1;
        
        int randNum = (int)(Math.random()*range) + min;
        
        return randNum;
    }
    /**
     * Method that generates a random number to be used between 1-10

     * @return random number
     */
    public static int randomNumberAlg(){
        int max = 10;
        int min = 1;
        int range = max-min+1;
        
        int randNum = (int)(Math.random()*range) + min;
        
        return randNum;
    }
    /**
     * Method that generates a random number to be used between 1-4
     * to be used to generate the locations of the answers in the second game
     * 
     * @return random number
     */
    public static int randomPosition(){
        int max = 4;
        int min = 1;
        int range = max-min+1;
        
        int randNum = (int)(Math.random()*range) + min;
        int pos = randNum;
        
        return pos;
    }
    /**
     * Method that generates a random number to be used between 0-100
     * 
     * @return random number
     */
    public static int randomNumber100(){
        int max = 100;
        int min = 0;
        int range = max-min+1;
        
        int randNum = (int)(Math.random()*range) + min;
        
        return randNum;
    }
     /**
     * Method that generates a random number to be used between 0-50
     * 
     * @return random number
     */
    public static int randomNumber50(){
        int max = 50;
        int min = 0;
        int range = max-min+1;
        
        int randNum = (int)(Math.random()*range) + min;
        
        return randNum;
    }
        
     /**
     * Method that calculates the highest common factor between two integers
     * 
     * @param a Integer that is used to find a HCF
     * @param b Integer that is used to find a HCF
     * 
     * @return HCF between two integers
     */
    public static int HCF(int a, int b){
        int x, i, hcf = 0;
        
        for(i = 1; i<=a || i<=b; i++){
            if(a%i == 0 && b%i == 0){
                hcf = i;
        }}   
        //System.out.print(hcf);
        return hcf;
    }
    /**
     * Method that calculates the lowest common multiple between two integers
     * 
     * @param a Integer that is used to find a LCM
     * @param b Integer that is used to find a LCM
     * 
     * @return LCM between two integers
     */
    public static int LCM(int a, int b){
        int lowest = a * b / GCD(a,b);
        //System.out.print(lowest);
        return lowest;
    }
    /**
     * Method that calculates the greatest common divisor between two integers
     * 
     * @param a Integer that is used to find a GCD
     * @param b Integer that is used to find a GCD
     * 
     * @return GCD between two integers
     */
    public static int GCD(int a, int b){
        if (b == 0){
            return a;
        }
        return GCD(b,a%b);
    }
    
    /**
     * Method to generate random questions for the game to use
     * 
     * @param num number of questions used in the game
     * @param op Operation being used in the game
     * 
     * @return list of questions and answers for the game to use
     */
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
                String[] x = randomQuestionKS2(op);

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
    /**
     * Method that calculates a random question for the ks2 question areas
     * 
     * @param op Operation being used
     * 
     * @return List of both question and answers
     */
    public static String[] randomQuestionKS2(String op){
        int part1 = randomNumber();
        int part2 = randomNumber();
        
        ArrayList<Integer> multiQs = new ArrayList<>(Arrays.asList(2,5,10));
        ArrayList<Integer> divQs = new ArrayList<>(Arrays.asList(5,10));
        
        
        if (op.equals("*")){       
            int pos = multiQs.get(randomMulti());
            
            part1 = pos;
        } else if (op.equals("/")){
            ArrayList <Integer> divide10 = new ArrayList<>(Arrays.asList(10,20,30,40,50,60,70,80,90,100));
            
            int pos = (randomNumber()) - 1;
            int pos2 = (randomDivide());
            
            part1 = divide10.get(pos);
            part2 = divQs.get(pos2);  
        }
        
        String str1 = Integer.toString(part1);
        String str2 = Integer.toString(part2);
        
        String question = str1 + " " + op + " " + str2;
        int ans = 0;
        
        if (op.equals("+")){
            part1 = randomNumber50();
            part2 = randomNumber50();
            ans = part1 + part2;
            str1 = Integer.toString(part1);
            str2 = Integer.toString(part2);
            question = str1 + " " + op + " " + str2;
        }
        else if (op.equals("-")){
            part1 = randomNumber100();
            part2 = randomNumber50();
            if (part1 < part2){
                ans = part2 - part1;
                str1 = Integer.toString(part1);
                str2 = Integer.toString(part2);
                question = str2 + " " + op + " " + str1;
            }
            ans = part1 - part2;
            str1 = Integer.toString(part1);
            str2 = Integer.toString(part2);
            question = str1 + " " + op + " " + str2;
        }
        else if (op.equals("*")){
            ans = part1 * part2;
        }
        else if (op.equals("/")){
            ans = part1 / part2;
        }
        
        String ansStr = Integer.toString(ans);
        
        String x[] = new String[2];
        x[0] = question;
        x[1] = ansStr;
        
        return x;
    }
    /**
     * Method that calculates a random question for the ks1 question areas
     * 
     * @param op Operation being used
     * 
     * @return List of both question and answers
     */
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
            //Precentages - Covert Fraction to Percentage
            int div = HCF(part1, part2);
            int finalp1 = part1 % div;
            int finalp2 = part2 % div;
            
            if (finalp1 == 0){
                finalp1 = randomNumberRatio();
            }
            if (finalp2 == 0){
                finalp2 = randomNumberRatio();
            }
            
            double fract = finalp1/finalp2;
            
            if (finalp1>finalp2){
                fract = finalp1/finalp2;
                question = finalp1+"/"+finalp2;
            }
            else {
                fract = finalp2/finalp1;
                question = finalp2+"/"+finalp1;
            }
            
            double perc = fract * 100;
           
            ansStr = Double.toString(perc);
            
        }
        else if (op.equals(":")){
            //Ratio - Simplifying
            part1 = randomNumberRatio();
            part2 = randomNumberRatio();
            int div = HCF(part1, part2);
            int finalp1 = part1 / div;
            int finalp2 = part2 / div;
            
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
 