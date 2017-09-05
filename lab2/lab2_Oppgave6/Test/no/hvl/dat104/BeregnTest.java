package no.hvl.dat104;

import org.junit.Assert;
import org.junit.Test;

import static no.hvl.dat104.Beregn.isValidTemp;
import static org.junit.Assert.*;

/**
 * Created by Peder on 29.08.2017.
 */
public class BeregnTest {
    Beregn b;
    String temp0 = "10.0";
    String temp1 = "-400.0";
    String temp2 = "200.0";

    double omregn = 12.0;
    double omregn1 = 15.0;
    double omregn2 = 17.0;


    @org.junit.Before
    public void setUp() throws Exception {
        b = new Beregn();
    }
    @Test
    public void erGyldigInput() throws Exception {
        assertTrue(isValidTemp(temp0));
        assertTrue(isValidTemp(temp2));
        assertFalse(isValidTemp(temp1));
        assertFalse(isValidTemp(""));
    }
    private static final double DELTA = 1e-15;
    @org.junit.Test
    public void omregnFraCtilFTest() throws Exception {

        b = new Beregn(1.0);
        double omregn = b.omregnFraCtilF();
        try {
            assertEquals(33.8, omregn,DELTA);
        } catch (Exception k){
            fail("lol");
        }
    }

    @org.junit.Test
    public void omregnFraFtilCTest() throws Exception {
        b.setTemp(33.8);
        double omregn = b.omregnFraFtilC();
        assertEquals(1.0, Math.ceil(omregn), DELTA);

    }

}