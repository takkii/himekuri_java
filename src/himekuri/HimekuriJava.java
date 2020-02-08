/*
 *  Copyright © 2020 Takayuki, Kamiyama
 */
package himekuri;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;

/**
 *
 * @author Takayuki, Kamiyama
 */
public class HimekuriJava {
    public static void main(String[] args) {
        
        try{
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
        
        }catch(Exception e){
            System.err.println("Exceptionエラーを捕捉しました...");
            e.printStackTrace(System.out);
            
        }finally{
            String version = "1.0.0";
            String himekuriVersion = "日めくりの数え番号：" + version;
            
            System.out.println(himekuriVersion);
        }
    }
    
}
