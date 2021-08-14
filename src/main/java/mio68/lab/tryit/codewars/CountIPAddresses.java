package mio68.lab.tryit.codewars;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.util.Arrays;

public class CountIPAddresses {
    public static long ipsBetween(String start, String end) {
        return ipsBetween1(start, end);
    }


    public static long ipsBetween1(String start, String end) {
        return parseIP(end) - parseIP(start);
    }

    public static long parseIP(String ip) {
        return Arrays.stream(ip.split("\\.")).map(Long::parseLong).reduce(0L, (a, b) -> a * 256 + b);
    }

    /*
     * Вариант с использовнием скриптового движка.
     * Данный вариант не удалось довести "до ума". engine почему-то null?
     * Проверил exp в онлайн калькуляторе - дает правильное значение.
     * Для start = "10.0.0.0", end = "10.0.0.50"
     * exp = (((10)*256+0)*256+0)*256+50 - ((((10)*256+0)*256+0)*256+0)
     *
     */
    public static long ipsBetween2(String start, String end) {
        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine engine = manager.getEngineByName("nashorn");

        String exp = "(((" + end.replaceAll("\\.", ")*256+")
                + " - ((((" + start.replaceAll("\\.", ")*256+") + ")";

        System.out.println(exp);

        long res = 0;
        try {
            res = Long.parseLong(engine.eval(exp).toString());
        } catch (ScriptException e) {
            e.printStackTrace();
        }

        return res;
    }

}
