/**
 * Clase que define vehículos.
 */
public class Vehicle {
    // Campos de la clase.
    private String plate;
    private String type;

    /**
     * Constructor para un vehículo.
     * @param type Tipo de vehículo (coche o camión).
     * @param plate Matrícula del vehículo.
     */
    Vehicle(String type, String plate) {
        this.type = type;
        this.plate = plate;
    }

    /**
     * Método que establece el tipo del objeto.
     * @param type Tipo de vehículo (coche o camión).
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * Método que establece la matrícula del objeto.
     * @param plate Matrícula del vehículo.
     */
    public void setPlate(String plate) {
        this.plate = plate;
    }

    /**
     * Método que devuelve el tipo de vehículo.
     * @return Tipo de vehículo.
     */
    public String getType() {
        return type;
    }

    /**
     * Método que devuelve la matrícula del vehículo.
     * @return Matrícula del vehículo.
     */
    public String getPlate() {
        return plate;
    }
}
