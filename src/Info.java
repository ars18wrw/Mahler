import java.util.HashMap;
import java.util.Map;

/**
 * Created by Уладзімір Асіпчук on 20.04.15.
 */
public class Info {
    public final static Map<String, String> info;
    static {
        info = new HashMap<>();

        info.put("hello", "hello\nGreets program with the beginning of work.\n");
        info.put("help", "help [command]\nGives you some info about each command in Mahler.\n" +
                "Try \"help [command]\"\n"
        );
        info.put("print", "print\nPrints your current pattern.\n");
        info.put("play", "play\nPlays your current patern.\n");
        info.put("init", "init\nInitialize your pattern with Cdur scale " +
                "and standart characterstics: Piano, Tempo120, etc...\n");
        info.put("status", "status\nGives you info about your current pattern, which include:\n" +
                "+author name;\n" +
                "+title;\n" +
                "+number of voices;\n" +
                "+current voice;\n" +
                "+current instrument;\n" +
                "+current tempo.\n");
//        info.put("author", "author author [command]\nEnters a bloke of settings commands, which includes:\n" +
//                "+hello;\n" +
//                "+help;\n" +
//                "+print;\n" +
//                "+play;\n" +
//                "+init;\n" +
//                "+status.\n");
        info.put("try", "try [pitch]\nAllows you to hear certain pitch.\n");

        info.put("append", "append [MusicString] --\nSimply appends string of MusicString format to your pattern.\n" +
                "-- combination indicates that command is off.\n" +
                "Be careful: Mahler do not think about appendix's accuracy!\n");
        info.put("instrument","instrument [Name|Number]\nChanges current instrument to a certain one.\n");
        info.put("clear","Clears everything from your pattern.\n");
        info.put("voice", "voice [number]\nCreates new voice or changes the voice to required number.\n");
        info.put("set", "set arg val\nSets vakue to special arguments, such as:\n" +
                "+Author;\n" +
                "Title;\n" +
                "etc...\n" +
                "Be carefull! Mahler do not care about correctness of your fields.\n");
    }

}
