package org.example;

public class Prodotti {
    int id;
    int qta; //quantità prodotto
    String nomeProdotto;
    String descrizione;
    double costo;
    Prodotti(){}

    public Prodotti(int id, int qta, String nomeProdotto, String descrizione, double costo) {
        this.id = id;
        this.qta = qta;
        this.nomeProdotto = nomeProdotto;
        this.descrizione = descrizione;
        this.costo = costo;
    }

    @Override
    public String toString() {
        return "{" +
                "id=" + id +
                ", qta=" + qta +
                ", nomeProdotto=" + nomeProdotto +
                ", descrizione=" + descrizione +
                ", costo=" + costo +
                '}';
    }


}
