package Labo5;

public class Matrice {

    private int[][] matrice;
    private int     modulo;

    //#region Constructors

    public Matrice(int length, int height, int modulo) {

        int[][] matrice = new int[length][height];
        // TODO Random generation
        for (int i = 0; i < length; ++i) {
            for(int j = 0; j < height; j++) {
                matrice[i][j] = (int)(Math.random()*modulo);
            }
        }

        this.matrice = matrice;
        this.modulo = modulo;

        checkDimensions();
        checkModulo();
    }

    public Matrice(int[][] matrice, int modulo) {
        this.matrice = matrice;
        this.modulo  = modulo;
        // TODO Check correct values
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

    public String toString() {

        System.out.println("The modulus is " + modulo);
        StringBuilder temp = new StringBuilder();
        for (int[] ints : matrice) {

            for (int val : ints) {
                temp.append(val).append(" ");
            }

            temp.append("\n");

        }

        return temp.toString();
    }
    public void printMatrice() {
        System.out.println(this);
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
