
/**
 * Write a description of class Barbero here.
 *
 * @author Adrian Hernandez Islas
 * @version 0.0.1
 */

import java.util.Queue;
import java.util.LinkedList;

public class Barbero
{
    
    public Barbero()
    {
        
    }

    public Queue<Integer> ocuparLugares(int clientes){
        Queue<Integer> asientos = new LinkedList<>();
        for(int i=1 ; i <= clientes ;i++){
            asientos.add(i);
        }
        return asientos;
    }
    
    public Queue<Integer> crearFila(int totalAsientos,int clientesTotales){
        Queue<Integer> filaClientes = new LinkedList<>();
        
        for(int i = totalAsientos+1 ; i <= clientesTotales ; i ++ ){
            filaClientes.add(i);
        }
        
        return filaClientes;
    }
    
    public void imprimir(Queue<Integer> filaClientes){
        for(Integer cliente:filaClientes){
            System.out.print(cliente+" ");
        }
        System.out.println();
    }
    
    public void mostrarClientes(Queue<Integer> asientos, Queue<Integer> filaClientes, int tiempo){
        System.out.println("\t\t\tTiempo Acumulado: "+tiempo);
        for(Integer asiento: asientos){
            System.out.print("|"+asiento);
        }
        System.out.print(" --- ");
        for(Integer cliente: filaClientes){
            System.out.print(cliente+" ");
        }
        System.out.println();
    }
    
    public void esperar(){
       try{
        Thread.sleep(5000);
       }catch(InterruptedException ex){}
    }
    
    
    public void atender(int clientes,int totalAsientos){
        Queue<Integer> asientos = null;
        int tiempoAcumulado = 0;
        
        if(clientes > totalAsientos ){
            asientos = ocuparLugares(totalAsientos);
        }else{
            asientos = ocuparLugares(clientes);
        }
        
        Queue<Integer> filaClientes =  crearFila(totalAsientos,clientes);
        int cliente = 0;
        mostrarClientes(asientos,filaClientes,tiempoAcumulado);
        while(!asientos.isEmpty()){
           cliente = asientos.remove();
           if(!filaClientes.isEmpty()){
               asientos.add(filaClientes.remove());
           }
           esperar();
           tiempoAcumulado+=5;
           mostrarClientes(asientos,filaClientes,tiempoAcumulado);
        }
    }
    
    
    public static void main(String args[]){
        Barbero barbero = new Barbero();
        barbero.atender(10,5);
    }
}
