/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package final_project;
import java.util.*;
/**
 *
 * @author Peter Standing - UP817277
 */
public class ks2Functions extends keyFunctions{
    private static ArrayList<Double> roundQuestion;
    private static ArrayList<Integer> roundAnswers;
    
    public static ArrayList<Double> rounding(){
        roundQuestion = new ArrayList<Double>();
        for (int k=0;k<12;k++){
            Double rand = randomDecimal();
            roundQuestion.add(rand);
        }
        return roundQuestion;
    }
    
    public static Double randomDecimal(){
        int max = 1000;
        int min = 0;
        int range = max-min+1;
        
        int randNum = (int)(Math.random()*range) + min;
        
        double randDec = (randNum/100.0);
        
        return randDec;
        
    }
}
 