import java.util.ArrayList;

public class InterList {
    public ArrayList<Intersection> intersections;

    public InterList() {
        this.intersections = new ArrayList<>();
    }

    public Intersection getbyid(int id){
        for (int i = 0; i < intersections.size(); i++) {
            Intersection inter = this.intersections.get(i);
            if (inter.getId() == id){
                return inter;
                break;
            }

        }
    }

    public ArrayList<Intersection> getIntersections() {
        return intersections;
    }

    public void setIntersections(ArrayList<Intersection> linter) {
        this.intersections = linter;
    }
}
