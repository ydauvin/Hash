import java.io.IOException;

public class Main {


    public static void main(String args[]){

        System.out.println("Hello world");

        String file1 = "./Input/a_example.in";
        Read r = new Read();

        try {
            r.readfile(file1);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}