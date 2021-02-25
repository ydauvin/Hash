package test;

import java.io.IOException;
import java.util.ArrayList;

public class Distribution {

    private static String file=Main.file;
    public static void distribution(int nb2, int nb3, int nb4, ArrayList<Pizza> pizzas) throws IOException {
        // write(file, String.valueOf(nb2+nb3+nb4)+"\n");

        while(nb4>0){
            int[] pizza4= new int[4];
            pizza4[0]=-1;
            pizza4[1]=-1;
            pizza4[2]=-1;
            pizza4[3]=-1;

            nb4--;
            for(int i=0;i<4;i++) {
                Pizza pizza = choosePizza4(pizzas,pizza4);
                Main.pizzaUsed.add(pizza);
                pizza4[i]=pizzas.indexOf(pizza);;
            }

            ReadWrite.write(file,"4 ");
            for(int k=0;k<pizza4.length;k++) {
                ReadWrite.write(file,String.valueOf(pizza4[k]));
                ReadWrite.write(file," ");
            }
            //System.out.println("");
            ReadWrite.write(file,"\n");
        }

        while(nb3>0){
            int[] pizza3= new int[3];
            pizza3[0]=-1;
            pizza3[1]=-1;
            pizza3[2]=-1;

            nb3--;
            for(int i=0;i<3;i++) {
                Pizza pizza = choosePizza3(pizzas,pizza3);
                Main.pizzaUsed.add(pizza);
                pizza3[i]=pizzas.indexOf(pizza);;
            }

            ReadWrite.write(file,"3 ");
            for(int k=0;k<pizza3.length;k++) {
                ReadWrite.write(file,String.valueOf(pizza3[k]));
                ReadWrite.write(file," ");
            }
            //System.out.println("");
            ReadWrite.write(file,"\n");
        }

        while(nb2>0){
            int[] pizza2= new int[2];
            pizza2[0]=-1;
            pizza2[1]=-1;

            nb2--;
            for(int i=0;i<2;i++) {
                Pizza pizza = choosePizza2(pizzas,pizza2);
                Main.pizzaUsed.add(pizza);
                pizza2[i]=pizzas.indexOf(pizza);;
            }

            ReadWrite.write(file,"2 ");
            for(int k=0;k<pizza2.length;k++) {
                ReadWrite.write(file,String.valueOf(pizza2[k]));
                ReadWrite.write(file," ");
            }
            //System.out.println("");
            ReadWrite.write(file,"\n");
        }

    }

    public static Pizza choosePizza3(ArrayList<Pizza> pizzas, int[] pizza3) {
        Pizza pizza = new Pizza();
        if(pizza3[0]==-1){
            //System.out.print("1ere pizza : ");
            for(int i=0;i<pizzas.size();i++){
                int ingcourant = pizzas.get(i).nbIngredient;
                if(ingcourant>=pizza.nbIngredient && !Main.pizzaUsed.contains(pizzas.get(i))){
                    pizza=pizzas.get(i);
                }
            }
        }
        else if(pizza3[1]==-1) { //que 1ere pizza choisi
            //System.out.print("2eme pizza : ");
            Pizza pizzaCourant = pizzas.get(pizza3[0]);
            Pizza pizzaTmp;
            int nbIngredientdiff = pizzaCourant.nbIngredient;
            for (int i = 0; i < pizzas.size(); i++) {
                pizzaTmp=pizzas.get(i);
                if (!Main.pizzaUsed.contains(pizzaTmp)) {
                    int nbIngredient = pizzaCourant.nbIngredientDiff(pizzaTmp);
                    if (nbIngredient >= nbIngredientdiff) {
                        pizza = pizzaTmp;
                        nbIngredientdiff = nbIngredient;
                    }
                }
            }
        }
        else{
            //System.out.print("3eme pizza : ");
            Pizza pizzaTmp;
            Pizza pizzaCourant = new Pizza(pizzas.get(pizza3[0]),pizzas.get(pizza3[1]));
            int nbIngredientdiff = pizza.nbIngredient;
            for (int i = 0; i < pizzas.size(); i++) {
                pizzaTmp=pizzas.get(i);
                if (!Main.pizzaUsed.contains(pizzaTmp)) {
                    int nbIngredient = pizzaCourant.nbIngredientDiff(pizzaTmp);
                    if (nbIngredient >= nbIngredientdiff) {
                        pizza = pizzaTmp;
                        nbIngredientdiff = nbIngredient;
                    }
                }
            }

        }
        //System.out.println(pizzas.indexOf(pizza));
        return pizza;
    }

