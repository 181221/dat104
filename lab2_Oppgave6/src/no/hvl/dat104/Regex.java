package no.hvl.dat104;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Peder on 29.08.2017.
 */
public class Regex {
    public static void main(String[] args) {
        String p = "Hei jeg heter peder. Jeg er fra bergen";
        String k = "12.21";
        reqexChecker("[0-9]{0,3}.[0-9]{0,3}", k);
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
