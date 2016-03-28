package MoteurDeJeu;

import java.util.Objects;

public class Malus {

    public String name;
    public int timeout;

    public Malus(String name, int timeout){
        this.name = name;
        this.timeout = timeout;
    }
}
