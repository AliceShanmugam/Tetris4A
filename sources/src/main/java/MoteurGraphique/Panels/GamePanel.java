package MoteurGraphique.Panels;


import MoteurDeJeu.Plateau;

import java.awt.*;

import javax.swing.JPanel;

public class GamePanel extends JPanel {


    public static final int COLOR_MIN = 35;
    public static final int COLOR_MAX = 255 - COLOR_MIN;
    private static final int BORDER_WIDTH = 5;

    public static final int TILE_SIZE = 24;
    public static final int SHADE_WIDTH = 4;

    private Plateau plateau;
    private final static Color[] colors = {Color.BLACK, Color.ORANGE, Color.GREEN, Color.CYAN, Color.MAGENTA, Color.BLUE, Color.YELLOW, Color.RED};

    private Graphics2D g2d;

    public GamePanel(Plateau p) {
        plateau= p;
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g2d = (Graphics2D)g;
        //This helps simplify the positioning of things.
        g.translate(BORDER_WIDTH, BORDER_WIDTH);

        setBackground(Color.BLACK);
        drawTile(plateau);
		/*
		 * Draw the board differently depending on the current game state.
		 */

            g.setColor(Color.DARK_GRAY);
            for(int x = 0; x < Plateau.largeur; x++) {
                for(int y = 0; y < Plateau.hauteur; y++) {
                    g.drawLine(0, y * TILE_SIZE, Plateau.largeur * TILE_SIZE, y * TILE_SIZE);
                    g.drawLine(x * TILE_SIZE, 0, x * TILE_SIZE, Plateau.hauteur * TILE_SIZE);
                }
            }

            // Draw the outline.
        g.setColor(Color.WHITE);
        g.drawRect(0, 0, TILE_SIZE * Plateau.largeur, TILE_SIZE * Plateau.hauteur);

    }

    private void drawTile(Plateau plateau) {

        for (int j = 0; j < Plateau.largeur; j++) {
            for (int i = 0; i < Plateau.hauteur; i++) {
                int a = plateau.tab[j][i];
                g2d.setPaint(colors[Math.abs(a)]);
                g2d.fillRect(j* TILE_SIZE,(Plateau.hauteur -1)*TILE_SIZE- i* TILE_SIZE ,  TILE_SIZE, TILE_SIZE);
            }
        }
    }

}