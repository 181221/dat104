package no.pederyo.app;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

/**
 * Created by Peder on 27.09.2017.
 */
public class SjekkOpplysninger {
    /**
     * Sjekker parameter typene ved a kalle på ValidatorUtil sjekker om de er gyldig
     * @param type fornavn, etternavn og mobil
     * @param param parameter value: Peder, Gunnar, 12345678
     * @return
     */
    public static boolean sjekkParams(String type, String param) {
        switch (type) {
            case "fornavn":
                return ValidatorUtil.isValidfornavn(param);
            case "etternavn":
                return ValidatorUtil.isValidetternavn(param);
            case "mobil":
                return ValidatorUtil.isValidNumber(param);
        }
        return false;
    }

    /**
     * Sjekker cookies kaller på sjekkParams for å sjekke om de er gyldig.
     * sjekkParams sjekker fornavn, etternavn og mobil er riktig.
     * Escaper HTML.
     * @param cookies
     * @return returnerer sann om fornavn, etternavn og mobil er Ok.
     */
    public static boolean sjekkCookies(List<Cookie> cookies) {
        List<String> meldinger = new ArrayList<>();
        FlashUtil flash = new FlashUtil();
        Boolean feil = true;
        for(int i = 0; i < cookies.size()-1; i ++) {
            String navn = cookies.get(i).getName();
            String verdi = cookies.get(i).getValue();
            if(!sjekkParams(navn, verdi)) {
                meldinger.add(navn);
                feil = false;
            }
        }
        flash.setMeldinger(meldinger);
        return feil;
    }

    /**
     * Lager cookies til alle parameterene for å sende inn flash
     * @param request
     * @return
     */
    public static List<Cookie> sjekkPersonOpplysninger(HttpServletRequest request, HttpServletResponse response) {
        Enumeration<String> k = request.getParameterNames();
        List<Cookie> cookies = new ArrayList<>();
        while (k.hasMoreElements()){
            String param = k.nextElement();
            Cookie ny = new Cookie(param,request.getParameter(param));
            response.addCookie(ny);
            cookies.add(ny);
        }
        return cookies;
    }
}
