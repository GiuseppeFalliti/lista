import java.util.Scanner;
public class Mainapp {

    public static void addData(Scanner sc, ControlloDate data,String dataString){
        data.addData(dataString);

    }
    public static void plus(Scanner sc, ControlloDate data,String dataString){
        System.out.println("inserisci i giorni da aggiungere");
        int giorni=sc.nextInt();
        data.plus(dataString, giorni);
        
    }  
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ControlloDate data = new ControlloDate();
        System.out.println("inserisci la data");
        String date=sc.nextLine();
        System.out.println();
        addData(sc, data,date);

        System.out.println();
        System.out.println("1.aggiungi giorni alla data");
        System.out.println("2.exit");
         String scelta=sc.nextLine();

         while (true) {
             switch (scelta) {
            case "1":
                plus(sc, data,date);
                break;
         }
        

       
    }
}
}
