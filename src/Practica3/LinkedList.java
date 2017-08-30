// Gerardo López Chacón
// A01379707

package Practica3;

import java.util.NoSuchElementException;

public class LinkedList<E> implements List<E> {
	private Node<E> header;
	private int size;
	
	public LinkedList() {
		header = new Node<E>();
		size = 0;
	}
	
	/**
	 * Gets the node at the specified index.
	 * @param index the index of the node to get
	 * @return the node at the specified position
	 * @throws IndexOutOfBoundsException if the index is out of range (index < 0 || index >= size())
	 */
	private Node<E> node(int index) {
		if(index < 0 || index >= size()) {
			throw new IndexOutOfBoundsException();
		}
		
            if (index < (size >> 1)) {
                Node<E> x = header.next;
                for (int i = 0; i < index; i++)
                    x = x.next;
                return x;
            } 
            else {
                Node<E> x = header.prev;
                for (int i = size - 1; i > index; i--)
                    x = x.prev;
                return x;
            }
	}

	@Override
	public void addFirst(E e) {
		Node<E> newElement = new Node<E>(e);
		
		Node<E> firstElement = header.next;
		newElement.next = firstElement;
		firstElement.prev = newElement;
		
		newElement.prev = header;
		header.next = newElement;
		
		size++;
	}

	@Override
	public void addLast(E e) {
		Node<E> newElement = new Node<E>(e);
		
		Node<E> lastElement = header.prev;
		newElement.next = header;
		header.prev = newElement;
                
                lastElement.next = newElement;
                newElement.prev = lastElement;
		
		size++;
		
	}

	@Override
	public void add(int index, E element) {
            if(index < 0 || index > size()) {
			throw new IndexOutOfBoundsException();
		}
		
		if(index == size()) {
			addLast(element);
		} else {
			Node<E> newElement = new Node<E>(element);
			Node<E> current = node(index);
			Node<E> previousElement = current.prev;
			
			newElement.prev = previousElement;
			previousElement.next = newElement;
			
			newElement.next = current;
			current.prev = newElement;
			size++;
		}

	}

	@Override
	public E removeFirst() {
		
		Node<E> firstElement = header.next;
		header.next = firstElement.next;
		firstElement.next.prev = header; //Vamos al segundo elemento(si lo hay, y si no seria el header de nuevo)
                                                // y luego estando ahi, cambiamos su prev al header.
		size--;
                
                return firstElement.value;
	}

	@Override
	public E removeLast() {
		Node<E> lastElement = header.prev;
		header.prev = lastElement.prev;
		lastElement.prev.next = header;
		
	
		size--;
                
                return lastElement.value;
	}

	@Override
	public E remove(int index) {
		if(index < 0 || index >= size()) {
			throw new IndexOutOfBoundsException();
		}
            
		
            Node<E> current = header;
		            
            for(int i = 0; i < index; i++){ // el for solo me sirve para detenerme antes del index
                current = current.next;
                
            }
		
		Node<E> ElementToRemove = current.next;
		current.next = ElementToRemove.next;
                ElementToRemove.next.prev = current;
		size--;
		return ElementToRemove.value;
	}

	@Override
	public boolean remove(Object o) {
		int index = indexOf(o);
		
		if(index >= 0 && index < size()) {
			remove(index);
			return true;
		}
		
		return false;
	}

	@Override
	public E getFirst() {
		if(header.next == null) {
			throw new NoSuchElementException();
		}
		
		return header.next.value;
	}

	@Override
	public E getLast() {
		if(header.prev == null) {
			throw new NoSuchElementException();
		}

		return header.prev.value;
	}

	@Override
	public E get(int index) {
		if(index < 0 || index >= size()) {
			throw new IndexOutOfBoundsException();
		}
            
		
            Node<E> current = header;
		            
            for(int i = 0; i < index; i++){ // el for solo me sirve para detenerme antes del index
                current = current.next;
                
            }
		
		return current.next.value;
	}

	@Override
	public E set(int index, E element) {
            Node<E> newElement = new Node<E>(element); // Creo mi nodo con el elemento que me indican
            
            Node<E> current = header;
            
            for(int i = 0; i < index; i++){ // el for solo me sirve para detenerme antes del index
                current = current.next;
                
            }
            Node <E> oldElement = current.next;
            current.next = newElement;
            newElement.next = oldElement.next;
            oldElement.next = null;
            
            return oldElement.value;
	}

	@Override
	public boolean contains(E e) {
		Node<E> current = header.next;
		while(current != header) { // comprobacion para saber que no hemos dado la vuelta ya a la lista circular (o sea al final)
			if(current.value == e)
				return true;
			current = current.next;
		}
		
		return false;
	}

	@Override
	public int indexOf(Object o) {
		int index = 0;
		
		if(o == null) {
			for(Node<E> x = header.next; x != header; x = x.next) {
				if(x.value == null)
					return index;
				index++;
			}
		}
		else {
			for(Node<E> x = header.next; x != header; x = x.next) {
				if(o.equals(x.value))
					return index;
				index++;
			}
		}
		return -1;
	}

	@Override
	public void clear() {
		header.prev = header;
                header.next = header;
                size = 0;
		
	}

	@Override
	public int size() {
		
		return size;
	}

	@Override
	public boolean isEmpty() {
		return size() == 0;
	}

	@Override
	public Object[] toArray() {
		Object[] Array = new Object[size]; // creamos una lista con el tamaño de size.

                Node <E> current = header.next; //Empezamos desde el principio
                
                for(int i =0; i<Array.length; i++){
                    Array[i] = current.value;
                    current = current.next;
            }
                return Array;
	}
	
	@Override
	public String toString() {
		if(header.next == header)
			return "[]";
		
		Node<E> current = header.next;
		String returnValue = "[" + current.value;
		while(current.next != header) {
			current = current.next;
			returnValue += ", " + current.value;
		}
		
		returnValue += "]";
		return returnValue;
	}
}
