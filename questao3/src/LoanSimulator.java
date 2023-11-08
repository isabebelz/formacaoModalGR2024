import java.util.ArrayList;
import java.util.List;

public class LoanSimulator {

    public static boolean isEligible(int yearsHome, double salary, double loanValue) {
        return yearsHome > 5 && loanValue <= (salary * 2) && loanValue % 2 == 0;
    }

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
            if(r > 0) {
                moneyNotes.add(r + " x " + notes[i] + " reais");
            }
            r *= notes[i];
            loanValue -= r;
            i++;
        }

        i = 2;

        while (loanValue2 != 1 && i < notes.length) {
            r = (int) (loanValue2 / notes[i]);
            if(r > 0) {
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