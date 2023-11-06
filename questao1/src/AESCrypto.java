import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;

public class AESCrypto {
    private static SecretKey secretKey;

    public AESCrypto() {
        try {
            byte[] salt = new byte[16];
            String KEY = "#modalGR#GPTW#top#maiorEmpresaTecnologia#baixadaSantista";
            PBEKeySpec pbeKeySpec = new PBEKeySpec(KEY.toCharArray(), salt, 10000, 128);
            SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
            SecretKey tmp = factory.generateSecret(pbeKeySpec);
            secretKey = new SecretKeySpec(tmp.getEncoded(), "AES");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public byte[] encryptPassword(String password, String mode, byte[] iv) {
        try {
            Cipher cipher = Cipher.getInstance("AES/" + mode + "/PKCS5Padding");
            IvParameterSpec ivSpec = new IvParameterSpec(iv);
            cipher.init(Cipher.ENCRYPT_MODE, secretKey, ivSpec);

            return cipher.doFinal(password.getBytes());
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public byte[] decryptPassword(byte[] encryptedPassword, String mode, byte[] iv) {
        try {
            Cipher cipher = Cipher.getInstance("AES/" + mode + "/PKCS5Padding");
            IvParameterSpec ivSpec = new IvParameterSpec(iv);
            cipher.init(Cipher.DECRYPT_MODE, secretKey, ivSpec);

            return cipher.doFinal(encryptedPassword);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
