package no.hvl.dat104;

import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Peder on 29.08.2017.
 */
public class Regex {
    public static void main(String[] args) {
        String p = "Hei jeg heter peder. Jeg er fra bergen";
        String k = "";
        //reqexChecker("\\d{0,3}.\\d{0,3}", k);
        System.out.println(isValidTemp(k));
    }

    public static boolean isValidTemp(String s) {
        return s != null && s.matches("\\d{0,3}.\\d{0,3}");
    }
    public static void reqexChecker(String theRegex, String str2Check) {
        Pattern checkRegex = Pattern.compile(theRegex);

        Matcher regexMatcher = checkRegex.matcher(str2Check);

        while(regexMatcher.find()){
            if(regexMatcher.group().length() != 0){
                System.out.println("Start index: " + regexMatcher.start());
                System.out.println("End Index: " + regexMatcher.end());
            }
        }
    }

}
