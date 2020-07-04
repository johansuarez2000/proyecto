/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto;

/**
 *
 * @author Usuario
 * @param <T>
 */
public class NodoHash<T extends Comparable> {
    T key;
    NodoHash siguiente;
    
    public NodoHash(T key) {
        this.key = key;
    }

    public T getKey() {
        return key;
    }

    public void setKey(T key) {
        this.key = key;
    }

    public NodoHash Siguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoHash siguiente) {
        this.siguiente = siguiente;
    }

    @Override
    public String toString() {
        return "NodoHash{" + "key=" + key ;
    }
    
  
    
}
