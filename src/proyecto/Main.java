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
        usuarios.add(new Usuario(0, "Contraseña"), new ordenar());
        usuarios.add(new Usuario(3, "Contraseña"), new ordenar());
        usuarios.add(new Usuario(2, "Contraseña"), new ordenar());
        usuarios.add(new Usuario(5, "Contraseña"), new ordenar());
        usuarios.add(new Usuario(1, "Contraseña"), new ordenar());
        
        for (int i = 0; i < usuarios.size(); i++) {
            System.out.println(usuarios.get(i));
        }
   
    }
}
