import java.util.ArrayList;

public class BoardYellow implements Board{
    private ArrayList<Tile> tiles;
    @Override
    public int fillTile(Dice dice, int index) throws ImpossibleFill {
        if( !(tiles.get(index).getAllowedDiceList().contains(dice)))
            throw new ImpossibleFill("Nie można umieścić tej kostki w planszy fioletowej!");
        return 0;
    }

    @Override
    public int getPoints() {
        return 0;
    }
}
