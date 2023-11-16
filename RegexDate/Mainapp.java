import java.util.Scanner;
public class Mainapp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ControlloDate data = new ControlloDate();
        System.out.println("inserire la data:");
        data.addData(sc.nextLine());
    }
}
