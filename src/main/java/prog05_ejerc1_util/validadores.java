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

    public static void validadorKilometros(double kilometros){
        if (kilometros <= Principal.vehiculo.getKilometros() ) {
            throw new IllegalArgumentException("\nEl número debe de ser superior al anterior kilometraje, el anterior kilometraje es : " + Principal.vehiculo.getKilometros());
            } 
        }
    public static void validadorKilometrosInicial(double kilometros){
        if (kilometros < 0) {
            throw new IllegalArgumentException("\nEl número de kilómetros debe de ser superior a 0.");
            } 
        }
    
    public static void validadorFecha(LocalDate fechaMatriculacion){
        if(fechaMatriculacion.isAfter(LocalDate.now())){
            throw new IllegalArgumentException("\nLa fecha debe de ser anterior a la actual. La fecha actual es: " + LocalDate.now());
        }
    }
    public static void validadorDni(String dniPropietario){ //TODO: Realizar la validación del DNI.
        
        
    }


}
