package no.hvl.dat104;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pwa.app.SHA1;
import pwa.app.ValidatorUtil;

import java.security.NoSuchAlgorithmException;

import static org.junit.jupiter.api.Assertions.*;

public class ValidatorUtilTest {
    private String in1 = "<h1 style=\"font-size:\n" +
            "20em;position:absolute;top:0;left:0;margin:0;padding:0;\n" +
            "background:red\">Hei</h1>";
    private String in2 = "<img src=”\n" +
            "https://www.google.no/images/branding/googlelogo/2x/googlelogo_color\n" +
            "_272x92dp.png” />";
    private String in3 = "<script type=\"text/javascript\">\n" +
            "window.location=\"http://www.hvl.no\"</script>\n";
    private String in4 = "Ola Nordman";
    private String in5 = "";
    private String in6 = null;
    private String in7 = "1234567";
    private String in8 = "@\"'*^%¤#";
    private String s = "";
    private String noll = null;
    private String passord = "detteErEtPassord";
    /*
     * < = &lt;
     * > = &gt;
     * " = &quot;
     * & = &amp;
     */
    private String r1 = "&lt;h1 style=&quot;font-size:\n" +
            "20em;position:absolute;top:0;left:0;margin:0;padding:0;\n" +
            "background:red&quot;&gt;Hei&lt;/h1&gt;";


    @BeforeEach
    void setUp() {

    }

    @Test
    void validerTall() {
        assertTrue(ValidatorUtil.isValidNumber(in7));
    }

    @Test
    void validerUgyldigStreng() {
        assertFalse(ValidatorUtil.isValidNumber(in4));
    }

    @Test
    void validerNavn() {
        assertTrue(ValidatorUtil.isValidString(in4));
    }

    @Test
    void validerTomStreng() {
        assertFalse(ValidatorUtil.isValidString(in5));
    }

    @Test
    void validerNull() {
        assertFalse(ValidatorUtil.isValidString(in6));
    }

    @Test
    void validerUgyldigeTall() {
        assertFalse(ValidatorUtil.isValidString(in7));
    }

    @Test
    void validerUgyligeSymboler() {
        assertFalse(ValidatorUtil.isValidString(in8));
    }

    @Test
    void escapeHtmlHTML() {
        assertEquals(r1, ValidatorUtil.escapeHtml(in1));
    }

    @Test
    void escapeHtmlNavn() {
        assertEquals(in4, ValidatorUtil.escapeHtml(in4));
    }

    @Test
    void escapeHtmlEmpty() {
        assertEquals(in5, ValidatorUtil.escapeHtml(in5));
    }

    @Test
    void escapeHtmlNull() {
        assertNull(ValidatorUtil.escapeHtml(in6));
    }

    @Test
    void escapeHtmlAPI() {
    }

    @Test
    void validerSubmit() {
    }
    @Test
    void isNotNull() {
        assertFalse(ValidatorUtil.isNotNull0(s));
        assertFalse(ValidatorUtil.isNotNull0(noll));
    }
    @Test
    void isValidVare() {
        String feil = "powekfopwkefopwkefpowkefopwkefpowkefopwekfpowekfpasdasasdawoekfpwoekfwe";
        assertFalse(ValidatorUtil.isValidVare(null));
        assertFalse(ValidatorUtil.isValidVare(feil));
        assertFalse(ValidatorUtil.isValidVare(""));
    }
    @Test
    void SHA1Hash() throws NoSuchAlgorithmException {
        String p1 = SHA1.SHA1Hash(passord);
        String p2 = SHA1.SHA1Hash(passord);
        String p3 = SHA1.SHA1Hash("heisann");
        String p4 = SHA1.SHA1Hash("heisann");
        String p5 = SHA1.SHA1Hash("heiSann");
        String feil = SHA1.SHA1Hash("DETTEERIKKEETPASSORD");
        assertFalse(feil.equals(p1));
        assertFalse(p5.equals(p4));
        assertEquals(p1,p2);
        assertEquals(p3,p4);
    }
}
