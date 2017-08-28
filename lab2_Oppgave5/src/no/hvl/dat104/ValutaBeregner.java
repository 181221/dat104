package no.hvl.dat104;

import no.hvl.lph.ExchangeRate;
import no.hvl.lph.ExchangeRateService;

import java.io.IOException;

public class ValutaBeregner {

    public boolean isValid(String s) {
        return s != null && s.matches("^\\d{1,12}(|[.]\\\\d+)$");
    }
    //"heihwe\"\+\"hwie"

    public static double BeregnValuta(String fra, String til, double belop) throws IOException {
        ExchangeRate rate = ExchangeRateService.getRate(fra, til);
        return rate.getRate() * belop;
    }

}
