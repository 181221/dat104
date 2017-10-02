package no.pederyo.utils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Peder on 27.09.2017.
 */
public class SjekkOpplysninger {
    public static final String FEIL_FORNAVN = "Fornavn skal være 2-20 tegn og kan inneholde bokstaver (inkl. æøåÆØÅ) bindestrek og mellomrom. Første tegn skal være en stor bokstav.";
    public static final String FEIL_ETTERNAVN = "Etternavn skal være 2-20 tegn og kan inneholde bokstaver (inkl. æøåÆØÅ) og bindestrek (IKKE mellomrom). Første tegn skal være en stor bokstav.";
    public static final String FEIL_MOBIL = "Mobil skal være eksakt 8 siffer";
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
                return ValidatorUtil.isValidTelefon(param);
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
    public static boolean sjekkCookies(List<Cookie> cookies, HttpServletRequest request) {
        HashMap<String, String> feilmeldinger = new HashMap<>();
        String[] meldinger = {FEIL_FORNAVN,FEIL_ETTERNAVN,FEIL_MOBIL};
        Boolean feil = true;
        for(int i = 0; i < cookies.size()-1; i ++) {
            String navn = cookies.get(i).getName();
            String verdi = cookies.get(i).getValue();
            if(!sjekkParams(navn, verdi)) {
                feilmeldinger.put(navn,meldinger[i]);
                feil = false;
            }
        }
        request.getSession().setAttribute("feilmeldinger", feilmeldinger);
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
