package no.pederyo.utils;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Created by Peder on 27.09.2017.
 */
public class ValidatorTest {
    /**
     * fornavn
     */
    private String f0 = "Pæåder";
    private String f1 = "Pe-der";
    private String f2 = "Ped-Wiig Ålener";
    private String f3 = "pederpederpederpederpederpederpederpeder";
    private String f4 = "Pederderpederpederpederpederpederpederpederpe";
    private String f5 = "peDer";
    private String f6 = "P";

    /**
     * etternavn
     */
    private String e0 = "Wiig";
    private String e2 = "Ås";
    private String e3 = "Ivar Åsen";
    private String e4 = "Åsen-Iversen";
    private String e5 = "åsen";
    private String e6 = "G";
    private String e7 = "";

    /**
     * mobil
     */
    private String t0 = "123";
    private String t1 = "12345678";
    private String t2 = "1234567812345678";
    @BeforeEach
    void setUp() {

    }

    @Test
    void isValidTelfon() {
        assertTrue(ValidatorUtil.isValidTelefon(t1));
        assertFalse(ValidatorUtil.isValidTelefon(t0));
        assertFalse(ValidatorUtil.isValidTelefon(t0));
    }

    @Test
    void isValidfornavn() {
        assertTrue(ValidatorUtil.isValidfornavn(f0));
        assertTrue(ValidatorUtil.isValidfornavn(f1));
        assertTrue(ValidatorUtil.isValidfornavn(f2));
        assertFalse(ValidatorUtil.isValidfornavn(f3));
        assertFalse(ValidatorUtil.isValidfornavn(f4));
        assertFalse(ValidatorUtil.isValidfornavn(f5));
        assertFalse(ValidatorUtil.isValidfornavn(f6));
    }
    @Test
    void isValidEtternav() {
        assertTrue(ValidatorUtil.isValidetternavn(e0));
        assertTrue(ValidatorUtil.isValidetternavn(e2));
        assertFalse(ValidatorUtil.isValidetternavn(e3));
        assertTrue(ValidatorUtil.isValidetternavn(e4));
        assertFalse(ValidatorUtil.isValidetternavn(e5));
        assertFalse(ValidatorUtil.isValidetternavn(e6));
        assertFalse(ValidatorUtil.isValidetternavn(e7));
    }




}
