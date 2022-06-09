import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class BoardYellow implements Board{
    private final ArrayList<Tile> tiles;
    private final List<DiceCombination> dices;

    public BoardYellow() {
        tiles = new ArrayList<>();
        dices = new LinkedList<>();

        LinkedList<DiceCombination> value1 = new LinkedList<>();
        value1.add(new DiceCombination( new Dice((Color.YELLOW),1)));
        value1.add(new DiceCombination( new Dice((Color.WHITE),1)));

        LinkedList<DiceCombination> value2 = new LinkedList<>();
        value2.add(new DiceCombination( new Dice((Color.YELLOW),2)));
        value2.add(new DiceCombination( new Dice((Color.WHITE),2)));

        LinkedList<DiceCombination> value3 = new LinkedList<>();
        value3.add(new DiceCombination( new Dice((Color.YELLOW),3)));
        value3.add(new DiceCombination( new Dice((Color.WHITE),3)));

        LinkedList<DiceCombination> value4 = new LinkedList<>();
        value4.add(new DiceCombination( new Dice((Color.YELLOW),4)));
        value4.add(new DiceCombination( new Dice((Color.WHITE),4)));

        LinkedList<DiceCombination> value5 = new LinkedList<>();
        value5.add(new DiceCombination( new Dice((Color.YELLOW),5)));
        value5.add(new DiceCombination( new Dice((Color.WHITE),5)));

        LinkedList<DiceCombination> value6 = new LinkedList<>();
        value6.add(new DiceCombination( new Dice((Color.YELLOW),6)));
        value6.add(new DiceCombination( new Dice((Color.WHITE),6)));

        for(int i = 1; i < 7; i++){
            dices.add(new DiceCombination(new Dice(Color.YELLOW,i)));
            dices.add(new DiceCombination(new Dice(Color.WHITE,i)));
        }
        tiles.add(0, new Tile(value3, null));
        tiles.add(1, new Tile(value6,null));
        tiles.add(2, new Tile(value5,null));

        tiles.add(3, new Tile(value2,null));
        tiles.add(4, new Tile(value1,null));
        tiles.add(5, new Tile(value5,null));

        tiles.add(6, new Tile(value1,null));
        tiles.add(7, new Tile(value2,null));
        tiles.add(8, new Tile(value4,null));

        tiles.add(9, new Tile(value3,null));
        tiles.add(10, new Tile(value4,null));
        tiles.add(11, new Tile(value6,null));
    }

    @Override
    public TileSpecialAction fillTile(DiceCombination dice, int index) throws ImpossibleFill {
        if( !(tiles.get(index).getAllowedDiceCombinationList().contains(dice)))
            throw new ImpossibleFill("Nie można umieścić tej kostki w planszy żółtej!");
        tiles.get(index).updateAllowedDiceList(null);
        return getSpecialAction();
    }

    public TileSpecialAction getSpecialAction(){
        if((!tiles.get(0).isEmpty()) & (!tiles.get(1).isEmpty()) & (!tiles.get(2).isEmpty())){
            return TileSpecialAction.ADDRANDOMBLUE;
        } else if((!tiles.get(3).isEmpty()) & (!tiles.get(4).isEmpty()) & (!tiles.get(5).isEmpty())){
            return TileSpecialAction.ADDORANGE4;
        } else if((!tiles.get(6).isEmpty()) & (!tiles.get(7).isEmpty()) & (!tiles.get(8).isEmpty())){
            return TileSpecialAction.ADDRANDOMGREEN;
        } else if((!tiles.get(9).isEmpty()) & (!tiles.get(10).isEmpty()) & (!tiles.get(11).isEmpty())){
            return TileSpecialAction.ADDFOX;
        } else {return null;
        }
    }

    @Override
    public int getPoints() {
        int points = 0;
        if((!tiles.get(0).isEmpty()) & (!tiles.get(3).isEmpty()) & (!tiles.get(6).isEmpty())){
            points = points + 10;
        }
        if((!tiles.get(1).isEmpty()) & (!tiles.get(4).isEmpty()) & (!tiles.get(9).isEmpty())){
            points = points + 14;
        }
        if((!tiles.get(2).isEmpty()) & (!tiles.get(7).isEmpty()) & (!tiles.get(10).isEmpty())){
            points = points + 16;
        }
        if((!tiles.get(5).isEmpty()) & (!tiles.get(8).isEmpty()) & (!tiles.get(11).isEmpty())){
            points = points + 20;
        }
        return points;
    }

    @Override
    public List<PossibleMove> possibleMoves() {
        LinkedList<PossibleMove> moves = new LinkedList<>();
        for(int i = 0; i < tiles.size(); i++) {
            for(DiceCombination dice: dices)
                if((tiles.get(i).getAllowedDiceCombinationList().contains(dice))) {
                    moves.add(new PossibleMove(this, dice, i));
                }
        }

        return moves;
    }

    @Override
    public List<PossibleMove> possibleMovesWithDice(DiceCombination dice) {
        LinkedList<PossibleMove> moveWithDice = new LinkedList<>();

        if(dices.contains(dice)){
            for(int i = 0; i < tiles.size(); i++) {
                if((tiles.get(i).getAllowedDiceCombinationList().contains(dice))){
                    moveWithDice.add(new PossibleMove(this, dice, i));
                }
            }
        }  return moveWithDice;
    }
}
