package fr.tpbank.model;

public abstract class Compte {
    protected int compte_id;
    protected double solde;
    protected Client client;

    protected Compte(int compte_id, double solde, Client client) {
        this.compte_id = compte_id;
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
        return compte_id;
    }

    public void setId(int id) {
        this.compte_id = id;
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
                "id=" + compte_id +
                ", solde=" + solde +
                ", client=" + client +
                '}';
    }
}
