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
                Piece piece = new Piece1();
                piece.setRandomColor();
                return piece;

            case "Piece2":
                piece = new Piece2();
                piece.setRandomColor();
                return piece;

            case "Piece3":
                piece = new Piece3();
                piece.setRandomColor();
                return piece;

            case "Piece4":
                piece = new Piece4();
                piece.setRandomColor();
                return piece;

            case "Piece5":
                piece = new Piece5();
                piece.setRandomColor();
                return piece;

            case "Piece6":
                piece = new Piece6();
                piece.setRandomColor();
                return piece;

            default:
                piece = new Piece1();
                piece.setRandomColor();
                return piece;
        }
    }
}
