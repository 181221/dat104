package no.hvl.dat104;

/**
 * Created by Peder on 28.08.2017.
 */
public class Beregn {
    double temp;

    public Beregn() {

    }
    public Beregn( double temp){
        this.temp = temp;
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



}
