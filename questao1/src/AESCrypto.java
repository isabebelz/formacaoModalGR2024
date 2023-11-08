import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;

/**
 * Classe responsável por criptografar e descriptografar senhas usando o algoritmo AES.
 */
public class AESCrypto {
    private static SecretKey secretKey;

    /**
     * Construtor da classe que inicializa a chave secreta a ser usada para criptografia.
     */
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

    /**
     * Criptografa uma senha utilizando o algoritmo AES com o modo de operação especificado.
     *
     * @param password A senha a ser criptografada.
     * @param mode O modo de operação (por exemplo, "CBC", "CFB", "OFB").
     * @param iv O vetor de inicialização a ser usado na criptografia.
     * @return O array de bytes representando a senha criptografada.
     */
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

    /**
     * Descriptografa uma senha criptografada utilizando o algoritmo AES com o modo de operação especificado.
     *
     * @param encryptedPassword O array de bytes representando a senha criptografada.
     * @param mode O modo de operação (por exemplo, "CBC", "CFB", "OFB").
     * @param iv O vetor de inicialização a ser usado na descriptografia.
     * @return A senha descriptografada como array de bytes.
     */
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

