package Labo5;

public abstract class MatriceOperation {

    public Matrice process(Matrice a, Matrice b) throws RuntimeException {
        // TODO modulo check
        // TODO different size handling
        // TODO call applyOperation()
        // TODO apply modulo n
        throw new RuntimeException("TODO, not Implemented");
    }

    protected abstract int applyOperation(int a, int b);
}
