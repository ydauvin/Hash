package yann;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class Main {

    public static void main (String[] args) throws IOException {

        String line1 = readFile();
        //String line1 = "5 1 2 1";
        String[] line = line1.split(" ");
        int nbPizza = Integer.parseInt(line[0]);
        int nb2 = Integer.parseInt(line[1]);
        int nb3 = Integer.parseInt(line[2]);
        int nb4 = Integer.parseInt(line[3]);

        System.out.println("Pizza : " + nbPizza);
        System.out.println("Equipe de 2 : " + nb2);
        System.out.println("Equipe de 3 : " + nb3);
        System.out.println("Equipe de 4 : " + nb4);

        int[] livre = nourir(nbPizza,nb2,nb3,nb4);

        System.out.println("============================");

        System.out.println("Equipe de 2 livré : " + livre[0]);
        System.out.println("Equipe de 3 livré : " + livre[1]);
        System.out.println("Equipe de 4 livré : " + livre[2]);

        System.out.println("Je livre donc " + (2*livre[0]+3*livre[1]+4*livre[2]) +" pizza");
    }

    public static int[] nourir(int pizza, int team2, int team3, int team4){

        int livre2=0;
        int livre3=0;
        int livre4=0;

        // on cherche le plus de nombre de binome
        if (pizza % 2 == 0) {
            livre2 = pizza / 2;
        } else {
            livre2 = pizza % 2;
        }

        int betc = pizza - 2 * livre2;

        //avec ce qu'il reste on crée des equipes de 3
        if (betc % 3 == 0) {
            livre3 = betc / 3;
        } else {
            //si le nombre n'set pas divisible par 3
            livre2 --;
            betc= betc + 2;
            livre3 = betc % 3;
        }

        livre4 = (pizza - 2 * livre2 - 3 * livre3)/4;
        //on enleve des equipes de 2 pour mettre des 4
        int tmp = livre2/2;
        while (tmp>0){
            if (livre2 / 2 > 0) {
                livre4 ++;
                livre2 = livre2 - 2;
            }
            tmp--;
        }

        //TODO verification avec le nombre d'équipe presente

        int livre[] = {livre2,livre3,livre4};

        return livre;
    }


    public static String readFile() throws IOException {

        String line1 = null;
        int nb=0;
        BufferedReader in = new BufferedReader(new FileReader("input/a.in"));
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
