import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.util.Locale;

/**
 * @author Giuseppe Falliti & Riccardo Ponzano.
 * @version 1.0
 *          stamparla in formato dd -- mm - aaaa
 *          stampare il giorno della settimana (in italiano)
 *          stampare il nome del mese (in italiano)
 *          stampare la data successiva (giorno dopo)
 *          dato un certo numero di giorni - stampare la data da quella letta
 *          più il periodo letto
 * 
 */

public class ControlloDate {
    private LocalDate date;
    private final String regex = "^(0[1-9]|[1-9]|[12][0-9]|3[01])\\--(0[1-9]|[1-9]|1[0-2])\\-(\\d{4})$";
    private final int[] DAYS = { 31, 29, 31, 30, 31, 30, 31, 30, 30, 31, 30, 31 };

    public void addData(String data) {
        if (!data.matches(regex)) {
            System.out.println("Formato data non valido");
            return;
        }
        try {
            /**
             * creazione data e formattata.
             */
            date = LocalDate.parse(data, DateTimeFormatter.ofPattern("dd--MM-yyyy"));
            int day = date.getDayOfMonth();
            int month = date.getMonthValue();
            int year = date.getYear();

            /**
             * controllo mese
             *
             */
            if (month < 1 || month > 12) {
                System.out.println("Mese non valido");
                return;
            }

            int maxDaysOfMonth = DAYS[month - 1];

           if (month == 2 && (year % 4 != 0 || (year % 100 == 0 && year % 400 != 0))) {
                maxDaysOfMonth = 28;
            }
            /**
             * controllo giorno.
             */
            if (day <= maxDaysOfMonth) {
                System.out.println("Giorno valido");

            } else {
                System.out.println("Giorno non valido");
                return;
            }
            /**
             * controllo seè bisestile.
             */
            if (year % 4 == 0 && (year % 400 == 0 || year % 100 != 0)) {
                System.out.println("Anno bisestile");
            } else {
                System.out.println("Anno non bisestile");
            }


            /**
             * stampa normale.
             */
             System.out.println("data:  " + day + "--" + month + "-" + year);
            /**
             * stampa data valida italiano.
             */
            System.out.println("data valida: " + date.getDayOfWeek().getDisplayName(TextStyle.FULL, Locale.ITALIAN)
                    + "--" + date.getMonth().getDisplayName(TextStyle.FULL, Locale.ITALIAN)
                    + "-" + year);
            /**
             * stampa data successiva.
             */
            day = day + 1;
            System.out.println("data successiva->" + day + "--" + month + "-" + year);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
