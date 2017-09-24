package no.hvl.dat104.app;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by Peder on 24.09.2017.
 */
public class SHA {
    public static String SALT = "VALERIEN STEEL";

    /**
     * Hasher passord til SHA-512
     * @param passord passord som skal hashes
     * @return
     * @throws NoSuchAlgorithmException
     */
    public static String SHA1Hash(String passord) throws NoSuchAlgorithmException {
        String passwordToHash = passord;
        return get_SHA_1_SecurePassword(passwordToHash, SALT);
    }
    private static String get_SHA_1_SecurePassword(String passwordToHash, String salt)
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
    public static void setSALT(String SALT) {
        SHA.SALT = SALT;
    }
}
