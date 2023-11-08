import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Collaborator {

    private String name;
    private final Date hiringDate;
    private double salary;

    public Collaborator(String name, double salary, String hiringDate) throws ParseException {
        this.name = name;
        this.salary = salary;

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        this.hiringDate = dateFormat.parse(hiringDate);

    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getHiringDate() {
        return hiringDate;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}
