import org.jfugue.Pattern;
import org.jfugue.Player;

import java.awt.*;
import java.util.*;

/**
 * Created by Уладзімір Асіпчук on 19.04.15.
 */

public class Mahler {

    static int curVoice = 0;
    static int lastVoice = 0;
    static String curInstrument = "Piano";
    static String curTempo = "120";

    static int curOctave = 5;
    static char curDuration = 'q';


    static Player player = new Player();
    static Pattern pattern = new Pattern();
    static Scanner in = new Scanner(System.in);
    public static void main(String[] args) {
        // main melody
        System.out.println("Mahler music editor");
//        System.out.println("Don't know what to do?\n" +
//                "Try \"author help help\".");

        EventQueue.invokeLater(new Runnable() {
            public void run() {
                play(Melodies.vivaldi);
            }
        });
        System.out.println("Hello, " + System.getProperty("user.name") + ".");
        while(true) {
            switch (in.next()) {
                case "help":
                    help();
                    break;
                case "hello":
                    hello();
                    break;
                case "init":
                    init();
                    break;
                case "print":
                    print();
                    break;
                case "play":
                    play();
                    break;
                case "mahler":
                    play(Melodies.mahSymphony5);
                    break;
                case "status":
                    status();
                    break;
                case "try":
                    tryPitch(in.next());
                    break;
                case "a":
                case "append":
                    append();
                    break;
                case "instrument":
                    instrument();
                    break;
                case "clear":
                    clear();
                    break;
                case "voice":
                    voice();
                    break;
                case "tempo":
                    tempo();
                    break;
                case "set":
                    set();
                    break;
                case "p":
                case "put":
                    put();
                    break;
                case "o":
                case "octave":
                    octave(null);
                    break;
                case "d":
                case "duration":
                    duration();
                    break;
                case "up":
                    octave(true);
                    break;
                case "down":
                    octave(false);
                    break;
                default:
                    defaultOperation();
                    break;
            }
        }
    }

    public static void octave(Boolean isUp) {
        if (null==isUp) {
            curOctave = in.nextInt();
        } else if (isUp) {
            curOctave++;
        } else {
            curOctave--;
        }
    }

    public static void duration() {
        curDuration = in.next().charAt(0);
    }

    public static void put() {
        String temp = in.next();
        while (!"--".equals(temp)) {
            pattern.add(temp+curOctave+curDuration);
            temp = in.next();
        }
    }

    private static void set() {
        pattern.setProperty(in.next(), in.next());
    }

    private static void tempo() {
        curTempo = in.next();
        pattern.add(" T[" + curTempo + "] ");
    }

    private static void voice() {
        if (!in.hasNextInt()) {
            lastVoice++;
            curVoice = lastVoice;
            pattern.add(" V" + curVoice+ " ");
        } else {
            int tempVoice = Integer.parseInt(in.next());
            curVoice = tempVoice;
            pattern.add(" V" + curVoice + " ");
        }

    }

    private static void instrument() {
        String temp = in.next();
        pattern.add("I["+temp+"]");
        curInstrument = temp;
    }

    private static void append() {
        String temp = in.next();
        while (!"--".equals(temp)) {
            pattern.add(temp);
            temp = in.next();
        }

    }

    private static void defaultOperation() {
        System.out.println("Mahler don't know this command.\n" +
                "Please, try \"help\" to find required information.\n");
    }

    private static void tryPitch(String ss){
        player.play(String.valueOf(ss.charAt(0)));
    }

    private static void status() {
        System.out.println("Author: "+ pattern.getProperty("Author"));
        System.out.println("Title: " + pattern.getTitle());
        System.out.println("Current voice: " + curVoice);
        System.out.println("Current instrument: " + curInstrument);
        System.out.println("Current tempo: " + curTempo);
    }

    private static void help() {
        System.out.println(Info.info.get(in.next()));
    }

    private static void hello() {

        java.util.TimeZone tz = java.util.TimeZone.getTimeZone("GMT+1");
        java.util.Calendar c = java.util.Calendar.getInstance(tz);
        int hour = c.get(java.util.Calendar.HOUR_OF_DAY);

        String dayPeriod = null;
        // night
        if (hour < 6) {
            dayPeriod = "night";
        } // morning
        else if (hour < 12) {
            dayPeriod = "morning";
        } // afternoon
        else if (hour < 18) {
            dayPeriod = "afternoon";
        } // evening
        else if (hour < 24) {
            dayPeriod = "evening";
        }
        System.out.println("Thanks for greetings! Good " + dayPeriod + "!");
        player.play(Melodies.greetings);
    }

    private static void init() {
        pattern = new Pattern();
        pattern.add("V0 a4 b4 c d e f g# aw");
    }

    private static void clear() {
        pattern = new Pattern();
        curDuration = 'q';
        curOctave = 5;
        curTempo = "120";
        curInstrument = "Piano";
        curVoice = 0;
        lastVoice = 0;
    }

    private static void print() {
        System.out.println(pattern.toString());
    }

    private static void play() {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                player.play(pattern);
            }
        });
    }

    private static void play(String pat){
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                player.play(pat);
            }
        });
    }
}
