package MoteurGraphique.Panels;

/**
 * Created by asusss on 2.04.2016.
 */

import MoteurDeJeu.Plateau;

import java.awt.Color;
        import java.awt.Dimension;
        import java.awt.Font;
        import java.awt.Graphics;

        import javax.swing.JPanel;

public class GamePanel extends JPanel {


    public static final int COLOR_MIN = 35;
    public static final int COLOR_MAX = 255 - COLOR_MIN;
    private static final int BORDER_WIDTH = 5;

    public static final int TILE_SIZE = 24;
    public static final int SHADE_WIDTH = 4;

    private Plateau plateau;


    public GamePanel() {
        plateau= new Plateau();
    }


/*
    public void clear() {
		*/
/*
		 * Loop through every tile index and set it's value
		 * to null to clear the board.
		 *//*

        for(int i = 0; i < plateau.hauteur; i++) {
            for(int j = 0; j < plateau.largeur ; j++) {
                plateau.tab[i][j] =0;
            }
        }
    }
*/



    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        //This helps simplify the positioning of things.
        g.translate(BORDER_WIDTH, BORDER_WIDTH);

        setBackground(Color.BLACK);
		/*
		 * Draw the board differently depending on the current game state.
		 */






            g.setColor(Color.DARK_GRAY);
            for(int x = 0; x < plateau.largeur; x++) {
                for(int y = 0; y < plateau.hauteur; y++) {
                    g.drawLine(0, y * TILE_SIZE, plateau.largeur* TILE_SIZE, y * TILE_SIZE);
                    g.drawLine(x * TILE_SIZE, 0, x * TILE_SIZE,plateau.hauteur * TILE_SIZE);
                }
            }


		/*
		 * Draw the outline.
		 */
        g.setColor(Color.WHITE);
        g.drawRect(0, 0, TILE_SIZE * plateau.largeur, TILE_SIZE * plateau.hauteur);
    }

    /**
     * Draws a tile onto the board.
     * @param type The type of tile to draw.
     * @param x The column.
     * @param y The row.
     * @param g The graphics object.
     */
  //  private void drawTile(TileType type, int x, int y, Graphics g) {
 //       drawTile(type.getBaseColor(), type.getLightColor(), type.getDarkColor(), x, y, g);
 //   }

    /**
     * Draws a tile onto the board.
     * @param base The base color of tile.
     * @param light The light color of the tile.
     * @param dark The dark color of the tile.
     * @param x The column.
     * @param y The row.
     * @param g The graphics object.
     */
    private void drawTile(Color base, Color light, Color dark, int x, int y, Graphics g) {

		/*
		 * Fill the entire tile with the base color.
		 */
        g.setColor(base);
        g.fillRect(x, y, TILE_SIZE, TILE_SIZE);

		/*
		 * Fill the bottom and right edges of the tile with the dark shading color.
		 */
        g.setColor(dark);
        g.fillRect(x, y + TILE_SIZE - SHADE_WIDTH, TILE_SIZE, SHADE_WIDTH);
        g.fillRect(x + TILE_SIZE - SHADE_WIDTH, y, SHADE_WIDTH, TILE_SIZE);

		/*
		 * Fill the top and left edges with the light shading. We draw a single line
		 * for each row or column rather than a rectangle so that we can draw a nice
		 * looking diagonal where the light and dark shading meet.
		 */
        g.setColor(light);
        for(int i = 0; i < SHADE_WIDTH; i++) {
            g.drawLine(x, y + i, x + TILE_SIZE - i - 1, y + i);
            g.drawLine(x + i, y, x + i, y + TILE_SIZE - i - 1);
        }
    }

}