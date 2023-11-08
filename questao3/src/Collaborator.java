import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
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
}
