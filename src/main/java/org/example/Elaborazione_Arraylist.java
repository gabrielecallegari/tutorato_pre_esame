package org.example;

import java.util.ArrayList;

public class Elaborazione_Arraylist {
    ArrayList<Prodotti> arr;
    Elaborazione_Arraylist(){
        arr=new ArrayList<Prodotti>();
    }

    void add_Prodotti(int id,int qta,String nomeProdotto,String descrizione,double costo){
        Prodotti a=new Prodotti(id,qta,nomeProdotto,descrizione,costo);
        arr.add(a);
    }


    void crea_lista(){
        add_Prodotti(1,50,"coca cola","coca colaaaa",26.32);
        add_Prodotti(2,20,"geranio","geraniooo",48.35);
        add_Prodotti(3,30,"telefono","lolkisdolf",98.22);
        add_Prodotti(4,18,"sprite","cfasfgsda",96.22);
        add_Prodotti(5,99,"scarpa","grsgkajfsdg",33.52);
        add_Prodotti(6,2,"televisore","guirhfgsdgsdo",16.85);
    }
    String all(){
        String msg="All: ";
        for (int i = 0; i < arr.size(); i++) {
            msg=msg+arr.get(i).toString();
        }
        return "All: "+msg;
    }

    String sum(){
        String somma="";
        double som=0;
        for (int i = 0; i < arr.size(); i++) {
            som=som+arr.get(i).costo;
        }
        somma=Double.toString(som);
        return "Sum: "+somma;
    }

    String minorPrice(){
        arr.sort((Prodotti p1, Prodotti p2)->(int) (p1.costo-p2.costo));
        return "Minor price: "+arr.get(0).toString();
    }

    String sort(){
        arr.sort((Prodotti p1, Prodotti p2)->(int) (p1.costo-p2.costo));
        String msg="Sorted: ";
        for (int i = 0; i < arr.size(); i++) {
            msg=msg+arr.get(i).toString();
        }
        return msg;
    }

    String quantita(){
        arr.sort((Prodotti p1, Prodotti p2)->(p2.qta-p1.qta));
        return "Qta: "+arr.get(0).toString();
    }
}
