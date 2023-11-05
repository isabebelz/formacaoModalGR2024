import files.DataFileReader;

import java.time.LocalDate;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        LocalDate currentDate = LocalDate.now();
        int currentMonth = currentDate.getMonthValue();

        List<String> consultantData = DataFileReader.readFile();

        List<String> birthdays =  BirthdayMonthSearch.dateBirth(consultantData,currentMonth);

        System.out.println(consultantData);
        System.out.println();
        System.out.println(birthdays);

    }
}

