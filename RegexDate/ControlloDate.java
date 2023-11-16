import java.util.regex.Pattern;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
 /**
 * @author Giuseppe Falliti & Riccardo Ponzano.
 * @version 1.0
*/
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

        if(this.day<=DAYS[this.month-1] ){
            System.out.println("days existed");
        }

        else{
            System.out.println("days not existed");
        }

        if(this.years%4==0 && this.years%400==0 && this.years%100!=0){
            System.out.println("years bisestile");
        }
        else{
            System.out.println("years not bisestile");
        }
    
        System.out.println("data valida:" + date);
                
    }

    public static void main(String[] args) {
        ControlloDate app = new ControlloDate();
        app.addData("05/03/2023");
    
    }
}
