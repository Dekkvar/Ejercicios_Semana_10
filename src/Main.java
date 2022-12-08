/**
 * Parking
 *
 * @author Aitor Couñago Figueroa
 * @version 1.0.0
 */
public class Main {
    public static void main(String[] args) {
        int action = -1;
        System.out.println("Bienvenido al Parking!");
        System.out.println("Seleccione el tamaño del parking introduciendo un número:");
        Vehicle[] parking = new Vehicle[Input.num()];
        System.out.println("Su parking tiene " + parking.length + " plazas.");

        while (action != 0) {
            System.out.println("\nSeleccione una acción a realizar introduciendo el número correspondiente: " +
                    "\n1 - Introducir un vehículo. " +
                    "\n2 - Consultar un vehículo o plaza. " +
                    "\n3 - Retirar un vehículo. " +
                    "\n0 - Salir.");
            action = Input.num();

            switch (action) {
                case 0: // Salir del programa.
                    int confirm = -1;
                    do {
                        System.out.println("\nSi abandona el parking se perderan todos los datos. ¿Está seguro que desea salir?: " +
                                "\n0 - Sí, salir. " +
                                "\n1 - No, quedarme.");
                        confirm = Input.num();
                        if (confirm == 1) {
                            action = -1;
                        } else if (confirm != 0) {
                            System.out.println("[Error]: Seleccione una de las opciones válidas.");
                        }
                    } while (confirm != 0 && confirm != 1);
                    break;
                case 1: // Introducir un vehículo.
                    int select = -1;
                    int numSpaces = 0;
                    int truckSpaces = 0;
                    String type = "";
                    String plate = "";

                    // Se comprueban las plazas libres en el parking.
                    for (int i = 0; i < parking.length; i++) {
                        if (parking[i] == null) {
                            numSpaces++;
                            if (i != parking.length - 1 && parking[i+1] == null) {
                                truckSpaces++;
                            }
                        }
                    }

                    if (numSpaces == 0) {
                        System.out.println("El parking está lleno!");
                        break;
                    }

                    do {
                        System.out.println("\n¿Desea introducir un vehículo manualmente o aleatorio?: " +
                                "\n1 - Manualmente. " +
                                "\n2 - Aleatorio. " +
                                "\n0 - Volver atrás.");
                        select = Input.num();
                        if (select != 1 && select != 2 && select != 0) {
                            System.out.println("[Error]: Acción no válida. Por favor seleccione una acción válida.");
                        } else if (select == 1) { // Introducir vehículo manualmente.
                            int selectType = -1;

                            do {
                                System.out.println("\n¿Qué tipo de vehículo desea aparcar?: " +
                                        "\n1 - Coche. " +
                                        "\n2 - Camión. " +
                                        "\n0 - Volver atrás.");

                                selectType = Input.num();
                                if (selectType == 1) {
                                    System.out.println("\nPor favor, introduzca la matrícula del coche:");
                                    plate = Input.str().toUpperCase();
                                    type = "coche";
                                    selectType = 0;
                                } else if (selectType == 2) {
                                    if (numSpaces == 1 || truckSpaces == 0) {
                                        System.out.println("No hay plazas suficientes para un camión.");
                                    } else {
                                        System.out.println("\nPor favor, introduzca la matrícula del camión:");
                                        plate = Input.str().toUpperCase();
                                        type = "camión";
                                    }
                                    selectType = 0;
                                } else if (selectType != 0){
                                    System.out.println("[Error]: Acción no válida. Por favor seleccione una acción válida.");
                                }
                            } while (selectType != 0);

                            Vehicle newVehicle = new Vehicle(type, plate);

                            // Comprobar si el vehículo que se intenta introducir ya existe y si no, lo guarda en el parking.
                            for (int i = 0; i < parking.length; i++) {
                                if (parking[i] != null && parking[i].getPlate().equals(plate)) {
                                    System.out.println("Ya existe un vehículo con esa matrícula en el parking.");
                                    break;
                                } else if (type.equals("coche") && parking[i] == null) {
                                    parking[i] = newVehicle;
                                    System.out.println("Se ha aparcado el " + newVehicle.getType() + " con la matrícula " + newVehicle.getPlate() + " en la plaza nº" + i + ".");
                                    break;
                                } else if (type.equals("camión") && parking[i] == null && parking[i+1] == null) {
                                    parking[i] = newVehicle;
                                    parking[i+1] = newVehicle;
                                    System.out.println("Se ha aparcado el " + newVehicle.getType() + " con la matrícula " + newVehicle.getPlate() + " en la plaza nº" + i + ".");
                                    break;
                                }
                            }
                            break;

                        } else if (select == 2) { // Introducir vehículo aleatorio.
                            if (truckSpaces == 0) {
                                type = "coche";
                            } else {
                                type = Randomizer.type();
                            }

                            // Randomizar la matrícula y comprobar que no exista ya un vehículo con esa matrícula.
                            boolean copy = false;

                            do {
                                plate = Randomizer.plate();

                                for (Vehicle vehicle : parking) {
                                    if (vehicle != null && vehicle.getPlate().equals(plate)) {
                                        copy = true;
                                        break;
                                    }
                                }
                            } while (copy);

                            Vehicle newVehicle = new Vehicle(type, plate);

                            for (int i = 0; i < parking.length; i++) {
                                if (parking[i] == null && type.equals("coche")) {
                                    parking[i] = newVehicle;
                                    System.out.println("Se ha aparcado el " + newVehicle.getType() + " con la matrícula " + newVehicle.getPlate() + " en la plaza nº" + i + ".");
                                    break;
                                } else if (type.equals("camión") && parking[i] == null && parking[i+1] == null) {
                                    parking[i] = newVehicle;
                                    parking[i + 1] = newVehicle;
                                    System.out.println("Se ha aparcado el " + newVehicle.getType() + " con la matrícula " + newVehicle.getPlate() + " en la plaza nº" + i + ".");
                                    break;
                                }
                            }
                            break;
                        }
                    } while (select != 0);
                    break;
                case 2: // Consultar un vehículo o plaza.
                    int select2 = -1;

                    while (select2 != 0) {
                        System.out.println("\n¿Desea consultar una plaza o buscar un vehículo?: " +
                                "\n1 - Consultar plaza. " +
                                "\n2 - Buscar vehículo. " +
                                "\n0 - Volver atrás.");
                        select2 = Input.num();
                        if (select2 == 1) { // Consultar una plaza.
                            System.out.println("\nLa primera plaza del parking es la 0 y la última es la " + (parking.length - 1) + ". \nIntroduzca el número de plaza que desea consultar:");
                            int query = Input.num();
                            if (query < 0 || query > parking.length -1) {
                                System.out.println("[Error]: La plaza introducida no existe.");
                            } else if (parking[query] == null) {
                                System.out.println("La plaza nº" + query + " se encuentra vacía.");
                            } else {
                                System.out.println("En la plaza nº" + query + " se encuentra el " + parking[query].getType() + " con la matrícula " + parking[query].getPlate() + ".");
                            }
                        } else if (select2 == 2) { // Buscar un vehículo por su matrícula.
                            System.out.println("Introduzca la matrícula del vehículo que desea buscar:");
                            String queryPlate = Input.str().toUpperCase();
                            for (int i = 0; i < parking.length; i++) {
                                if (parking[i] != null && parking[i].getPlate().equals(queryPlate)) {
                                    System.out.println("El vehículo con matrícula " + queryPlate + " es un " + parking[i].getType() + " que se encuentra estacionado en la plaza " + i + ".");
                                    break;
                                } else if (i == parking.length-1 && (parking[i] == null || !parking[i].getPlate().equals(queryPlate))) {
                                    System.out.println("El vehículo que busca no se encuentra en el parking.");
                                }
                            }
                        } else if (select2 != 0) {
                            System.out.println("[Error]: Seleccione una opción válida.");
                            select2 = -1;
                        }
                    }
                    break;
                case 3: // Retirar un vehículo del parking.
                    int select3 = -1;

                    do {
                        int emptyPark = 0;
                        for (Vehicle v: parking) {
                            if (v == null) {
                                emptyPark++;
                            }
                        }

                        if (emptyPark == parking.length) {
                            System.out.println("El parking está vacio, no hay ningún vehículo para retirar.");
                            break;
                        }

                        System.out.println("\n¿Desea retirar un vehículo específico o aleatorio?: " +
                                "\n1 - Retirar vehículo por matrícula. " +
                                "\n2 - Retirar vehículo de una plaza. " +
                                "\n3 - Retirar vehículo aleatorio. " +
                                "\n0 - Volver atrás.");

                        select3 = Input.num();

                        if (select3 == 1) { // Retirar vehículo por matrícula.
                            System.out.println("Introduzca la matrícula del vehículo que desea retirar:");
                            String removePlate = Input.str().toUpperCase();

                            for (int i = 0; i < parking.length; i++) {
                                if (parking[i] != null && parking[i].getPlate().equals(removePlate)) {
                                    System.out.println("Se ha retirado el " + parking[i].getType() + " con matrícula " + removePlate + " de la plaza nº" + i + ".");
                                    if (parking[i].getType().equals("camión")) {
                                        parking[i + 1] = null;
                                    }
                                    parking[i] = null;
                                    break;
                                } else if (i == parking.length-1) {
                                    System.out.println("El vehículo con matrícula " + removePlate + " no se encuentra en el parking.");
                                }
                            }
                        } else if (select3 == 2) { // Retirar vehículo de una plaza.
                            System.out.println("\nLa primera plaza del parking es la 0 y la última es la " + (parking.length - 1) + "\nIntroduzca la plaza que desea dejar libre:");
                            int removePark = Input.num();

                            if (removePark < 0 || removePark > parking.length-1) {
                                System.out.println("[Error]: La plaza introducida no existe.");
                            } else {
                                String msgPark = RemoveByPark.park(parking, removePark);
                                System.out.println(msgPark);
                            }
                        } else if (select3 == 3) { // Retirar vehículo aleatorio.
                            int removeRandomPark = -1;
                            boolean fullPark = false;

                            do {
                                removeRandomPark = Randomizer.num(parking.length);
                                if (parking[removeRandomPark] != null) {
                                    fullPark = true;
                                }
                            } while (!fullPark);

                            String msgRandom = RemoveByPark.park(parking, removeRandomPark);
                            System.out.println(msgRandom);
                        }

                        int changedCapacity = 0;
                        for (Vehicle v: parking) {
                            if (v == null) {
                                changedCapacity++;
                            }
                        }
                        if (changedCapacity != emptyPark) {
                            break;
                        }
                    } while (select3 != 0);

                    break;
                default:
                    System.out.println("[Error]: No ha seleccionado una acción válida. Por favor seleccione una de las opciones dadas.");
                    action = -1;
            }
        }
    }
}
