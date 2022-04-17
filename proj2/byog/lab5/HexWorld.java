package byog.lab5;
import org.junit.Test;
import static org.junit.Assert.*;

import byog.TileEngine.TERenderer;
import byog.TileEngine.TETile;
import byog.TileEngine.Tileset;

import javax.swing.text.Position;
import java.util.Random;

/**
 * Draws a world consisting of hexagonal regions.
 */
public class HexWorld {
    private static final int WIDTH = 60;
    private static final int HEIGHT = 60;

    private static final long SEED = 2873412;
    private static final Random RANDOM = new Random(SEED);

    private static TETile randomTile() {
        int tileNum = RANDOM.nextInt(3);
        switch (tileNum) {
            case 0: return Tileset.MOUNTAIN;
            case 1: return Tileset.FLOWER;
            case 2: return Tileset.GRASS;
            default: return Tileset.GRASS;
        }

    }

    private static void fillup(TETile[][] tiles){
        for (int x = 0; x < WIDTH; x += 1){
            for (int y = 0; y < HEIGHT; y += 1){
                fillWithHex(tiles, x, y, Tileset.NOTHING);
            }
        }
    }

    private static void fillWithHex(TETile[][] tiles, int x, int y, TETile t){
        tiles[x][y] = t;
    }


    public static void addHexagon(TETile[][] tiles, int x, int y, int s, TETile t){
        int count = s;
        for (int i = 0; i < s*2; i += 1){
            for (int j = 0; j < count; j += 1){
                fillWithHex(tiles, x, y, t);
                x += 1;
            }
            y -= 1;
//            count += 2;
            if (i > s - 1) {
                x -= (count - 1);
                count -= 2;
            } else if (i < s - 1){
                x -= (count + 1);
                count += 2;
            } else {
                x -= count;
            }
        }
    }

    private static void addlineof(TETile[][] tiles, int x, int y, int s, int height){
        TETile t = randomTile();
        for (int i = 0; i < height; i += 1) {
            addHexagon(tiles, x, y, s, t);
            y -= (s * 2);
        }
    }

    public static void tessel(TETile[][] tiles, int x, int y, int s){
        int format = 5;
        int count = 3;
        for (int i = 0; i < format; i += 1){
            addlineof(tiles, x, y, s, count);

            x += (2 * s - 1);

            if (i < 2) {
                count += 1;
                y += s;
            } else {
               count -= 1;
               y -= s;
            }
        }
    }

    public static void main(String[] args){
        TERenderer ter = new TERenderer();
        ter.initialize(WIDTH, HEIGHT);

        TETile[][] tiles = new TETile[WIDTH][HEIGHT];
        fillup(tiles);
//        addHexagon(tiles, 16, 16, 3, Tileset.GRASS);

        tessel(tiles, 30,30, 3);
        ter.renderFrame(tiles);
    }
}
