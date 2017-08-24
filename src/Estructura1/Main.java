/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Estructura1;

/**
 *
 * @author geral
 */
public class Main {

	public static void main(String[] args) {
		/*IntegerLinkedList iList = new IntegerLinkedList();
		System.out.println(iList);
		iList.addFirst(5);
		System.out.println(iList);
		iList.addFirst(10);
		System.out.println(iList);
		iList.addLast(7);
		System.out.println(iList);*/
		
		SLinkedList<String> sList = new SLinkedList<String>();
		sList.addFirst("World");
		sList.addFirst("Hello");
		System.out.println(sList);
		
		SLinkedList<Integer> iList = new SLinkedList<Integer>();
		for(int i=0; i<10; i++)
			iList.addFirst(i);
		System.out.println(iList);
		
		while(!iList.isEmpty()) {
			iList.removeLast();
			System.out.println(iList);
		}
		
		for(int i=0; i<10; i++)
			iList.addLast(i);
		System.out.println(iList);
		
		System.out.println(iList.getFirst());
		System.out.println(iList.getLast());
		
		iList.clear();
		System.out.println(iList);
		
		for(int i=0; i<10; i++)
			iList.addLast(null);
		System.out.println(iList);
		
		System.out.println(iList.indexOf(1));
	}
	
}
