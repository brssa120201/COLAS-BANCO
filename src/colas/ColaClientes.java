package colas;

public class ColaClientes {

	NodoCliente head;
	NodoCliente tail;
	int tamaño = 0;
	
	public void enqueue(Cliente cliente) {
		NodoCliente nuevo = new NodoCliente();
		nuevo.cliente = cliente;
		
		if(head == null) {
			head = nuevo;
			tail = nuevo;
		}
		else {
			tail.next = nuevo;
			tail = nuevo;
		}
		tamaño++;
	}
	
	public Cliente dequeue() {
		if(head == null) {
			return null;
		}
		
		Cliente cliente = head.cliente;
		head = head.next;
		
		tamaño--;
		return cliente;
	}
	
	public void insertarPrioridad(Cliente cliente, int prioridad) {
		if(prioridad >= 0 && prioridad < tamaño) {
			NodoCliente nuevo = new NodoCliente();
			nuevo.cliente = cliente;
			if(prioridad == 1) {
				nuevo.next = head;
				head = nuevo;	
			} if(prioridad == 2) {
				nuevo.next = head.next;
				head.next = nuevo;
			}
			else {
				if(prioridad == tamaño) {
					NodoCliente tmp = head;
					while(tmp.next == null) {
						tmp = null;
					}
				}
				else {
					NodoCliente tmp = head;
					for(int i = 0; i < (prioridad - 1); i++) {
						tmp = tmp.next;
					}
					NodoCliente next = tmp.next;
					tmp.next = nuevo;
					nuevo.next = next;
				}
			}
			tamaño++;
		}
	}
	
	//Para imprimir los datos de las colas
	public void imprimir() {
		NodoCliente tmp = head;
		while(tmp != null) {
			System.out.println(tmp.cliente.documento+ " , " +tmp.cliente.nombre+ " , " +tmp.cliente.valorConsignar);
			tmp = tmp.next;
		}
	}
}
