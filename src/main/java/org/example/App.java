package org.example;

/**
 * Server multi thread per elaborazione e salvataggio in un database
 * Restituisce lista intera
 * sort per prezzo crescente
 * prodotto con maggiore quantità
 * prodotto con prezzo minore
 * somma di tutti i prezzi
 */
public class App 
{
    public static void main( String[] args )
    {
        Elaborazione el=new Elaborazione();
        el.createEl();
        Server server= new Server(1234);
    }
}
