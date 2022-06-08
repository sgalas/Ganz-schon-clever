import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class BoardBlue implements Board{
    private ArrayList<Tile> tiles;
    private final List<Dice> dices;

    public BoardBlue() {
        tiles = new ArrayList<>();
        dices = new LinkedList<>();

        for (int i = 1; i < 7; i++) {
            dices.add(new Dice(Color.BLUE, i));
            dices.add(new Dice(Color.WHITE, i));
        }

        LinkedList<Dice> sum2 = new LinkedList<>(); // prawdopodobnie lepiej byłoby upadateować AllowedDiceList w possibleMoveWithDice (w celu dodania kostek), a później w FillTile(zmienionym pod dwie kostki; w celu usunięcia)
        sum2.add(new Dice((Color.BLUE),1));
        sum2.add(new Dice((Color.WHITE),1));

        LinkedList<Dice> sum3 = new LinkedList<>();
        sum3.add(new Dice((Color.BLUE),2));
        sum3.add(new Dice((Color.WHITE),2));

        LinkedList<Dice> sum4 = new LinkedList<>();
        sum4.add(new Dice((Color.BLUE),3));
        sum4.add(new Dice((Color.WHITE),3));

        LinkedList<Dice> sum5 = new LinkedList<>();
        sum5.add(new Dice((Color.BLUE),4));
        sum5.add(new Dice((Color.WHITE),4));

        LinkedList<Dice> sum6 = new LinkedList<>();
        sum6.add(new Dice((Color.BLUE),5));
        sum6.add(new Dice((Color.WHITE),5));

        LinkedList<Dice> sum7 = new LinkedList<>();
        sum7.add(new Dice((Color.BLUE),6));
        sum7.add(new Dice((Color.WHITE),6));

        LinkedList<Dice> sum8 = new LinkedList<>();
        sum8.add(new Dice((Color.BLUE),6));
        sum8.add(new Dice((Color.WHITE),6));

        LinkedList<Dice> sum9 = new LinkedList<>();
        sum9.add(new Dice((Color.BLUE),6));
        sum9.add(new Dice((Color.WHITE),6));

        LinkedList<Dice> sum10 = new LinkedList<>();
        sum10.add(new Dice((Color.BLUE),6));
        sum10.add(new Dice((Color.WHITE),6));

        LinkedList<Dice> sum11 = new LinkedList<>();
        sum11.add(new Dice((Color.BLUE),6));
        sum11.add(new Dice((Color.WHITE),6));

        LinkedList<Dice> sum12 = new LinkedList<>();
        sum12.add(new Dice((Color.BLUE),6));
        sum12.add(new Dice((Color.WHITE),6));

        tiles.add(0, new Tile(null,null));
        tiles.add(1, new Tile(null,null));
        tiles.add(2, new Tile(null,null));

        tiles.add(3, new Tile(null,null));
        tiles.add(4, new Tile(null,null));
        tiles.add(5, new Tile(null,null));
        tiles.add(6, new Tile(null,null));

        tiles.add(7, new Tile(null,null));
        tiles.add(8, new Tile(null,null));
        tiles.add(9, new Tile(null,null));
        tiles.add(10, new Tile(null,null));
    }

    @Override
    public TileSpecialAction fillTile(Dice dice, int index) throws ImpossibleFill {
        if( !(tiles.get(index).getAllowedDiceList().contains(dice)))
            throw new ImpossibleFill("Nie można umieścić tej kostki w planszy niebieskiej!");
        tiles.get(index).updateAllowedDiceList(null);
        return tiles.get(index).fillWithDice(dice); // change method so that it takes 2 vaules of dices (white and blue)
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
        return null;
    }

    @Override
    public List<PossibleMove> possibleMovesWithDice(Dice dice) {
        if(dice.getColor().equals(Color.BLUE) || dice.getColor().equals(Color.WHITE)){
            //to do
        }
        return null;
    }
}
