package yann;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class Main {

    public static void main (String[] args) throws IOException {

        String line1 = readFile("b");
        //String line1 = "8 2 20 1";
        String[] line = line1.split(" ");
        int nbPizza = Integer.parseInt(line[0]);
        int nb2 = Integer.parseInt(line[1]);
        int nb3 = Integer.parseInt(line[2]);
        int nb4 = Integer.parseInt(line[3]);

        System.out.println("Pizza : " + nbPizza);
        System.out.println("Equipe de 2 : " + nb2);
        System.out.println("Equipe de 3 : " + nb3);
        System.out.println("Equipe de 4 : " + nb4);

        int[] livra = nourir(nbPizza,0,0,0);
        int[] livre = verif(livra,nb2,nb3,nb4);

        System.out.println("============================");

        System.out.println("Equipe de 2 livré : " + livre[0]);
        System.out.println("Equipe de 3 livré : " + livre[1]);
        System.out.println("Equipe de 4 livré : " + livre[2]);

        System.out.println("Je livre donc " + (2*livre[0]+3*livre[1]+4*livre[2]) +" pizza");
    }

    public static int[] nourir(int pizza, int livre2, int livre3, int livre4){
        int livre[] = {livre2, livre3, livre4};
        if(pizza==0){
            return livre;
        }
        else {
            if(pizza%2==0){
                return nourir(pizza - 2,livre2+1,livre3,livre4);
            }else {
                return nourir(pizza-3,livre2,livre3+1,livre4);
            }
        }
    }

    public static int[] verif(int[] livre,int team2,int team3,int team4){
        int livre2 = livre[0];
        int livre3 = livre[1];
        int livre4 = livre[2];

        while (livre2>=2){
            livre4++;
            livre2= livre2 -2 ;
        }

        while (livre4>team4){
            livre4--;
            livre2=livre2+2;
        }

        while (livre2>team2){
            livre2=livre2-3;
            livre3=livre3+2;
        }

        int[] livraison = {livre2, livre3, livre4};
     return livraison;
    }

    public static String readFile(String input) throws IOException {

        String line1 = null;
        int nb=0;
        BufferedReader in = new BufferedReader(new FileReader("input/"+input+".in"));
        String line;
        while ((line = in.readLine()) != null)
        {
            if(nb==0) {
                line1 = line;
                nb++;
            }

        }
        in.close();
        return line1;
    }
}
