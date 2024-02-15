/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daw;

import java.util.ArrayList;

/**
 *
 * @author 
 */
public class Main {
    
    public static void main(String[] args) {
        
       
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
    
    private static ArrayList<Viaje> getListaViajes(){
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
}
