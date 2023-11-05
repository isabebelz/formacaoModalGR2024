package files;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DataFileReader {
    public static List<String> readFile() {

        List<String> consultantData = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader("consultant_data\\consultant.txt"))) {

            String line = br.readLine();
            consultantData.add(line);

            while (line != null) {
                line = br.readLine();
                consultantData.add(line);
            }

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }

        return consultantData;
    }





}
