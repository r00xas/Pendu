import Pendu.Pendu;
import Pendu.FctPendu;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc;
        sc = new Scanner(System.in);
        String m=sc.next();
        Pendu p=FctPendu.init(m);
        while (FctPendu.estPerdue(p) && !FctPendu.estGagnee(p)) {
            System.out.println(FctPendu.toString(p));
            System.out.print("Entrer une lettre : ");
            m=sc.next();
            char c=m.charAt(0);
            FctPendu.jouer(p,c);
        }
        System.out.println(FctPendu.toString(p));
        if (FctPendu.estGagnee(p))
            System.out.println("Bravo");
        else
            System.out.println("Arg...");
    }
}