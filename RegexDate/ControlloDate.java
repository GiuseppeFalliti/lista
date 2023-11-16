import java.util.regex.Pattern;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
public class ControlloDate{
    int years,month,day;
    private LocalDate date;
    private final String regex = "^(0[1-9]|[1-9]|[12][0-9]|3[01])\\/(0[1-9]|[1-9]|1[0-2])\\/(\\d{4})$";
    private final int[] DAYS ={31,29,31,30,31,30,31,30,30,31,30,31};

    public void addData(String data) {
        if(!data.matches(regex)){
            System.out.println(false);
        }
        
        date = LocalDate.parse(data,DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        String[] splitDate = date.split("\\/");
        this.years= Integer.parseInt(splitDate[2]);
        this.month= Integer.parseInt(splitDate[1]);
        this.day= Integer.parseInt(splitDate[0]);

        if(){

        }

        System.out.println("data valida:" + date);
                
    }

    public static void main(String[] args) {
        ControlloDate app = new ControlloDate();
        app.addData("05/03/2023");
    
    }
}
