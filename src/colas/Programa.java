package colas;

public class Programa {

	public static void main(String[] args) {
		
		ColaClientes colaClientes = fillStack();
		float consignaciones = valorTotalComisiones(colaClientes);
		System.out.println("Valor total del banco en consignaciones: " +consignaciones);
		
		colaClientes = fillStack();
		float mayorConsignacion = clienteMayorConsignacion(colaClientes);
		System.out.println("El valor de consignacion mas alto es de: " +mayorConsignacion);
		
		colaClientes = fillStack();
		float promedio = promedio(colaClientes);
		System.out.println("El promedio de los valores de consignacion es: " +promedio);
	}
		
	public static ColaClientes fillStack() {
			
		ColaClientes colaClientes = new ColaClientes();
		
		//Clientes operacion enqueue
		Cliente c1 = new Cliente();
		c1.documento = "1";
		c1.nombre = "Susana";
		c1.valorConsignar = 1000;
		
		Cliente c2 = new Cliente();
		c2.documento = "2";
		c2.nombre = "Pedro";
		c2.valorConsignar = 2000;
		
		Cliente c3 = new Cliente();
		c3.documento = "3";
		c3.nombre = "Leonardo";
		c3.valorConsignar = 3000;
		
		Cliente c4 = new Cliente();
		c4.documento = "4";
		c4.nombre = "Camila";
		c4.valorConsignar = 4000;
		
		Cliente c5 = new Cliente();
		c5.documento = "5";
		c5.nombre = "Luz";
		c5.valorConsignar = 5000;
		
		colaClientes.enqueue(c5);
		colaClientes.enqueue(c4);
		colaClientes.enqueue(c3);
		colaClientes.enqueue(c2);
		colaClientes.enqueue(c1);
		
	
		//Clientes operacion enqueue por prioridad
		Cliente cl1 = new Cliente();
		cl1.documento = "1";
		cl1.nombre = "Michelle";
		cl1.prioridad = "1";
		cl1.valorConsignar = 200;
		
		Cliente cl2 = new Cliente();
		cl2.documento = "2";
		cl2.nombre = "Camilo";
		cl2.prioridad = "2";
		cl2.valorConsignar = 300;
		
		
		
		return colaClientes;
	}	
	
	public static float valorTotalComisiones(ColaClientes colaClientes) {
		float consignaciones = 0;
		
		while(colaClientes.tamaño > 0) {
			Cliente c = colaClientes.dequeue();
			consignaciones = consignaciones + c.valorConsignar;
		}
		
		return consignaciones;
	}
	
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
	
	

}
