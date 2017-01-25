/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**cas
 *
 * @author jose
 */
public class Examples {

    public static final String EXAMPLE_SUMA
            = "//Ejemplo de suma\n"
            + "//Cargamos al acumulador con la instruccion 1\n"
            + "1-900\n"
            + "//Sumamos al acumulador con la instruccion 5\n"
            + "5-901\n"
            + "//Guardamos en la poscion de memoria designada con la instruccion 2 desde el acumulador\n"
            + "2-903\n";

    public static final String EXAMPLE_RESTA
            = "//Ejemplo de resta\n"
            + "//Cargamos al acumulador con la instruccion 1\n"
            + "1-900\n"
            + "//Restamos al acumulador con la instruccion 6\n"
            + "6-901\n"
            + "//Guardamos en la poscion de memoria designada con la instruccion 2 desde el acumulador\n"
            + "2-903\n";

    public static final String EXAMPLE_SUMA_ABS
            = "//Ejemplo de suma absoluta\n"
            + "//Generamos un numero negativo a base de restas repetitivas\n"
            + "1-902\n"
            + "6-900\n"
            + "6-900\n"
            + "6-900\n"
            + "2-900\n"
            + "//Cargamos un numero negativo al acumulador\n"
            + "1-902\n"
            + "//Sumamos la memoria con valor absoluto con la instruccion 7\n"
            + "7-900\n"
            + "//Movemos el acumulador a una poscion de memoria\n"
            + "2-905\n";

    public static final String EXAMPLE_MULTIPLICACION
            = "//Ejemplo de multiplicacion\n"
            + "//Cargamos un valor al acumulador\n"
            + "1-901\n"
            + "//Multiplicamos por dos el valor del acumulador\n"
            + "//Nota: La posicion de memoria ingresada en la multiplicacion y suma sera la posicion en donde el resultado sera guardado\n"
            + "16-901\n";

}
