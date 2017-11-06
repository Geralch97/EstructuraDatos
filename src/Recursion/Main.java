package Recursion;

public class Main {
	public static void main (String[] args){
		
	}
	
	public int factorial(int n) {
		  if (n == 0){
		    return 1;
		  }
		  else{
		    return n * factorial(n -1);
		  }
		}
	
	public int bunnyEars(int bunnies) {
		  if (bunnies == 0){
		    return bunnies;
		  }
		  else{
		    return 2 + bunnyEars(bunnies - 1);
		  }
		}
	
	public int bunnyEars2(int bunnies) {
		  if(bunnies == 0){
		    return 0;
		  }
		  else if (bunnies%2 == 0){
		    return 3 + bunnyEars2(bunnies - 1);
		    
		  }
		  else{
		    return 2 + bunnyEars2(bunnies - 1);
		  }
		  
		}
	public int fibonacci(int n) {
		   if(n <= 1){
		     return n;
		   }
		   else{
		     return fibonacci(n-1) + fibonacci(n-2);
		     
		   }

		}
	public int triangle(int rows) {
		  if(rows == 0){
		    return 0;
		  }
		  else{
		    return triangle(rows - 1) + rows;
		    
		  } 
		}
	
	public int sumDigits(int n) {
		  if(n == 0){
		    return 0;
		  }
		  else{
		    return n % 10 + sumDigits(n / 10); 
		  }
		}
	
	public int count7(int n) {
		  if (n == 0){
		    return 0;
		  }
		  else{
		    if(n % 10 == 7){
		      return 1 + count7(n/10);
		      
		    }
		   
		      return count7(n / 10);
		    }
		  }
	
	public int count8(int n) {
		  if(n == 0){
		    return 0;
		  }
		  else{
		    if(n % 10 == 8){
		      if((n / 10) % 10 == 8){
		        return 2 + count8(n / 10);
		      }
		      return 1 + count8(n / 10);
		      
		      
		    } 
		      
		  }
		  return count8(n / 10);
		}
	
	public int powerN(int base, int n) {
		  if(n == 1){
		    return base;
		  }
		  else{
		    return powerN(base, n - 1) * base;
		  }
		  
		}
	
	public int countX(String str) {
		  if(str.length() == 0){
		    return 0;
		  }
		  if(str.charAt(0) == 'x'){
		    return 1 + countX(str.substring(1));
		  }
		  return countX(str.substring(1));
		}
	
	public String changeXY(String str) {
	    if(str.length() == 0){
	      return str;
	    }
	    else{
	      if(str.charAt(0) == 'x')
	        return 'y' + changeXY(str.substring(1));
	      
	    }
	    return str.charAt(0) + changeXY(str.substring(1));

	}
	
	public boolean array6(int[] nums, int index) {
	     if(index >= nums.length){
	        return false;
	       
	     }

	    else{
	      return nums[index] == 6 || array6(nums, index + 1);
	    }
	  
	}
	
	public int array11(int[] nums, int index) {
	    if(index >= nums.length){
	      return 0;
	    }
	    if(nums[index] == 11){
	      return 1 + array11(nums, index + 1);
	    }
	        
	                    
	    return array11(nums, index + 1);
	}


}
