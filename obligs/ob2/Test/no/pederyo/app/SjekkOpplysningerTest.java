package no.pederyo.app;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Tester SjekkOpplysninger klassen
 */
class SjekkOpplysningerTest {
    /**
     * params info
     */
    private String f = "Peder";
    private String f1 = "Gunnar";
    private String mobil ="12345678";

    /**
     * param type
     */
    private String type = "fornavn";
    private String type1 = "etternavn";
    private String type2 = "mobil";

    /**
     * cookies
     */
    private List<Cookie> cookies;
    private Cookie cookie;
    private Cookie cookie1;
    private Cookie cookie2;

    @BeforeEach
    void setUp() {
        cookies = new ArrayList<>();
        cookie = new Cookie(type,f);
        cookie1 = new Cookie(type1,f1);
        cookie2 = new Cookie(type2,mobil);

        cookies.add(cookie);
        cookies.add(cookie1);
        cookies.add(cookie2);
    }

    @Test
    void sjekkParams() {
        assertTrue(SjekkOpplysninger.sjekkParams(type, f));
        assertTrue(SjekkOpplysninger.sjekkParams(type1, f1));
        assertTrue(SjekkOpplysninger.sjekkParams(type2, mobil));
    }

    @Test
    void sjekkCookies() {
        HttpServletRequest request = null;
        assertTrue(SjekkOpplysninger.sjekkCookies(cookies, request));
    }

}