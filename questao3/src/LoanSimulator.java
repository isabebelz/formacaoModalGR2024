import java.util.ArrayList;
import java.util.List;

public class LoanSimulator {

    public static void simulateLoan(double loanValue, int withdraw) {

        List<String> moneyNotes = new ArrayList<>();
        int r;

        if(withdraw == 1) {
            int[] notes = {100, 50, 20, 10, 5, 2};
            int i = 0;

            while (loanValue != 1 && i < notes.length) {
                r = (int) (loanValue / notes[i]);
                moneyNotes.add(r+" x "+notes[i]+" reais");
                r *= notes[i];
                loanValue -= r;
                i++;
            }

            System.out.println("Notas de maior valor:");

            for(String note : moneyNotes) {
                System.out.println(" > " + note);
            }

        } else if(withdraw == 2) {
            int[] notes = {20, 10, 5, 2};
            int i = 0;

            while (loanValue != 1 && i < notes.length) {
                r = (int) (loanValue / notes[i]);
                moneyNotes.add(r+" x "+notes[i]+" reais");
                r *= notes[i];
                loanValue -= r;
                i++;
            }

            System.out.println("Notas de menor valor:");

            for(String note : moneyNotes) {
                System.out.println(" > " + note);
            }

        } else {
            int[] notes = {100, 50, 20, 10, 5, 2};
            int i = 0;

            double loanValue2 = loanValue / 2;

            while ((loanValue / 2) != 1 && i < notes.length) {
                r = (int) (loanValue / notes[i]);
                moneyNotes.add(r+" x "+notes[i]+" reais");
                r *= notes[i];
                loanValue -= r;
                i++;
            }

            System.out.println("Notas meio a meio");
            System.out.println(loanValue +" reais em notas de maior valor:");

            for(String note : moneyNotes) {
                System.out.println(" > " + note);
            }

            i = 2;

            while (loanValue2 != 1 && i < notes.length) {
                r = (int) (loanValue2 / notes[i]);
                moneyNotes.add(r+" x "+notes[i]+" reais");
                r *= notes[i];
                loanValue2 -= r;
                i++;
            }

            System.out.println("\n"+loanValue2 + " reais em notas de menor valor:");

            for(String note : moneyNotes) {
                System.out.println(" > " + note);
            }

        }

    }
}
