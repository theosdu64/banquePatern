package fr.tpbank.service;

import fr.tpbank.dao.interfaces.ClientDAO;
import fr.tpbank.dao.interfaces.CompteDAO;
import fr.tpbank.dao.interfaces.OperationDAO;
import fr.tpbank.model.Compte;
import fr.tpbank.model.Operation;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

public class CompteService {

    private final CompteDAO compteDAO;
    private final ClientDAO clientDAO;
    private final OperationDAO operationDAO;

    public CompteService(CompteDAO compteDAO,ClientDAO clientDAO, OperationDAO operationDAO) {
        this.compteDAO = compteDAO;
        this.clientDAO = clientDAO;
        this.operationDAO = operationDAO;
    }

    public double consulterSolde(int idCompte) {
        Compte compte = compteDAO.findByID(idCompte);

        if(compte==null){
            throw new IllegalArgumentException("Compte introuvable");
        }

        return compte.getSolde();
    }

    public List<Compte> listerCompte(int id_client) {
        return this.compteDAO.findAllComptesByClient(id_client);
    }

    public void deposer(int idCompte, double montant) {
        if(montant < 0) {
            throw new IllegalArgumentException("Montant invalide");
        }

        Compte compte = compteDAO.findByID(idCompte);

        if(compte==null){
            throw new IllegalArgumentException("Compte introuvable");
        }

        compte.deposer(montant);
        compteDAO.updateSolde(idCompte,compte.getSolde());

        Operation operation = new Operation(
            0,
            "DEPOT",
             montant,
             LocalDateTime.now(),
             compte
        );

        operationDAO.save(operation);
    }

    public void retirer(int idCompte, double montant) {
        Compte compte = compteDAO.findByID(idCompte);

        if(compte==null){
            throw new IllegalArgumentException("Compte introuvable");
        }

        double initialMontant = compte.getSolde();
        compte.retirer(montant);
        double montantFinal = initialMontant - compte.getSolde();

        compteDAO.updateSolde(idCompte,compte.getSolde());

        Operation operation = new Operation(
                0,
                "RETRAIT",
                montantFinal,
                LocalDateTime.now(),
                compte
        );
        operationDAO.save(operation);
    }


}
