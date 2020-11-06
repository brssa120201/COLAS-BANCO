package colas;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Programa {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		System.out.println();
		System.out.println("------------------ COLA CLIENTES ------------------");
		System.out.println();
		
		ColaClientes colaClientes = fillStack();
		float consignaciones = valorTotalComisiones(colaClientes);
		System.out.println("Valor total del banco en consignaciones: " +consignaciones);
				
		colaClientes = fillStack();
		float promedio = promedio(colaClientes);
		System.out.println("El promedio de los valores de consignacion es: " +promedio);
		
		colaClientes = fillStack();
		float mayorConsignacion = clienteMayorConsignacion(colaClientes);
		System.out.println("El valor de consignacion mas alto es de: " +mayorConsignacion);
				
		colaClientes = fillStack();
		float menorConsignacion = clienteMenorConsignacion(colaClientes);
		System.out.println("El valor de consignacion mas pequeño es de: " +menorConsignacion);
		System.out.println();
		
	}
		
	public static ColaClientes fillStack() throws NumberFormatException, IOException {
			
		ColaClientes colaClientes = new ColaClientes();
		
		BufferedReader bf = new BufferedReader(new FileReader("cliente.csv"));
		int cantClientes = Integer.parseInt(bf.readLine());
		for(int i=0; i<cantClientes; i++) {
			String[] datosCliente = bf.readLine().split(",");
			Cliente cliente = new Cliente();
			cliente.documento = datosCliente[0];
			cliente.nombre = datosCliente[1];
			cliente.valorConsignar = Float.parseFloat(datosCliente[2]);
			colaClientes.enqueue(cliente);
		}
		 
		//colaClientes.imprimir();
		//System.out.println();
		
		return colaClientes;
	}	
	
	//VALOR TOTAL EN CONSIGNACIONES DEL BANCO
	public static float valorTotalComisiones(ColaClientes colaClientes) {
		float consignaciones = 0;
		while(colaClientes.tamaño > 0) {
			Cliente c = colaClientes.dequeue();
			consignaciones = consignaciones + c.valorConsignar;
		}
		return consignaciones;
	}
	
	//PROMEDIO DE CONSIGNACIONES DEL BANCO
	public static float promedio(ColaClientes colaClientes) {
		float promedio = 0;
		int cantClientes = 0;
		while(colaClientes.tamaño > 0) {
			Cliente c = colaClientes.dequeue();
			promedio = promedio + c.valorConsignar;
			cantClientes = cantClientes + 1;
		}
		return promedio / cantClientes;
	}
	
	//CLIENTE CON MAYOR CONSIGNACION EN EL BANCO
	public static float clienteMayorConsignacion(ColaClientes colaClientes) {
		float mayor = colaClientes.dequeue().valorConsignar;
		while(colaClientes.tamaño > 0) {
			float mayorConsignacion = colaClientes.dequeue().valorConsignar;
			if(mayorConsignacion > mayor) {
				mayor = mayorConsignacion;
			}
		}
		return mayor;
	}
	
	//CLIENTE CON MENOR CONSIGNACION EN EL BANCO
	public static float clienteMenorConsignacion(ColaClientes colaClientes) {
		float menor = colaClientes.dequeue().valorConsignar;
		while(colaClientes.tamaño > 0) {
			float menorConsiganciones = colaClientes.dequeue().valorConsignar;
			if(menorConsiganciones < menor) {
				menor = menorConsiganciones;
			}
		}
		return menor;
	}
}
