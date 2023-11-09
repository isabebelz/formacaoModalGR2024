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

        int[] notes = {100, 50, 20, 10, 5, 2};
        String title;
        int i;

        if (withdraw == 1) {
            i = 0;
            title = "Notas de maior valor:";
            moneyNotes(loanValue, notes, i, title);
        } else if (withdraw == 2) {
            i = 2;
            title = "Notas de menor valor:";
            moneyNotes(loanValue, notes, i, title);
        } else {
            for (i = 0; i < 2; i++) {
                if(i == 0) {
                    title = "Notas meio a meio:\nNotas de maior valor:";
                } else {
                    title = "Notas de menor valor:";
                }
                if(i == 1) {
                    i = 2;
                }
                moneyNotes((loanValue / 2), notes, i, title);
            }
        }
    }


    /**
     * Este método calcula a quantidade de cédulas necessárias para representar um valor monetário em reais
     * usando as denominações de cédulas fornecidas.
     *
     * @param loanValue O valor monetário que deve ser representado em cédulas.
     * @param notes Um array de inteiros contendo as denominações das cédulas disponíveis em ordem decrescente.
     * @param i O índice atual no array 'notes' que indica qual denominação de cédula está sendo avaliada.
     * @param title Uma string que descreve o título ou finalidade da impressão das cédulas calculadas.
     */
    public static void moneyNotes(double loanValue, int[] notes, int i, String title) {

        List<String> moneyNotes = new ArrayList<>();
        int r;

        while (loanValue != 1 && i < notes.length) {
            r = (int) (loanValue / notes[i]);
            if (r > 0) {
                moneyNotes.add(r + " x " + notes[i] + " reais");
            }
            r *= notes[i];
            loanValue -= r;
            i++;
        }

        System.out.println(title);

        for(String note : moneyNotes) {
            System.out.println("> " + note);
        }

    }
}
