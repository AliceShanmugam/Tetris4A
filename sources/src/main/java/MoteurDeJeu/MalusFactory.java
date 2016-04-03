package MoteurDeJeu;

import java.util.*;

public class MalusFactory {

    private HashMap<String, Integer> malus_liste = new HashMap<>();

    public MalusFactory(){
        malus_liste.put("Blind",20);
        malus_liste.put("Reverse",60);
    }

    public Malus getRandomMalus(){
        Random random = new Random();
        List<String> keys  = new ArrayList<>(malus_liste.keySet());
        String randomName = keys.get( random.nextInt(keys.size()) );
        int timeout = malus_liste.get(randomName);

        return new Malus(randomName, timeout);
    }

    public Malus createMalus(String name){
        return new Malus(name, malus_liste.get(name));
    }
}
