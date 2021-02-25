import java.util.ArrayList;

public class Intersection {

    public int id;
    public ArrayList<Rue> in;
    public ArrayList<Rue> out;

    public void intersection(int id) {
        this.id=id;
        this.in = new ArrayList<Rue>();
        this.out = new ArrayList<Rue>();
    }

    public int getId() {
        return id;
    }

    public ArrayList<Rue> getIn() {
        return in;
    }

    public ArrayList<Rue> getOut() {
        return out;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setIn(ArrayList<Rue> in) {
        this.in = in;
    }

    public void setOut(ArrayList<Rue> out) {
        this.out = out;
    }
}
