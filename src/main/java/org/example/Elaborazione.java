package org.example;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Locale;

public class Elaborazione extends Thread{
    Gson gson=new Gson();
    Socket clientSocket=null;
    ServerSocket serverSocket=null;
    static Elaborazione_Arraylist el; //N.B: la variabile deve essere per forza statica

    Elaborazione(){}

    Elaborazione(Socket clientSocket, ServerSocket serverSocket){
        this.clientSocket=clientSocket;
        this.serverSocket=serverSocket;
    }
    void createEl(){ //inizializza variabile per l'elaborazione dell'array list e crea la lista
        el=new Elaborazione_Arraylist();
        el.crea_lista();
    }
    @Override
    public void run(){
        BufferedReader input=null;
        try {
            input=new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        } catch (IOException e) {
            System.out.println("Errore buffered reader\n"+e.toString());
        }
        String messaggio=""; //messaggio che arriva al server
        PrintWriter output=null; //risponde al client
        try {
            output=new PrintWriter(clientSocket.getOutputStream(),true);
        } catch (IOException e) {
            System.out.println("Errore printwriter \n"+e.toString());
        }
        output.println("CONNESSO AL SERVER");

        try {
            while ((messaggio = input.readLine()) != null) { //legge input
                //qui faremo l'elaborazione dei nostri dati
                output.println(elaborazione_messaggio(messaggio.toLowerCase(Locale.ROOT)));
            }
        }catch(IOException e){
            System.out.println("Errore nella lettura\n"+e.toString());
        }
    }

    String elaborazione_messaggio(String digitato){
        String result="";
        switch (digitato){
            case "all":
                result=el.all();
                break;
            case "sum":
                result=el.sum();
                break;
            case "minor":
                result=el.minorPrice();
                break;
            case "sort":
                result=el.sort();
                break;
            default:
                result="Comando errato!";
                break;
        }
        return result;
    }






}
