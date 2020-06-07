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
        System.out.println(usuarios1.find(new Usuario(0, "Contra")));
        int j=0;
        Random r= new Random();
        long startTime = System.currentTimeMillis();
          for (int i = 0; i < 10; i++) {
              j++;
              Usuario p= new Usuario(j,"Hola");
              usuarios.add(p);
          }
          for (int k = 0; k < 10; k ++) {
              medicamento p= new medicamento("hola",5,3,3);
              medicamentos.add(p);              
          }
        
        medicamentos.sort(new ordenarNombre());
        usuarios.sort(new ordenar());
        
        System.out.println(usuarios.find(new Usuario(800,"ola")));
    }
}
