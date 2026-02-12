package fr.tpbank.model;

public class CompteCourant extends Compte{

    private double decouvertAutorisé;
    private double frais;

    public CompteCourant(int compte_id, double solde, Client client, double decouvertAutorisé, double frais) {
        super(compte_id, solde, client);
        this.decouvertAutorisé = decouvertAutorisé;
        this.frais = frais;
    }

    public double getDecouvertAutorisé() {
        return decouvertAutorisé;
    }

    public void setDecouvertAutorisé(double decouvertAutorisé) {
        this.decouvertAutorisé = decouvertAutorisé;
    }

    public double getFrais() {
        return frais;
    }

    public void setFrais(double frais) {
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
                ", id=" + compte_id +
                ", solde=" + solde +
                ", client=" + client +
                '}';
    }
}
