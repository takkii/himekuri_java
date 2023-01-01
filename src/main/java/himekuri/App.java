/*
 *  Copyright © 2020 Takayuki, Kamiyama
 */
package himekuri;

import java.text.SimpleDateFormat;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.lang.Runtime;

// Ruco is SubClass.
class Ruco extends Thread {

    final SimpleDateFormat sdf_koyomi = new SimpleDateFormat("yyyy年MM月dd日 : HH時mm分ss秒 : EEEE");
    final Calendar cal = Calendar.getInstance();

    public void himekuri() {
        try {
            final Ruco thread = new Ruco();
            thread.setDaemon(true);
            thread.start();

            System.out.print(sdf_koyomi.format(cal.getTime())+" : ");

            final Month hugetu = LocalDateTime.now().getMonth();
            final String hugetu_wa = String.valueOf(hugetu);

            switch (hugetu_wa) {
                case "JANUARY":
                    System.out.println("睦月");
                    break;
                case "FEBRUARY":
                    System.out.println("如月");
                    break;
                case "MARCH":
                    System.out.println("弥生");
                    break;
                case "APRIL":
                    System.out.println("卯月");
                    break;
                case "MAY":
                    System.out.println("皐月");
                    break;
                case "JUNE":
                    System.out.println("水無月");
                    break;
                case "JULY":
                    System.out.println("文月");
                    break;
                case "AUGUST":
                    System.out.println("葉月");
                    break;
                case "SEPTEMBER":
                    System.out.println("長月");
                    break;
                case "OCTOBER":
                    System.out.println("神無月");
                    break;
                case "NOVEMBER":
                    System.out.println("霜月");
                    break;
                case "DECEMBER":
                    System.out.println("師走");
                    break;
                default:
                    try {
                        throw new Exception();
                    } catch (Exception e) {
                        System.out.println("到達すべき場所ではないため、例外を発生させました。");
                    }
                    break;
            }
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
    final int calc = d.getYear() - 2018;
    final String nengo_calc = sdf_nengo.format(cal.getTime());
    final String kigo_calc = sdf_kigo.format(cal.getTime());
    final String reiwa_kanji = "令和";
    final String reiwa_kanji_zero = "令和0";
    final String reiwa_alpha = "R";
    final String reiwa_alpha_zero = "R0";
    final String reiwa_beta = (reiwa_kanji + (calc)) + (nengo_calc);
    final String reiwa_delta = (reiwa_alpha + (calc)) + (kigo_calc);
    final String reiwa_beta_zero = (reiwa_kanji_zero + (calc)) + (nengo_calc);
    final String reiwa_delta_zero = (reiwa_alpha_zero + (calc)) + (kigo_calc);

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
    final String RiviSionNumber = "2023.1.1";
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
        } finally {
            Runtime run = Runtime.getRuntime();
            run.gc();
        }
    }
}
