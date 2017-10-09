/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ordenamiento;

import java.util.Arrays;

/**
 *
 * @author Gerardo López Chacón | A01379707
 */
public class Main {
    public static void main(String[] args) {
        int[] Insertion = {2, 15, 7, 1, 10};
        int[] Selection = {4, 9, 5, 0, -2};
        int[] Bubble = {6, 17, 10, 1, 0};
                
        
        insertionsort(Insertion);
        System.out.println(Arrays.toString(Insertion));
        selectionsort(Selection);
        System.out.println(Arrays.toString(Selection));
        bubblesort(Bubble);
        System.out.println(Arrays.toString(Bubble));
        
    }
    
        public static void insertionsort(int values []){
        for (int i = 1; i < values.length; i ++){
            for (int j = 0; j < i; j++ ){
                if(values[j] > values[i]){
                    int valori = values[i];
                    shiftRight(values ,j, i);
                    values[j] = valori;
                }
            }
        }    
    }
    
    public static void shiftRight (int values[], int start, int end){
       	
		for(int i= end; i > start; i--)
			values[i] = values[i - 1];
		
    }
    
    public static void selectionsort (int values []){
        for (int i = 0; i < values.length; i ++){
            for (int j = i; j < values.length; j ++){
                if (values[j] < values[i]){
                    int valori = values[i];
                    values[i] = values[j];
                    values[j] = valori;
                    
                }
                
            }
        }
        
    }
    
    public static void bubblesort (int values[]){
        boolean not_sorted = true;
        while (not_sorted){
            not_sorted = false;
            for(int i = 1; i < values.length; i++){
                if(values[i] < values[i - 1]){
                    int temp = values [i];
                    values [i] = values [i -1];
                    values [i -1] = temp;
                    
                    not_sorted = true;
                }
                
            }
        }
    }
}
