package Labo5;

public abstract class MatriceOperation {

    /**
     * Takes two matrix, and output a new one with the operation implemented in the overload
     * The modules must match for both matrix
     * Will throw a RuntimeException in case modules don't match, or in case of a operation error
     * @return a new matrix with the resul
     */
    public Matrice process(Matrice a, Matrice b) {
        if(a.getModulo() != b.getModulo())
            throw new RuntimeException("Modulos aren't equal.");

        int modulo = a.getModulo();
        int height = Math.max(a.getHeight(), b.getHeight());
        int width  = Math.max(a.getWidth() , b.getWidth());

        int[][] matrice = new int[height][width];
        for(int h = 0; h < height; ++h) {
            for (int w = 0; w < width; ++w) {
                // Uses 0 if the matrix isn't big enough
                int aValue = (a.getHeight() > h && a.getWidth() > w ? a.getMatrice()[h][w] : 0);
                int bValue = (b.getHeight() > h && b.getWidth() > w ? b.getMatrice()[h][w] : 0);

                // Apply the operations, and the modulo
                matrice[h][w] = applyOperation(aValue, bValue) % modulo;
            }
        }

        return new Matrice(matrice, modulo);
    }

    /**
     * Takes two int, apply an operation to them depending on the overload, then returns the result
     * Overload Example : `return a + b;`
     */
    protected abstract int applyOperation(int a, int b);
}
