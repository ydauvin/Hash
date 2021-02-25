import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

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
                nbInter = Integer.parseInt(lineCourrant[1]);
            }
            else if(nb>nbInter+1){
                System.out.println("voiture");
            }
            else{
                int idout = Integer.parseInt(lineCourrant[0]);
                int idint = Integer.parseInt(lineCourrant[1]);
                String name = lineCourrant[2];
                int time = Integer.parseInt(lineCourrant[3]);
                if(!interlist.ishere(idout)){
                    Intersection intersection = new Intersection(idout);
                    intersection.addRueOut(name, time);
                    interlist.add(intersection);
                }
                else{
                    Intersection inter = interlist.getbyid(idout);
                    inter.addRueOut(name, time);
                }

                if(!interlist.ishere(idint)){
                    Intersection intersection = new Intersection(idint);
                    intersection.addRueIn(name, time);
                    interlist.add(intersection);
                }
                else{
                    Intersection inter = interlist.getbyid(idout);
                    inter.addRueIn(name, time);
                }

            }
            nb++;
        }
        in.close();
        Main.interlist = interlist;
    }

}
