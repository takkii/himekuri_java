/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package himekuri;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
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
        
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日mm分ss秒");
        SimpleDateFormat sdf2 = new SimpleDateFormat("年MM月dd日");
        SimpleDateFormat sdf3 = new SimpleDateFormat(".MM.dd");
        
        LocalDateTime d = LocalDateTime.now();
        
        Calendar cal = Calendar.getInstance();
        String reiwa = "令和";
        String r = "R";
        
        
        System.out.println(sdf.format(cal.getTime()));
        System.out.println(reiwa + (d.getYear()-2018) + sdf2.format(cal.getTime()) + " : " + (r + (d.getYear()-2018) +sdf3.format(cal.getTime())));
    }
    
}
