package Practica2;
import java.util.*;

public class SLinkedList<E> implements List<E> {
	private SNode<E> top;
	private int size;
	
	public SLinkedList() {
		top = new SNode<E>();
		size = 0;
	}

	@Override
	public void addFirst(E e) {
            SNode<E> newNode = new SNode<E>(e);
		newNode.next = top.next;
		top.next = newNode;
		size++;
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addLast(E e) {
		SNode<E> newNode = new SNode<E>(e);
		
		SNode<E> current = top; // guardo mi centinela en una variable temporal
		while(current.next != null) // recorro la lista, siempre y cuando no se encuentre un nodo.next en null
			current = current.next; // actualizo el current al siguiente nodo (avanzo)
                
		current.next = newNode; // me salgo del while en el ultimo nodo( que apunta a null) y hago que ese nodo apunte a mi newNode
		size++; // la lista crece
		
	}

	@Override
	public void add(int index, E element) {
            
            /*if(index < 0 || index >= size()) {
			throw new IndexOutOfBoundsException();
		}*/
            
            SNode<E> newNode = new SNode<E>(element); // Creo mi nodo con el elemento que me indican
            
            SNode<E> current = top;
            
            for(int i = 0; i < index; i++){ // el for solo me sirve para detenerme antes del index
                current = current.next;
                
            }
            SNode <E> x = current.next;
            current.next = newNode;
            newNode.next = x;
            
            
            
		// TODO Auto-generated method stub
		
	}

	@Override
	public E removeFirst() {
		if(top.next == null) {
			throw new NoSuchElementException();
		}
		
		SNode<E> nodeToRemove = top.next;
		top.next = nodeToRemove.next;
		nodeToRemove.next = null;
		size--;
		return nodeToRemove.value;
	}

	@Override
	public E removeLast() {
		if(top.next == null) {
			throw new NoSuchElementException();
		}
		
		SNode<E> current = top;
		while(current.next.next != null)
			current = current.next;
		
		SNode<E> nodeToRemove = current.next;
		current.next = null;
		size--;
		return nodeToRemove.value;
	}

	@Override
	public E remove(int index) {
            /*if(index < 0 || index >= size()) {
			throw new IndexOutOfBoundsException();
		}*/
            
		SNode<E> current = top;
            
            for(int i = 0; i < index; i++){ // el for solo me sirve para detenerme antes del index
                current = current.next;
                
            }
		
		SNode<E> nodeToRemove = current.next;
		current.next = nodeToRemove.next;
		size--;
		return nodeToRemove.value;
	}

	@Override
	public boolean remove(Object o) {
		/*SNode<E> current = top;
		while(current.next.next != o)
			current = current.next;
		
		SNode<E> nodeToRemove = current.next;
		current.next = nodeToRemove.next;
		size--;*/
		return false;
	}

	@Override
	public E getFirst() {
		if(top.next == null) {
			throw new NoSuchElementException();
		}
		
		return top.next.value;
	}

	@Override
	public E getLast() {
		if(top.next == null) {
			throw new NoSuchElementException();
		}
		
		SNode<E> current = top.next;
		while(current.next != null)
			current = current.next;
		
		return current.value;
	}

	@Override
	public E get(int index) {
		/*if(index < 0 || index >= size()) {
			throw new IndexOutOfBoundsException();
		}*/
            
		SNode<E> current = top;
            
            for(int i = 0; i < index; i++){ // el for solo me sirve para detenerme antes del index
                current = current.next;
                
            }
		
		SNode<E> nodeToReturn = current.next;
		
		return nodeToReturn.value;
	}
 
	@Override
	public E set(int index, E element) {
            SNode<E> newNode = new SNode<E>(element); // Creo mi nodo con el elemento que me indican
            
            SNode<E> current = top;
            
            for(int i = 0; i < index; i++){ // el for solo me sirve para detenerme antes del index
                current = current.next;
                
            }
            SNode <E> oldNode = current.next;
            current.next = newNode;
            newNode.next = oldNode.next;
            oldNode.next = null;
            
            return oldNode.value;
	}

	@Override
	public boolean contains(E e) {
            
            SNode<E> current = top.next;
            
            while(current.next != null){
                if(e.equals(current.value)){
                    return true;
                }
                else{
                    current = current.next;
                }

            } 
                return false;
                
	}

	@Override
	public int indexOf(Object o) {
		int index = 0;
		
		if(o == null) {
			for(SNode<E> x = top.next; x != null; x = x.next) {
				if(x.value == null)
					return index;
				index++;
			}
		}
		else {
			for(SNode<E> x = top.next; x != null; x = x.next) {
				if(o.equals(x.value))
					return index;
				index++;
			}
		}
		return -1;
	}

	@Override
	public void clear() {
		top.next = null;
		size = 0;
		
	}

	@Override
	public int size() {
            size = 0;
            SNode <E> current = top;
            while(current.next != null){
                size++;
                current = current.next;
            }
	
		return size;
	}

	@Override
	public boolean isEmpty() {
		return size() == 0;
	}

	@Override
	public Object[] toArray() {
		
            Object[] arr = new Object[this.size()];
            if(this.isEmpty()){
                return arr;
            }
            else{
                SNode <E> current = top.next;
                
                for(int i =0; i<arr.length; i++){
                    arr[i] = current.value;
                    current = current.next;
                    
                }
                return arr;
            }
		
	}
	
        @Override
	public String toString() {
		if(top.next == null)
			return "[]";
		
		SNode<E> current = top.next;
		String returnValue = "[" + current.value;
		while(current.next != null) {
			current = current.next;
			returnValue += ", " + current.value;
		}
		
		returnValue += "]";
		return returnValue;
	}
}
