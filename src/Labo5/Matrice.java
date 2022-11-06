package Labo5;

public class Matrice {

    private final int[][] matrice;
    private final int     modulo;

    //#region Constructors

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

    public Matrice(int[][] matrice, int modulo) {
        this.matrice = matrice;
        this.modulo  = modulo;
        checkDimensions();
        checkModulo();
    }

    public Matrice(Matrice matrice) {
        this.matrice = matrice.matrice;
        this.modulo  = matrice.modulo;
        checkModulo();
    }

    /**
     * Throws runtime exception if matrix has an invalid value (less than 1 in size)
     */
    public void checkDimensions() {
        if (matrice.length == 0 || matrice[0].length == 0) {
            throw new RuntimeException("Invalid matrice size");
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
