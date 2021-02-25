package model;

import java.lang.reflect.Array;
import java.util.List;

public class Voiture {
    List<Rue> listrue;

    public Voiture(List<Rue> listrue) {
        this.listrue = listrue;
    }

    public List<Rue> getListrue() {
        return listrue;
    }

    public void setListrue(List<Rue> listrue) {
        this.listrue = listrue;
    }
}
