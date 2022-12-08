import java.util.Scanner;

/**
 * Agrupación de distintos métodos de inserción por consola.
 */
public class Input {
    /**
     * Introducir un número por consola.
     * @return El número introducido.
     */
    public static int num() {
        Scanner inputNum = new Scanner(System.in);
        return inputNum.nextInt();
    }

    /**
     * Introducir una cadena por consola.
     * @return La cadena introducida.
     */
    public static String str() {
        Scanner inputStr = new Scanner(System.in);
        return inputStr.nextLine();
    }
}
