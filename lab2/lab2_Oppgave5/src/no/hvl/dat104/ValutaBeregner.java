package no.hvl.dat104;

import no.hvl.lph.ExchangeRate;
import no.hvl.lph.ExchangeRateService;

import java.io.IOException;
import java.util.Currency;
import java.util.Set;

public class ValutaBeregner {

    /**
     * @param s
     * @return
     */
    public boolean isValidBelop(String s) {
        return s != null && s.matches("^\\d{1,12}(|[.]\\\\d+)$");
    }
    //"heihwe\"\+\"hwie"

    public static double BeregnValuta(String fra, String til, double belop) throws IOException {
        ExchangeRate rate;
        if(sjekkOmValutaStemmer(fra, til)){
             rate = ExchangeRateService.getRate(fra, til);
        }else {
            return 0;
        }
        return rate.getRate() * belop;
    }
    public static boolean sjekkOmValutaStemmer(String fra, String til) {
        Set<Currency> currencies = Currency.getAvailableCurrencies();
        if(currencies.contains(fra) && currencies.contains(til)){
            return true;
        }else {
            return false;
        }
    }

}
