package fr.tpbank.model;

import java.time.LocalDateTime;

public class Operation {

    private int operation_id;
    private String type;
    private double montant;
    private LocalDateTime date;
    private Compte compte;

    public Operation(int operation_id, String type, double montant, LocalDateTime date, Compte compte) {
        this.operation_id = operation_id;
        this.type = type;
        this.montant = montant;
        this.date = date;
        this.compte = compte;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public int getOperation_id() {
        return operation_id;
    }

    public void setOperation_id(int operation_id) {
        this.operation_id = operation_id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getMontant() {
        return montant;
    }

    public void setMontant(double montant) {
        this.montant = montant;
    }

    public Compte getCompte() {
        return compte;
    }

    public void setCompte(Compte compte) {
        this.compte = compte;
    }

    @Override
    public String toString() {
        return "Operation{" +
                "id=" + operation_id +
                ", type='" + type + '\'' +
                ", montant=" + montant +
                ", date=" + date +
                ", compte=" + compte +
                '}';
    }
}
