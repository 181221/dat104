package no.pederyo.app;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Created by Peder on 27.09.2017.
 */
public class ValidatorTest {
    private String f0 = "Pæåder";
    private String f1 = "Peder";
    private String f2 = "peder";
    private String f3 = "pederpederpederpederpederpederpederpeder";
    private String f4 = "Pederderpederpederpederpederpederpederpederpe";
    private String f5 = "peDer";
    private String f6 = "P";

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
        assertFalse(ValidatorUtil.isValidfornavn(f2));
        assertFalse(ValidatorUtil.isValidfornavn(f3));
        assertFalse(ValidatorUtil.isValidfornavn(f4));
        assertFalse(ValidatorUtil.isValidfornavn(f5));
        assertFalse(ValidatorUtil.isValidfornavn(f6));
    }


}
