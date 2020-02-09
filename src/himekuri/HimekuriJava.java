/*
 *  Copyright © 2020 Takayuki, Kamiyama
 */
package himekuri;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;

// Juke is SubClass.
class Juke {
    public void himekuri() {
        try {
            SimpleDateFormat sdf_koyomi = new SimpleDateFormat("yyyy年MM月dd日mm分ss秒");
            SimpleDateFormat sdf_nengo = new SimpleDateFormat("年MM月dd日");
            SimpleDateFormat sdf_kigo = new SimpleDateFormat(".MM.dd");

            LocalDateTime d = LocalDateTime.now();
            Calendar cal = Calendar.getInstance();

            LocalDate date_before = LocalDate.of(d.getYear(), d.getMonth(), d.getDayOfMonth());
            LocalDate date_after = LocalDate.of(d.getYear() + 1, 1, 1);

            long datediff = ChronoUnit.DAYS.between(date_before, date_after);
            String reiwa_kanji = "令和";
            String reiwa_alpha = "R";
            String reiwa_beta = (reiwa_kanji + (d.getYear() - 2018)) + (sdf_nengo.format(cal.getTime()));
            String reiwa_delta = (reiwa_alpha + (d.getYear() - 2018)) + (sdf_kigo.format(cal.getTime()));

            System.out.println(sdf_koyomi.format(cal.getTime()));
            System.out.println("来年の1月1日まであと：" + (datediff - 1) + "日です。");
            System.out.println(reiwa_beta + "：" + reiwa_delta);

        } catch (Exception e) {
            System.err.println("Exceptionエラーを捕捉しました...");
            e.printStackTrace(System.out);
        }
    }
}

// Tool is SubClass
class Tool {
    public void himekuri() {
        try {
            String version = "1.0.1";
            String himekuriVersion = "日めくりの数え番号：" + version;
            System.out.println(himekuriVersion);
        } catch (Exception ex) {
            System.err.println("Exceptionエラーを捕捉しました...");
            ex.printStackTrace(System.out);
        }
    }
}

/**
 * @author takkii(Takayuki Kamiyama)
 * HimekuriJava is SuperClass.
 */
public class HimekuriJava {
    public static void main(String[] args) {

        // SubClass call
        Juke obj = new Juke();
        obj.himekuri();

        // SubClass call
        Tool objc = new Tool();
        objc.himekuri();
    }
}
