package Practica7;


public class Main {
	
	public static String checkForBalance(String expression) {
            
            System.out.println(expression);
            Stack<Character> izquierdos = new Stack<Character>();
            char check = 0;
            String revision = "";
            expression.replaceAll("\\s+", ""); // Se juntan los espacios
            for(int i = 0; i < expression.length(); i++){
                if(expression.charAt(i) == '(' || expression.charAt(i) == '[' || expression.charAt(i) == '{'){
                    izquierdos.push(expression.charAt(i));
                }
                else if(expression.charAt(i) == ')' || expression.charAt(i) == ']' || expression.charAt(i) == '}'){
                    if(izquierdos.empty()){ // caso 1
                        for(int n = 0; n < i; n++)
                            revision += " ";
                        revision += "^ Missing left symbol"; // Hacemos un for, dentro del for principal, y nos detenemos antes de i, porque ahi es donde ocurrió el error de match, 
                                                            //ya que la pila esta vacia en este caso.
                        return revision;
                    }
                    check = izquierdos.pop();
                    switch (expression.charAt(i)){
                        case ')':
                            if(check != '('){
                                for(int n = 0; n < i; n++)
                                    revision += " ";
                                revision += "^ Missing left symbol";
                                return revision;      
                            }
                            break;   
                        case ']':
                            if(check != '['){
                                for(int n = 0; n < i; n++)
                                    revision += " ";
                                revision += "^ Missing left symbol";
                                return revision;
                            }
                            break;
                        case '}':
                            if(check != '{'){
                                for(int n = 0; n < i; n++)
                                    revision += " ";
                                revision += "^ Missing left symbol";
                                return revision;
                            }
                            break;
                        default:
                            break;
                    }
                }

            }
            for(int n = 0; n < expression.length(); n++)
                revision += " ";
            if(!izquierdos.empty()){
                revision += "^ Missing right symbol";
                return revision;
            }
            else{
                revision += " Expression is balanced";
                return revision;
                
            }
            
	} 
	
	public static String postfixEval(String expression) {
            Stack <Integer> operandos = new Stack <Integer>();
            int count = 0, count2= 0;
            int right, left;
            String resultado;
            int nuevo = 0, numeroNuevo = 0;
            for(int i = 0; i < expression.length(); i++){
                char symbol = expression.charAt(i);
                if(symbol == '1' || symbol == '2' || symbol == '3' || symbol == '4' || symbol == '5' || symbol == '6' || symbol == '7' || symbol == '8' || symbol == '9'){
                    nuevo = Integer.parseInt(String.valueOf(symbol)); // convirtiendo el char a string y luego a int, con parseint
                    operandos.push(nuevo); // metemos los numeros int ya a la pila
                    count++;
                } 
                if(symbol == '+' || symbol == '-' || symbol == '*' || symbol == '/'){
                    count2++;
                    left = operandos.pop();
                    if(operandos.empty() == true){
                        return "The operation has too many operators";
                    }
                    right = operandos.pop();
                    numeroNuevo = Operacion(right, left, symbol);
                    operandos.push(numeroNuevo); 
                }

            } 
            if(count > count2+1){
                return "The expression has too many operands";
            }
            resultado = String.valueOf(numeroNuevo);
            return resultado;
            
           
		
	}
        
        public static int Operacion(int x, int y, char z){
            int numeroNuevo = 0;
            if(z == '+'){
                numeroNuevo= x+y;
            }
            if(z == '-'){
                numeroNuevo= x-y;
            }
            if(z == '/'){
                numeroNuevo= x/y;
            }
            if(z == '*'){
                numeroNuevo= x*y;
            }
            return numeroNuevo;
            
        }
	
	public static void fibonacci(int n) {
            Queue <Integer> fibonacci = new Queue <Integer>();
            fibonacci.offer(1);
            fibonacci.offer(1);
            for (int i = 0; i < n; i++){
                int a = fibonacci.remove();
                int b = fibonacci.remove();
                System.out.print(a + " ");
                fibonacci.offer(b);
                fibonacci.offer(a + b);
       
            }
		
	}
	
	public static void main(String[] args) {
		System.out.println("Testing balanced symbols");
		System.out.println(checkForBalance("t = arr[3] + a) - 4"));
		System.out.println(checkForBalance("if (arr(3] < 4)"));
		System.out.println(checkForBalance("System.out.println(std.charAt(3);"));
		System.out.println(checkForBalance("while (i > 100) { sum += i; i++; }"));
		System.out.println();
		
		System.out.println("Testing postfix evaluation");
		System.out.println("4 3 5 * + => " + postfixEval("4 3 5 * +"));
		System.out.println("1 2 * 3  4 / - => " + postfixEval("1 2 * 3 4 / -"));
		System.out.println("1 2 * 3 * 4 * 5 * 6 * => " + postfixEval("1 2 * 3 * 4 * 5 * 6 *"));
		System.out.println("1 2 3 * 4 + 5 / + => " + postfixEval("1 2 3 * 4 + 5 / +"));
		System.out.println("2 2 * 4 1 * 3 * - 2 1 * / => " + postfixEval("2 2 * 4 1 * 3 * - 2 1 * /"));
		System.out.println("3 8 + * 9 => " + postfixEval("3 8 + * 9"));
		System.out.println("9 8 + 7 => " + postfixEval("9 8 + 7"));
		System.out.println();
		
		System.out.println("Testing Fibonacci sequence");
		fibonacci(20);
		System.out.println();
                System.out.println();
		
		System.out.println("Testing the Printer class");
		Printer printer = new Printer();
		printer.printDocument("gato.jpg");
		printer.printDocument("tarea.docx");
		printer.printDocument("meme.png");
    
                try{
			printer.runPrinter();			
		} 
                catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println();
	}
}
