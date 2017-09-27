package no.pederyo.app;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

/**
 * Klasse for aa Hashe passord
 */
public class SHA512 {
    /**
     * SALT kan endres etter behov.
     */
    public static String SALT = "VALERIEN STEEL";

    /**
     * Hashpassord
     * @param passord
     * @return
     * @throws NoSuchAlgorithmException
     */
    public static String SHA1Hash(String passord) throws NoSuchAlgorithmException {
        String passwordToHash = passord;
        return get_SHA_512_SecurePassword(passwordToHash, SALT);
    }
    /**
     * Hasher passordet.
     * @param passwordToHash
     * @param salt
     * @return
     */
    private static String get_SHA_512_SecurePassword(String passwordToHash, String salt)
    {
        String generatedPassword = null;
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-512");
            md.update(salt.getBytes());
            byte[] bytes = md.digest(passwordToHash.getBytes());
            StringBuilder sb = new StringBuilder();
            for(int i=0; i< bytes.length ;i++)
            {
                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }
            generatedPassword = sb.toString();
        }
        catch (NoSuchAlgorithmException e)
        {
            e.printStackTrace();
        }
        return generatedPassword;
    }

    public static String getSALT() {
        return SALT;
    }

    public static void setSALT(String SALT) {
        SHA512.SALT = SALT;
    }
}
