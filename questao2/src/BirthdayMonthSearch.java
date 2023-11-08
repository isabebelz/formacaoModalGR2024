import java.util.ArrayList;
import java.util.List;

/**
 * Classe responsável por buscar e filtrar aniversariantes do mês em uma lista de dados de consultores.
 */
public class BirthdayMonthSearch {

    /**
     * Busca e filtra aniversariantes do mês em uma lista de dados de consultores.
     *
     * @param consultantData Uma lista de strings contendo dados dos consultores.
     * @param currentMonth O número do mês atual para filtrar os aniversariantes.
     * @return Uma lista de strings contendo informações dos aniversariantes do mês.
     */
    public static List<String> dateBirth(List<String> consultantData, int currentMonth) {

        List<String> birthdaysMonth = new ArrayList<>();

        for (String data : consultantData) {
            if (data != null) {
                String[] dataSplit = data.split("\\|");

                if (dataSplit.length == 3) {
                    String name = dataSplit[0];
                    String email = dataSplit[1];
                    String dateBirth = dataSplit[2];

                    String[] birthSplit = dateBirth.split("/");
                    if (birthSplit.length == 3) {
                        String month = birthSplit[1];
                        if (Integer.parseInt(month) == currentMonth) {
                            birthdaysMonth.add(name + "|" + email + "|" + dateBirth);
                        }
                    } else {
                        System.out.println("Formato de data de nascimento inválido! A data de nascimento deve estar no formato dd/mm/yyyy");
                    }
                } else {
                    System.out.println("Formato de dados inválido! Os dados devem estar no formato nome|email|data de nascimento");
                }
            }
        }

        return birthdaysMonth;
    }
}


