package files;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class BirthdayMonthFileCreator {

    public static void birthdayMonthFile(List<String> birthdays) {

        try (BufferedWriter bw = new BufferedWriter(new FileWriter("consultant_data\\birthdays.txt"))){

            bw.write("BIRTHDAYS OF THE MONTH");

            for(String line: birthdays) {
                bw.newLine();
                bw.write(line);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
