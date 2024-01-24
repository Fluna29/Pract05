package prog05_ejerc1_util;

import java.time.LocalDate;
import prog05_ejerc1.Principal;


import prog05_ejerc1.Vehiculo;

/**
 * En esta clase vamos a incorporar una serie de validadores,
 * para poder evitar diferentes casos que no queremos que se den en nuestro progama.
 * @author Francisco Luna
 */
public class validadores {

    //Nos retorna un error en caso de que los kilometros introducidos sean superiores al anterior kilometraje introducido.
    public static void validadorKilometros(double kilometros){
        if (kilometros <= Principal.vehiculo.getKilometros() ) {
            throw new IllegalArgumentException("\nEl número debe de ser superior al anterior kilometraje, el anterior kilometraje es : " + Principal.vehiculo.getKilometros());
            } 
        }
        //Nos retorna un error en caso de que los kilometros iniciales sean superiores a 0.
    public static void validadorKilometrosInicial(double kilometros){
        if (kilometros < 0) {
            throw new IllegalArgumentException("\nEl número de kilómetros debe de ser superior a 0.");
            } 
        }
    //Nos retorna un error en caso de que la fecha introducida sea posterior a la actual.
    public static void validadorFecha(LocalDate fechaMatriculacion){
        if(fechaMatriculacion.isAfter(LocalDate.now())){
            throw new IllegalArgumentException("\nLa fecha debe de ser anterior a la actual. La fecha actual es: " + LocalDate.now());
        }
    }
     //Nos retorna un error en caso de que el DNI sea igual al regex que hemos realizado
    public static void validadorDni(String dniPropietario){

        String dniMayus = dniPropietario.toUpperCase();
        if (!dniMayus.matches("^[0-9]{7,8}[T|R|W|A|G|M|Y|F|P|D|X|B|N|J|Z|S|Q|V|H|L|C|K|E]$")){
            throw new IllegalArgumentException("\nEl DNI es incorrecto, el DNI debe incluir 8 números y 1 letra válida.");
        }
        
        
    }


}
