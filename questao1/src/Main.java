import java.security.SecureRandom;
import java.util.Base64;

public class Main {
    public static void main(String[] args) {

        String[] passwords = {"#senha1!##", "#senha2!##", "#senha3!##"};

        AESCrypto cryptoAES = new AESCrypto();

        SecureRandom random = new SecureRandom();

        byte[] iv1 = new byte[16];
        random.nextBytes(iv1);
        byte[] iv2 = new byte[16];
        random.nextBytes(iv2);
        byte[] iv3 = new byte[16];
        random.nextBytes(iv3);

        System.out.println("Criptografando senhas com o AES");

        System.out.println("\nUtilizando o modo de operação CBC");

        byte[] encryptedPasswordCBC = cryptoAES.encryptPassword(passwords[0], "CBC", iv1);
        byte[] decryptedPasswordCBC = cryptoAES.decryptPassword(encryptedPasswordCBC, "CBC", iv1);

        System.out.println("\nSenha criptografada: " + Base64.getEncoder().encodeToString(encryptedPasswordCBC));
        System.out.println("Senha descriptografada: " + new String(decryptedPasswordCBC));

        System.out.println("\nUtilizando o modo de operação CFB");

        byte[] encryptedPasswordCFB = cryptoAES.encryptPassword(passwords[0], "CFB", iv2);
        byte[] decryptedPasswordCFB = cryptoAES.decryptPassword(encryptedPasswordCFB, "CFB", iv2);

        System.out.println("\nSenha criptografada: " + Base64.getEncoder().encodeToString(encryptedPasswordCFB));
        System.out.println("Senha descriptografada: " + new String(decryptedPasswordCFB));

        System.out.println("\nUtilizando o modo de operação OFB");

        byte[] encryptedPasswordOFB = cryptoAES.encryptPassword(passwords[0], "OFB", iv3);
        byte[] decryptedPasswordOFB = cryptoAES.decryptPassword(encryptedPasswordOFB, "OFB", iv3);

        System.out.println("\nSenha criptografada: " + Base64.getEncoder().encodeToString(encryptedPasswordOFB));
        System.out.println("Senha descriptografada: " + new String(decryptedPasswordOFB));


    }
}
