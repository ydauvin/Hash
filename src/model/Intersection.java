package model;

import java.util.ArrayList;

public class Intersection {

    public int id;
    public ArrayList<Rue> in;
    public ArrayList<Rue> out;

    public Intersection(String id) {
        this.id= Integer.parseInt(id);
        this.in = new ArrayList<Rue>();
        this.out = new ArrayList<Rue>();
    }

    public Intersection(int id) {
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

    public void addRueIn(Rue rue){
        this.in.add(rue);
    }

    public void addRueOut(Rue rue){
        this.out.add(rue);
    }

    public void addRueOut(String name, int time) {
        Rue rue = new Rue(name,time);
        this.out.add(rue);
    }

    public void addRueIn(String name, int time) {
        Rue rue = new Rue(name,time);
        this.in.add(rue);
    }
}
