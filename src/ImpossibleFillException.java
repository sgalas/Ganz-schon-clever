/**
 * Wyjątek braku możliwości zapełnienia pola
 */
public class ImpossibleFillException extends Exception {
    public ImpossibleFillException(String errorMessage) {
        super(errorMessage);
    }
}