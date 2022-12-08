public class RemoveByPark {
    /**
     * Comprueba que vehículo está aparcado en una plaza.
     * @param parking en el que están aparcados los vehículos.
     * @param num plaza que se desea consultar.
     * @return mensaje con el resultado de la consulta.
     */
    public static String park(Vehicle[] parking, int num) {
        String msg = "";

        if (parking[num] != null) {
            msg = "Se ha retirado el " + parking[num].getType() + " con matrícula " + parking[num].getPlate() + " de la plaza nº" + num + ".";

            if (parking[num].getType().equals("camión")) {
                if (num == 0 || (num != parking.length - 1 && parking[num + 1] != null && parking[num+1].getPlate().equals(parking[num].getPlate()))) {
                    parking[num + 1] = null;
                } else {
                    parking[num - 1] = null;
                }
            }
            parking[num] = null;
        } else {
            msg = "La plaza ya está vacía.";
        }

        return msg;
    }
}
