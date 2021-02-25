package model;

import java.io.IOException;
import java.util.ArrayList;

public class Main {

    public static InterList interlist = new InterList();

    public static void main (String[] args) throws IOException {
        ReadWrite.readFile("a");
        ArrayList<Intersection> inter = interlist.getIntersections();

        System.out.println("Rue entrant");
        for(int i=0;i<inter.size();i++){
            Intersection intersection = inter.get(i);
            System.out.println(intersection.id);
            for (int j=0;j<intersection.in.size();j++){
                System.out.println(intersection.in.get(j).name);
            }
            System.out.println("=======================");
        }

        System.out.println("");
        System.out.println("|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|");
        System.out.println("");

        System.out.println("Rue sortant");
        for(int i=0;i<inter.size();i++){
            Intersection intersection = inter.get(i);
            System.out.println(intersection.id);
            for (int j=0;j<intersection.out.size();j++){
                System.out.println(intersection.out.get(j).name);
            }
            System.out.println("=======================");
        }
    }
}
