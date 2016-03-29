package MoteurDeJeu;

import MoteurDeJeu.Pieces.*;
import java.util.*;

public class PieceFactory {

    private ArrayList<String> piece_liste = new ArrayList<>();

    public PieceFactory(){
        piece_liste.add("Piece1");
        piece_liste.add("Piece2");
        piece_liste.add("Piece3");
        piece_liste.add("Piece4");
        piece_liste.add("Piece5");
        piece_liste.add("Piece6");
    }

    public Piece getRandomPiece(){
        Random random = new Random();
        String randomPiece = piece_liste.get( random.nextInt(piece_liste.size()) );

        switch (randomPiece){
            case "Piece1":
                return new Piece1();

            case "Piece2":
                return new Piece2();

            case "Piece3":
                return new Piece3();

            case "Piece4":
                return new Piece4();

            case "Piece5":
                return new Piece5();

            case "Piece6":
                return new Piece6();

            default:
                return new Piece1();
        }
    }
}
