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
public class Nodo {
    
    private Vegetal vegetal;
    private Nodo siguiente;

    public Nodo() {
        this.vegetal = null;
        this.siguiente = null;
    }

    public Nodo getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(Nodo siguiente) {
        this.siguiente = siguiente;
    }

    public Vegetal getVegetal() {
        return vegetal;
    }

    public void setVegetal(Vegetal vegetal) {
        this.vegetal = vegetal;
    }
    
    
}
