/*
 *  Copyright © 2020 Takayuki, Kamiyama
 */
package himekuri;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;

// Ruco is SubClass.
class Ruco extends Thread {
    public void himekuri() {
        try {
            final Ruco thread = new Ruco();
            thread.setDaemon(true);
            thread.start();

            final SimpleDateFormat sdf_koyomi = new SimpleDateFormat("yyyy年MM月dd日HH時mm分ss秒：EEEE");
            final SimpleDateFormat sdf_nengo = new SimpleDateFormat("年MM月dd日");
            final SimpleDateFormat sdf_kigo = new SimpleDateFormat(".MM.dd");

            final LocalDateTime d = LocalDateTime.now();
            final Calendar cal = Calendar.getInstance();

            final LocalDate date_before = LocalDate.of(d.getYear(), d.getMonth(), d.getDayOfMonth());
            final LocalDate date_after = LocalDate.of(d.getYear() + 1, 1, 1);

            final long datediff = ChronoUnit.DAYS.between(date_before, date_after);
            final String reiwa_kanji = "令和";
            final String reiwa_alpha = "R";
            final String reiwa_beta = (reiwa_kanji + (d.getYear() - 2018)) + (sdf_nengo.format(cal.getTime()));
            final String reiwa_delta = (reiwa_alpha + (d.getYear() - 2018)) + (sdf_kigo.format(cal.getTime()));

            System.out.println(sdf_koyomi.format(cal.getTime()));
            System.out.println("来年の1月1日まであと：" + (datediff - 1) + "日です。");
            System.out.println(reiwa_beta + "：" + reiwa_delta);
            thread.join();

        } catch (final Exception e) {
            System.err.println("Exceptionエラーを捕捉しました...");
            e.printStackTrace(System.out);
        }
    }
}

// Seel is SubClass
class Seel extends Thread {
    public void himekuri() {
        try {
            final Seel thread = new Seel();
            thread.start();

            final String version = "1.0.1";
            final String himekuriVersion = "日めくりの数え番号：" + version;
            System.out.println(himekuriVersion);

            thread.join();
        } catch (final Exception ex) {
            System.err.println("Exceptionエラーを捕捉しました...");
            ex.printStackTrace(System.out);
        }
    }
}

/**
 * @author takkii(Takayuki Kamiyama) App is SuperClass. mvn build.
 */
public class App {
    public static void main(final String[] args) {

        // SubClass call
        final Ruco obj = new Ruco();
        obj.himekuri();

        // SubClass call
        final Seel objc = new Seel();
        objc.himekuri();
    }
}
