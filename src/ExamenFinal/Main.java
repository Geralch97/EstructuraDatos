/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ExamenFinal;

/**
 *
 * @author geral
 */
public class Main {
    public static void main(String[] args) {
        String prueba1 = "Hola123Amigo5";
        System.out.println(cleanString(prueba1));
        System.out.println(mystery(1,1));
        System.out.println(mystery(3, 4));
        System.out.println(mystery(4, 0));
        LinkedList<Integer> list1 = new LinkedList<Integer>();
        LinkedList<Integer> list2 = new LinkedList<Integer>();
        list1.addLast(5);
        list1.addLast(1);
        System.out.println(list1);
        list2.addLast(6);
        list2.addLast(7);
        System.out.println(union(list1, list2));
        
        LinkedList<Integer> lista = new LinkedList<Integer>();
        lista.addLast(1);
        lista.addLast(2);
        lista.addLast(6);
        lista.addLast(8);
        lista.addLast(11);
        lista.addLast(54);
        System.out.println(lista);
        insertInOrder(lista, 10);
        System.out.println(lista);
        
        LinkedList<Integer> lista3 = new LinkedList <Integer>();
        lista3.addLast(1);
        lista3.addLast(2);
        lista3.addLast(3);
        lista3.addLast(4);
        lista3.addLast(5);
        lista3.addLast(6);
        System.out.println(lista3);
        moveToBeginning(lista3, 2);
        System.out.println(lista3);
        
        

        
    }
    
    public static String cleanString(String str){
        String salida = str.replaceAll("[^a-zA-Z]+", "");
        return salida.toUpperCase();
        

    }
        public static int mystery (int m, int n){
        if(m == 0){
            return n + 1;
        }
        else if(m > 0 && n == 0){
            return mystery(m - 1, 1);
        }
        else{
            return mystery(m - 1, mystery(m, n - 1));
        }
        
    }
        public static LinkedList <Integer> union (LinkedList<Integer> list1, LinkedList<Integer> list2){
            LinkedList <Integer> salida = new LinkedList <Integer>();
            while(!list1.isEmpty()){
                salida.addLast(list1.removeFirst());
            }
            while(!list2.isEmpty()){
                salida.addLast(list2.removeFirst());
            }
            
            return salida;
            
        }
        public static void insertInOrder (LinkedList<Integer> lst, int element){
            for(int i = 0; i < lst.size(); i++){
                if (element <= lst.get(i)){
                    lst.add(i, element);
                    break;
                    
                }
                
            }
            
            
        }
        public static void moveToBeginning (LinkedList <Integer> lst, int i){
            lst.addFirst(lst.remove(i));
        }
        
       
        
        
}
