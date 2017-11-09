/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Examen3;

/**
 *
 * @author geral
 */
public class Main {
    public static void main(String[] args) {
        LinkedList<Integer> lista1 = new LinkedList<Integer>();
        LinkedList<Integer> lista2 = new LinkedList<Integer>();
        lista1.addFirst(5);
        lista1.addFirst(1);
        lista1.addFirst(6);
        lista1.addFirst(7);
        lista2.addFirst(1);
        lista2.addFirst(9);
        lista2.addFirst(0);
        lista2.addFirst(5);
        lista2.addFirst(100);
        System.out.println(intersect(lista1, lista2));
        LinkedList<Integer> lista3 = new LinkedList<Integer>();
        LinkedList<Integer> lista4 = new LinkedList<Integer>();
        lista3.addFirst(0);
        lista3.addFirst(1);
        lista3.addFirst(5);
        lista3.addFirst(9);
        
        lista4.addFirst(4);
        lista4.addFirst(5);
        lista4.addFirst(8);
        lista4.addFirst(9);
        System.out.println(difference(lista3, lista4));
        System.out.println(endx("xrexx"));
        
    }
    
    public static LinkedList <Integer> intersect (LinkedList <Integer> list1, LinkedList <Integer> list2){
        LinkedList <Integer> salida = new LinkedList <Integer>();
        for(int i = 0; i < list1.size(); i ++){
            for(int j = 0; j < list2.size(); j ++){
                if(list1.get(i).equals(list2.get(j))){ 
                    salida.addFirst(list1.get(i));
                }
            }
        }
        return salida;
        
        
    }
    
    public static LinkedList <Integer> difference(LinkedList <Integer> list1, LinkedList <Integer> list2){
        LinkedList <Integer> salida = new LinkedList <Integer>();
        for(int i = 0; i < list1.size(); i ++){
            for(int j = 0; j < list2.size(); j ++){
                if(list1.get(i).equals(list2.get(j))){ 
                    salida.addFirst(list1.remove(i));
                }
            }
        }
        return list1;
        
    }
    
    public static String endx (String str){
        for(int i = 0; i < str.length(); i ++){
            if(str.substring(i, i + 1) != "x"){
                return str.substring(i, i + 1);   
            }
            else{
                return str + "x";
            }
            
            
        }
        return str + "x";

    }
    
}
