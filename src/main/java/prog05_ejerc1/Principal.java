package prog05_ejerc1;

import java.time.LocalDate;
import java.util.Scanner;

import prog05_ejerc1_util.validadores;

/**
 *  En esta clase vamos a inicializar nuestro programa.
 *  Incluyendo en el nuestra clase vehículo, haciendo import de él.
 *  Además vamos a crear las funciones para crear el menú y crear las diferentes funcionalidades.
 *  @author Francisco Luna Raya
 */
public class Principal {

    public static Vehiculo vehiculo = null;
    static Scanner scanner = new Scanner(System.in);
    static LocalDate fechaMatriculacion = null;

    //En esta función main vamos a introducir la funcionalidad de nuestro menú y al finalizar el menu, cierra el scanner para evitar una fuga de recursos.
    public static void main(String[] args){

        int eleccion;
    
        do{
            menuVisual();
            eleccion = scanner.nextInt();
            scanner.nextLine();
            if (eleccion < 1 || eleccion > 9) {
                System.out.println("\nDebe introducir un número acorde al menú (1-9)");
                scanner.nextLine();
                
            }else{
                if (eleccion != 1 && vehiculo == null){
                    System.out.println("\nERROR, antes de realizar cualquier acción debe crear un vehículo.");
                    scanner.nextLine();
                }else{
    
                    switch (eleccion) {
                        case 1:
                            crearVehiculo();
                            break;
                        case 2:
                            verMatricula();
                            break;
                        case 3:
                            verKilometros();
                            break;
                        case 4:
                            actualizaKilometros();
                            break;
                        case 5:
                            verAntiguedad();
                            break;
                        case 6:
                            verPropietario();
                            break;
                        case 7:
                            verDescripcion();
                            break;
                        case 8:
                            verPrecio();
                            break;
                        case 9:
                            System.out.println("Hasta la próxima");
                            break;
                        default:
                            System.out.println("ERROR");
                            break;
                    }}
            }
        }while(eleccion != 9);
        scanner.close();
    }
    

    //Esta función sirve para llamar al menú visual.
    private static void menuVisual(){
        System.out.println("\n-----MENU-----");
        System.out.println("1. Nuevo Vehículo");
        System.out.println("2. Ver Matrícula");
        System.out.println("3. Ver Números de Kilómetros");
        System.out.println("4. Actualiza Kilómetros");
        System.out.println("5. Ver Años de Antigüedad");
        System.out.println("6. Mostrar Propietario");
        System.out.println("7. Mostrar descripción");
        System.out.println("8. Mostrar Precio");
        System.out.println("9. Salir");
    }


    //Esta función la vamos a usar para ingresar todos los datos necesarios para crear el objeto Vehiculo.
    private static void crearVehiculo() {
        vehiculo = new Vehiculo();

        System.out.println("-----Ingrese los datos del vehículo:-----");
        System.out.println("\n==== Ingrese la marca del vehículo: ====");
        String marca = scanner.nextLine();
        vehiculo.setMarca(marca);
        
        
        System.out.println("\n==== Ingrese la matrícula del vehículo ====");
        String matricula = scanner.nextLine();
        vehiculo.setMatricula(matricula);
        scanner.nextLine();
        

        boolean kilometrosValidos = false;
        do{
            System.out.println("\n ==== Ingrese los kilómetros del vehículo ====");
            double kilometros = scanner.nextDouble();
            
            try {
                validadores.validadorKilometrosInicial(kilometros);
                kilometrosValidos = true;
                vehiculo.setKilometros(kilometros);
            } catch (IllegalArgumentException ex) {                                                                                                             
                System.out.println(ex.getMessage());
            }
            scanner.nextLine();
            
        }while(!kilometrosValidos);


        boolean fechaValida = false;
        do {
            System.out.println("\n==== Ingrese el dia de matriculación del vehículo ====");
            int dia = scanner.nextInt();
            scanner.nextLine();
            
            System.out.println("\n==== Ingrese el mes de matriculación del vehículo ====");
            int mes = scanner.nextInt();
            scanner.nextLine();
            
            System.out.println("\n==== Ingrese el año de matriculación del vehículo ====");
            int anio = scanner.nextInt();
            scanner.nextLine();
            
            try {
                fechaMatriculacion = LocalDate.of(anio, mes, dia);
                validadores.validadorFecha(fechaMatriculacion);
                fechaValida = true;
                vehiculo.setFechaMatriculacion(fechaMatriculacion);
            } catch (IllegalArgumentException ex) {
                System.out.println(ex.getMessage());
            }
            scanner.nextLine();
        } while (!fechaValida);
        

        System.out.println("\n==== Ingrese la descripción del vehículo ====");
        String descripcion = scanner.nextLine();
        vehiculo.setDescripcion(descripcion);
        scanner.nextLine();


        System.out.println("\n==== Ingrese el precio del vehículo ====");
        double precio = scanner.nextDouble();
        vehiculo.setPrecio(precio);
        scanner.nextLine();


        System.out.println("\n==== Ingrese el nombre del propietario del vehículo ====");
        String nombrePropietario = scanner.nextLine();
        vehiculo.setNombrePropietario(nombrePropietario);
        scanner.nextLine();


        boolean dniValido = false;
        do{
            System.out.println("\n==== Ingrese el DNI del propietario del vehículo ====");
            String dniPropietario = scanner.nextLine();
                try {
                validadores.validadorDni(dniPropietario);
                dniValido = true;
                vehiculo.setDniPropietario(dniPropietario);
                } catch (IllegalArgumentException ex) {
                System.out.println(ex.getMessage());
            }
            scanner.nextLine();

        }while(!dniValido);
    }


