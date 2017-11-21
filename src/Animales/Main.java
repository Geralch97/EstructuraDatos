
package Animales;
import java.util.Scanner;
import java.io.*;
import java.util.Arrays;

public class Main {
   
    public static void main(String[] args) {
                int level=0;
                int branch=0;
                animales animal = new animales();
                String[][] treeArr=animal.read();
                Scanner entrada=new Scanner(System.in);
                animal.mainTree=treeArr;
                
                
                System.out.println("¡Hola soy una computadora! \n Piensa en un animal e intentaré adivinarlo"
                + ", contesta con s para si, y n para no\n Mi primera pregunta:");
                System.out.println(treeArr[0][0].toString());
                boolean guess=true;
                
                while(level<animal.fileLength){
                    System.out.println("Tu respuesta(s/n):   ");
                    String respuesta=entrada.nextLine();
                    if(respuesta.equals("s")){
                        level++;
                        branch=branch*2+1;
                        if(level<animal.fileLength){
                            if(!treeArr[level][branch].equals("null")){
                                System.out.println(treeArr[level][branch]);
                            }
                            else{guess=true;break;}
                        }
                        else{
                            guess=true;
                        }
                    }
                    else if(respuesta.equals("n")){
                        level++;
                        branch=branch*2;
                        if(level<animal.fileLength){
                            if(!treeArr[level][branch].equals("null")){
                                System.out.println(treeArr[level][branch]);
                            }
                            else{guess=false;break;}
                        }
                        else{
                            guess=false;
                        }
                    }
                    else{
                        System.out.println("Respuesta no válida...Intenta con s ó n");
                    }
                }
                
                if(guess){
                    System.out.println("He ganado, gracias por jugar");
                }
                else{
                    System.out.println("Ayudame a aprender, dime el animal en el que pensabas ");
                    String newAnim=entrada.nextLine();
                    System.out.println("Ahora dime una característica sobre él(Ejem:tiene cuello largo)");
                    String newQues=entrada.nextLine()+"?";
                    
                    animal.learn(level, branch, newQues, newAnim);
                }
                
                
                    
    
    
 
    }
}