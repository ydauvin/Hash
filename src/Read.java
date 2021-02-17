import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;

public class Read {

    /**
     * Lit un fichier et l'affiche (ne renvoi rien pour le moment)
     * @param filePath
     * @throws IOException
     */
    public void readfile (String filePath) throws IOException {
            BufferedReader file = new BufferedReader(new FileReader(filePath));
            String line;
            while ((line = file.readLine()) != null)
            {
                System.out.println (line);
            }
            file.close();

    }
}
