/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daw;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;

/**
 *
 * @author
 */
public class Main {

    public static void main(String[] args) {

        ArrayList<Viaje> listaViajes = getListaViajes();
        
        //Metodo A
        HashMap<String, Integer> listaOrigen = listaOrigen(listaViajes);
        System.out.println("Metodo A -> lista de viajes por origen y cantidad:");
        listaOrigen.forEach((k, v) -> System.out.println("origen: " + k + " " + v + " viajes"));
        
        
        
        //Metodo B
        System.out.println("Metodo B-> lista de viajes por destino");
        HashSet<String> listaDestinos=listaDestino(listaViajes);
        Iterator<String> it= listaDestinos.iterator();
        while(it.hasNext()){
            System.out.println("destino: "+ it.next());
        }
        for (Iterator<String> iterator = listaDestinos.iterator(); iterator.hasNext();) {
            String next = iterator.next();
            System.out.println("Destinos: " + next );
            
        }
        
        //Metodo C
         HashMap<String, Integer> listaPasajerosDestino = cantidadPasajerosDestino(listaViajes);
         Iterator<String> it2=listaPasajerosDestino.keySet().iterator();
         
         while(it2.hasNext()){
             String texto = it2.next();
             System.out.println("Destino " +texto +" pasajeros " + listaPasajerosDestino.get(texto));
         }
//         for (Map.Entry<String, Integer> entry : listaPasajerosDestino.entrySet()) {
//            Object key = entry.getKey();
//            Object val = entry.getValue();
//             System.out.println("Destino "+ key + " Pasajeros: " + val);
//            
//        }
        

        // Metodo C
        
        ordenar(listaViajes);
        listaViajes.forEach(e->System.out.println("Destino: "+ e.destino()+ " nº " + e.numeroPasajeros()));
         
         

    }

    //----------------------------------------
    // ABRE EL ARCHIVO POM.XML, MODIFICA EL CONTENIDO QUE HAY ENTRE LAS ETIQUETAS
    // <artifactId>PruebaFeb24</artifactId> PARA QUE SEA <artifactId>PruebaFeb24+TUNOMBRE</artifactId>
    // CREA UN REPOSITORIO LOCAL GIT, AÑADE EN UN PRIMER COMMIT LOS ARCHIVOS NECESARIOS
    // DEL PROYECTO. EL REPOSITORIO, AL FINALIZAR LA PRUEBA, DEBE CONTENER CUATRO COMMITS, UNO POR CADA
    // APARTADO. AL CREAR EL ZIP, INCLUYE LA CARPETA .GIT. SI NO HAY CONTROL DE VERSIONES CORRECTO
    // NO SE CORRIGE EL RESTO
    //---------------------------------------
    // A.- Crea un método que reciba la lista y devuelva una estructura de datos/colección
    // / con el número de viajes que salen de cada ciudad de origen. Usa el método en el main
    // e imprime el resultado usando un foreach
    // B.- Crea un método que reciba la lista y devuelva una estructura de datos/colección 
    // con todos los destinos diferentes. Usa el método en el main
    // e imprime el resultado usando un iterador
    // C.- Crea un método que reciba la lista y devuelva una estructura de datos/colección
    // para saber por cada ciudad destino el número total de viajeros que llegan ese día
    // Usa el método en el main, obten las claves de la estructura devuelta e iterando por ellas imprime 
    // el número de viajeros por ciudad
    // D.- Crea un método que reciba la lista y la ordene por destino y si hay
    // destinos iguales se ordenan por número de viajeros. Usa el método en el main
    // e imprime el resultado usando foreach con expresión lambda, para obtener
    // una salida como esta por cada elemento: "Destino: Estepona Viajeros: 35" 
    //---------------------------------------
    private static ArrayList<Viaje> getListaViajes() {
        ArrayList<Viaje> listaViajes = new ArrayList();
        // Origen - destino - número de pasajeros
        listaViajes.add(new Viaje("Estepona", "Málaga", 120));
        listaViajes.add(new Viaje("Estepona", "Granada", 45));
        listaViajes.add(new Viaje("Estepona", "Algeciras", 100));
        listaViajes.add(new Viaje("Algeciras", "Málaga", 20));
        listaViajes.add(new Viaje("Algeciras", "Granada", 50));
        listaViajes.add(new Viaje("Granada", "Estepona", 35));
        listaViajes.add(new Viaje("Casares", "Málaga", 12));
        listaViajes.add(new Viaje("Marbella", "Málaga", 120));

        return listaViajes;
    }

    public static HashMap<String, Integer> listaOrigen(ArrayList<Viaje> listaViajes) {
        HashMap<String, Integer> listaDevuelta = new HashMap<>();

        for (Viaje p : listaViajes) {
            if (listaDevuelta.containsKey(p.origen())) {
                listaDevuelta.put(p.origen(), listaDevuelta.get(p.origen()) + 1);
            } else {
                listaDevuelta.put(p.origen(), 1);
            }

        }
        return listaDevuelta;
    }
    
    
    public static HashSet<String> listaDestino(ArrayList<Viaje> listaViajes){
        HashSet<String> listaDevuelta = new HashSet<>();
        for(Viaje p:listaViajes){
            listaDevuelta.add(p.destino());
        }
      
        return listaDevuelta;
    }
    
    public static HashMap<String,Integer> cantidadPasajerosDestino(ArrayList<Viaje> listaViajes){
        HashMap<String, Integer> listaDevuelta = new HashMap<>();
        for (Viaje p : listaViajes) {
            if (listaDevuelta.containsKey(p.destino())) {
                listaDevuelta.put(p.destino(), listaDevuelta.get(p.destino()) + p.numeroPasajeros());
            } else {
                listaDevuelta.put(p.destino(), p.numeroPasajeros());
            }

        }
        return listaDevuelta;
    }
            
    
    public static void ordenar (ArrayList<Viaje> viajes){
        Comparator<Viaje> porPasajero= (e1,e2)-> e1.numeroPasajeros()-e2.numeroPasajeros();
        //Comparator<Viaje> porPasajero= (e1,e2)-> Integer.compare(e1.numeroPasajeros(), e2.numeroPasajeros());
        Comparator<Viaje> porDestino=(v1,v2)-> v1.destino().compareTo(v2.destino());
        Collections.sort(viajes,porDestino.thenComparing(porPasajero));
        
        
        }
}
