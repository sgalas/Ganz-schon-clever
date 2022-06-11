import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BoardTest {
    @Test
    public void testBoardBlue(){
        BoardBlue boardBlue = new BoardBlue();
        List<PossibleMove> moves=boardBlue.possibleMoves();
        PossibleMove testmove=new PossibleMove(boardBlue,DiceCombination.createTwoDiceCombo(new Dice(DiceColor.BLUE,1),new Dice(DiceColor.WHITE,1)),0);
        Assertions.assertTrue(moves.contains(testmove));
    }
    @Test
    public void testBoardGreen(){
        BoardGreen boardGreen = new BoardGreen();
        List<PossibleMove> moves=boardGreen.possibleMoves();
        PossibleMove testmove=new PossibleMove(boardGreen,new Dice(DiceColor.GREEN,1),0);
        Assertions.assertTrue(moves.contains(testmove));
    }
}
