/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.script.ScriptEngineManager;
import javax.script.ScriptEngine;
import javax.script.ScriptException;

/**
 *
 * @author peter
 * Researched Code From:
 * https://stackoverflow.com/questions/3422673/how-to-evaluate-a-math-expression-given-in-string-form
 * 
 */
public class stringToExp {
    
  public static String testing = "40 + 2";
  public static int ansFromCard = 42;
  
  public static void main(String[] args){
      try {
          ScriptEngineManager mgr = new ScriptEngineManager();
          ScriptEngine engine = mgr.getEngineByName("JavaScript");
          System.out.println(engine.eval(testing));
          
          int ans = (int) engine.eval(testing);
          
          if (ans == ansFromCard){
              System.out.print("This Method Works");
          } } catch (ScriptException ex) {
          Logger.getLogger(stringToExp.class.getName()).log(Level.SEVERE, null, ex);
      }
    } 
}

