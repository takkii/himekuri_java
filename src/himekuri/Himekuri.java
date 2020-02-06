/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package himekuri;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 *
 * @author Takayuki Kamiyama.
 */
public class Himekuri {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年 MM月 dd日 mm分 ss秒"); 
       
        Calendar cal = Calendar.getInstance();
        
        System.out.println(sdf.format(cal.getTime()));
    }
    
}
