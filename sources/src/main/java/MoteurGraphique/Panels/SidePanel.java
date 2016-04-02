package MoteurGraphique.Panels;

/**
 * Created by asusss on 2.04.2016.
 */
import MoteurDeJeu.Jeu;
import MoteurDeJeu.Pieces.*;

import java.awt.*;

import javax.swing.JPanel;

/**
 * The {@code SidePanel} class is responsible for displaying various information
 * on the game such as the next piece, the score and current level, and controls.
 * @author Brendan Jones
 *
 */
public class SidePanel extends JPanel {


    private static final int TILE_SIZE = GamePanel.TILE_SIZE >> 1;
    private static final int SHADE_WIDTH = GamePanel.SHADE_WIDTH >> 1;
    private static final int TILE_COUNT = 5;

    private static final int SQUARE_CENTER_X = 130;
    private static final int SQUARE_CENTER_Y = 65;
    private static final int SQUARE_SIZE = (TILE_SIZE * TILE_COUNT >> 1);
    private static final int SMALL_INSET = 20;

    private static final int LARGE_INSET = 40;
    private static final int STATS_INSET = 175;
    private static final int CONTROLS_INSET = 300;
    private static final int TEXT_STRIDE = 25;

    private static final Font SMALL_FONT = new Font("Tahoma", Font.BOLD, 11);

    private static final Font LARGE_FONT = new Font("Tahoma", Font.BOLD, 13);
    private static final Color DRAW_COLOR = new Color(128, 192, 128);

    private final static Color[] colors = {Color.BLACK, Color.ORANGE, Color.GREEN, Color.CYAN, Color.MAGENTA, Color.BLUE, Color.YELLOW, Color.RED};
    private Graphics2D g2d;

    private Jeu tetris;

    public SidePanel() {

        setPreferredSize(new Dimension(100, 100));
        setBackground(Color.BLACK);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g2d = (Graphics2D)g;

        //Set the color for drawing.
        g2d.setColor(DRAW_COLOR);

        drawStat();

        //get next piece
        Piece p= new Piece4();
        // utilise ligne suivant quand  getNextPiece fonction a implemente
       // Piece p = tetris.getNextPiece();
        if(p!= null) {

            int largeur= p.largeur;

			// Calculate the top left corner (origin) of the piece.
            int startX = (SQUARE_CENTER_X - (largeur * TILE_SIZE / 2));
            int startY = (SQUARE_CENTER_Y - (largeur * TILE_SIZE / 2));

			// Loop through the piece and draw it's tiles onto the preview.
            for(int row = 0; row < largeur; row++) {
                for(int col = 0; col < largeur; col++) {

                    drawTile(p, startX + ((col ) * TILE_SIZE), startY + ((row ) * TILE_SIZE), g);

                }
            }
        }
    }

    private void drawStat()
    {
        int offset;
        //STATS
        g2d.setFont(LARGE_FONT);
        g2d.drawString("Stats", SMALL_INSET, offset = STATS_INSET);
        g2d.setFont(SMALL_FONT);
        g2d.drawString("Score: " + "GET SCORE METHOD", LARGE_INSET, offset += TEXT_STRIDE);


        g2d.setFont(LARGE_FONT);
        g2d.drawString("Controls", SMALL_INSET, offset = CONTROLS_INSET);
        g2d.setFont(SMALL_FONT);
        g2d.drawString("UP - Move Left ?", LARGE_INSET, offset += TEXT_STRIDE);
        g2d.drawString("DOWN - Rotate Piece ?", LARGE_INSET, offset += TEXT_STRIDE);

        g2d.setFont(LARGE_FONT);
        g2d.drawString("Next Piece:", SMALL_INSET, 70);
        g2d.drawRect(SQUARE_CENTER_X - SQUARE_SIZE, SQUARE_CENTER_Y - SQUARE_SIZE, SQUARE_SIZE * 2, SQUARE_SIZE * 2);
    }


   private void drawTile(Piece type, int x, int y, Graphics g) {


        for (int j = 0; j < type.largeur; j++) {
            for (int i = 0; i < type.largeur; i++) {
                int a = type.tab[j][i];
                g2d.setPaint(colors[a]);
                g2d.fillRect(105+i* TILE_SIZE, 50+j* TILE_SIZE ,  TILE_SIZE, TILE_SIZE);

            }
        }
   }
}