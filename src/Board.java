public interface Board {
    int fillTile(Dice dice,int index) throws ImpossibleFill;

    int getPoints();
}
