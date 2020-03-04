/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package final_project;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.script.ScriptEngineManager;
import javax.script.ScriptEngine;
import javax.script.ScriptException;

/**
 * @author Peter Standing - UP817277
 * Researched Code From:
 * https://stackoverflow.com/questions/3422673/how-to-evaluate-a-math-expression-given-in-string-form
 * 
 * Converts a String equation to a usable math equation
 * If the inputted answer is equation to the answer returned from the equation than the function returns true
 * 
 * @param question String variation of the math equation
 * @param answer Integer answer of the math equation
 * 
 * @return true if the inputted answer equations the answer from the math equation
 * 
 */
public class checkQuestion {
    public static Boolean main(String question, int answer){
        try {
          ScriptEngineManager mgr = new ScriptEngineManager();
          ScriptEngine engine = mgr.getEngineByName("JavaScript");
          //System.out.println(engine.eval(question));
          
          int qAns = (int) engine.eval(question);
          
          if (qAns == answer){
              return true;
          }} catch (ScriptException ex) {
          Logger.getLogger(checkQuestion.class.getName()).log(Level.SEVERE, null, ex);
      }
        return false;
    }
}
