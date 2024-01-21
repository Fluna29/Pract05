package prog05_ejerc1_util;

import java.time.LocalDate;


import prog05_ejerc1.Vehiculo;

/**
 *
 * @author fluna
 */
public class validadores {

    private static Vehiculo vehiculo = null; //TODO: Cannot invoke "prog05_ejerc1.Vehiculo.getKilometros()" because "prog05_ejerc1_util.validadores.vehiculo" is null
    
    public static void validadorKilometros(double kilometros){
        if (kilometros < 0 || kilometros <= vehiculo.getKilometros()) {
            throw new IllegalArgumentException("\nEl número de kilómetros debe de ser superior a 0.\nEl número debe de ser superior al anterior kilometraje, el anterior kilometraje es : " + vehiculo.getKilometros() );
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
