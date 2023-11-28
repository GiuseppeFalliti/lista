import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * @author Giuseppe Falliti & Riccardo Ponzano.
 * @version 1.0
 */

public class ControlloDate {
    private LocalDate date;
    private final String regex = "^(0[1-9]|[1-9]|[12][0-9]|3[01])\\/(0[1-9]|[1-9]|1[0-2])\\/(\\d{4})$";
    private final int[] DAYS = {31, 29, 31, 30, 31, 30, 31, 30, 30, 31, 30, 31 };
    String days;
    String years;

    public void addData(String data) {
        if (!data.matches(regex)) {
            System.out.println("Formato data non valido");
            return;
        }

        date = LocalDate.parse(data, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        int day = date.getDayOfMonth();
        int month = date.getMonthValue();
        int year = date.getYear();

        if (month < 1 || month > 12) {
            System.out.println("Mese non valido");
            return;
        }

        int maxDaysOfMonth = DAYS[month - 1];

        if (month == 2 && (year % 4 != 0 || (year % 100 == 0 && year % 400 != 0))) {
            maxDaysOfMonth = 28;
        }

        if (day <= maxDaysOfMonth) {
            System.out.println("Giorno valido");
            System.out.println("data valida: " + date.getDayOfMonth() + "/" + date.getMonth() + "/" + date.getYear());

        } else {
            System.out.println("Giorno non valido");
            return;
        }

        if (year % 4 == 0 && (year % 400 == 0 || year % 100 != 0)) {
            System.out.println("Anno bisestile");
        } else {
            System.out.println("Anno non bisestile");
        }


        /*
         * switch (month) {
            case 1:
                days = Integer.toString(day);
                years = Integer.toString(year);
                System.out.println("data valida: " + days + "/" + "gennaio" + "/" + years);

                break;
            case 2:
                days = Integer.toString(day);
                years = Integer.toString(year);
                System.out.println("data valida: " + days + "/" + "febbraio" + "/" + years);

                break;
            case 3:
                days = Integer.toString(day);
                years = Integer.toString(year);
                System.out.println("data valida: " + days + "/" + "marzo" + "/" + years);

                break;
            case 4:
                days = Integer.toString(day);
                years = Integer.toString(year);
                System.out.println("data valida: "+ days + "/" + "aprile" + "/" + years);

                break;
            case 5:
                days = Integer.toString(day);
                years = Integer.toString(year);
                System.out.println("data valida: " + days + "/" + "maggio" + "/" + years);

                break;
            case 6:
                days = Integer.toString(day);
                years = Integer.toString(year);
                System.out.println("data valida: " + days + "/" + "giugno" + "/" + years);

                break;
            case 7:
                days = Integer.toString(day);
                years = Integer.toString(year);
                System.out.println("data valida: "+ days + "/" + "luglio" + "/" + years);

                break;
            case 8:
                days = Integer.toString(day);
                years = Integer.toString(year);
                System.out.println("data valida:" + days + "/" + "agosto" + "/" + years);

                break;
            case 9:
                days = Integer.toString(day);
                years = Integer.toString(year);
                System.out.println("data valida: " + days + "/" + "settembre" + "/" + years);

                break;
            case 10:
                days = Integer.toString(day);
                years = Integer.toString(year);
                System.out.println("data valida;" + days + "/" + "ottobre" + "/" + years);

                break;
            case 11:
                days = Integer.toString(day);
                years = Integer.toString(year);
                System.out.println("data valida;" + days + "/" + "novembre" + "/" + years);

                break;
            case 12:
                days = Integer.toString(day);
                years = Integer.toString(year);
                System.out.println("data valida;" + days + "/" + "dicembre" + "/" + years);
                break;
        }
         */
        

    }
}
