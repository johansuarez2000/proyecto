/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto;

import java.math.BigInteger;
import java.util.*;

/**
 *
 * @author Usuario
 * @param <T>
 */

public class HashTable<T extends Comparable>{
    
     NodoHash<T>[] elementos= new NodoHash[1000];
     BigInteger p= new BigInteger("27973363717");
     BigInteger a= new BigInteger("14379444716");
     BigInteger b= new BigInteger("18937960365");
     int numElements=0;
     
     public int dispercion(T x){
       BigInteger pos= (((a.multiply(BigInteger.valueOf(x.hashCode()))).add(b)).mod(p)).mod(BigInteger.valueOf(1000));
       return pos.intValue();
     }

    public HashTable() {
    }
     
     public void insertar(T x){
         int posicion;
         NodoHash<T> y= new NodoHash(x);
         posicion= dispercion(x);                
         y.setSiguiente(elementos[posicion]);
         elementos[posicion]= y;
         numElements ++;             
     }
    public void eliminar(T x){
        int posicion;
        posicion= dispercion(x);
        NodoHash<T> y= elementos[posicion];
        if(elementos[posicion]==null){
            System.out.println("Not founded"+ x);
        }
        else{
            NodoHash<T> anterior;
            NodoHash<T> actual;
            anterior=null;
            actual=y;
            while(actual.Siguiente()!=null || x.compareTo(actual.key)!=0){
                anterior=actual;
                actual=actual.Siguiente();
            }
            if(x.compareTo(actual.key)!=0){
                System.out.println("Not founded" + x);
            }
            else{
                if(anterior== null){
                    elementos[posicion]=actual.siguiente;//primer elemento
                }
                else{
                    anterior.setSiguiente(actual.Siguiente());
                }
            }
        } 
        
    }
    public NodoHash<T> buscar(T x){
        NodoHash<T> y=null;
        int posicion=dispercion(x);
        if(elementos[posicion]!=null){
            y=elementos[posicion];
            while(y.Siguiente()!=null || x.compareTo(y.key)!=0){
                y=y.Siguiente();
            }
            if(x.compareTo(y.key)!=0){
               y=null;
            }           
        }
        return y;
    }
    
     
    
    
}
