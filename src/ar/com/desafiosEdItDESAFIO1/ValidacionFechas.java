package ar.com.desafiosEdItDESAFIO1;
//importamos el teclado
import java.util.Scanner;

public class ValidacionFechas {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		//Solicitamos la fecha
		System.out.print("Ingrese una fecha (dd/mm/yyyy): ");
		String teclado = scanner.nextLine();
		
		//Agregamos separador para que el escribirlo cumpla el sistema "dd/mm/yyyy"
		//por lo que tengo que usar Integer.parseInt() para que el dato sea Int,
		//aunque sea un array de tipo String.(No es de tipo int el array xq no me dejaria usar "/")
		String[] partesFecha = teclado.split("/");
	    int dia = Integer.parseInt(partesFecha[0]);
	    int mes = Integer.parseInt(partesFecha[1]);
	    int anio = Integer.parseInt(partesFecha[2]);
	    
	    if (validarDia(dia, mes, anio) && validarMes(mes) && validarAnio(anio)) {
	    	//buscando que toda la validacion sea true
	        System.out.println("La fecha es válida.");
	    } else {
	        System.out.println("La fecha no es válida.");
	    }
	    
	    //cerramos el teclado
	    scanner.close();
	    
	    }//cierre del main
	
	    //validaciones:(t/f) 
	    
	    //función para validar el anio
	    public static boolean validarAnio(int año) {
	        return año >= 1900 && año <= 2099;
	    }
	    
	    //función para validar el mes
	    public static boolean validarMes(int mes) {
	        return mes >= 1 && mes <= 12;
	    }
	    
	    //función para determinar si el año es bisiesto
	    //dividimos el anio en 4, si da resto 0 es bisiesto
	    public static boolean esAnioBisiesto(int anio) {
	        return (anio % 4 == 0);
	    }
	    
	    //función para validar el día teniendo en cuenta el mes y el año bisiesto
	    public static boolean validarDia(int dia, int mes, int anio) {
	        if (mes >= 1 && mes <= 12) {
	            if (mes == 2) {
	                if (esAnioBisiesto(anio)) {
	                    return dia >= 1 && dia <= 29;
	                } else {
	                    return dia >= 1 && dia <= 28;
	                }
	            } else if (mes == 4 || mes == 6 || mes == 9 || mes == 11) {
	                return dia >= 1 && dia <= 30;
	            } else {
	                return dia >= 1 && dia <= 31;
	            }
	        } else {
	            return false;
	        }
	    }
	
}