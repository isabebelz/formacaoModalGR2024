import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Classe que representa um colaborador da empresa ModalGR.
 */
public class Collaborator {

    private String name;
    private final Date hiringDate;
    private double salary;

    /**
     * Construtor da classe Collaborator.
     *
     * @param name Nome do colaborador.
     * @param salary Salário do colaborador.
     * @param hiringDate Data de admissão no formato "dd/MM/yyyy".
     * @throws ParseException Exceção lançada em caso de erro ao analisar a data.
     */
    public Collaborator(String name, double salary, String hiringDate) throws ParseException {
        this.name = name;
        this.salary = salary;

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        this.hiringDate = dateFormat.parse(hiringDate);
    }

    /**
     * Obtém o nome do colaborador.
     *
     * @return Nome do colaborador.
     */
    public String getName() {
        return name;
    }

    /**
     * Define o nome do colaborador.
     *
     * @param name Novo nome do colaborador.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Obtém a data de admissão do colaborador.
     *
     * @return Data de admissão no formato Date.
     */
    public Date getHiringDate() {
        return hiringDate;
    }

    /**
     * Obtém o salário do colaborador.
     *
     * @return Salário do colaborador.
     */
    public double getSalary() {
        return salary;
    }

    /**
     * Define o salário do colaborador.
     *
     * @param salary Novo salário do colaborador.
     */
    public void setSalary(double salary) {
        this.salary = salary;
    }

    /**
     * Calcula o tempo de casa do colaborador com base na data de admissão.
     *
     * @param hiringDate Data de admissão do colaborador.
     * @return Número de anos de tempo de casa.
     */
    public static int calculateHomeTime(Date hiringDate) {
        Calendar currentDate = Calendar.getInstance();

        Calendar hiringDateCalendar = Calendar.getInstance();
        hiringDateCalendar.setTime(hiringDate);

        int yearsHome = currentDate.get(Calendar.YEAR) - hiringDateCalendar.get(Calendar.YEAR);

        if (currentDate.get(Calendar.MONTH) < hiringDateCalendar.get(Calendar.MONTH) ||
                (currentDate.get(Calendar.MONTH) == hiringDateCalendar.get(Calendar.MONTH) &&
                        currentDate.get(Calendar.DAY_OF_MONTH) < hiringDateCalendar.get(Calendar.DAY_OF_MONTH))) {
            yearsHome--;
        } else {
            yearsHome++;
        }

        return yearsHome;
    }
}
