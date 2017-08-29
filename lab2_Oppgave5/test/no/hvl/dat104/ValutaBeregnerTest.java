package no.hvl.dat104;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertFalse;
import static no.hvl.dat104.ValutaBeregner.sjekkOmValutaStemmer;

/**
 * Created by Peder on 28.08.2017.
 */
public class ValutaBeregnerTest {
    ValutaBeregner v;
    String val1;
    String val2;
    double belop;

    @Before
    public void setUp() throws Exception {
        v = new ValutaBeregner();
        val1 = "NOK";
        val2 = "NOK";
        belop = 1000;
    }
    @Test
    public void beregnValutaFraTilGirSamme() throws Exception {
        double r = v.BeregnValuta(val1,val2,belop);
        double k = v.BeregnValuta(val1,val2,belop);
        assertEquals(r, k);
    }
    @Test
    public void testBelop() throws Exception {
        String usd = "USD";
        String sek = "SEK";
        double belopet = 0;
        double result = v.BeregnValuta(usd,sek,belopet);
        assertEquals(0.0,result);
    }
    @Test
    public void UgyldigValutaKodeIkkeKastUnntak() throws Exception {
        String ugyldig = "esad";
        String sek = "SEK";
        double belopet = 10;
        double result = v.BeregnValuta(ugyldig,sek,belopet);
        assertEquals(0.0,result);
    }

    @Test
    public void sjekkValutaValue() throws Exception {
        String ugyldigKode = "asdasda";
        String ugyldigKode2 = "asdasd";
        boolean stemmer;
        stemmer =sjekkOmValutaStemmer(ugyldigKode, ugyldigKode2);
        assertFalse(stemmer);
    }

    @Test
    public void isValidBelop() throws Exception {
        String ugyldigKode ="asde";
        boolean result = v.isValidBelop(ugyldigKode);
        assertFalse(result);
    }


}