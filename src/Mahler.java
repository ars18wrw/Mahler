import org.jfugue.Pattern;
import org.jfugue.Player;

import java.awt.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by Уладзімір Асіпчук on 19.04.15.
 */

public class Mahler {

    static Player player = new Player();
    static Pattern pattern = new Pattern();
    static Scanner in = new Scanner(System.in);
    public static void main(String[] args) {
        // main melody
        System.out.println("Mahler music editor\n" +
                "Loading...");
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                play(Melodies.mahSymphony5);
            }
        });
        System.out.println("Hello, " + System.getProperty("user.name") + ".");
        while(true) {
            switch (in.next()) {
                // play melody of current dayperiod
                case "hello":
                    hello();
                    break;
                // new pattern or voice or smth else
                case "new":
                    switch(in.next()) {
                        case "pattern":
                            pattern = new Pattern("V0");
                            break;
                        case "voice":
                            pattern.add("V1");
                    }
                    break;

                case "add":
                    pattern.add(in.next());
                    break;

                case "play":
                    play();
                    break;

                case "Tania":
                    System.out.println("Liebe...");
                    break;

                case "init":
                    init();
                    break;

                case "print":
                    print();
                    break;

                case "mahler":
                    play(Melodies.mahSymphony5);
                    break;
            }
        }
    }


    static void hello() {
        player.stop();
        java.util.TimeZone tz = java.util.TimeZone.getTimeZone("GMT+1");
        java.util.Calendar c = java.util.Calendar.getInstance(tz);
        int hour = c.get(java.util.Calendar.HOUR_OF_DAY);
        // for notes
        String notes = null;
        String dayPeriod = null;

        // night
        if (hour < 6) {
            dayPeriod = "night";
            notes = "Dmin Dmin^ Dmin^^ Dmin^^^";
        } // morning
        else if (hour < 12) {
            dayPeriod = "morning";
            notes = "Emaj Emaj^ Emaj^^ Emaj^^^";
        } // afternoon
        else if (hour < 18) {
            dayPeriod = "afternoon";
            notes = "Cmaj Cmaj^ Cmaj^^ Cmajn^^^";
        } // evening
        else if (hour < 24) {
            dayPeriod = "evening";
            notes = "Amin Amin^ Amin^^ Amin^^^";
        }
        System.out.println("Thanks for greetings! Good " + dayPeriod + "!");
        play(notes);
    }

    static void init() {
        pattern = new Pattern();
        pattern.add("V0 a4 b4 c d e f g# aw");
    }

    static void print() {
        System.out.println(pattern.toString());
    }

    static void play() {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                player.play(pattern);
            }
        });
    }

    static void play(final String pat){
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                player.play(pat);
            }
        });
    }
}
