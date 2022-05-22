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
    static Elaborazione_Arraylist el;

    Elaborazione(){}

    Elaborazione(Socket clientSocket, ServerSocket serverSocket){
        this.clientSocket=clientSocket;
        this.serverSocket=serverSocket;
    }
    void createEl(){
        el=new Elaborazione_Arraylist();
        el.crea_lista();
        System.out.println(el.arr.get(1).costo);
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
                output.println(el.all());
                
            }
        }catch(IOException e){
            System.out.println("Errore nella lettura\n"+e.toString());
        }

    }








}
