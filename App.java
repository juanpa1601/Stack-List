/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fruver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author Juan Pablo
 */
public class App {
    
    public static void main(String[] args) throws IOException {
    BufferedReader cp = new BufferedReader(new InputStreamReader(System.in));
    Pila inventario = new Pila();
    String nombre;
    int opcion, tipo, id, cantidad;
    do{
        String menu = "\n---MENÚ---\n"
                    + "1. Apilar producto en el inventario\n"
                    + "2. Agregar cantidad de un producto\n"
                    + "3. Disminuir cantidad de un producto\n"
                    + "4. Mostrar los productos del inventario\n"
                    + "5. Mostrar el primer producto del inventario\n"
                    + "6. Buscar un elemento en el inventario\n"
                    + "7. Eliminar el primero producto del inventario\n"
                    + "8. Eliminar un elemento en especificico del inventario\n"
                    + "9. Borrar inventario\n"
                    + "10. Actualizar un elemento del inventario\n"
                    + "11. Filtrar inventario\n"
                    + "12. Ordenarmiento del inventario por cantidad\n"
                    + "0. Salir\n"
                    + "\nDigite la opción deseada\n";
            
                    System.out.println(menu);
                    opcion = Integer.parseInt(cp.readLine());
                    
                    switch(opcion){
                        case 1:
                            System.out.println("\n---REGISTRO AL INVENTARIO---\n");
                            System.out.println("\n");
                            boolean estado = false;
                            do{
                                System.out.println("Ingrese una de las siguientes opciones:\n"
                                        + "1. fruta\n"
                                        + "2. verdura\n");
                                tipo = Integer.parseInt(cp.readLine());
                                if(tipo == 1 || tipo == 2){
                                    estado = true;
                                }else{
                                    System.out.println("Ingreso una opción incorrecta, vuelve a intentarlo\n");
                                }
                            }while(estado != true); 
                            
                            System.out.println("\n");
                            do{
                                System.out.println("Ingrese el nombre del producto: ");
                                nombre = cp.readLine();
                                nombre = nombre.toLowerCase();
                                if(isBlank(nombre) == true){
                                    System.out.println("Ingreso una opción incorrecta, vuelve a intentarlo\n");
                                    estado = false;
                                }else{
                                    estado = true;
                                }
                            }while(estado != true);
                            
                            System.out.println("\n");
                            do{
                                System.out.println("Ingrese la cantidad del producto: ");
                                cantidad = Integer.parseInt(cp.readLine());
                                if(0 < cantidad){
                                    estado = true;
                                }else{
                                    System.out.println("Las cantidades tienen que se 'x > 0', vuelve a intentarlo\n");
                                    estado = false;
                                }
                            }while(estado != true);
                            
                            System.out.println("\n");
                            do{
                                System.out.println("Ingrese el id para el inventario:");
                                id = Integer.parseInt(cp.readLine());
                                if(100 <= id){    
                                    if(!inventario.Buscar(id)){
                                        estado = true;
                                    }else{
                                        System.out.println("Este id ya existe, vuelve a intentarlo\n");
                                        estado = false;
                                    }
                                }else{
                                    System.out.println("Ingreso un dato incorrecto recuerde que el formato de id es '1xx', vuelve a intentarlo\n");
                                    estado = false;
                                }    
                            }while(estado != true);
                            Vegetal v1 = new Vegetal(nombre, tipo, cantidad, id);
                            inventario.Apilar(v1);
                            break;
                        case 2:
                            System.out.println("\n---AGREGAR CANTIDAD A UN PRODUCTO---\n");
                            boolean estado2 = false;
                            if(!inventario.PilaVacia()){    
                                do{
                                    System.out.println("Ingrese el id para buscar el producto en el inventario: ");
                                    id = Integer.parseInt(cp.readLine());
                                    if(100 <= id){
                                        if(inventario.Buscar(id)){
                                            System.out.println("Ingrese la cantidad que desea agregar: ");
                                            int auxiliar = Integer.parseInt(cp.readLine());
                                            inventario.Modificar(auxiliar, id);
                                            estado2 = true;
                                        }else{
                                            System.out.println("El id no se encuentra en el invetario, vuelve a intentarlo\n");
                                        }
                                    }
                                }while(estado2 != true);
                            }else{
                                System.out.println("El inventario esta vacio.\n");
                            }
                            break;
                        case 3:
                            System.out.println("\n--ELIMINAR CANTIDAD A UN PRODUCTO---\n");
                            boolean estado3 = false;
                            if(!inventario.PilaVacia()){    
                                do{
                                    System.out.println("Ingrese el id para buscar el producto en el inventario: ");
                                    id = Integer.parseInt(cp.readLine());
                                    if(100 <= id){
                                        if(inventario.Buscar(id)){
                                            System.out.println("Ingrese la cantidad que desea disminuir: ");
                                            int auxiliar = Integer.parseInt(cp.readLine());
                                            inventario.Modificar2(auxiliar, id);
                                            estado3 = true;
                                        }else{
                                            System.out.println("El id no se encuentra en el invetario, vuelve a intentarlo\n");
                                        }
                                    }
                                }while(estado3 != true);
                            }else{
                                System.out.println("El inventario esta vacio.\n");
                            }
                            break;
                        case 4:
                            System.out.println("\n---MOSTRAR INVENTARIO---\n");
                            if(!inventario.PilaVacia()){
                                System.out.println(inventario.MostrarPila());
                            }else{
                                System.out.println("El inventario esta vacio.");
                            }
                            break;
                        case 5:
                            System.out.println("\n---PRIMER ELEMENTO DEL INVENTARIO---\n");
                            System.out.println("La cima es: \n"
                                    + inventario.Cima());
                            break;
                        case 6:
                            System.out.println("\n---SISTEMA DE BUSQUEDA---\n");
                            System.out.println("Ingrese el código del elemento a buscar en el inventario: ");
                            id = Integer.parseInt(cp.readLine());
                            if(inventario.Buscar(id)){
                                System.out.println("El elemento se encuentra en el inventario");
                            }else{
                                System.out.println("El elemento no se encuentra en el inventario");
                            }
                            break;
                        case 7:
                            System.out.println("\n---ELIMINAR EL PRIMER REGISTRO DEL INVENTARIO---\n");
                            System.out.println(inventario.EliminarTope());
                            break;
                        case 8:
                            System.out.println("\n---ELIMINAR UN REGISTRO ESPECIFICO DEL INVENTARIO---\n");
                            System.out.println("Ingrese el id del elemento a eliminar: ");
                            id = Integer.parseInt(cp.readLine());
                            if(inventario.EliminarElemento(id)){
                                System.out.println("El elemento fue eliminado.\n");
                                System.out.println("El inventario quedo así: ");
                                System.out.println(inventario.MostrarPila());
                            }
                            break;
                        case 9:
                            System.out.println("\n---ELIMINACION DE INVENTARIO---\n");
                            if(!inventario.PilaVacia()){    
                                System.out.println("¿Esta seguro que desea eliminar el inventario?\n"
                                        + "1. si\n"
                                        + "2. no\n");
                                int verificacion = Integer.parseInt(cp.readLine());
                                if(verificacion == 1){
                                    inventario.EliminarPila();
                                    System.out.println("El inventario ha sido elimnado.");
                                }else{
                                    System.out.println("El inventario no ha sido eliminado.");
                                }
                            }else{
                                System.out.println("El inventario no se puede eliminar, porqué está vacio.");
                            }
                            break;
                        case 10:
                            System.out.println("\n---ACTUALIZACION DE INVENTARIO----\n");
                            boolean estado4 = false;
                            System.out.println("Ingrese el id para buscar el registro en el inventario:");
                            do{
                                id = Integer.parseInt(cp.readLine());
                                if(100 <= id){
                                    estado4 = true;
                                }else{
                                    System.out.println("Ingreso un rango incorrecto, vuelve a intentarlo\n");
                                }    
                            }while(estado4 != true);
                            
                            System.out.println("\n");
                            if(inventario.Buscar(id)){
                                System.out.println("El registro se encuentra en el inventario. Ingrese los datos para la actualización");
                                System.out.println("Ingrese una de las siguientes opciones:\n"
                                    + "1. fruta\n"
                                    + "2. verdura\n");
                            do{    
                                tipo = Integer.parseInt(cp.readLine());
                                if(tipo == 1 || tipo == 2){
                                    estado4 = true;
                                }else{
                                    System.out.println("Ingreso una opción incorrecta, vuelva a intentarlo\n");
                                }
                            }while(estado4 != true);
                            
                            System.out.println("\n");
                            System.out.println("Ingrese el nombre del producto: ");
                            do{
                                nombre = cp.readLine();
                                nombre = nombre.toLowerCase();
                                if(!isBlank(nombre) == true){
                                    estado = true;
                                }else{
                                    System.out.println("Ingreso una opción incorrecta, vuelve a intentarlo\n");
                                }
                            }while(estado4 != true);
                            System.out.println("\n");
                            
                            System.out.println("Ingrese la cantidad del producto: ");
                            do{
                                cantidad = Integer.parseInt(cp.readLine());
                                if(100 <= id){    
                                    if(!inventario.Buscar(id)){
                                        estado = true;
                                    }else{
                                        System.out.println("Este id ya existe, vuelve a intentarlo\n");
                                    }
                                }else{
                                    System.out.println("Ingreso un dato incorrecto recuerde que el formato de id es '1xx', vuelve a intentarlo\n");
                                }    
                            }while(estado4 != true);
                            System.out.println("\n");
                            Vegetal v2 = new Vegetal(nombre, tipo, cantidad, id);
                            if(inventario.Actualizar(id, v2)){
                                System.out.println("El valor se ha actualizado correctamente\n");
                                System.out.println(inventario.MostrarPila());
                            }
                            }else{
                                System.out.println("El registro no se encuentra en el inventario");
                            }
                            break;
                        case 11:
                            System.out.println("\n---FILTRAR INVENTARIO---\n");
                            System.out.println("\n");
                            boolean estado5 = false;
                            do{
                                System.out.println("Ingrese una de las siguientes opciones:\n"
                                        + "1. fruta\n"
                                        + "2. verdura\n");
                                tipo = Integer.parseInt(cp.readLine());
                                if(tipo == 1 || tipo == 2){
                                    estado5 = true;
                                }else{
                                    System.out.println("Ingreso una opción incorrecta, vuelve a intentarlo\n");
                                }
                            }while(estado5 != true); 
                            
                            System.out.println("\n");
                            System.out.println("El filtro es el siguiente:\n"
                                    + inventario.Filtrar(tipo));
                            break;
                        case 12:
                            System.out.println("\n---ORDENAMIENTO POR CANTIDAD---\n");
                            boolean estado6 = false;
                            do{
                                System.out.println("Ingrese una de las siguientes opciones:\n"
                                        + "1. Orden Ascendente\n"
                                        + "2. Orden Descendente\n");
                                tipo = Integer.parseInt(cp.readLine());
                                if(tipo == 1 || tipo == 2){
                                    estado6 = true;
                                    inventario.OrdenamientoInsercion(tipo);
                                }else{
                                    System.out.println("Ingreso una opción incorrecta, vuelve a intentarlo\n");
                                }
                            }while(estado6 != true); 
                            break;
                        case 0:
                            System.out.println("Finalizando programa.");
                            break;
                        default:
                            System.out.println("Error. Ingreso una opción incorrecta...");
                            break;
                            
                    }
    }while(opcion != 0);
    
    }

        public static boolean isBlank(String str){
            return str.trim().isEmpty();
        }
}
