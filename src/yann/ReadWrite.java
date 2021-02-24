package yann;

import java.io.*;
import java.util.ArrayList;

public class ReadWrite {

    public static void CreateFile(String output) throws IOException {
        try {
            File file = new File("output/"+output+".out");
            file.delete();
        }catch (Exception e){

        }
        new File("output/"+output+".out").createNewFile();

    }

    public static void write(String output,String a) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter("output/"+output+".out", true));
        writer.append(a);
        writer.close();
    }

    public static ArrayList<Pizza> readPizza(String input) throws IOException {
        ArrayList<Pizza> pizzas = new ArrayList<Pizza>();
        int nb=0;
        BufferedReader in = new BufferedReader(new FileReader("input/"+input+".in"));
        String line;
        while ((line = in.readLine()) != null)
        {
            if(nb==0) {
                nb++;
            }
            else {
                String[] pizzaData = line.split(" ");
                String[] ingredientpizza = new String[pizzaData.length-1];
                for(int k=0;k<ingredientpizza.length;k++){
                    ingredientpizza[k]=pizzaData[k+1];
                }
                Pizza pizza = new Pizza(ingredientpizza);
                pizzas.add(pizza);
            }

        }
        in.close();
        return pizzas;
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
                break;
            }

        }
        in.close();
        return line1;
    }

}
