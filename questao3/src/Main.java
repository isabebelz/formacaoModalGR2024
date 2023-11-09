import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.Scanner;

/**
 * Classe principal que implementa um programa de empréstimo para funcionários da ModalGR.
 */
public class Main {
    public static void main(String[] args) throws ParseException {

        System.out.println("PROGRAMA DE EMPRÉSTIMO MODALGR");

        System.out.println("\nDigite seus dados e iremos avaliar se o seu perfil atende os requisitos mínimos do programa");

        Scanner sc = new Scanner(System.in);
        Locale.setDefault(Locale.US);

        System.out.print("\nNome: ");
        String name = sc.nextLine();

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        dateFormat.setLenient(false);

        boolean check = false;
        String hiringDate = null;

        while (!check) {
            System.out.print("Data de admissão (formato dd/MM/yyyy): ");
            hiringDate = sc.next();

            try {
                dateFormat.parse(hiringDate);
                check = true;
            } catch (ParseException e) {
                System.out.println("Data em formato inválido.");
            }
        }

        check = false;
        double salary = 0.0;

        while (!check) {
            System.out.print("Salário atual: ");
            String input = sc.next();

            try {
                salary = Double.parseDouble(input);
                check = true;
            } catch (NumberFormatException e) {
                System.out.println("Valor em formato inválido.");
            }
        }

        Collaborator collaborator = new Collaborator(name, salary, hiringDate);

        check = false;
        double loanValue = 0.0;

        System.out.println("O valor do empréstimo precisa ser multiplo de 2.");
        while (!check) {
            System.out.print("Valor do empréstimo: ");
            String input = sc.next();

            try {
                loanValue = Double.parseDouble(input);
                check = true;

                if(loanValue % 2 != 0) {
                    System.out.println("Insira um valor válido!");
                    check = false;
                }

            } catch (NumberFormatException e) {
                System.out.println("Valor em formato inválido!");
            }
        }


        while (loanValue % 2 != 0) {
            System.out.println("Insira um valor válido!");
            loanValue = sc.nextDouble();
        }

        // Verifica se o funcionário é elegível para simular um empréstimo
        boolean canSimulateLoan =  LoanSimulator.isEligible(Collaborator.calculateHomeTime(collaborator.getHiringDate()), collaborator.getSalary(), loanValue);

        if (canSimulateLoan) {
            System.out.println("\nDigite o número correspondente a opção de retirada:");
            System.out.println("\n1. Notas de maior valor considerando primeiramente as notas de 100 e 50 reais, e em seguida, as inferiores (20, 10, 5 e 2 reais)");
            System.out.println("2. Notas de menor valor (20, 10, 5 e 2 reais)");
            System.out.println("3. Notas meio a meio (50% em notas de maior valor e 50% em notas de menor valor)");
            System.out.println("4. Sair (para encerrar o programa)");

            int withdraw = sc.nextInt();

            if (withdraw == 4) {
                System.exit(0);
            } else {
                LoanSimulator.simulateLoan(loanValue, withdraw);
            }

        } else {
            System.exit(0);
        }

        sc.close();
    }
}
