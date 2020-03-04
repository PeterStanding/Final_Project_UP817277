/**
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package final_project;

/**
 *
 * @author Peter Standing - UP817277
 */
import java.lang.Math.*;
import java.util.*;
import java.io.*;
import static java.lang.System.*;

public abstract class keyFunctions {
    static ArrayList<String> current;
    /**
     * Method to generate a list of random questions based on the operation that the user has entered. 
     * 
     * @param op Operation that the user would like to generate questions for 
     */
    public static String[] randomQuestion(String op){
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
            ans = part1 + part2;
        }
        else if (op.equals("-")){
            ans = part1 - part2;
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
     * This method runs a random number between 1 and 2
     */
    public static int randomDivide(){
        int max = 2;
        int min = 1;
        int range = max-min+1;
        
        int randNum = (int)(Math.random()*range) + min;
        
        return (randNum-1); 
    }
    
    /**
     * This method generates a random number between 1 and 3
     */
    public static int randomMulti(){
        int max = 3;
        int min = 1;
        int range = max-min+1;
        
        int randNum = (int)(Math.random()*range) + min;
        
        return (randNum-1); 
    }
    
    /**
     * This method generates a random number between 1 and 10
     */
    public static int randomNumber(){
        int max = 10;
        int min = 1;
        int range = max-min+1;
        
        int randNum = (int)(Math.random()*range) + min;
        
        return randNum;        
    }
    
    /**
     * This method reads the file at the provided file destination
     * 
     * @param fileName Is the file name of the required file to read
     * 
     * @return current Returns an Array List string which contains the contents of the file.
     */
    public static ArrayList<String> readFile(String fileName){
        current = new ArrayList<String>();
        try {
            FileReader f = new FileReader(fileName);
            BufferedReader br = new BufferedReader(f);
            
            String str;
            while ((str = br.readLine())!=null){
                current.add(str);
            }
            return current;
        } catch (IOException e){
            System.out.println("File not found");
        }
        return current;
    }
    
    /**
     * This method writes to the file at the provided file destination
     * 
     * @param fileName Is the file name of the required file to write
     * @param txt This is the string information that the user would like to write to the file.
     * @param index Is the line that the new text should be written too
     */
    public static void writeFile(String fileName, String txt, int index){
        current = new ArrayList<String>();
        try {
            FileReader fR = new FileReader(fileName);
            BufferedReader br = new BufferedReader(fR);
            String str;
            while ((str = br.readLine())!=null){
                if (current.size() == index){
                    current.add(txt);
                } else {
                    current.add(str);
            }}
            
            FileWriter fW = new FileWriter(fileName);
            BufferedWriter bW = new BufferedWriter(fW);
            for (int i = 0; i<current.size();i++){
                String r = current.get(i);
                bW.write(r);
                bW.newLine();
            }
            bW.close();
        }  catch (IOException e){
            System.out.println("File not found");
        } 
    }
      
}
