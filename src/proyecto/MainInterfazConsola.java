/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto;

import java.util.*;
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
        Usuario u2 = new Usuario(1234, "1234");
        usuarios.add(u, new ordenarNombre());
        usuarios1.insert(u);
        usuarios1.insert(u2);
        medicamento p= new medicamento("Loratadina", 60 , 7, 3);
        u.medicamentos.add(p,new ordenarNombre());
        medicamentos.add(p, new ordenarNombre());
        Avl_Node<Usuario> existe = null; //cuando se compruebe el usuario sus datos se van a manejar con este nodo, por eso es global
        
        Scanner sc = new Scanner(System.in);
        
        //El siguiente while permite crear un usuario, quitar los comentarios cuando se pruebe el balanceo del AVL
        boolean flag=false;
        while(flag!=true){
            System.out.println("¿Tienes una cuenta o deseas registrarte?");
            System.out.println("1.Tengo una cuenta 2. deseo registrarme");
            int decision=sc.nextInt();
            switch (decision){
                case 1:
                    flag = true;
                    break;
                case 2:
                    System.out.println("Escribe tu id");
                    int id= sc.nextInt();
                    System.out.println("Escribe tu contraseña");
                    String contraseña= sc.next();
                    Usuario l= new Usuario(id,contraseña);
                    usuarios1.insert(l);
                    flag = true;
                    break;
            }
        }
        
        //comprobar si existe el usuario
        flag=false;
        while ( flag !=true){
            System.out.println("Por favor ingresa tu id de usuario.");
            int id = sc.nextInt();
            System.out.println("Ingresa tu contraseña");
            String contraseña = sc.next();
            Usuario usu = new Usuario(id,contraseña);
            existe = usuarios1.find(usu);
            if(existe != null){                
                System.out.println("Bienvenido ¿En que podemos ayudarte?");
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
                        System.out.println("Medicamento "+ (i+1));
                        System.out.println(existe.element.medicamentos.get(i).toString());
                    }
                    System.out.println("Esos son todos los medicamentos");
                    break;
                case 2:
                    System.out.println("Nombre del medicamento que deseas buscar");
                    String nombre = sc.next();
                    medicamento m = new medicamento (nombre, 0,0,0);
                   for(int i=0; i<existe.element.medicamentos.getSize();i++){
                       if(m.getNombre().equals(existe.element.medicamentos.get(i).getNombre())){
                           System.out.println(existe.element.medicamentos.get(i).toString());
                       }
                       else{
                           System.out.println("Medicamento no encontrado");
                       }
                    }
                    break;
                case 3:
                    System.out.println("¿Nombre del medicamento?");
                    nombre=sc.next();
                    System.out.println("¿Cantidad del medicamento?");
                    int cantidad=sc.nextInt();
                    System.out.println("¿Veces por semana del medicamento?");
                    int vecesSemana=sc.nextInt();
                    System.out.println("¿Veces por dia del medicamento?");
                    int vecesDia=sc.nextInt();
                    medicamento f = new medicamento(nombre, cantidad, vecesSemana, vecesDia);
                    existe.element.medicamentos.add(f,new ordenarNombre());
                    System.out.println("Registrado Exitosamente");
                    break;
            }
        }
    }
}