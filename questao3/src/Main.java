import java.text.ParseException;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws ParseException {

        System.out.println("PROGRAMA DE EMPRÉSTIMO MODALGR");

        System.out.println("\nDigite seus dados e iremos avaliar se o seu perfil atende os requisitos mínimos do programa");

        Scanner sc = new Scanner(System.in);
        Locale.setDefault(Locale.US);

        System.out.print("Nome: ");
        String name = sc.nextLine();
        System.out.print("Data de admissão no formato (dd/MM/yyyy): ");
        String hiringDate = sc.next();
        System.out.print("Salário atual: ");
        double salary = sc.nextDouble();
        Collaborator collaborator = new Collaborator(name, salary, hiringDate);

        System.out.print("Valor do empréstimo: ");
        double loanValue = sc.nextDouble();

        while (loanValue % 2 != 0) {
            System.out.println("Insira um valor válido!");
            loanValue = sc.nextDouble();
        }

        boolean canSimulateLoan =  Analyzer.canSimulateLoan(Analyzer.calculateHomeTime(collaborator.getHiringDate()), collaborator.getSalary(), loanValue);

        if(canSimulateLoan) {
            System.out.println("Digite o número correspondente a opção de retirada:");
            System.out.println("1. Notas de maior valor considerando primeiramente as notas de 100 e 50 reais, e em seguida, as inferiores (20, 10, 5 e 2 reais)");
            System.out.println("2. Notas de menor valor (20, 10, 5 e 2 reais)");
            System.out.println("3. Notas meio a meio (50% em notas de maior valor e 50% em notas de menor valor)");
            System.out.println("4. Sair (para encerrar o programa)");

            int withdraw = sc.nextInt();

            if(withdraw == 4) {
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