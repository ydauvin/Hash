package yann;

import java.io.*;
import java.util.ArrayList;


public class Main {

    private static String file = "a";
    public static void main (String[] args) throws IOException {

        String line1 = readFile(file);
        CreateFile(file);
        //String line1 = "160451 9999999 9999999 9999999";
        String[] line = line1.split(" ");
        int nbPizza = Integer.parseInt(line[0]);
        int nb2 = Integer.parseInt(line[1]);
        int nb3 = Integer.parseInt(line[2]);
        int nb4 = Integer.parseInt(line[3]);
        int nbligne = Integer.parseInt(line[4]);

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

        System.out.println("|-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-|");

        System.out.println("╔═════════════════════════════════╗");
        System.out.println("║ Pizzas are delivered to "+(livre[0]+livre[1]+livre[2])+" teams ║");
        System.out.println("╚═════════════════════════════════╝");

        distribution(livre[0],livre[1],livre[2],nbligne);



        Score a = new Score();
        a.Calcul();
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

    public static String readFile(String input) throws IOException {

        String line1 = null;
        int nbLine = 0;
        int nb=0;
        BufferedReader in = new BufferedReader(new FileReader("input/"+input+".in"));
        String line;
        while ((line = in.readLine()) != null)
        {
            nbLine++;
            if(nb==0) {
                line1 = line;
                nb++;
            }

        }
        in.close();
        return line1+" "+(nbLine-1);
    }


    public static void distribution(int nb2, int nb3, int nb4,int nbLigne) throws IOException {
        write(file, String.valueOf(nb2+nb3+nb4)+"\n");
        ArrayList<Integer> pizzaUsed = new ArrayList<>();
        String service;
        while(nb2>0){
            service = "2 ";
            System.out.print("2 ");
            nb2--;
            for(int i=0;i<2;i++) {
                boolean add = false;
                int pizza;
                while (add==false){
                    pizza = (int) (Math.random() * nbLigne);
                    if(!pizzaUsed.contains(pizza)) {
                        add = true;
                        pizzaUsed.add(pizza);
                        System.out.print(pizza+" ");
                        service=service+pizza+" ";
                    }

                }
            }

            System.out.println("");
            service=service+"\n";
            write(file,service);
        }
        while(nb3>0){
            System.out.print("3 ");
            service = "3 ";
            nb3--;
            for(int i=0;i<3;i++) {
                boolean add = false;
                int pizza;
                while (add==false){
                    pizza = (int) (Math.random() * nbLigne);
                    if(!pizzaUsed.contains(pizza)) {
                        add = true;
                        pizzaUsed.add(pizza);
                        System.out.print(pizza+" ");
                        service=service+pizza+" ";
                    }

                }
            }
            System.out.println("");
            service=service+"\n";
            write(file,service);
        }
        while(nb4>0){
            System.out.print("4 ");
            service = "4 ";
            nb4--;
            for(int i=0;i<4;i++) {
                boolean add = false;
                int pizza;
                while (add==false){
                    pizza = (int) (Math.random() * nbLigne);
                    if(!pizzaUsed.contains(pizza)) {
                        add = true;
                        pizzaUsed.add(pizza);
                        System.out.print(pizza+" ");
                        service=service+pizza+" ";
                    }

                }
            }

            System.out.println("");
            service=service+"\n";
            write(file,service);
        }
        System.out.println(pizzaUsed);

    }

    public static void CreateFile(String output) {
        try {
            File file = new File("output/" + output + ".out");
            file.delete();
        }catch (Exception e){

        }
        new File("output/"+output+".out");
    }

    public static void write(String output, String a) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter("output/"+output+".out", true));
        writer.append(a);
        writer.close();
    }
}
