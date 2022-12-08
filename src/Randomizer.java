/**
 * Agrupación de los distintos métodos de randomizado.
 */
public class Randomizer {
    /**
     * Seleccionar un tipo de vehículo aleatoriamente.
     * @return Un tipo de vehículo aleatorio.
     */
    public static String type() {
        String type;
        int random = (int) Math.floor(Math.random()*2);

        if (random == 1) {
            type = "coche";
        } else {
            type = "camión";
        }

        return type;
    }

    /**
     * Seleccionar una matrícula aleatoria en formato español.
     * @return Una cadena con el valor de una matrícula aleatoria.
     */
    public static String plate() {
        String plate = "";
        for (int i = 0; i < 7; i++) {
            if (i < 4) {
                int num = (int) Math.floor(Math.random()*10);
                plate += num;
            } else {
                String letters = "BCDFGHJKLMNPRSTVWXYZ";
                char c = letters.charAt((int) Math.floor(Math.random()*(letters.length())));
                plate += c;
            }
        }

        return plate;
    }

    /**
     * Calcula un número aleatorio entre 0 y de otro número dado.
     * @param lenght Número máximo.
     * @return Número aleatorio.
     */
    public static int num(int lenght) {
        return (int) Math.floor(Math.random()*lenght);
    }
}
