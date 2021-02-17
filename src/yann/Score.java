package yann;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Score {

    public int score =0;

    public void Calcul() throws IOException {
        /*tableau des ingredients des pizza*/
        ArrayList<ArrayList<String>> pizza = readPizzaFile("a");
        for(int i=0;i<pizza.size();i++){
            if(pizza.get(i)!=null) {
                System.out.println(pizza.get(i));
            }
        }
        System.out.println("===========");

        /*tableau pizza donne par equie*/
        ArrayList<ArrayList<String>> pizzaGive = readDeliveryFile("a");
        //System.out.println(pizzaGive);
        for (int i=0;i<pizzaGive.size();i++){
            if(pizzaGive!=null){
//                System.out.println(i+" |  "+pizzaGive.get(i));
                ArrayList<String> pizzaTeam = pizzaGive.get(i);
                ArrayList<String> listIngredient = new ArrayList<>();
                if (pizzaTeam != null) {
                    for(int j=0;j<pizzaTeam.size();j++){
                        ArrayList<String> list = pizza.get(Integer.parseInt(pizzaTeam.get(j)));
                        for(int k=0;k<list.size();k++){
                            System.out.print(list.get(k)+" ");
                            if(!listIngredient.contains(list.get(k))){
                                listIngredient.add(list.get(k));
                            }
                        }
                        System.out.print(" | ");
                        //listIngredient.add()
                        //System.out.println("Pizza n°"+ pizzaTeam.get(j) +" : "+ pizza.get(Integer.parseInt(pizzaTeam.get(j))));
                    }
                    System.out.println("");
                    score=score+(listIngredient.size()*listIngredient.size());
                }
            }
        }
    }

    public ArrayList<ArrayList<String>> readPizzaFile(String input) throws IOException {

        int nb=0;
        ArrayList<ArrayList<String>> pizza = new ArrayList<>();
        ArrayList<String> ingredient = null;
        BufferedReader in = new BufferedReader(new FileReader("input/"+input+".in"));
        String line;
        while ((line = in.readLine()) != null){
            if(nb!=0){
                String[] a = line.split(" ");
                ingredient = new ArrayList<>();
                for (int i = 0; i < Integer.parseInt(a[0]); i++) {
                    if(a[i+1]!=null) {
                        ingredient.add(a[i + 1]);
                    }
                }
            }
            if(ingredient!=null) {
                pizza.add(ingredient);
            }
            nb++;
        }
        in.close();
        return pizza;
    }

    public ArrayList<ArrayList<String>> readDeliveryFile(String input) throws IOException {

        int nb=0;
        ArrayList<ArrayList<String>> pizza = new ArrayList<>();
        ArrayList<String> ingredient = null;
        BufferedReader in = new BufferedReader(new FileReader("output/"+input+".out"));
        String line;
        while ((line = in.readLine()) != null){
            if(nb!=0){
                String[] a = line.split(" ");
                ingredient = new ArrayList<>();
                for (int i = 0; i < Integer.parseInt(a[0]); i++) {
                    if(a[i+1]!=null) {
                        ingredient.add(a[i + 1]);
                    }
                }
            }
            if(ingredient!=null) {
                pizza.add(ingredient);
            }
            nb++;
        }
        in.close();
        return pizza;
    }

    public int getScore() {
        return this.score;
    }
}
