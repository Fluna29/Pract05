package prog05_ejerc1;

import prog05_ejerc1_util.validadores;
import prog05_ejerc1.Vehiculo;
import java.time.LocalDate;
import java.util.Scanner;

/**
 *  En esta clase vamos a inicializar nuestro programa.
 *  Incluyendo en el nuestra clase vehículo, haciendo import de él.
 *  @author Francisco Luna Raya
 */
public class Principal {

    static Vehiculo vehiculo = null;
    static Scanner scanner = new Scanner(System.in);
    static LocalDate fechaMatriculacion = null;
    
    public static void main(String[] args){
        
        
        int eleccion;
        

        do{
            menu();
            eleccion = scanner.nextInt();
            scanner.nextLine();
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
            }
            
            
        }while(eleccion != 9);
        
        //Cerramos el scanner creado puesto que ya no se va a usar más y así evitamos un leak de recursos.
        scanner.close();
        
    }

    private static void menu(){
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

    private static void crearVehiculo() {
        vehiculo = new Vehiculo();

        System.out.println("-----Ingrese los datos del vehículo:-----");
        System.out.println("\n1. Ingrese la marca del vehículo:");
        String marca = scanner.nextLine();
        vehiculo.setMarca(marca);
        scanner.nextLine();
        
        
        System.out.println("\n2. Ingrese la matrícula del vehículo");
        String matricula = scanner.nextLine();
        vehiculo.setMatricula(matricula);
        scanner.nextLine();
        

        boolean kilometrosValidos = false;
        do{
            System.out.println("\n3. Ingrese los kilómetros del vehículo");
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

        boolean fechaValida = false;
        do {
            System.out.println("\n4. Ingrese la fecha de matriculación del vehículo");
            System.out.println("\n4.1 Ingrese el dia de matriculación del vehículo");
            int dia = scanner.nextInt();
            scanner.nextLine();
            

            System.out.println("\n4.2 Ingrese el mes de matriculación del vehículo");
            int mes = scanner.nextInt();
            scanner.nextLine();
            

            System.out.println("\n4.3 Ingrese el año de matriculación del vehículo");
            int anio = scanner.nextInt();
            scanner.nextLine();
            
            try {
                fechaMatriculacion = LocalDate.of(anio, mes, dia);
                validadores.validadorFecha(fechaMatriculacion);
                fechaValida = true;
                vehiculo.setFechaMatriculacion(fechaMatriculacion);
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
            scanner.nextLine();
        } while (!fechaValida);
        

        System.out.println("\n5. Ingrese la descripción del vehículo");
        String descripcion = scanner.nextLine();
        vehiculo.setDescripcion(descripcion);
        scanner.nextLine();

        System.out.println("\n6. Ingrese el precio del vehículo");
        double precio = scanner.nextDouble();
        vehiculo.setPrecio(precio);
        scanner.nextLine();

        System.out.println("\n7. Ingrese el nombre del propietario del vehículo");
        String nombrePropietario = scanner.nextLine();
        vehiculo.setNombrePropietario(nombrePropietario);
        scanner.nextLine();

        System.out.println("\n8. Ingrese el DNI del propietario del vehículo");
        String dniPropietario = scanner.nextLine();
        vehiculo.setDniPropietario(dniPropietario);
        scanner.nextLine();
    }

    private static void verMatricula(){
        System.out.println("\nLa matrícula del vehículo es: " + vehiculo.getMatricula());
        scanner.nextLine();
    }
    private static void verKilometros(){
        System.out.println("\nEl vehículo lleva recorridos: " + vehiculo.getKilometros() + " km");
        scanner.nextLine();
    }
    private static void actualizaKilometros(){ //TODO: ACTUALIZAR EL VALIDADOR PARA QUE SI ES UN NUMERO ERRONEO NO SE ACTUALICE Y ME SALGA EL ERROR.
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
    private static void verAntiguedad(){
        System.out.println("\nEl vehículo tiene " + vehiculo.getAnios() + " años");
        scanner.nextLine();
    }
    private static void verPropietario(){
        System.out.println("\nEl nombre del propietario es : " + vehiculo.getNombrePropietario());
        System.out.println("\nEl DNI del propietario es: " + vehiculo.getDniPropietario());
        scanner.nextLine();
    }
    private static void verDescripcion(){
        System.out.println("\nMatrícula del vehículo: " + vehiculo.getMatricula());
        System.out.println("\nKilómetros del vehículo: " + vehiculo.getKilometros() + " km");
        System.out.println("\nDescripción del Vehículo: " + vehiculo.getDescripcion() + ".");
        scanner.nextLine();
    }
    private static void verPrecio(){
        System.out.println("\nEl vehículo tiene un valor de " + vehiculo.getPrecio() + " $");
        scanner.nextLine();
    }

}