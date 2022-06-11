import java.util.ArrayList;
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
    @Test
    public void testBoardOrange(){
        BoardOrange boardOrange = new BoardOrange();
        List<PossibleMove> moves=boardOrange.possibleMoves();
        List<PossibleMove> testmoves=new ArrayList<>();
        for (int i=1;i<7;i++){
            testmoves.add(new PossibleMove(boardOrange,new Dice(DiceColor.ORANGE,i),0));
        }
        for (PossibleMove possibleMove : testmoves){
            Assertions.assertTrue(moves.contains(possibleMove));
        }

    }
    @Test
    public void testBoardPurple(){
        BoardPurple boardPurple = new BoardPurple();
        List<PossibleMove> moves=boardPurple.possibleMoves();
        List<PossibleMove> testmoves=new ArrayList<>();
        for (int i=1;i<7;i++){
            testmoves.add(new PossibleMove(boardPurple,new Dice(DiceColor.PURPLE,i),0));
        }
        for (PossibleMove possibleMove : testmoves){
            Assertions.assertTrue(moves.contains(possibleMove));
        }
    }
    @Test
    public void testBoardYellow(){
        BoardYellow boardYellow = new BoardYellow();
        List<PossibleMove> moves=boardYellow.possibleMoves();
        PossibleMove testmove=new PossibleMove(boardYellow,new Dice(DiceColor.YELLOW,3),0);
        Assertions.assertTrue(moves.contains(testmove));
    }
}
