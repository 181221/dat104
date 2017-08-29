package no.hvl.dat104;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Peder on 28.08.2017.
 */
public class Beregn {
    private double temp;

    public Beregn() {
        temp = 0.0;
    }
    public Beregn( double temp){
        this.temp = temp;
    }
    public static boolean isValidTemp(String s) {
        return s != null && s.matches("[0-9]{0,3}.[0-9]{0,3}");
    }

    public double omregnFraCtilF() {
        /* fra C til F  | T(°C) × 1.8 + 32 */
        return temp*1.8+32;

    }
    public double omregnFraFtilC() {
        /* fra F til C  | (T(°F) - 32) / 1.8 */
        double omregning = ((temp-32) / 1.8);
        return omregning;
    }



    public double getTemp() {
        return temp;
    }




}
