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
public class BinaryNode {
    public int value;
    public BinaryNode leftChild;
    public BinaryNode rightChild;
    
    
    
    public BinaryNode (int value){
        this.value = value;
        leftChild = null;
        rightChild = null;
    }
    
    public void preorderTraversal(){
        preorder(this);
        
    }
    
    public void inorderTraversal(){
        inorder(this);
        
    }
    
    public void postorderTraversal(){
        postorder(this);
        
    }
    
    public void depthFirstTraversal(){
        Queue <BinaryNode> fila = new Queue<BinaryNode>();
        fila.offer(this);
        while(!fila.isEmpty()){
            BinaryNode n = fila.remove();
            System.out.print(n.value);
            if(n.leftChild != null){
                fila.offer(n.leftChild);
            }
            if(n.rightChild != null){
                fila.offer(n.rightChild);
            }
            
        }
        
        
    }
    
    private void preorder (BinaryNode node){
        System.out.print(node.value);
        if(node.leftChild != null){
            preorder(node.leftChild);
            
        }
        if(node.rightChild != null){
            preorder(node.rightChild);
            
        }
        
    }
    
    private void inorder(BinaryNode node){
        if(node.leftChild != null){
            inorder(node.leftChild);
        }
        System.out.print(node.value);
        
        if(node.rightChild != null){
            inorder(node.rightChild);
        }
           
    }
    
    private void postorder (BinaryNode node){
        if(node.leftChild != null){
            postorder(node.leftChild);
        }
        
        if(node.rightChild != null){
            postorder(node.rightChild);
        }
        System.out.print(node.value);
        
        
    }
    public void addNode (int NewValue){
        if(NewValue < this.value){
            if(this.leftChild == null){
                this.leftChild = new BinaryNode (NewValue);
            }
            else{
                this.leftChild.addNode(NewValue);
            }
        }
        else if(NewValue > this.value){
            if(this.rightChild == null){
                this.rightChild = new BinaryNode (NewValue);
            }
            else{
                this.rightChild.addNode(NewValue);
            }
            
        }
        
    }
    public BinaryNode findNode (int target){
        if(target == this.value){
            return this;
        }
        if(target < this.value){
            if(this.leftChild == null){
                return null;
            }
            return this.leftChild.findNode(target);
        }
        else{
            if(this.rightChild == null){
                return null;
            }
            return this.rightChild.findNode(target);
        }
    }
    
    
}
