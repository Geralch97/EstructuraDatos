/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Busqueda;

/**
 *
 * @author geral
 */
public class Main {
    public static void main(String[] args) {
        
    }
    public static int linearsearch(int [] list, int target){
        for(int i = 0; i < list.length; i++){
            if (list [i] == target){
                return 1;
            }
            if (list[i] > target){
                return -1;
            }
        }
        return -1;
            
    }
}
