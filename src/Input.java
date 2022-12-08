import java.util.Scanner;

public class Input {
    /**
     * Introducir un número por consola.
     * @return el número introducido.
     */
    public static int num() {
        Scanner inputNum = new Scanner(System.in);
        return inputNum.nextInt();
    }

    /**
     * Introducir una cadena por consola.
     * @return la cadena introducida.
     */
    public static String str() {
        Scanner inputStr = new Scanner(System.in);
        return inputStr.nextLine();
    }
}
