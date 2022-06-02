import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class BoardPurple implements Board{
    private ArrayList<Tile> tiles;
    private final List<Dice> dices;

    public BoardPurple() {
        tiles = new ArrayList<>();
        dices = new LinkedList<>();

        for(int i = 1; i < 7; i++){
            dices.add(new Dice(Color.PURPLE,i));
            dices.add(new Dice(Color.WHITE,i));
        }
        tiles.add(0, new Tile(dices,null));
        tiles.add(1, new Tile(dices,null));
        tiles.add(2, new Tile(dices,TileSpecialAction.ADDROLL));
        tiles.add(3, new Tile(dices,TileSpecialAction.ADDRANDOM));
        tiles.add(4, new Tile(dices,TileSpecialAction.ADDROLL));
        tiles.add(5, new Tile(dices,TileSpecialAction.ADDRANDOM));
        tiles.add(6, new Tile(dices,TileSpecialAction.ADDFOX));
        tiles.add(7, new Tile(dices,TileSpecialAction.ADDADDITIONALDICE));
        tiles.add(8, new Tile(dices,TileSpecialAction.ADDRANDOM));
        tiles.add(9, new Tile(dices,TileSpecialAction.ADDCONST));
        tiles.add(10, new Tile(dices,TileSpecialAction.ADDADDITIONALDICE));
    }

    @Override
    public TileSpecialAction fillTile(Dice dice, int index) throws ImpossibleFill {
        if( !(tiles.get(index).getAllowedDiceList().contains(dice)))
            throw new ImpossibleFill("Nie można umieścić tej kostki w planszy fioletowej!");
        return tiles.get(index).fillWithDice(dice);
    }

    @Override
    public int getPoints() {
        int points = 0;
        for(int i = 0; i < tiles.size(); i++) {
            int temp = tiles.get(i).getFilledWith().getValue();
            points = points + temp;
        }
        return points;
    }

    @Override
    public List<PossibleMove> possibleMoves() {
        return null; //przesunąć drugiego if-a z possibleMovesWithDice
    }

    @Override
    public List<PossibleMove> possibleMovesWithDice(Dice dice) {
        LinkedList<PossibleMove> moveWithDice = new LinkedList<>();

        if(dices.contains(dice)){
            for(int i = 0; i < tiles.size(); i++) {
                if(!(tiles.get(i).getAllowedDiceList().contains(dice)))
                    if(dice.getValue()>tiles.get(0).getFilledWith().getValue())
                    moveWithDice.add(new PossibleMove(this, dice, i)); // 1 element czy więcej?
                break;
            }
            return moveWithDice;
        }
        return null;
    }
}
