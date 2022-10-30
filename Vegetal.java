/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fruver;

/**
 *
 * @author Juan Pablo
 */
public class Vegetal {
    String nombre;
    int clasificacion; //"fruta" o "verdura"
    private int cantidad;
    private int id;

    public Vegetal(String nombre, int clasificacion, int cantidad, int id) {
        this.nombre = nombre;
        this.clasificacion = clasificacion;
        this.cantidad = cantidad;
        this.id = id;
    }

    public Vegetal(int id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
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
        final Vegetal other = (Vegetal) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }
    
    
    @Override
    public String toString() {
        return "vegetal{" + "nombre=" + nombre + ", clasificacion=" + clasificacion + ", cantidad=" + cantidad + ", id=" + id + '}';
    }


    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
   
}
