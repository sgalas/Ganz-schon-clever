import java.util.ArrayList;

public class BoardYellow implements Board{
    private ArrayList<Tile> tiles;
    @Override
    public int fillTile(Dice dice, int index) {
        return 0;
    }

    @Override
    public int getPoints() {
        return 0;
    }
}
