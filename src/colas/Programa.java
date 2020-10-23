package colas;

public class Programa {

	public static void main(String[] args) {
		
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
		
	public static ColaClientes fillStack() {
			
		ColaClientes colaClientes = new ColaClientes();
		
		//Clientes operacion enqueue
		Cliente c1 = new Cliente();
		c1.documento = "1";
		c1.nombre = "Susana";
		c1.valorConsignar = 100;
		
		Cliente c2 = new Cliente();
		c2.documento = "2";
		c2.nombre = "Pedro";
		c2.valorConsignar = 200;
		
		Cliente c3 = new Cliente();
		c3.documento = "3";
		c3.nombre = "Leonardo";
		c3.valorConsignar = 300;
		
		Cliente c4 = new Cliente();
		c4.documento = "4";
		c4.nombre = "Camila";
		c4.valorConsignar = 400;
		
		Cliente c5 = new Cliente();
		c5.documento = "5";
		c5.nombre = "Luz";
		c5.valorConsignar = 500;
			
		//Clientes operacion insertar por prioridad
		Cliente c6 = new Cliente();
		c6.documento = "6";
		c6.nombre = "Michelle";
		c6.valorConsignar = 250;
		
		Cliente c7 = new Cliente();
		c7.documento = "7";
		c7.nombre = "Camilo";
		c7.valorConsignar = 350;
		
		Cliente c8 = new Cliente();
		c8.documento = "8";
		c8.nombre = "Juan";
		c8.valorConsignar = 550;
		
		colaClientes.enqueue(c5);
		colaClientes.enqueue(c4);
		colaClientes.enqueue(c3);
		colaClientes.enqueue(c2);
		colaClientes.enqueue(c1);
		
		colaClientes.insertarPrioridad(c6, 1);
		colaClientes.insertarPrioridad(c7, 2);
		colaClientes.insertarPrioridad(c8, 1);
		 
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
