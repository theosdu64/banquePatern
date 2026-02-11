package fr.tpbank.model;

public abstract class Compte {
    protected int id;
    protected double solde;
    protected Client client;

    protected Compte(int id, double solde, Client client) {
        this.id = id;
        this.solde = solde;
        this.client = client;
    }

    public double getSolde() {
        return solde;
    }

    public void setSolde(double solde) {
        this.solde = solde;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void deposer(double montant) {
        if(montant < 0) {
            throw new IllegalArgumentException("Montant Invalide");
        }
        solde += montant;
    }

    public abstract void retirer(double montant);

    @Override
    public String toString() {
        return "Compte{" +
                "id=" + id +
                ", solde=" + solde +
                ", client=" + client +
                '}';
    }
}
