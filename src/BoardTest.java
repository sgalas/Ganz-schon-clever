import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BoardTest {
    @Test
    public void testBoardBlue() {
        BoardBlue boardBlue = new BoardBlue();
        List<PossibleMove> moves = boardBlue.possibleMoves();
        PossibleMove testmove = new PossibleMove(boardBlue, DiceCombination.createTwoDiceCombo(new Dice(DiceColor.BLUE, 1), new Dice(DiceColor.WHITE, 1)), 0);
        Assertions.assertTrue(moves.contains(testmove));
    }

    @Test
    public void testBoardGreen() {
        BoardGreen boardGreen = new BoardGreen();
        List<PossibleMove> moves = boardGreen.possibleMoves();
        PossibleMove testmove = new PossibleMove(boardGreen, new Dice(DiceColor.GREEN, 1), 0);
        Assertions.assertTrue(moves.contains(testmove));
    }

    @Test
    public void testBoardOrange() {
        BoardOrange boardOrange = new BoardOrange();
        List<PossibleMove> moves = boardOrange.possibleMoves();
        List<PossibleMove> testmoves = new ArrayList<>();
        for (int i = 1; i < 7; i++) {
            testmoves.add(new PossibleMove(boardOrange, new Dice(DiceColor.ORANGE, i), 0));
        }
        for (PossibleMove possibleMove : testmoves) {
            Assertions.assertTrue(moves.contains(possibleMove));
        }

    }

    @Test
    public void testBoardGreen2() {
        BoardGreen boardGreen = new BoardGreen();
        List<PossibleMove> testmoves = new ArrayList<>();

        Assertions.assertDoesNotThrow(() -> new PossibleMove(boardGreen, new DiceCombination(new Dice(DiceColor.GREEN, 2)), 0).doMove());
        for (int i = 3; i < 7; i++) {
            testmoves.add(new PossibleMove(boardGreen, new Dice(DiceColor.GREEN, i), 1));
        }
        List<PossibleMove> moves = boardGreen.possibleMoves();
        for (PossibleMove possibleMove : testmoves) {
            Assertions.assertTrue(moves.contains(possibleMove));
        }
    }

    @Test
    public void testBoardPurple() {
        BoardPurple boardPurple = new BoardPurple();
        List<PossibleMove> moves = boardPurple.possibleMoves();
        List<PossibleMove> testmoves = new ArrayList<>();
        for (int i = 1; i < 7; i++) {
            testmoves.add(new PossibleMove(boardPurple, new Dice(DiceColor.PURPLE, i), 0));
        }
        for (PossibleMove possibleMove : testmoves) {
            Assertions.assertTrue(moves.contains(possibleMove));
        }
    }

    @Test
    public void testBoardYellow() {
        BoardYellow boardYellow = new BoardYellow();
        List<PossibleMove> moves = boardYellow.possibleMoves();
        PossibleMove testmove = new PossibleMove(boardYellow, new Dice(DiceColor.YELLOW, 3), 0);
        Assertions.assertTrue(moves.contains(testmove));
    }

    @Test
    public void testBoardPurple2() {
        BoardPurple boardPurple = new BoardPurple();
        List<PossibleMove> testmoves = new ArrayList<>();

        Assertions.assertDoesNotThrow(() -> new PossibleMove(boardPurple, new DiceCombination(new Dice(DiceColor.PURPLE, 2)), 0).doMove());
        for (int i = 3; i < 7; i++) {
            testmoves.add(new PossibleMove(boardPurple, new Dice(DiceColor.PURPLE, i), 1));
        }
        List<PossibleMove> moves = boardPurple.possibleMoves();
        for (PossibleMove possibleMove : testmoves) {
            Assertions.assertTrue(moves.contains(possibleMove));
        }
    }

    @Test
    public void testBoardPurple3() {
        BoardPurple boardPurple = new BoardPurple();
        List<PossibleMove> testmoves = new ArrayList<>();

        Assertions.assertDoesNotThrow(() -> new PossibleMove(boardPurple, new DiceCombination(new Dice(DiceColor.PURPLE, 2)), 0).doMove());
        Assertions.assertDoesNotThrow(() -> new PossibleMove(boardPurple, new DiceCombination(new Dice(DiceColor.PURPLE, 6)), 1).doMove());
        for (int i = 1; i < 7; i++) {
            testmoves.add(new PossibleMove(boardPurple, new Dice(DiceColor.PURPLE, i), 2));
        }
        List<PossibleMove> moves = boardPurple.possibleMoves();
        for (PossibleMove possibleMove : testmoves) {
            Assertions.assertTrue(moves.contains(possibleMove));
        }
    }

    @Test
    public void testBoardOrange2() {
        BoardOrange boardOrange = new BoardOrange();
        for (int j = 0; j < 10; j++) {
            List<PossibleMove> testmoves = new ArrayList<>();
            for (int i = 1; i < 7; i++) {
                testmoves.add(new PossibleMove(boardOrange, new Dice(DiceColor.ORANGE, i), j));
            }
            List<PossibleMove> moves = boardOrange.possibleMoves();
            for (PossibleMove possibleMove : testmoves) {
                Assertions.assertTrue(moves.contains(possibleMove));
            }
            Assertions.assertDoesNotThrow(() -> moves.get(0).doMove());
        }

    }

    @Test
    public void testBoardYellow2() {
        BoardYellow boardYellow = new BoardYellow();

        Assertions.assertDoesNotThrow(() -> new PossibleMove(boardYellow, new DiceCombination(new Dice(DiceColor.YELLOW, 3)), 0).doMove());
        Assertions.assertDoesNotThrow(() -> new PossibleMove(boardYellow, new DiceCombination(new Dice(DiceColor.YELLOW, 2)), 3).doMove());
        Assertions.assertDoesNotThrow(() -> new PossibleMove(boardYellow, new DiceCombination(new Dice(DiceColor.YELLOW, 1)), 6).doMove());

        Assertions.assertEquals(10, boardYellow.getPoints());
    }

    @Test
    public void testBoardGreen3() {
        BoardGreen boardGreen = new BoardGreen();

        Assertions.assertDoesNotThrow(() -> new PossibleMove(boardGreen, new DiceCombination(new Dice(DiceColor.GREEN, 3)), 0).doMove());
        Assertions.assertDoesNotThrow(() -> new PossibleMove(boardGreen, new DiceCombination(new Dice(DiceColor.GREEN, 3)), 1).doMove());
        Assertions.assertDoesNotThrow(() -> new PossibleMove(boardGreen, new DiceCombination(new Dice(DiceColor.GREEN, 3)), 2).doMove());

        Assertions.assertEquals(6, boardGreen.getPoints());
    }


    @Test
    public void testBoardOrange3() {
        BoardOrange boardOrange = new BoardOrange();

        Assertions.assertDoesNotThrow(() -> new PossibleMove(boardOrange, new DiceCombination(new Dice(DiceColor.ORANGE, 6)), 0).doMove());
        Assertions.assertDoesNotThrow(() -> new PossibleMove(boardOrange, new DiceCombination(new Dice(DiceColor.ORANGE, 1)), 1).doMove());
        Assertions.assertDoesNotThrow(() -> new PossibleMove(boardOrange, new DiceCombination(new Dice(DiceColor.ORANGE, 5)), 2).doMove());

        Assertions.assertEquals(12, boardOrange.getPoints());
    }


    @Test
    public void testBoardPurple4() {
        BoardPurple boardPurple = new BoardPurple();

        Assertions.assertDoesNotThrow(() -> new PossibleMove(boardPurple, new DiceCombination(new Dice(DiceColor.PURPLE, 4)), 0).doMove());
        Assertions.assertDoesNotThrow(() -> new PossibleMove(boardPurple, new DiceCombination(new Dice(DiceColor.PURPLE, 6)), 1).doMove());
        Assertions.assertDoesNotThrow(() -> new PossibleMove(boardPurple, new DiceCombination(new Dice(DiceColor.PURPLE, 1)), 2).doMove());

        Assertions.assertEquals(11, boardPurple.getPoints());
    }

    @Test
    public void testBoardBlue2() {
        BoardBlue boardBlue = new BoardBlue();
        LinkedList<DiceCombination> sum2 = new LinkedList<>();
        sum2.add( DiceCombination.createTwoDiceCombo(new Dice(DiceColor.BLUE,1),new Dice(DiceColor.WHITE,1)));
        LinkedList<DiceCombination> sum3 = new LinkedList<>();
        sum3.add(DiceCombination.createTwoDiceCombo(new Dice(DiceColor.BLUE,1),new Dice(DiceColor.WHITE,2)));
        LinkedList<DiceCombination> sum4 = new LinkedList<>();
        sum4.add(DiceCombination.createTwoDiceCombo(new Dice(DiceColor.BLUE,2),new Dice(DiceColor.WHITE,2)));


        Assertions.assertDoesNotThrow(() -> new PossibleMove(boardBlue,sum2.get(0),0).doMove());
        Assertions.assertDoesNotThrow(() -> new PossibleMove(boardBlue,sum3.get(0),1).doMove());
        Assertions.assertDoesNotThrow(() -> new PossibleMove(boardBlue,sum4.get(0),2).doMove());

        Assertions.assertEquals(4, boardBlue.getPoints());
    }
}

