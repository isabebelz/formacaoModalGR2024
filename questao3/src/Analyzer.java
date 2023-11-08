import java.util.Calendar;
import java.util.Date;

public class Analyzer {

    public static int calculateHomeTime(Date hiringDate) {
        Calendar currentDate = Calendar.getInstance();

        Calendar hiringDateCalendar = Calendar.getInstance();
        hiringDateCalendar.setTime(hiringDate);


        int yearsHome = currentDate.get(Calendar.YEAR) - hiringDateCalendar.get(Calendar.YEAR);

        if(currentDate.get(Calendar.MONTH) < hiringDateCalendar.get(Calendar.MONTH) || currentDate.get(Calendar.MONTH) == hiringDateCalendar.get(Calendar.MONTH) && currentDate.get(Calendar.DAY_OF_MONTH) < hiringDateCalendar.get(Calendar.DAY_OF_MONTH)) {
            yearsHome--;
        } else {
            yearsHome++;
        }

        return yearsHome;
    }


    public static boolean canSimulateLoan(int yearsHome, double salary, double loanValue) {

        if(yearsHome > 5 && loanValue <= (salary * 2) && loanValue % 2 == 0) {
            return true;
        } else {
            System.out.println("Agradecemos seu interesse, mas você não atende os requisitos mínimos do programa.");
            return false;
        }

    }
}



