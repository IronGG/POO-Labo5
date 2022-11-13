package Labo5;

public class Matrice {

    private final int[][] matrice;
    private final int     modulo;

    //#region Constructors

    /**
     * Random matrix constructor
     * Will create a matrix and fill it with values between 0 (included) and modulo
     * @param length The width of each row of the matrix
     * @param height The number of rows of the matrix
     * @param modulo The max value possible in the matrix +1
     */
    public Matrice(int length, int height, int modulo) {

        matrice = new int[length][height];
        for (int i = 0; i < length; ++i) {
            for(int j = 0; j < height; j++) {
                matrice[i][j] = (int)(Math.random()*modulo);
            }
        }

        this.modulo = modulo;

        checkDimensions();
        checkModulo();
    }

    /**
     * Will create a matrix with already existing values
     * The passed values must represent a non-empty, regular matrix
     * It's values must be between 0 (included) and modulo
     * @param matrice a matrix of int
     * @param modulo The max value possible of the matrix +1
     */
    public Matrice(int[][] matrice, int modulo) {
        this.matrice = matrice;
        this.modulo  = modulo;
        checkDimensions();
        checkModulo();
    }

    // Copy constructor
    public Matrice(Matrice matrice) {
        this.matrice = matrice.matrice;
        this.modulo  = matrice.modulo;
        checkModulo();
    }

    /**
     * Throws runtime exception if matrix is not a regular matrix
     */
    public void checkDimensions() {
        if (matrice.length == 0 || matrice[0].length == 0) {
            throw new RuntimeException("Invalid matrice size");
        }
        for(int i = 1; i < matrice.length; ++i) {
            if (matrice[i].length != matrice[0].length)
                throw new RuntimeException("matrice shape is not regular");
        }
    }

    /**
     * Throws runtime exception if matrix has a value higher than modulo
     */
    public void checkModulo(){

        for (int i = 0; i < matrice.length; ++i) {
            for (int j = 0; j < matrice[0].length; ++j)
            {
                if(matrice[i][j] >= modulo || matrice[i][j] < 0) {
                    throw new RuntimeException("Invalid value");
                }
            }
        }

    }

    //#endregion

    //#region Static methods

    /**
     * Takes two matrices and a MatriceOperation to apply to them to
     * @return the resulting matrix
     */
    public static Matrice operate(Matrice a, MatriceOperation op, Matrice b) {
        return op.process(a, b);
    }

    //#endregion

    public void printMatrice() {
        // Get the number of digits
        int nbDigits = Integer.toString(modulo).length();
        for (int[] ints : matrice) {

            for (int val : ints) {
                System.out.printf("%" + nbDigits + "s ", val);
            }
            System.out.println();

        }
    }

    //#region getter/setters

    public int getModulo() {
        return modulo;
    }

    public int[][] getMatrice() {
        return matrice;
    }
    public int getHeight() {
        return matrice.length;
    }
    public int getWidth() {
        return matrice[0].length;
    }

    //#endregion
}
