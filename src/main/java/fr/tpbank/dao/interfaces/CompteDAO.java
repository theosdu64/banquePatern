package fr.tpbank.dao.interfaces;

import fr.tpbank.model.Compte;

import java.util.List;

public interface CompteDAO {
    Compte findByID(int id);
    List<Compte> findAllComptesByClient(int client_id);
    void save(Compte compte);
    void updateSolde(int idCompte, double montant);
}
