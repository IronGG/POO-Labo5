package Labo5;

public class Main {
    public static void main(String[] args) {
        if(args.length != 5)
            throw new RuntimeException("Invalid arguments count! Format : height1 width1 height2 width2 Modulo");
        int modulus = Integer.parseInt(args[0]);
        if(modulus <= 0)
            throw new RuntimeException("A modulus must be strictly positive");
        int height1 = Integer.parseInt(args[1]);
        int width1  = Integer.parseInt(args[2]);
        int height2 = Integer.parseInt(args[3]);
        int width2  = Integer.parseInt(args[4]);

        if(height1 <= 0 || width1 <= 0 || height2 <= 0 || width2 <= 0) {
            throw new RuntimeException("The matrix dimensions must be greater than 0");
        }

        System.out.println("The modulus is " + modulus);

        System.out.println("one:");
        Matrice one = new Matrice(width1, height1, modulus);
        one.printMatrice();
        System.out.println();


        System.out.println("two:");
        Matrice two = new Matrice(width2, height2, modulus);
        two.printMatrice();
        System.out.println();


        System.out.println("one + two:");
        MatriceAddition addition = new MatriceAddition();
        Matrice.operate(one, addition, two).printMatrice();
        System.out.println();


        System.out.println("one - two:");
        MatriceSoustraction soustraction = new MatriceSoustraction();
        Matrice.operate(one, soustraction, two).printMatrice();
        System.out.println();


        System.out.println("one x two:");
        MatriceMultiplication multiplication = new MatriceMultiplication();
        Matrice.operate(one, multiplication, two).printMatrice();
        System.out.println();
    }
}