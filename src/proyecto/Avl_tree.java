/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto;

import java.util.*;

/**
 *
 * @author Usuario
 * @param <T>
 */
public class Avl_tree <T extends Comparable<? super T>> {
    Avl_Node<T> raiz;
   
    public Avl_tree() {
        raiz=null;
    }
     
    public void MakeEmpty(){
        raiz=null;
    }
    public boolean isEmpty(){
        return raiz==null;
    }
    public boolean contains(T x){
        return contains(x, raiz);
    }
    public T findMin(){
        if(isEmpty()){
            throw new UnderflowException("El arbol esta vacio");           
        }
        return findMin(raiz).element;
    }
    public T findMax(){
        if(isEmpty()){
            throw new UnderflowException("El arbol esta vacio");           
        }
        return findMax(raiz).element;
    }
    public void insert(T x){
        raiz=insert(x,raiz);
    }
    public void remove(T x){
        raiz=remove(x,raiz);
    }
    public void Printtree(){
        
    }
    private boolean contains(T x,Avl_Node<T> t){
        if(t==null){
            return false;
        }
        int compareResult=x.compareTo(t.element);
        if(compareResult<0){
            return contains(x,t.izquierda);
        }
        else if(compareResult>0){
            return contains(x,t.derecha);
        }else
            return true;       
    }
    private Avl_Node<T> findMin(Avl_Node<T> t){
        if(t==null){
            return null;
        }else if(t.izquierda==null){
            return t;
        }
        return findMin(t.izquierda);
    }
    private Avl_Node<T> findMax(Avl_Node<T> t){
        if(t==null){
            return null;
        }else if(t.derecha==null){
            return t;
        }
        return findMax(t.derecha);
    }
    private Avl_Node<T> insert(T x, Avl_Node<T> t){
        if(t==null){
            return new Avl_Node(x);
        }
        int compareResult = x.compareTo(t.element);
        if(compareResult<0){
            t.izquierda=insert(x,t.izquierda);
        }else if(compareResult>0){
            t.derecha=insert(x,t.derecha);
        }else;
        return balance(t);        
    }
    
    private Avl_Node<T> balance(Avl_Node t){
    if(t==null){
        return null;
    }
    if(t.izquierda.getHeight()-t.derecha.getHeight()>1){
        if(t.izquierda.izquierda.getHeight()>= t.izquierda.derecha.getHeight()){
            t= rotateLeft(t);
        }else
            t=doubleRotateLeft(t);
    }else {
     if(t.derecha.getHeight()-t.izquierda.getHeight()>1){
         if(t.derecha.derecha.getHeight()>=t.derecha.izquierda.getHeight()){
             t=rotateRigth(t);
         }else{
             t=doubleRotateRigth(t);
         }
     }   
    }
     t.height=Math.max(t.izquierda.getHeight(),t.derecha.getHeight());
     return t;
    }
    private Avl_Node<T> rotateLeft(Avl_Node<T> k2){
        Avl_Node<T> k1= k2.izquierda;
        k2.izquierda=k1.derecha;
        k1.derecha=k2;
        k2.height=Math.max(k2.izquierda.getHeight(),k2.derecha.getHeight())+1;
        k1.height=Math.max(k1.izquierda.getHeight(),k1.derecha.getHeight())+1;
        return k1;
    }
    private Avl_Node<T> rotateRigth(Avl_Node<T> k2){
        Avl_Node<T> k1= k2.derecha;
        k2.derecha=k1.izquierda;
        k1.izquierda=k2;
        k2.height=Math.max(k2.izquierda.getHeight(),k2.derecha.getHeight())+1;
        k1.height=Math.max(k1.izquierda.getHeight(),k1.derecha.getHeight())+1;
        return k1;
    }
    private Avl_Node<T> doubleRotateLeft(Avl_Node<T> k3){
        k3.izquierda= rotateRigth(k3.izquierda);
        return rotateLeft(k3);
    }
    private Avl_Node<T> doubleRotateRigth(Avl_Node<T> k3){
        k3.izquierda= rotateLeft(k3.izquierda);
        return rotateRigth(k3);
    }
    private Avl_Node<T> remove(T x,Avl_Node<T> t){
        if(t==null){
            return t;
        }
        int compareResult=x.compareTo(t.element);
        if(compareResult<0){
            t.izquierda=remove(x,t.izquierda);
        }else if(compareResult>0){
            t.derecha=remove(x,t.derecha);
        }else if(t.izquierda!= null && t.derecha!=null){
            t.element=findMin(t.derecha).element;
            t.derecha=remove(t.element, t.derecha);
        }
       return balance(t); 
    }
    private void print(){
        if(isEmpty()){
            System.out.println("Arbol vacio");
        }else{
            print(raiz);
        }
    }
    private void print(Avl_Node<T> t){
        if(t!=null){
            print(t.izquierda);
            System.out.println(t.element);
            print(t.derecha);
        }
    }
}