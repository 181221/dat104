package no.pederyo.utils;

/**
 * Created by Peder on 28.09.2017.
 */
public class TelefonUtil {
    public static String formaterTlf(String nummer) {
        String ny = String.format("%s %s %s", nummer.substring(0,3), nummer.substring(3,5), nummer.substring(5,8));
        return ny;
    }


}
