package model;

import java.io.*;

public class ReadWrite {

    public static void readFile(String input) throws IOException {
        InterList interlist = Main.interlist;
        String line1 = null;
        int nb=0;
        int nbInter = 0;
        BufferedReader in = new BufferedReader(new FileReader("input/"+input+".txt"));
        String line;
        while ((line = in.readLine()) != null)
        {
            String[] lineCourrant = line.split(" ");
            if(nb==0){
                nbInter = Integer.parseInt(lineCourrant[2]);
            }
            else if(nb>nbInter){
            }
            else{
                int idout = Integer.parseInt(lineCourrant[0]);
                int idint = Integer.parseInt(lineCourrant[1]);
                String name = lineCourrant[2];
                int time = Integer.parseInt(lineCourrant[3]);

                if(idout==629){
                    System.out.println(629);
                }
                if(!interlist.ishere(idout)){
                    Intersection intersection = new Intersection(idout);
                    intersection.addRueOut(name, time);
                    interlist.add(intersection);
                }
                else{
                    interlist.getbyid(idout).addRueOut(name, time);
                }

                if(idint==629){
                    System.out.println(629);
                }
                if(!interlist.ishere(idint)){
                    Intersection intersection = new Intersection(idint);
                    intersection.addRueIn(name, time);
                    interlist.add(intersection);
                }
                else{
                    interlist.getbyid(idint).addRueIn(name, time);
                }

            }
            nb++;
        }
        in.close();
    }

    public static void CreateFile(String output) throws IOException {
        try {
            File file = new File("output/"+output+".txt");
            file.delete();
        }catch (Exception e){

        }
        new File("output/"+output+".txt").createNewFile();
    }

    public static void write(String output,String a) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter("output/"+output+".txt", true));
        writer.append(a);
        writer.close();
    }



}
