import java.time.LocalDate;
import java.util.List;

/**
 * Classe principal responsável por realizar tarefas relacionadas ao aniversário de consultores.
 */
public class Main {
    public static void main(String[] args) {

        LocalDate currentDate = LocalDate.now();
        int currentDay = currentDate.getDayOfMonth();

        if(currentDay == 1) {
            int currentMonth = currentDate.getMonthValue();

            List<String> consultantData = DataFileReader.readFile();

            List<String> birthdays =  BirthdayMonthSearch.dateBirth(consultantData, currentMonth);

            BirthdayMonthFileCreator.birthdayMonthFile(birthdays);
        }
    }
}


