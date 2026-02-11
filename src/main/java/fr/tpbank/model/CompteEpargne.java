package fr.tpbank.model;

public class CompteEpargne extends Compte {

    private double taux_interet;

    public CompteEpargne(int id, double solde, Client client, double taux_interet) {
        super(id, solde, client);
        this.taux_interet = taux_interet;
    }

    public double getTaux_interet() {
        return taux_interet;
    }

    public void setTaux_interet(double taux_interet) {
        this.taux_interet = taux_interet;
    }

    @Override
    public void retirer(double montant) {
        if (montant <= 0) {
            throw new IllegalArgumentException("Montant invalide");
        }

        if (solde < montant) {
            throw new IllegalStateException("Solde insuffisant");
        }

        solde -= montant;
    }

    @Override
    public String toString() {
        return "CompteEpargne{" +
                "taux_interet=" + taux_interet +
                ", id=" + id +
                ", solde=" + solde +
                ", client=" + client +
                '}';
    }
}
