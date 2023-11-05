import java.util.Base64;

public class Main {

    public static void main(String[] args) {

        String[] passwords = {"#IsabelNosEstagiariosModalGR2024!", "#MaiorEmpresaDeTecnologiaDaBaixada!!!", "#MeDaUmaVagaModal!!!!"};
        byte[] salt = new byte[16];


        AESCrypto crypto = new AESCrypto(salt);

        for (String password : passwords) {
            byte[] iv = new byte[16]; // Use um IV único para cada senha
            byte[] encryptedPassword = crypto.encryptPassword(password, iv);

            System.out.println("Senha criptografada: " + Base64.getEncoder().encodeToString(encryptedPassword));

            byte[] decryptedPassword = crypto.decryptPassword(encryptedPassword, iv);
            System.out.println("Senha descriptografada: " + new String(decryptedPassword));

            System.out.println();
        }






    }
}
