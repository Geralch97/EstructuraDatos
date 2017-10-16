package Practica7;


public class Printer {
	private Queue<String> printerSpool;
	
	public Printer() {
		printerSpool = new Queue<String>();
	}
	
	public void printDocument(String name) {
            printerSpool.offer(name); // offer es un metodo push
		
	}
	
	public void runPrinter() throws InterruptedException  {

           
           while(!printerSpool.isEmpty()){
               if (Thread.interrupted()){ // Clears interrupted status!
                    throw new InterruptedException();
           }
               else{
                    Thread.sleep(5000);
                    String remove = printerSpool.remove(); // returns first element of printerSpool and size--; 
                    System.out.println(remove);
                   
               }
   
           }
           System.out.println("Finished printing documents");
	}
}
