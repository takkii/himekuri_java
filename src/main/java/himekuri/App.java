/*
 *  Copyright © 2020 Takayuki, Kamiyama
 */
package himekuri;

import java.text.SimpleDateFormat;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;

// Ruco is SubClass.
class Ruco extends Thread {

    final SimpleDateFormat sdf_koyomi = new SimpleDateFormat("yyyy年MM月dd日HH時mm分ss秒：EEEE");
    final Calendar cal = Calendar.getInstance();

    public void himekuri() {
        try {
            final Ruco thread = new Ruco();
            thread.setDaemon(true);
            thread.start();

            System.out.println(sdf_koyomi.format(cal.getTime()));

            thread.join();

        } catch (final Exception e) {
            System.err.println("Exceptionエラーを捕捉しました...");
            e.printStackTrace(System.out);
        }
    }
}

class Counter extends Thread {
    final LocalDateTime d = LocalDateTime.now();
    final SimpleDateFormat sdf_nengo = new SimpleDateFormat("年MM月dd日");
    final SimpleDateFormat sdf_kigo = new SimpleDateFormat(".MM.dd");
    final Calendar cal = Calendar.getInstance();
    final String reiwa_kanji = "令和";
    final String reiwa_alpha = "R";
    final String reiwa_beta = (reiwa_kanji + (d.getYear() - 2018)) + (sdf_nengo.format(cal.getTime()));
    final String reiwa_delta = (reiwa_alpha + (d.getYear() - 2018)) + (sdf_kigo.format(cal.getTime()));

    public void Reiwa_Counter() {
        try {
            final Counter thread = new Counter();

            thread.start();

            System.out.println(reiwa_beta + "：" + reiwa_delta);
            thread.join();

        } catch (final Exception ee) {
            System.err.println("Exceptionエラーを捕捉しました...");
            ee.printStackTrace(System.out);
        }
    }
}

class Hizuke extends Thread {
    final LocalDateTime d = LocalDateTime.now();
    final LocalDate date_before = LocalDate.of(d.getYear(), d.getMonth(), d.getDayOfMonth());
    final LocalDate date_after = LocalDate.of(d.getYear() + 1, 1, 1);
    final long datediff = ChronoUnit.DAYS.between(date_before, date_after);

    public void Hizuke_counter() {
        try {
            final Hizuke thread = new Hizuke();
            thread.start();

            System.out.println("来年の1月1日まであと：" + (datediff - 1) + "日です。");

            thread.join();
        } catch (final Exception eee) {
            System.err.println("Exceptionエラーを捕捉しました...");
            eee.printStackTrace(System.out);
        }
    }
}

// Seel is SubClass
class Seel extends Thread {
    final String RiviSionNumber = "1.1.0";
    final String himekuriVersion = "日めくりの数え番号：";
    final String version = himekuriVersion + RiviSionNumber;

    public void himekuri() {
        try {
            final Seel thread = new Seel();
            thread.start();

            System.out.println(version);

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

        try {
            // SubClass call
            final Ruco c = new Ruco();
            c.himekuri();

            // SubClass call
            final Hizuke rubim = new Hizuke();
            rubim.Hizuke_counter();

            // SubClass call
            final Counter swift = new Counter();
            swift.Reiwa_Counter();

            // SubClass call
            final Seel objc = new Seel();
            objc.himekuri();
        } catch (final DateTimeException abc) {
            abc.printStackTrace(System.out);
        }
    }
}
