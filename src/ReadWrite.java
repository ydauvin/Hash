import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadWrite {

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
