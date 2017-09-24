package no.hvl.dat104.app;

/**
 * Created by Peder on 24.09.2017.
 */
public class ValidatorUtil {
    /**
     * Validerer strengen om det er riktig, tillatter alle
     * unicode bokstaver fra alle språk samt -, ' og whitespaces
     *
     * @param s Strengen som skal valideres
     * @return True eller false
     */
    public static boolean isValidString(String s) {
        return s != null && s.matches("^[\\p{L}\\-\'\\s]+$");
    }

    public static boolean isValidNumber(String n) {
        return n != null && n.matches("^[\\d]+$");
    }

    /**
     * Renser strengen for <, >, &, ' med html encoding
     * @param s Strengen som skal renses
     * @return Renset streng eller null
     */
    public static String escapeHtml(String s) {
        if (s != null) {
            return s
                    .replaceAll("&", "&amp;")
                    .replaceAll("<", "&lt;")
                    .replaceAll(">", "&gt;")
                    .replaceAll("\"", "&quot;");
        }
        return null;
    }
    /**
     *
     * @param s
     * @return sann om strengen != "" og streng != null
     */
    public static boolean isNotNull0(String s) {
        return s != null && s != "";
    }

    /**
     *
     * @param username
     * @return sann om username != null && username.length() < 20
     */
    public static boolean isValidUsername(String username) {
        return username != null && !username.equals("") && username.length() < 20;
    }

    /**
     *
     * @param password
     * @return sann om passord != null && passord.length() < 200
     */
    public static boolean isValidPassword(String password) {
        return password != null && !password.equals("") && password.length() < 200;
    }
    public static boolean isValidEmail(String email) {
        return email != null && !email.equals("") && email.length() < 40;
    }

    /**
     * Sjekker en streng for null, "", og lengde under 40
     * @param b
     * @return
     */
    public static boolean isValidItem(String b) {
        return b != null && !b.equals("") && b.length() < 40;
    }

}
