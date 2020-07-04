/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto;
import java.util.*;
import java.math.*;
import java.security.*; 
/**
 *
 * @author ASUS
 */
public class Main {

    public static String randomtext(){
        SecureRandom random= new SecureRandom();
        String txt= new BigInteger(130, random).toString();
        return txt;
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        MyArrayList<Usuario> usuarios= new MyArrayList<>();
        MyArrayList<medicamento> medicamentos= new MyArrayList<>();
        Avl_tree<Usuario> usuarios1 = new Avl_tree<>();
        usuarios1.insert(new Usuario(0, "Contraseña"));
        HashTable<Usuario> usuarios2= new HashTable<>();
        float inicio,fin;
        
        
        for (int i = 0; i < 10000000; i++) { 
            Usuario a= new Usuario(i, "Contraseña");
            usuarios2.insertar(a);
        }
        inicio= System.nanoTime();
        double y= Math.random();
        y= (y*9999999.0)+1;
        int j= (int) y;
        Usuario z= new Usuario(j, "Contraseña");
        fin= System.nanoTime();
        System.out.println(usuarios2.buscar(z));
        
        
       System.out.printf("%nEl valor de la variable es %.6f", (fin-inicio)/(1000000000));
    }
}
