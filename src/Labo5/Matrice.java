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

        checkValues();
        checkModulo();
    }

    public Matrice(int[][] matrice, int modulo) {
        this.matrice = matrice;
        this.modulo  = modulo;
        // TODO Check correct values
        checkValues();
        checkModulo();
    }

    public Matrice(Matrice matrice) {
        this.matrice = matrice.matrice;
        this.modulo  = matrice.modulo;
        checkValues();
        checkModulo();
    }

    /**
     * Throws runtime exception if matrice has an invalid value (less than 1 in size)
     */
    public void checkValues() {
        if (matrice.length == 0 || matrice[0].length == 0) {
            throw new RuntimeException("Invalid matrice size");
        }
    }

    /**
     * Throws runtime exception if matrice has a value higher than modulo
     */
    public void checkModulo(){

        for (int i = 0; i < matrice[0].length; ++i) {
            for (int j = 0; j < matrice.length; ++j)
            {
                if(matrice[i][j] > modulo - 1) {
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
        StringBuilder temp = new StringBuilder();
        for (int[] ints : matrice) {

            temp.append(" { ");
            for (int val : ints) {
                temp.append(val).append(" ");
            }

            temp.append("}");

        }

        return temp.toString();
    }
    public void printMatrice() {
        System.out.println(matrice);
    }
}
