/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto;
import java.util.*;
/**
 *
 * @author Usuario
 */
public class Usuario implements Comparable<Usuario> {
    MyArrayList<medicamento> medicamentos= new MyArrayList<>();
    int id;
    String tipo;
    String Fecha;
    String Contraseña;

    public Usuario(int id, String Contraseña) {
        this.id = id;
        this.Contraseña = Contraseña;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getFecha() {
        return Fecha;
    }

    public void setFecha(String Fecha) {
        this.Fecha = Fecha;
    }

    public String getContraseña() {
        return Contraseña;
    }

    public void setContraseña(String Contraseña) {
        this.Contraseña = Contraseña;
    }

    @Override
    public int compareTo(Usuario t) {
        return this.id-t.id;

    }
    public String ComparePasword(Usuario t){
       if(t.getContraseña().equals(this.Contraseña)){
           return"Bienvenido";
       }
       return "contraseña incorrecta";
    }

    @Override
    public String toString() {
        return "id=" + id + ", tipo=" + tipo + ", Fecha=" + Fecha + ", Contrase\u00f1a=" + Contraseña + '}';
    }
    
}    
 class ordenar implements Comparator<Usuario>{

    @Override
    public int compare(Usuario t, Usuario t1) {
     return t.getId()-t1.getId();
    }

}
    
    

