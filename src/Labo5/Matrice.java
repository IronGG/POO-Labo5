package Labo5;

import com.sun.source.tree.ReturnTree;
import jdk.jshell.EvalException;

public class Matrice {

    /*
    A lot of modulo repetitions, how to manage that.

    No line of code should be used twice so
    The parsing of Matrices can't be double

    display has to be a certain way
     */
    Matrice() {
        // Random generation to make ?

    }

    Matrice(int length, int height, int modulo) {
        // define modulo or whatever to random

        double test = Math.random();

        this.matrice = new int[][]{ {2, 3}, {3, 4}, {5, 6}, {5, 6} };
    }

    public Matrice(int[][] matrice) {
        this.matrice = matrice;
    }

    public Matrice(Matrice matrice) {
        this.matrice = matrice.matrice;
    }

    public String toString() {
        String temp = "";

        //return Integer.toString(matrice[0].length * matrice.length);

        // What if they all elements don't have the same array size ? { {2, 3, <5>}, {3, 4}, {5, 6}, {5, 6} }
        for (int i = 0; i < matrice.length; ++i) {

            temp += " { ";
            for (int val : matrice[i]) {
                temp += val + " ";
            }

            temp += "}";

        }

        return temp;
    }

    public void printMatrice() {
        System.out.println(matrice);
    }

    public int[][] getMatrice() {
        return matrice;
    }

    public void setMatrice(int[][] matrice) {
        this.matrice = matrice;
    }

    private int[][] matrice;
    int modulo;
}
