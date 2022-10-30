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
public class Pila {
    
    private Nodo inicio;
    private int tamaño;
    
    public Pila(){
        this.inicio = null;
        this.tamaño = 0;
    }
    
    public boolean PilaVacia(){
        return inicio == null;
    }
    
    public int getTamaño() {
        return tamaño;
    }
    
    public boolean Apilar(Vegetal vegetal){
        Nodo nuevo = new Nodo();
        nuevo.setVegetal(vegetal);
        
        if(PilaVacia()){
            inicio = nuevo;
        }else{
            nuevo.setSiguiente(inicio);
            inicio = nuevo;
        }
        tamaño++;
        return true;
    }
    
    public String Cima(){
        if(!PilaVacia()){
            Vegetal aux = inicio.getVegetal();
            return aux.toString();
        }else{
            return "La pila esta vacia";
        }
    }
    
    public String MostrarPila(){
        Nodo auxiliar = inicio;
        String mostrar = "";
        while(auxiliar != null) {
            Vegetal vegetal = auxiliar.getVegetal();
            mostrar += (vegetal.toString() + "\n"); 
            auxiliar = auxiliar.getSiguiente();
        }
        return mostrar;
    }
    
    public boolean Buscar (int elemento_buscar){
        Nodo auxiliar = inicio;
        boolean existe = false;
        
        while(existe != true && auxiliar != null){
            Vegetal vegetal = auxiliar.getVegetal();
            
            if(elemento_buscar == vegetal.getId()){
            
                existe = true;
            
            }else{
              
                auxiliar = auxiliar.getSiguiente();
            
            }
        }
        return existe;
    }
    
    public String EliminarTope(){
        if(!PilaVacia()){
            Vegetal vegetal = inicio.getVegetal();
            inicio = inicio.getSiguiente(); //Elimina el enlace
            tamaño--;
            return "El elemento eliminado es: " + vegetal.toString();
            
        }else{
            return "El invetario se encuentra vacio";
        }
        
    }
    
    public void EliminarPila(){
        inicio = null;
        tamaño = 0;
    }
    
    public boolean EliminarElemento(int elemento_eliminar){
        boolean estado;
        if(!PilaVacia()){
            if(Buscar(elemento_eliminar)){
                estado = true;
                Nodo pilaAuxiliar = null;


                while(elemento_eliminar != inicio.getVegetal().getId()){

                    Nodo temporal = new Nodo();
                    temporal.setVegetal(inicio.getVegetal());

                    if(pilaAuxiliar == null){

                        pilaAuxiliar = temporal;

                    }else{

                        temporal.setSiguiente(pilaAuxiliar);
                        pilaAuxiliar = temporal;
                    }

                    EliminarTope();

                }

                EliminarTope();
                tamaño--;
                while(pilaAuxiliar != null){

                    Apilar(pilaAuxiliar.getVegetal());
                    pilaAuxiliar = pilaAuxiliar.getSiguiente();

                }
                pilaAuxiliar = null;
            }else{
                System.out.println("\nEl elemento no se encuentra en el inventario, vuelve a intentarlo...\n");
                estado = false;
            }
            return estado;
        }else{
            estado = false;
            System.out.println("El inventario esta vacio.");
            return estado;
        }    
    }
    
    public boolean Actualizar(int valor_actualizar, Vegetal vegetal){
        boolean estado;
        if(!PilaVacia()){
            if(Buscar(valor_actualizar)){
                estado = true;
                Nodo pilaAuxiliar = null;


                while(valor_actualizar != inicio.getVegetal().getId()){

                    Nodo temporal = new Nodo();
                    temporal.setVegetal(inicio.getVegetal());

                    if(pilaAuxiliar == null){

                        pilaAuxiliar = temporal;

                    }else{

                        temporal.setSiguiente(pilaAuxiliar);
                        pilaAuxiliar = temporal;
                    }

                    EliminarTope();

                }

                inicio.setVegetal(vegetal);

                while(pilaAuxiliar != null){

                    Apilar(pilaAuxiliar.getVegetal());
                    pilaAuxiliar = pilaAuxiliar.getSiguiente();

                }
                pilaAuxiliar = null;
            }else{
                System.out.println("\nEl elemento no se encuentra en el inventario, vuelve a intentarlo...\n");
                estado = false;
            }
            return estado;
        }else{
            estado = false;
            System.out.println("El inventario esta vacio.");
            return estado;
        }
    }
    
