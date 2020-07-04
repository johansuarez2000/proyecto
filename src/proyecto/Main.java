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
        Usuario sebas= new Usuario(1002687237, "Contraseña");
        Usuario sebas1= new Usuario(1002687237, "Contraseña1");
        usuarios2.insertar(sebas);
        usuarios2.insertar(sebas1);
        System.out.println(usuarios2.buscar(sebas1));
        
    }
}
