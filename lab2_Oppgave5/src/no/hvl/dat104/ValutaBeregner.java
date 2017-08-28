package no.hvl.dat104;

import no.hvl.lph.ExchangeRate;
import no.hvl.lph.ExchangeRateService;

import java.io.IOException;

public class ValutaBeregner {
    public static double BeregnValuta(String fra, String til) throws IOException {
        ExchangeRate rate = ExchangeRateService.getRate(fra, til);
        return rate.getRate();
    }

}
