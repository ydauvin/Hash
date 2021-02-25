package model;

import java.util.ArrayList;

public class InterList {
    public ArrayList<Intersection> intersections;

    public InterList() {
        this.intersections = new ArrayList<>();
    }

    public Intersection getbyid(int id){
        Intersection inter = null;
        for (int i = 0; i < intersections.size(); i++) {
            inter = this.intersections.get(i);
            if (inter.getId() == id){
                break;
            }

        }
        return inter;
    }

    public boolean ishere(int id){
        boolean exist = false;
        Intersection inter = null;
        for (int i = 0; i < intersections.size(); i++) {
            inter = this.intersections.get(i);
            if (inter.getId() == id){
                exist = true;
                break;
            }
        }
        return exist;
    }

    public void add(Intersection inter){
        this.intersections.add(inter);
    }

    public ArrayList<Intersection> getIntersections() {
        return intersections;
    }

    public void setIntersections(ArrayList<Intersection> linter) {
        this.intersections = linter;
    }
}
