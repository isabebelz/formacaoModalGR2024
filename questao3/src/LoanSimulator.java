import java.util.ArrayList;
import java.util.List;

/**
 * Classe que simula um empréstimo financeiro com base em critérios de elegibilidade.
 */
public class LoanSimulator {

    /**
     * Verifica se um colaborador é elegível para um empréstimo com base no tempo de casa, salário e valor do empréstimo.
     *
     * @param yearsHome Tempo de casa do colaborador em anos.
     * @param salary Salário do colaborador.
     * @param loanValue Valor do empréstimo desejado.
     * @return true se o colaborador for elegível, false caso contrário.
     */
    public static boolean isEligible(int yearsHome, double salary, double loanValue) {
        return yearsHome > 5 && loanValue <= (salary * 2) && loanValue % 2 == 0;
    }

    /**
     * Simula a distribuição de notas para o empréstimo com base na opção de retirada.
     *
     * @param loanValue Valor do empréstimo desejado.
     * @param withdraw Opção de retirada (1 - Notas de maior valor, 2 - Notas de menor valor, 3 - Notas meio a meio).
     */
    public static void simulateLoan(double loanValue, int withdraw) {
        List<String> moneyNotes = new ArrayList<>();
        int r;

        int[] notes;
        String title;
        double loanValue2 = 0.0;

        if (withdraw == 1) {
            notes = new int[]{100, 50, 20, 10, 5, 2};
            title = "Notas de maior valor:";
        } else if (withdraw == 2) {
            notes = new int[]{20, 10, 5, 2};
            title = "Notas de menor valor:";
        } else {
            notes = new int[]{100, 50, 20, 10, 5, 2};
            title = "Notas meio a meio:";
            loanValue /= 2;
            loanValue2 = loanValue;
        }

        int i = 0;

        while (loanValue != 1 && i < notes.length) {
            r = (int) (loanValue / notes[i]);
            if (r > 0) {
                moneyNotes.add(r + " x " + notes[i] + " reais");
            }
            r *= notes[i];
            loanValue -= r;
            i++;
        }

        i = 2;

        while (loanValue2 != 1 && i < notes.length) {
            r = (int) (loanValue2 / notes[i]);
            if (r > 0) {
                moneyNotes.add(r + " x " + notes[i] + " reais");
            }
            r *= notes[i];
            loanValue2 -= r;
            i++;
        }

        System.out.println(title);

        for (String note : moneyNotes) {
            System.out.println(" > " + note);
        }
    }
}
