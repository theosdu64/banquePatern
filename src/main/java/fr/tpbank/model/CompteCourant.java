package fr.tpbank.model;

public class CompteCourant extends Compte{

    private double decouvertAutorisé;
    private double frais;

    public CompteCourant(int id, double solde, Client client, double decouvertAutorisé, double frais) {
        super(id, solde, client);
        this.decouvertAutorisé = decouvertAutorisé;
        this.frais = frais;
    }

    @Override
    public void retirer(double montant) {
        if(montant < 0) {
            throw new IllegalArgumentException("Montant negatif");
        }
        if(solde + decouvertAutorisé < montant) {
            throw new IllegalStateException("Solde Insuffisant");
        }

        solde -= montant + frais;
    }

    @Override
    public String toString() {
        return "CompteCourant{" +
                "decouvertAutorisé=" + decouvertAutorisé +
                ", frais=" + frais +
                ", id=" + id +
                ", solde=" + solde +
                ", client=" + client +
                '}';
    }
}
