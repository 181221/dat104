package no.pederyo.app;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
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
            case "fornavn": case "etternavn":
                return ValidatorUtil.isValidfornavn(param);
            case "mobil":
                return ValidatorUtil.isValidNumber(param);
            default:
                return false;
        }
    }

    /**
     * Sjekker cookies kaller på sjekkParams for å sjekke om de er gyldig
     * @param cookies
     * @return
     */
    public static boolean sjekkCookies(List<Cookie> cookies) {
        for(int i = 0; i < cookies.size(); i ++) {
            if(!sjekkParams(cookies.get(i).getName(), cookies.get(i).getValue())) {
                return false;
            }else {
                ValidatorUtil.escapeHtml(cookies.get(i).getValue());
            }
        }
        return true;
    }

    /**
     * Lager cookies til alle parameterene for å sende inn flash
     * @param request
     * @return
     */
    public static List<Cookie> sjekkPersonOpplysninger(HttpServletRequest request) {
        Enumeration<String> k = request.getParameterNames();
        List<Cookie> cookies = new ArrayList<>();
        while (k.hasMoreElements()){
            String param = k.nextElement();
            Cookie ny = new Cookie(param,request.getParameter(param));
            cookies.add(ny);
        }
        return cookies;
    }
}
