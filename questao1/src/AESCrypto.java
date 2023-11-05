import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;

public class AESCrypto {
    private static SecretKey secretKey;
    private final String key = "#modalGR#GPTW#top#maiorEmpresaTecnologia#baixadaSantista";

    public AESCrypto(byte[] salt) {
        try {
            PBEKeySpec pbeKeySpec = new PBEKeySpec(key.toCharArray(), salt, 10000, 128);
            SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
            SecretKey tmp = factory.generateSecret(pbeKeySpec);
            secretKey = new SecretKeySpec(tmp.getEncoded(), "AES");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public byte[] encryptPassword(String password, byte[] iv) {
        try {
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            IvParameterSpec ivSpec = new IvParameterSpec(iv);
            cipher.init(Cipher.ENCRYPT_MODE, secretKey, ivSpec);

            return cipher.doFinal(password.getBytes());
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public byte[] decryptPassword(byte[] encryptedPassword, byte[] iv) {
        try {
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            IvParameterSpec ivSpec = new IvParameterSpec(iv);
            cipher.init(Cipher.DECRYPT_MODE, secretKey, ivSpec);

            return cipher.doFinal(encryptedPassword);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
