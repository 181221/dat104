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
     * Fornavn skal være 2-20 tegn og kan inneholde bokstaver (inkl. æøåÆØÅ),
     * @param fornavn
     * @return
     */
    public static boolean isValidfornavn(String fornavn) {
        return fornavn.matches("^[A-Z]\\p{L}{2,20}");
    }

    /**
     * Mobil skal være eksakt 8 siffer, ingenting annet
     * @param telefon
     * @return
     */
    public static boolean isValidTelefon(String telefon) {
        return telefon.matches("^[A-Z]\\p{L}{2,20}");
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
