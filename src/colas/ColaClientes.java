package colas;

public class ColaClientes {

	NodoCliente head;
	NodoCliente tail;
	int tama�o = 0;
	
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
		tama�o++;
	}
	
	public Cliente dequeue() {
		if(head == null) {
			return null;
		}
		
		Cliente cliente = head.cliente;
		head = head.next;
		
		tama�o--;
		return cliente;
	}
	
}
