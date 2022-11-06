package Labo5;

public class Main {
    // TODO ARGS
    public static void main(String[] args) {
        int modulus = 5;

        System.out.println("The modulus is " + modulus);

        System.out.println("one:");
        int height1 = 4;
        int width1 = 4;
        Matrice one = new Matrice(width1, height1, modulus);
        one.printMatrice();


        System.out.println("two:");
        int height2 = 4;
        int width2 = 4;
        Matrice two = new Matrice(width2, height2, modulus);
        two.printMatrice();


        System.out.println("one + two:");
        MatriceAddition addition = new MatriceAddition();
        Matrice.operate(one, addition, two).printMatrice();


        System.out.println("one - two:");
        MatriceSoustraction soustraction = new MatriceSoustraction();
        Matrice.operate(one, soustraction, two).printMatrice();


        System.out.println("one x two:");
        MatriceMultiplication multiplication = new MatriceMultiplication();
        Matrice.operate(one, multiplication, two).printMatrice();
    }
}