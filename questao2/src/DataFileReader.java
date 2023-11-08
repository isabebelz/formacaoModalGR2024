import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe responsável por ler dados de consultores a partir de um arquivo de texto.
 */
public class DataFileReader {

    /**
     * Lê dados de consultores a partir de um arquivo de texto.
     *
     * @return Uma lista de strings contendo os dados dos consultores lidos do arquivo.
     */
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
            System.out.println("Erro: " + e.getMessage());
        }

        return consultantData;
    }
}
