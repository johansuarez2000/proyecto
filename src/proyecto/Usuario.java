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
    MyArrayList<medicamento> medicamentos;
    int id;
    String tipo;
    String Fecha;
    String Contraseña;

    public Usuario(int id, String Contraseña) {
        this.id = id;
        this.Contraseña = Contraseña;
        this.medicamentos= new MyArrayList<>();
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

    @Override
    public int hashCode() {
        return this.id;
    }    

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Usuario other = (Usuario) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }
}    
 class ordenar implements Comparator<Usuario>{

    @Override
    public int compare(Usuario t, Usuario t1) {
     return t.getId()-t1.getId();
    }

}
    
    

