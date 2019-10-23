/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package final_project;

/**
 *
 * @author Peter Standing - UP817277
 */
import java.util.*;

public class ks1Functions extends keyFunctions {
    
    static ArrayList<String> testList;
    static ArrayList<String> bothList;
    static ArrayList<String> randomQs;
    static ArrayList<String> qs;
    
    public static ArrayList<String> generateQ(int num, String op){
        //3 Difficuties - Easy, Medium, Hard
        //4x3 Grid for Easy(12), 4x4 for Medium(16), 4x5 for Hard(20)
        bothList = new ArrayList<String>();
        
        for (int i = 1; i <= num; i++){
            String[] x = randomQuestion(op);
                        
            bothList.add(x[0]);
            bothList.add(x[1]);
        }
        
        //System.out.print(questionList);
        //System.out.print(answerList);
          
        return bothList;
                
    }  

    public static ArrayList<String> randomLayout(int num,String op){
        int qNum = num;
        
        qs = new ArrayList<String>();
        testList = new ArrayList<String>();
        randomQs = new ArrayList<String>();
        
        qs = ks1Functions.generateQ(num, op);
                
        for (int j = 1;j <= num;j++){
            int rand = randomNumber(qNum);
            String txt = qs.get(rand);
            //System.out.print(" ");
            //System.out.print(txt);
            qs.remove(rand);
            qNum = qNum - 1;
            randomQs.add(txt);
        }
        return randomQs;
    }
    
    public static int randomNumber(int up){
        int max = up-1;
        int min = 0;
        int range = max-min+1;
        
        int randNum = (int)(Math.random()*range) + min;
        
        return randNum;
        
    }
}