    //Esta función nos retorna el valor de la matricula del vehiculo.
    private static void verMatricula(){
        System.out.println("\nLa matrícula del vehículo es: " + vehiculo.getMatricula());
        scanner.nextLine();
    }


    //Esta función nos retorna el valor de los kilometros establecidos actuales actuales del vehiculo.
    private static void verKilometros(){
        System.out.println("\nEl vehículo lleva recorridos: " + vehiculo.getKilometros() + " km");
        scanner.nextLine();
    }


    //Esta función la vamos a utilizar para actualizar los kilometros ya establecidos en nuestro objeto.
    private static void actualizaKilometros(){ 
        boolean kilometrosValidos = false;
        do{
            System.out.println("\nUsted va a actualizar los kilómetros del vehículo.");
            System.out.println("\nEl vehículo actual tiene : " + vehiculo.getKilometros() + " km");
            System.out.println("\nIntroduzca la nueva cantidad de kilómetros del vehículo, recuerde que esta cantidad solo puede ser superior a la anterior.");
            double kilometros = scanner.nextDouble();
            try {
                validadores.validadorKilometros(kilometros);
                kilometrosValidos = true;
                vehiculo.setKilometros(kilometros);
            } catch (IllegalArgumentException ex) {
                System.out.println(ex.getMessage());
            }
            scanner.nextLine();
        }while(!kilometrosValidos);
        
    }


    //Con esta función podemos ver la antigüedad del vehículo.
    private static void verAntiguedad(){
        System.out.println("\nEl vehículo tiene " + vehiculo.getAnios() + " años");
        scanner.nextLine();
    }

    
    //Esta función nos devuelve el nombre del propietario y el DNI.
    private static void verPropietario(){
        System.out.println("\nEl nombre del propietario es : " + vehiculo.getNombrePropietario());
        System.out.println("\nEl DNI del propietario es: " + vehiculo.getDniPropietario());
        scanner.nextLine();
    }


    //Esta función nos permite ver la descripción del vehiculo, además de la matrícula y los kilómetros.
    private static void verDescripcion(){
        System.out.println("\nMatrícula del vehículo: " + vehiculo.getMatricula());
        System.out.println("\nKilómetros del vehículo: " + vehiculo.getKilometros() + " km");
        System.out.println("\nDescripción del Vehículo: " + vehiculo.getDescripcion() + ".");
        scanner.nextLine();
    }


    //Esta función nos retorna el precio del vehiculo objeto.
    private static void verPrecio(){
        System.out.println("\nEl vehículo tiene un valor de " + vehiculo.getPrecio() + " $");
        scanner.nextLine();
    }

}