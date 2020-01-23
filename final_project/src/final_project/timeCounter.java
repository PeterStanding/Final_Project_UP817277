/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package final_project;

import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author peter
 */
public class timeCounter {
    static Thread thread = new Thread();
    public static void main(){
        for (int i = 60; i >=0;i--){
            try {
                thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(timeCounter.class.getName()).log(Level.SEVERE, null, ex);
            }
            System.out.println(i);
        }
    }
}
