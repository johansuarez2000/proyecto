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
public class MainInterfazConsola {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        MyArrayList<Usuario> usuarios= new MyArrayList<>();
        MyArrayList<medicamento> medicamentos= new MyArrayList<>();
        Avl_tree<Usuario> usuarios1 = new Avl_tree<>();
        
        Usuario u = new Usuario(1234, "1234");
        usuarios.add(u);
        usuarios1.insert(u);
        medicamento p= new medicamento("Loratadina", 60 , 7, 3);
        u.medicamentos.add(p);
        medicamentos.add(p);
        
        Scanner sc = new Scanner(System.in);
        
        while (true){
            //comprobar si existe el usuario
            System.out.println("Hola, por favor ingresa tu id de usuario.");
            int id = sc.nextInt();
            System.out.println("Ingresa tu contraseña");
            String contraseña = sc.nextLine();
            Usuario comparar = new Usuario(id, contraseña );
            boolean existe = usuarios1.contains(comparar);
            if(existe==true){
                System.out.println("Bienvenido, en que podemos ayudarte?");
            }
            else{
                System.out.println("Usuario o contraseña incorrecta");
            }
        }
        
        
        
        
        
        
        
       
    }
}
