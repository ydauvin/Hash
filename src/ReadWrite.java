import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadWrite {

    public static void readFile(String input) throws IOException {
        String line1 = null;
        int nb=0;
        BufferedReader in = new BufferedReader(new FileReader("input/"+input+".in"));
        String line;
        while ((line = in.readLine()) != null)
        {
            String[] lineCourrant = line.split(" ");
            if(nb==0){
            }
            else{
                if(!true){
                    Intersection intersection = new Intersection(lineCourrant[0]);
                    intersection.addRueOut(lineCourrant[2], Integer.parseInt(lineCourrant[3]));
                }
                else{
                    System.out.println("exite deja");
                }

                if(!true){
                    Intersection intersection = new Intersection(lineCourrant[0]);
                    intersection.addRueOut(lineCourrant[2], Integer.parseInt(lineCourrant[3]));
                }
                else{
                    System.out.println("exite deja");
                }

            }

        }
        in.close();
    }

}
