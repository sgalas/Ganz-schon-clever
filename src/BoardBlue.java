import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class BoardBlue implements Board{
    private ArrayList<Tile> tiles;
    private final List<DiceCombination> dices;
    public BoardBlue() {
        tiles = new ArrayList<>();
        dices = new LinkedList<>();

        for (int i = 1; i < 7; i++) {
            dices.add(new DiceCombination(new Dice (Color.BLUE, i)));
            dices.add(new DiceCombination(new Dice (Color.WHITE, i)));
        }

        LinkedList<DiceCombination> sum2 = new LinkedList<>();// prawdopodobnie lepiej byłoby upadateować AllowedDiceList w possibleMoveWithDice (w celu dodania kostek), a później w FillTile(zmienionym pod dwie kostki; w celu usunięcia)
        sum2.add(DiceCombination.createTwoDiceCombo(new Dice(Color.BLUE,1),new Dice(Color.WHITE,1)));
        sum2.add(DiceCombination.createTwoDiceCombo(new Dice(Color.WHITE,1),new Dice(Color.BLUE,1)));

        LinkedList<DiceCombination> sum3 = new LinkedList<>();
        sum3.add(DiceCombination.createTwoDiceCombo(new Dice(Color.BLUE,1),new Dice(Color.WHITE,2)));
        sum3.add(DiceCombination.createTwoDiceCombo(new Dice(Color.BLUE,2),new Dice(Color.WHITE,1)));
        sum3.add(DiceCombination.createTwoDiceCombo(new Dice(Color.WHITE,1),new Dice(Color.BLUE,2)));
        sum3.add(DiceCombination.createTwoDiceCombo(new Dice(Color.WHITE,2),new Dice(Color.BLUE,1)));

        LinkedList<DiceCombination> sum4 = new LinkedList<>();
        sum4.add(DiceCombination.createTwoDiceCombo(new Dice(Color.BLUE,2),new Dice(Color.WHITE,2)));
        sum4.add(DiceCombination.createTwoDiceCombo(new Dice(Color.WHITE,2),new Dice(Color.BLUE,2)));
        sum4.add(DiceCombination.createTwoDiceCombo(new Dice(Color.BLUE,1),new Dice(Color.WHITE,3)));
        sum4.add(DiceCombination.createTwoDiceCombo(new Dice(Color.BLUE,3),new Dice(Color.WHITE,1)));
        sum4.add(DiceCombination.createTwoDiceCombo(new Dice(Color.WHITE,1),new Dice(Color.BLUE,3)));
        sum4.add(DiceCombination.createTwoDiceCombo(new Dice(Color.WHITE,3),new Dice(Color.BLUE,1)));

        LinkedList<DiceCombination> sum5 = new LinkedList<>();
        sum5.add(DiceCombination.createTwoDiceCombo(new Dice(Color.BLUE,1),new Dice(Color.WHITE,4)));
        sum5.add(DiceCombination.createTwoDiceCombo(new Dice(Color.BLUE,4),new Dice(Color.WHITE,1)));
        sum5.add(DiceCombination.createTwoDiceCombo(new Dice(Color.WHITE,1),new Dice(Color.BLUE,4)));
        sum5.add(DiceCombination.createTwoDiceCombo(new Dice(Color.WHITE,4),new Dice(Color.BLUE,1)));
        sum5.add(DiceCombination.createTwoDiceCombo(new Dice(Color.BLUE,2),new Dice(Color.WHITE,3)));
        sum5.add(DiceCombination.createTwoDiceCombo(new Dice(Color.BLUE,3),new Dice(Color.WHITE,2)));
        sum5.add(DiceCombination.createTwoDiceCombo(new Dice(Color.WHITE,2),new Dice(Color.BLUE,3)));
        sum5.add(DiceCombination.createTwoDiceCombo(new Dice(Color.WHITE,3),new Dice(Color.BLUE,2)));

        LinkedList<DiceCombination> sum6 = new LinkedList<>();
        sum6.add(DiceCombination.createTwoDiceCombo(new Dice(Color.BLUE,1),new Dice(Color.WHITE,5)));
        sum6.add(DiceCombination.createTwoDiceCombo(new Dice(Color.BLUE,5),new Dice(Color.WHITE,1)));
        sum6.add(DiceCombination.createTwoDiceCombo(new Dice(Color.WHITE,1),new Dice(Color.BLUE,5)));
        sum6.add(DiceCombination.createTwoDiceCombo(new Dice(Color.WHITE,5),new Dice(Color.BLUE,1)));
        sum6.add(DiceCombination.createTwoDiceCombo(new Dice(Color.BLUE,2),new Dice(Color.WHITE,4)));
        sum6.add(DiceCombination.createTwoDiceCombo(new Dice(Color.BLUE,4),new Dice(Color.WHITE,2)));
        sum6.add(DiceCombination.createTwoDiceCombo(new Dice(Color.WHITE,2),new Dice(Color.BLUE,4)));
        sum6.add(DiceCombination.createTwoDiceCombo(new Dice(Color.WHITE,4),new Dice(Color.BLUE,2)));
        sum6.add(DiceCombination.createTwoDiceCombo(new Dice(Color.BLUE,3),new Dice(Color.WHITE,3)));
        sum6.add(DiceCombination.createTwoDiceCombo(new Dice(Color.WHITE,3),new Dice(Color.BLUE,3)));

        LinkedList<DiceCombination> sum7 = new LinkedList<>();
        sum7.add(DiceCombination.createTwoDiceCombo(new Dice(Color.BLUE,1),new Dice(Color.WHITE,6)));
        sum7.add(DiceCombination.createTwoDiceCombo(new Dice(Color.BLUE,6),new Dice(Color.WHITE,1)));
        sum7.add(DiceCombination.createTwoDiceCombo(new Dice(Color.WHITE,1),new Dice(Color.BLUE,6)));
        sum7.add(DiceCombination.createTwoDiceCombo(new Dice(Color.WHITE,6),new Dice(Color.BLUE,1)));
        sum7.add(DiceCombination.createTwoDiceCombo(new Dice(Color.BLUE,2),new Dice(Color.WHITE,5)));
        sum7.add(DiceCombination.createTwoDiceCombo(new Dice(Color.BLUE,5),new Dice(Color.WHITE,2)));
        sum7.add(DiceCombination.createTwoDiceCombo(new Dice(Color.WHITE,2),new Dice(Color.BLUE,5)));
        sum7.add(DiceCombination.createTwoDiceCombo(new Dice(Color.WHITE,5),new Dice(Color.BLUE,2)));
        sum7.add(DiceCombination.createTwoDiceCombo(new Dice(Color.BLUE,3),new Dice(Color.WHITE,4)));
        sum7.add(DiceCombination.createTwoDiceCombo(new Dice(Color.BLUE,4),new Dice(Color.WHITE,3)));
        sum7.add(DiceCombination.createTwoDiceCombo(new Dice(Color.WHITE,3),new Dice(Color.BLUE,4)));
        sum7.add(DiceCombination.createTwoDiceCombo(new Dice(Color.WHITE,4),new Dice(Color.BLUE,3)));

        LinkedList<DiceCombination> sum8 = new LinkedList<>();
        sum8.add(DiceCombination.createTwoDiceCombo(new Dice(Color.BLUE,2),new Dice(Color.WHITE,6)));
        sum8.add(DiceCombination.createTwoDiceCombo(new Dice(Color.BLUE,6),new Dice(Color.WHITE,2)));
        sum8.add(DiceCombination.createTwoDiceCombo(new Dice(Color.WHITE,2),new Dice(Color.BLUE,6)));
        sum8.add(DiceCombination.createTwoDiceCombo(new Dice(Color.WHITE,6),new Dice(Color.BLUE,2)));
        sum8.add(DiceCombination.createTwoDiceCombo(new Dice(Color.BLUE,3),new Dice(Color.WHITE,5)));
        sum8.add(DiceCombination.createTwoDiceCombo(new Dice(Color.BLUE,5),new Dice(Color.WHITE,3)));
        sum8.add(DiceCombination.createTwoDiceCombo(new Dice(Color.WHITE,3),new Dice(Color.BLUE,5)));
        sum8.add(DiceCombination.createTwoDiceCombo(new Dice(Color.WHITE,5),new Dice(Color.BLUE,3)));
        sum8.add(DiceCombination.createTwoDiceCombo(new Dice(Color.BLUE,4),new Dice(Color.WHITE,4)));
        sum8.add(DiceCombination.createTwoDiceCombo(new Dice(Color.WHITE,4),new Dice(Color.BLUE,4)));

        LinkedList<DiceCombination> sum9 = new LinkedList<>();
        sum9.add(DiceCombination.createTwoDiceCombo(new Dice(Color.BLUE,3),new Dice(Color.WHITE,6)));
        sum9.add(DiceCombination.createTwoDiceCombo(new Dice(Color.BLUE,6),new Dice(Color.WHITE,3)));
        sum9.add(DiceCombination.createTwoDiceCombo(new Dice(Color.WHITE,3),new Dice(Color.BLUE,6)));
        sum9.add(DiceCombination.createTwoDiceCombo(new Dice(Color.WHITE,6),new Dice(Color.BLUE,3)));
        sum9.add(DiceCombination.createTwoDiceCombo(new Dice(Color.BLUE,4),new Dice(Color.WHITE,5)));
        sum9.add(DiceCombination.createTwoDiceCombo(new Dice(Color.BLUE,5),new Dice(Color.WHITE,4)));
        sum9.add(DiceCombination.createTwoDiceCombo(new Dice(Color.WHITE,4),new Dice(Color.BLUE,5)));
        sum9.add(DiceCombination.createTwoDiceCombo(new Dice(Color.WHITE,5),new Dice(Color.BLUE,4)));

        LinkedList<DiceCombination> sum10 = new LinkedList<>();
        sum10.add(DiceCombination.createTwoDiceCombo(new Dice(Color.BLUE,4),new Dice(Color.WHITE,6)));
        sum10.add(DiceCombination.createTwoDiceCombo(new Dice(Color.BLUE,6),new Dice(Color.WHITE,4)));
        sum10.add(DiceCombination.createTwoDiceCombo(new Dice(Color.WHITE,4),new Dice(Color.BLUE,6)));
        sum10.add(DiceCombination.createTwoDiceCombo(new Dice(Color.WHITE,6),new Dice(Color.BLUE,4)));
        sum10.add(DiceCombination.createTwoDiceCombo(new Dice(Color.BLUE,5),new Dice(Color.WHITE,5)));
        sum10.add(DiceCombination.createTwoDiceCombo(new Dice(Color.WHITE,5),new Dice(Color.BLUE,5)));

        LinkedList<DiceCombination> sum11 = new LinkedList<>();
        sum11.add(DiceCombination.createTwoDiceCombo(new Dice(Color.BLUE,5),new Dice(Color.WHITE,6)));
        sum11.add(DiceCombination.createTwoDiceCombo(new Dice(Color.BLUE,6),new Dice(Color.WHITE,5)));
        sum11.add(DiceCombination.createTwoDiceCombo(new Dice(Color.WHITE,5),new Dice(Color.BLUE,6)));
        sum11.add(DiceCombination.createTwoDiceCombo(new Dice(Color.WHITE,6),new Dice(Color.BLUE,5)));

        LinkedList<DiceCombination> sum12 = new LinkedList<>();
        sum12.add(DiceCombination.createTwoDiceCombo(new Dice(Color.BLUE,6),new Dice(Color.WHITE,6)));
        sum12.add(DiceCombination.createTwoDiceCombo(new Dice(Color.BLUE,6),new Dice(Color.WHITE,6)));

        tiles.add(0, new Tile(sum2,null));
        tiles.add(1, new Tile(sum3,null));
        tiles.add(2, new Tile(sum4,null));

        tiles.add(3, new Tile(sum5,null));
        tiles.add(4, new Tile(sum6,null));
        tiles.add(5, new Tile(sum7,null));
        tiles.add(6, new Tile(sum8,null));

        tiles.add(7, new Tile(sum9,null));
        tiles.add(8, new Tile(sum10,null));
        tiles.add(9, new Tile(sum11,null));
        tiles.add(10, new Tile(sum12,null));
    }

    @Override
    public TileSpecialAction fillTile(DiceCombination dice, int index) throws ImpossibleFill {
        if( !(tiles.get(index).getAllowedDiceCombinationList().contains(dice)))
            throw new ImpossibleFill("Nie można umieścić tej kostki w planszy niebieskiej!");
        tiles.get(index).updateAllowedDiceList(null);
        return getSpecialAction(); // change method so that it takes 2 vaules of dices (white and blue)
    }

    public TileSpecialAction getSpecialAction(){
        if((!tiles.get(0).isEmpty()) & (!tiles.get(1).isEmpty()) & (!tiles.get(2).isEmpty())){
            return TileSpecialAction.ADDORANGE5;
        } else if((!tiles.get(3).isEmpty()) & (!tiles.get(4).isEmpty()) & (!tiles.get(5).isEmpty()) & (!tiles.get(6).isEmpty())){
            return TileSpecialAction.ADDRANDOMYELLOW;
        } else if((!tiles.get(7).isEmpty()) & (!tiles.get(8).isEmpty()) & (!tiles.get(9).isEmpty()) & (!tiles.get(10).isEmpty())){
            return TileSpecialAction.ADDFOX;
        } else if((!tiles.get(3).isEmpty()) & (!tiles.get(7).isEmpty())){
            return TileSpecialAction.ADDROLL;
        } else if((!tiles.get(0).isEmpty()) & (!tiles.get(4).isEmpty()) & (!tiles.get(8).isEmpty())){
            return TileSpecialAction.ADDRANDOMGREEN;
        } else if((!tiles.get(1).isEmpty()) & (!tiles.get(5).isEmpty()) & (!tiles.get(9).isEmpty())) {
            return TileSpecialAction.ADDPURPLE6;
        } else if((!tiles.get(2).isEmpty()) & (!tiles.get(6).isEmpty()) & (!tiles.get(10).isEmpty())) {
            return TileSpecialAction.ADDADDITIONALDICE;
        } else {return null;
        }
    }

    @Override
    public int getPoints() {
        int points = 1;
        int counter = 0;
        for(int i = 0; i < tiles.size() + 1; i++){
            if(!(tiles.get(i).isEmpty())){
                points+=counter;
                counter++;
            }
        }
       if(counter==0)
           points=0;
        return points;
    }

    @Override
    public List<PossibleMove> possibleMoves() {
        LinkedList<PossibleMove> moves = new LinkedList<>();
        for(int i = 0; i < tiles.size(); i++) {
            for(DiceCombination dice: dices)
                if((tiles.get(i).getAllowedDiceCombinationList().contains(dice.getPrimaryDice())) & tiles.get(i).getAllowedDiceCombinationList().contains(dice.getHelperDices())) {
                    moves.add(new PossibleMove(this, dice, i));
                }
        }

        return moves;
    }

    @Override
    public List<PossibleMove> possibleMovesWithDice(DiceCombination dice) {
        LinkedList<PossibleMove> moveWithDice = new LinkedList<>();

        if (dices.contains(dice)) {
            for (int i = 0; i < tiles.size(); i++) {
                if ((tiles.get(i).getAllowedDiceCombinationList().contains(dice.getPrimaryDice())) & tiles.get(i).getAllowedDiceCombinationList().contains(dice.getHelperDices())) {
                    moveWithDice.add(new PossibleMove(this, dice, i));
                }
            }
        }
        return moveWithDice;
    }
}
