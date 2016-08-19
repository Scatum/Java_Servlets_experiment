/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

/**
 *
 * @author ScatUm
 */
public class UtilPM {
    
    public static String getTaskProgressByValue(String value){
       
        String []valueTask = { "on_hold", "to_do", "in_progres", "in_review", "done"};
        String []nameTAsk = { "On Hold", "To Do", "In Progres", "In Review", "Done"};
        for(int x = 0; x<nameTAsk.length; x++) {
            if(value.equals(valueTask[x])){
                return nameTAsk[x];
            }
        }
        return null;
    }
}
