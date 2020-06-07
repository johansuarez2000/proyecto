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
        Avl_Node<Usuario> existe = null;
        
        Scanner sc = new Scanner(System.in);
        
        //comprobar si existe el usuario
        boolean flag=false;
        while ( flag !=true){
            System.out.println("Por favor ingresa tu id de usuario.");
            int id = sc.nextInt();
            System.out.println("Ingresa tu contraseña");
            String contraseña = sc.next();
            Usuario usu = new Usuario(id,contraseña);
            existe = usuarios1.find(usu);
            if(existe != null){                
                System.out.println("Bienvenido, en que podemos ayudarte?");
                flag=true;
            }
            else{
                System.out.println("Usuario o contraseña incorrecta");
            }
        }/////////////////////////////////////////////////
        //Mostrar funcionalidades
        while(true){
            int decision;
            System.out.println("1. Listar Medicamentos 2. Consultar medicamento 3. Registrar Medicamento");
            decision = sc.nextInt();
            switch (decision){
                case 1:
                    for(int i=0; i<existe.element.medicamentos.getSize();i++){
                        Object[] t= existe.element.medicamentos.getItems();
                        t[i].toString();
                    }
                    break;
                case 2:
                    System.out.println("Nombre del medicamento que deseas buscar");
                    break;
            }
            
        }
    }
}
