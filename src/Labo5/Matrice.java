package Labo5;

public class Matrice {

    private int[][] matrice;
    private int     modulo;

    //#region Constructors

    public Matrice(int length, int height, int modulo) {
        // TODO Random generation
    }
    public Matrice(int[][] matrice, int modulo) {
        this.matrice = matrice;
        this.modulo  = modulo;
        // TODO Check correct values

    }

    public Matrice(Matrice matrice) {
        this.matrice = matrice.matrice;
        this.modulo  = matrice.modulo;
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
