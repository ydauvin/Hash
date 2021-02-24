package yann;

import java.io.IOException;
import java.util.ArrayList;

public class Pizza {
    public int nbIngredient;
    public String[] ingredient;

    Pizza(String[] ingredient){
        this.ingredient=ingredient;
        this.nbIngredient=ingredient.length;
    }

    public Pizza() {
        this.ingredient=null;
        this.nbIngredient=-1;
    }

    public Pizza(Pizza pizza, Pizza pizza1) {
        String[] ingredient = new String[pizza.nbIngredient+ pizza1.nbIngredient];
        for(int i = 0; i<pizza.nbIngredient; i++){
            ingredient[i]=pizza.ingredient[i];
        }
        for(int i = 0; i<pizza1.nbIngredient; i++){
            for(int j=0;j<pizza.nbIngredient;j++){
                if(!ingredient[j].equals(pizza1.ingredient[i])){
                    ingredient[i+ pizza.nbIngredient]=pizza1.ingredient[i];
                }
            }
        }
        this.ingredient=ingredient;
        this.nbIngredient= pizza.nbIngredient+ pizza1.nbIngredient;
    }

    public Pizza(Pizza pizza, Pizza pizza1, Pizza pizza2) {
        Pizza tmp = new Pizza(pizza1,pizza2);

        String[] ingredient = new String[pizza.nbIngredient+ tmp.nbIngredient];
        for(int i = 0; i<pizza.nbIngredient; i++){
            ingredient[i]=pizza.ingredient[i];
        }
        for(int i = 0; i<tmp.nbIngredient; i++){
            for(int j=0;j<pizza.nbIngredient;j++){
                if(!ingredient[j].equals(tmp.ingredient[i])){
                    ingredient[i+ pizza.nbIngredient]=tmp.ingredient[i];
                }
            }
        }
        this.ingredient=ingredient;
        this.nbIngredient= pizza.nbIngredient+ tmp.nbIngredient;
    }

    public int getNbIngredient() {
        return nbIngredient;
    }

    public int nbIngredientDiff(Pizza p){
        ArrayList<String> ingredient = new ArrayList<>();
        for(int i=0;i< this.nbIngredient;i++){
            ingredient.add(this.ingredient[i]);
        }
        for(int i=0;i< p.nbIngredient;i++){
            if (!ingredient.contains(p.ingredient[i])) {
                ingredient.add(p.ingredient[i]);

            }
        }
        return ingredient.size();
    }
}
