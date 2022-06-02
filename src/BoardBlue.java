import java.util.ArrayList;
import java.util.List;

public class BoardBlue implements Board{
    private ArrayList<Tile> tiles;


    public ArrayList<Tile> fillBoard(){
        for(int i = 2; i <= 12; i++){
        }
        return null;
    }
    @Override
    public TileSpecialAction fillTile(Dice dice, int index) throws ImpossibleFill {
        if( !(tiles.get(index).getAllowedDiceList().contains(dice)))
            throw new ImpossibleFill("Nie można umieścić tej kostki w planszy niebieskiej!");
        return tiles.get(index).fillWithDice(dice);
    }

    @Override
    public int getPoints() {
        return 0;
    }

    @Override
    public List<PossibleMove> possibleMoves() {
        return null;
    }

    @Override
    public List<PossibleMove> possibleMovesWithDice(Dice dice) {
        if(dice.getColor().equals(Color.BLUE) || dice.getColor().equals(Color.WHITE)){

        }
        return null;
    }
}
