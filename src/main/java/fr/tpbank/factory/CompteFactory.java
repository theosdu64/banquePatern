package fr.tpbank.factory;

import fr.tpbank.model.Client;
import fr.tpbank.model.Compte;
import fr.tpbank.model.CompteCourant;
import fr.tpbank.model.CompteEpargne;

public class CompteFactory {

    public static Compte creerCompte(String type,int compte_id , double solde, Client client, double decouvert , double taux, int frais) {
        switch (type.toUpperCase()) {
            case "COURANT":
                return new CompteCourant(compte_id, solde, client, decouvert, frais);
            case "EPARGNE":
                return new CompteEpargne(compte_id, solde, client, taux);
            default:
                throw new IllegalArgumentException("Type de compte inexistant");
        }
    }
}