    public static Pizza choosePizza4(ArrayList<Pizza> pizzas, int[] pizza4) {
        Pizza pizza = new Pizza();
        if(pizza4[0]==-1){
            //System.out.print("1ere pizza : ");
            for(int i=0;i<pizzas.size();i++){
                int ingcourant = pizzas.get(i).nbIngredient;
                if(ingcourant>=pizza.nbIngredient && !Main.pizzaUsed.contains(pizzas.get(i))){
                    pizza=pizzas.get(i);
                }
            }
        }
        else if(pizza4[1]==-1) { //que 1ere pizza choisi
            //System.out.print("2eme pizza : ");
            Pizza pizzaCourant = pizzas.get(pizza4[0]);
            Pizza pizzaTmp;
            int nbIngredientdiff = pizzaCourant.nbIngredient;
            for (int i = 0; i < pizzas.size(); i++) {
                pizzaTmp=pizzas.get(i);
                if (!Main.pizzaUsed.contains(pizzaTmp)) {
                    int nbIngredient = pizzaCourant.nbIngredientDiff(pizzaTmp);
                    if (nbIngredient >= nbIngredientdiff) {
                        pizza = pizzaTmp;
                        nbIngredientdiff = nbIngredient;
                    }
                }
            }
        }
        else if(pizza4[2]==-1){
            //System.out.print("3eme pizza : ");
            Pizza pizzaTmp;
            Pizza pizzaCourant = new Pizza(pizzas.get(pizza4[0]),pizzas.get(pizza4[1]));
            int nbIngredientdiff = pizza.nbIngredient;
            for (int i = 0; i < pizzas.size(); i++) {
                pizzaTmp=pizzas.get(i);
                if (!Main.pizzaUsed.contains(pizzaTmp)) {
                    int nbIngredient = pizzaCourant.nbIngredientDiff(pizzaTmp);
                    if (nbIngredient >= nbIngredientdiff) {
                        pizza = pizzaTmp;
                        nbIngredientdiff = nbIngredient;
                    }
                }
            }
        }
        else {
            //System.out.print("4eme pizza : ");
            Pizza pizzaTmp;
            Pizza pizzaCourant = new Pizza(pizzas.get(pizza4[0]), pizzas.get(pizza4[1]), pizzas.get(pizza4[2]));
            int nbIngredientdiff = pizza.nbIngredient;
            for (int i = 0; i < pizzas.size(); i++) {
                pizzaTmp = pizzas.get(i);
                if (!Main.pizzaUsed.contains(pizzaTmp)) {
                    int nbIngredient = pizzaCourant.nbIngredientDiff(pizzaTmp);
                    if (nbIngredient >= nbIngredientdiff) {
                        pizza = pizzaTmp;
                        nbIngredientdiff = nbIngredient;
                    }
                }
            }
        }
        //System.out.println(pizzas.indexOf(pizza));
        return pizza;
    }

    public static Pizza choosePizza2(ArrayList<Pizza> pizzas, int[] pizza2) {
        Pizza pizza = new Pizza();
        if(pizza2[0]==-1){
            //System.out.print("1ere pizza : ");
            for(int i=0;i<pizzas.size();i++){
                int ingcourant = pizzas.get(i).nbIngredient;
                if(ingcourant>=pizza.nbIngredient && !Main.pizzaUsed.contains(pizzas.get(i))){
                    pizza=pizzas.get(i);
                }
            }
        }
        else { //1ere pizza choisi
            //System.out.print("2eme pizza : ");
            Pizza pizzaCourant = pizzas.get(pizza2[0]);
            Pizza pizzaTmp;
            int nbIngredientdiff = pizzaCourant.nbIngredient;
            for (int i = 0; i < pizzas.size(); i++) {
                pizzaTmp=pizzas.get(i);
                if (!Main.pizzaUsed.contains(pizzaTmp)) {
                    int nbIngredient = pizzaCourant.nbIngredientDiff(pizzaTmp);
                    if (nbIngredient >= nbIngredientdiff) {
                        pizza = pizzaTmp;
                        nbIngredientdiff = nbIngredient;
                    }
                }
            }
        }
        //System.out.println(pizzas.indexOf(pizza));
        return pizza;
    }
}