    public void Modificar(int cantidad, int id){
        if(Buscar(id)){
                Nodo pilaAuxiliar = null;


                while(id != inicio.getVegetal().getId()){

                    Nodo temporal = new Nodo();
                    temporal.setVegetal(inicio.getVegetal());

                    if(pilaAuxiliar == null){

                        pilaAuxiliar = temporal;

                    }else{

                        temporal.setSiguiente(pilaAuxiliar);
                        pilaAuxiliar = temporal;
                    }

                    EliminarTope();

                }
                int auxiliar = inicio.getVegetal().getCantidad() + (cantidad);
                System.out.println("Antes: " + inicio.getVegetal().toString() + "\n");
                inicio.getVegetal().setCantidad(auxiliar);
                System.out.println("Después: " + inicio.getVegetal().toString() + "\n");
                while(pilaAuxiliar != null){

                    Apilar(pilaAuxiliar.getVegetal());
                    pilaAuxiliar = pilaAuxiliar.getSiguiente();

                }
                pilaAuxiliar = null;
            }
    }
    
    public void Modificar2(int cantidad, int id){
        if(Buscar(id)){
                Nodo pilaAuxiliar = null;


                while(id != inicio.getVegetal().getId()){

                    Nodo temporal = new Nodo();
                    temporal.setVegetal(inicio.getVegetal());

                    if(pilaAuxiliar == null){

                        pilaAuxiliar = temporal;

                    }else{

                        temporal.setSiguiente(pilaAuxiliar);
                        pilaAuxiliar = temporal;
                    }

                    EliminarTope();

                }
                boolean estado = false;
                do{
                    int auxiliar = inicio.getVegetal().getCantidad() - cantidad;
                    if(0 < auxiliar){
                        estado = true;
                        System.out.println("Antes: " + inicio.getVegetal().toString() + "\n");
                        inicio.getVegetal().setCantidad(auxiliar);
                        System.out.println("Después: " + inicio.getVegetal().toString() + "\n");
                    }else{
                        System.out.println("Ingresaste una cantidad incorrecta, por lo tanto no se puede modificar la cantidad del producto. Vuelve a intentarlo\n");
                    }
                }while(estado != true);    
                while(pilaAuxiliar != null){

                    Apilar(pilaAuxiliar.getVegetal());
                    pilaAuxiliar = pilaAuxiliar.getSiguiente();

                }
                pilaAuxiliar = null;
            }
    }
    
    public String Filtrar(int tipo){
        Nodo auxiliar = inicio;
        String mostrar = "";
        while(auxiliar != null) {
            
            if(auxiliar.getVegetal().clasificacion == tipo){
                mostrar += auxiliar.getVegetal().toString() + "\n";
            }
            auxiliar = auxiliar.getSiguiente();
        }
        return mostrar;
    }
    
    public void OrdenamientoInsercion(int n){
        Nodo aux = inicio;
        int x = 0;
        Vegetal ordenar[] = new Vegetal[this.tamaño];
        if(!PilaVacia()){
            while(aux != null){
                ordenar[x] = aux.getVegetal();
                aux = aux.getSiguiente();
                x++;
            }
        }else{
            System.out.println("El inventario esta vacio.");
        }
        int posicion;
        Vegetal auxiliar;
        for(int i = 0; i < this.tamaño; i++){
            posicion = i;
            auxiliar = ordenar[posicion];
            while((posicion > 0) && (ordenar[posicion-1].getCantidad() > auxiliar.getCantidad())){
                ordenar[posicion] = ordenar[posicion-1];
                posicion--;
            }
            ordenar[posicion] = auxiliar;
        }
        
        if(n == 1){
            System.out.println("\nOrden Ascendente:\n");
            for(int i = 0; i < this.tamaño; i++){
                System.out.print(ordenar[i].toString() + "\n");
            }
        }else if(n == 2){
            System.out.println("\nOrden Descendente:\n");
            for(int i = this.tamaño-1; i > 0; i--){
                System.out.print(ordenar[i].toString() + "\n");
            }
        }
        
        
        
    }
    

}    
    
