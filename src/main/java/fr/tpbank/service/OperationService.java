package fr.tpbank.service;

import fr.tpbank.dao.interfaces.CompteDAO;
import fr.tpbank.dao.interfaces.OperationDAO;
import fr.tpbank.model.Compte;
import fr.tpbank.model.Operation;

import java.util.List;

public class OperationService {

    private final OperationDAO operationDAO;
    private final CompteDAO compteDAO;

    public OperationService(OperationDAO operationDAO, CompteDAO compteDAO) {
        this.operationDAO = operationDAO;
        this.compteDAO = compteDAO;
    }

    public List<Operation> listerOperations(int compte_id) {
        Compte compte = compteDAO.findByID(compte_id);

        if(compte==null){
            throw new IllegalArgumentException("Compte introuvable");
        }

        return operationDAO.findByCompteId(compte_id);
    }
}
