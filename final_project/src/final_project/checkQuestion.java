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
 *
 * @author Peter Standing - UP817277
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
