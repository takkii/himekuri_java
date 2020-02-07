/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package himekuri;

import java.io.PrintStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;

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
        
        LocalDate date1 = LocalDate.of(d.getYear(), d.getMonth(), d.getDayOfMonth());
        LocalDate date2 = LocalDate.of(2021, 1, 1);
        
        long datediff = ChronoUnit.DAYS.between(date1,date2);
        String reiwa = "令和";
        String r = "R";
        
        System.out.println(sdf.format(cal.getTime()));
        System.out.println("来年の1月1日まであと：" + datediff + "日です。");
        System.out.println(reiwa + (d.getYear()-2018) + sdf2.format(cal.getTime()) + ":" + (r + (d.getYear()-2018) +sdf3.format(cal.getTime())));
    }
    
}
