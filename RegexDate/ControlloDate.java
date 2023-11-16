import java.util.regex.Pattern;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
public class ControlloDate{
   //private final  String regex="^([0-9]|[1-2][0-9]|[3][0-1])\\/([0-9]|[1][0-2])\\/([0-9]{4})$";
   //private final String regex = "^(0[1-9]|[1-9]|[1-2][0-9]|3[0-1])-(0[1-9]|[1-9]|1[0-2])-(\\d{4})$";
   private final String regex = "^(0[1-9]|[1-2][0-9]|3[0-1])-(0[1-9]|1[0-2])-(\\d{4})$";

 public boolean addData(String data) {
        try {
            LocalDate date = LocalDate.parse(data, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
            if (Pattern.matches(regex, data)) {
                return true;
            }
        } catch (DateTimeParseException e) {
            // Gestione dell'eccezione se la data non può essere parsata
        }
        return false;
    }

    public static void main(String[] args) {
        ControlloDate app = new ControlloDate();
        Boolean var = app.addData("21/11/2023");
        System.out.println(var);
    }
}