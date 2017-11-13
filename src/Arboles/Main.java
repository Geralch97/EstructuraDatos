/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Arboles;

/**
 *
 * @author geral
 */
public class Main {
    public static void main(String[] args) {
        BinaryNode root = new BinaryNode(4);
        BinaryNode node1 = new BinaryNode(1);
        BinaryNode node2 = new BinaryNode(2);
        BinaryNode node3 = new BinaryNode(3);
        BinaryNode node5 = new BinaryNode(5);
        BinaryNode node6 = new BinaryNode(6);
        BinaryNode node7 = new BinaryNode(7);
        BinaryNode node8 = new BinaryNode(8);
        
        root.leftChild = node2;
        root.rightChild = node5;
        node2.leftChild = node1;
        node2.rightChild = node3;
        node5.rightChild = node7;
        node7.leftChild = node6;
        node7.rightChild = node8;
        
        root.preorderTraversal();
        System.out.println();
        root.inorderTraversal();
        System.out.println();
        root.postorderTraversal();
        System.out.println();
        root.depthFirstTraversal();
        System.out.println();
        
        BinaryNode raiz = new BinaryNode (3);
        raiz.addNode(5);
        raiz.addNode(2);
        raiz.addNode(9);
        raiz.addNode(0);
        raiz.inorderTraversal();
        System.out.println();
       
    }
    
}
