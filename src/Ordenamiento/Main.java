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
        int[] Heap = {1, 0, 24, 18, -2, 10};
        int[] Quick = {2, 23, 10, 5, 1, 0};
        int[] Merge = {5, 10, 2, 1, 7};
        int[] SMerge = new int[Merge.length];
        
                
        
        insertionsort(Insertion);
        System.out.println(Arrays.toString(Insertion));
        selectionsort(Selection);
        System.out.println(Arrays.toString(Selection));
        bubblesort(Bubble);
        System.out.println(Arrays.toString(Bubble));
        makeheap(Heap);
        System.out.println(Arrays.toString(Heap));
        System.out.println(removeTopItem(Heap, Heap.length));
        System.out.println(Arrays.toString(Heap));
        //System.out.println(Arrays.toString(Quick));
        //quicksort(Quick,0, Quick.length -1);
        //System.out.println(Arrays.toString(Quick));
        System.out.println(Arrays.toString(Merge));
        mergesort(Merge, SMerge, 0, Merge.length -1);
        System.out.println(Arrays.toString(Merge));
        
        
        
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
    
    public static void makeheap (int values[]){
        for(int i = 0; i < values.length; i++){
            int index = i;
            while (index != 0){
                int parent = (index - 1) / 2;
                
                if (values[index] <= values[parent]){
                    break;
                }
                
                int temp = values[index];
                values [index] = values[parent];
                values [parent] = temp;
                
                index = parent;
            }
        }
        
    }
    
    public static int removeTopItem (int values[], int count){
        int result = values[0];
        values[0] = values [count - 1]; // ultimo elemento de nuestra lista
        
        int index = 0;
        while (true){
            int child1 = 2 * index + 1;
            int child2 = 2 * index + 2;
            
            if(child1 >= count){
                child1 = index;
            }
            
            if(child2 >= count){
                child2 = index;
            }
            
            if(values[index] >= values[child1] && values[index] >= values[child2]){
                break;
            }
            int swapChild = child1;
            if(values[child2] > values[child1]){
                swapChild = child2;
            }
            
            int temp = values[index];
            values[index] = values[swapChild];
            values[swapChild] = temp;
            
            index = swapChild;
        }
        return result;
        
        
        
    }
    /*public static  void quicksort (int values[], int start, int end){
        // If the list has no more than one element, it´s sorted.
        if(start >= end){
            return; 
        }
        // Use the first element as the dividing item
        int divider = values[start];
        
        // Move items < divider to the front of the array and
        // items >= divider to the end of the array.
        Stack<Integer> before = new Stack<Integer>();
        Stack<Integer> after = new Stack<Integer>();
        
        for(int i = start +1; i <= end; i++){
            if(values[i] < divider){
                before.push(values[i]);
            }
            else{
                after.push(values[i]);
            }
        }
        int i = start;
        while(!before.empty()){
            values[i++] = before.pop();
            
        }
        int middle = i++;
        values[middle] = divider;
        while(!after.empty()){
            values[i++] = after.pop();
        }
        // Recursively sort the two halves.
        quicksort(values, start, middle -1);
        quicksort(values, start, middle + 1);
    }*/
    
    public static void mergesort(int values[], int scratch[], int start, int end){
        if(start >= end){
            return;
        }
        int midpoint = (start + end)/ 2;
        mergesort(values, scratch, start, midpoint);
        mergesort(values, scratch, midpoint + 1, end);
        
        //Merge the two halves
        int leftIndex = start;
        int rightIndex = midpoint + 1;
        int scratchIndex = leftIndex;
        while(leftIndex <= midpoint && rightIndex <= end){
            if(values[leftIndex] <= values[rightIndex]){
                scratch[scratchIndex] = values[leftIndex];
                leftIndex = leftIndex + 1;
                
            }
            else{
                scratch[scratchIndex] = values[rightIndex];
                rightIndex = rightIndex + 1;
                
            }
            scratchIndex = scratchIndex + 1;
        }
        // Finish copying whichever half is not empty
        for(int i = leftIndex; i <= midpoint; i++){
            scratch[scratchIndex] = values[i];
            scratchIndex = scratchIndex + 1;
        }
        for(int i = rightIndex; i <= end; i++){
            scratch[scratchIndex] = values[i];
            scratchIndex = scratchIndex + 1;
        }
        //Copy the values back to the original array
        for(int i = start; i <= end; i++){
            values[i] = scratch[i];
        }
    }
}
