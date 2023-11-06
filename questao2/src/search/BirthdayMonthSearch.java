package search;

import java.util.ArrayList;
import java.util.List;

public class BirthdayMonthSearch {

    public static List<String> dateBirth(List<String> consultantData, int currentMonth) {

        List<String> birthdaysMonth = new ArrayList<>();

        for(String data : consultantData) {
            if(data != null) {
                String[] dataSplit = data.split("\\|");


                if(dataSplit.length == 3) {
                    String name = dataSplit[0];
                    String email = dataSplit[1];
                    String dateBirth = dataSplit[2];

                    String[] birthSplit = dateBirth.split("/");
                    if(birthSplit.length == 3) {
                        String month = birthSplit[1];
                        if(Integer.parseInt(month) == currentMonth) {
                            birthdaysMonth.add(name+"|"+email+"|"+dateBirth);
                        }
                    } else {
                        System.out.println("Invalid date of birth format! The date of birth must be in the format dd/mm/yyyy");
                    }
                } else {
                    System.out.println("Invalid data format! The data must be in the format name|email|birthday date");
                }

            }
        }

        return birthdaysMonth;
    }
}

