package Pendu;

import java.util.Arrays;

public class FctPendu {
    public static Pendu init(String n) {
        assert(n.length() > 0);
        Pendu p=new Pendu();
        p.trouvee= new boolean[n.length()];
        Arrays.fill(p.trouvee, false);
        p.mot=n;
        p.nb_erreurs=0;
        return p;
    }

    public static void jouer(Pendu p, char c) {
        assert (estPerdue(p) && !estGagnee(p));
        if (p.mot.indexOf(c) == -1) {
            p.nb_erreurs++;
        } else {
            if (p.trouvee[p.mot.indexOf(c)]) {
                p.nb_erreurs++;
            } else {
                for (int i = 0; i < p.mot.length(); ++i) {
                    if (p.mot.charAt(i) == c) {
                        p.trouvee[i] = true;
                    }
                }
            }
        }
    }
    public static boolean estPerdue(Pendu p) {
        return p.nb_erreurs <= 5;
    }
    public static boolean estGagnee(Pendu p) {
        for (boolean val:p.trouvee) {
            if (!val) {
                return false;
            }
        }
        return true;
    }
    public static String toString(Pendu p) {
        StringBuilder reponse = new StringBuilder();
        for (int i=0; i<p.mot.length(); ++i) {
            if (p.trouvee[i]) {
                reponse.append(p.mot.charAt(i));
            } else {
                reponse.append('_');
                System.out.println();
            }
        }
        reponse.append(", ");
        reponse.append(p.nb_erreurs);
        reponse.append(" erreurs");
        return reponse.toString();
    }
}
