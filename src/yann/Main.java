package yann;

import java.io.*;
import java.util.ArrayList;

public class Main {
    public static String file = "c";
    private static ArrayList<String[]> ingredient = new ArrayList<>();
    static ArrayList<Pizza> pizzaUsed = new ArrayList<Pizza>();
    static ArrayList<Pizza> pizzas = new ArrayList<>();
    public static void main (String[] args) throws IOException {
        /*pizzas = ReadWrite.readPizza(file);
        String line1 = ReadWrite.readFile(file);
        ReadWrite.CreateFile(file);
        String[] line = line1.split(" ");
        //String line1 = "160451 9999999 9999999 9999999";
        int nbPizza = Integer.parseInt(line[0]);
        int nb2 = Integer.parseInt(line[1]);
        int nb3 = Integer.parseInt(line[2]);
        int nb4 = Integer.parseInt(line[3]);

        System.out.println("Pizza : " + nbPizza);
        System.out.println("Equipe de 2 : " + nb2);
        System.out.println("Equipe de 3 : " + nb3);
        System.out.println("Equipe de 4 : " + nb4);

        int[] livraison;
        if((2*nb2+3*nb3+4*nb4)<nbPizza){
            livraison = new int[]{nb2, nb3, nb4};
        }
        else if(nbPizza<=16000){
            livraison = nourir(nbPizza, 0, 0, 0);
        }
        else{
            if(nbPizza%2==0){
                int livre2=nbPizza/2;
                livraison=nourir(0,livre2,0,0);
            }
            else{
                livraison=nourir(0,(nbPizza-3)/2,1,0);
            }
        }

        int[] livre = verif(livraison,nb2,nb3,nb4);

        System.out.println("============================");

        System.out.println("Equipe de 2 livré : " + livre[0]);
        System.out.println("Equipe de 3 livré : " + livre[1]);
        System.out.println("Equipe de 4 livré : " + livre[2]);

        System.out.println("Je livre donc " + (2*livre[0]+3*livre[1]+4*livre[2]) +" pizza");

        System.out.println("");

        System.out.println("╔═════════════════════════════════╗");
        System.out.println("║ Pizzas are delivered to "+(livre[0]+livre[1]+livre[2])+" teams ║");
        System.out.println("╚═════════════════════════════════╝");

        ReadWrite.write(file,(livre[0] + livre[1] + livre[2]) +"\n");
        Distribution distrib = new Distribution();
        distrib.distribution(livre[0],livre[1],livre[2],pizzas);
*/
        Score a = new Score();
        a.Calcul(file);
        System.out.println(a.getScore());
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



}
