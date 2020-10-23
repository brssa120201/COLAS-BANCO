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
	
}
