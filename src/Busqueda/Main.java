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
        int[] Array = {2, 6, 9, 104, 105, 200, 1024, 2048, 4096, 5970, 6666, 9999};
        System.out.println(binarysearch(Array, 5970));
        System.out.println(linearsearch(Array, 5970));
        
        
    }
    public static int linearsearch(int [] list, int target){
        for(int i = 0; i < list.length; i++){
            if (list [i] == target){
                return i;
            }
            if (list[i] > target){
                return -1;
            }
        }
        return -1;
            
    }
    
    public static int binarysearch(int [] arr, int target){
        int min = 0;
        int max = arr.length-1;
        
        
        while(min <= max){
            int mid = (min + max)/2;
            if(target < arr[mid]){
                max = mid-1;
            }
            else if (target > arr[mid]){
                min = mid+1;
            }
            
            else{
                return mid;
                
            }
            
        }
        return -1;
        
    }
}
