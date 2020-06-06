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
public class Avl_Node<T> {
  T element;
  Avl_Node<T> izquierda;
  Avl_Node<T> derecha;
  int height;

    public Avl_Node(T element) {
        this.element = element;
        this.height=0;
    }

    public T getElement() {
        return element;
    }

    public void setElement(T element) {
        this.element = element;
    }

    public Avl_Node<T> getIzquierda() {
        return izquierda;
    }

    public void setIzquierda(Avl_Node<T> izquierda) {
        this.izquierda = izquierda;
    }

    public Avl_Node<T> getDerecha() {
        return derecha;
    }

    public void setDerecha(Avl_Node<T> derecha) {
        this.derecha = derecha;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    @Override
    public String toString() {
        return "Avl_Node{" + "element=" + element + ", height=" + height + '}';
    }
    
}
