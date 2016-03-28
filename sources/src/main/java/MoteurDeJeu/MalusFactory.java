package MoteurDeJeu;

import java.util.*;

public class MalusFactory {

    private HashMap<String, Integer> malus_liste = new HashMap<>();

    public MalusFactory(){
        malus_liste.put("Blind",5000);
        malus_liste.put("Blocked",5000);
    }

    public Malus getRandomMalus(){
        Random random = new Random();
        List<String> keys  = new ArrayList<String>(malus_liste.keySet());
        String randomName = keys.get( random.nextInt(keys.size()) );
        int timeout = malus_liste.get(randomName);

        return new Malus(randomName, timeout);
    }

    public Malus createMalus(String name){
        System.out.print(name);
        return new Malus(name, malus_liste.get(name));
    }
}
