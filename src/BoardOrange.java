import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class BoardOrange implements Board{
    private ArrayList<Tile> tiles;
    private List<Dice> dices;

    public BoardOrange() {
        tiles = new ArrayList<>();
        dices = new LinkedList<>();

        for(int i = 1; i < 7; i++){
            dices.add(new Dice(Color.ORANGE,i));
            dices.add(new Dice(Color.WHITE,i));
        }
        tiles.add(1, new Tile(dices,null));
        tiles.add(2, new Tile(dices,null));
        tiles.add(3, new Tile(dices,SpecialAction.ADDROLL));
        tiles.add(4, new Tile(dices,null));
        tiles.add(5, new Tile(dices,SpecialAction.ADDRANDOM));
        tiles.add(6, new Tile(dices,SpecialAction.ADDADDITIONALDICE));
        tiles.add(7, new Tile(dices,null));
        tiles.add(8, new Tile(dices,SpecialAction.ADDFOX));
        tiles.add(9, new Tile(dices,null));
        tiles.add(10, new Tile(dices,SpecialAction.ADDCONST));
        tiles.add(11, new Tile(dices,null));
    }

    @Override
    public int fillTile(Dice dice, int index) {
        return 0;
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
        ArrayList<Tile> org = new ArrayList<>();
        if(dice.getColor().equals(Color.ORANGE)) {
        }
        return null;
    }
}
