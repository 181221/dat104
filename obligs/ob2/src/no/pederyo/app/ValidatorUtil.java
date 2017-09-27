package no.pederyo.app;

public class ValidatorUtil {
    /**
     * Validerer strengen om det er riktig, tillatter alle
     * unicode bokstaver fra alle språk samt -, ' og whitespaces
     * @param s Strengen som skal valideres
     * @return True eller false
     */
    public static boolean isValidString(String s) {
        return s != null && s.matches("^[\\p{L}\\-\'\\s]+$");
    }

    public static boolean isValidNumber(String n) {
        return n != null && n.matches("^[\\d]+$");
    }

    public static boolean isValidSubmitType(String submit) {
        return submit != null && (submit.equals("Slett") || submit.equals("Submit"));
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
     * Returnerer sann om streng er ulik null og ""
     * @param s
     * @return
     */
    public static boolean isNotNull0(String s) {
        return s != null && s != "";
    }

    /**
     * Sann om brukernavn ikke er null, "" eller mindre enn 20
     * @param username
     * @return
     */
    public static boolean isValidUsername(String username) {
        return username != null && !username.equals("") && username.length() < 20;
    }

    /**
     * Sann om passord ikke er null, "" eller mindre enn 200.
     * @param password
     * @return
     */
    public static boolean isValidPassword(String password) {
        return password != null && !password.equals("") && password.length() < 200;
    }
}
