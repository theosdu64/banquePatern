package fr.tpbank.business;

import fr.tpbank.dao.ClientDAOImpl;
import fr.tpbank.dao.CompteDAOImpl;
import fr.tpbank.dao.OperationDAOImpl;
import fr.tpbank.dao.interfaces.ClientDAO;
import fr.tpbank.dao.interfaces.CompteDAO;
import fr.tpbank.dao.interfaces.OperationDAO;
import fr.tpbank.model.*;
import fr.tpbank.service.ClientService;
import fr.tpbank.service.CompteService;
import fr.tpbank.service.OperationService;

import java.util.List;

public class BankingBusiness {

    private final CompteService compteService;
    private final ClientService clientService;
    private final OperationService operationService;

    public BankingBusiness() {
        CompteDAO compteDAO = new CompteDAOImpl();
        ClientDAO clientDAO = new ClientDAOImpl();
        OperationDAO operationDAO = new OperationDAOImpl();

        this.compteService = new CompteService(compteDAO, clientDAO, operationDAO);
        this.clientService = new ClientService(clientDAO);
        this.operationService = new OperationService(operationDAO, compteDAO);
    }

    public void afficherResume(int clientId) {
        Client client = clientService.findById(clientId);

        System.out.println("Client: " + client.getName() + " " + client.getSurname());
        System.out.println("Email: " + client.getEmail());
        System.out.println();

        List<Compte> comptes = compteService.listerCompte(clientId);

        for (Compte c : comptes) {
            String typeCompte = c instanceof CompteCourant ? "Compte Courant" : "Compte Épargne";
            System.out.println(typeCompte);
            System.out.println("   Solde: " + c.getSolde());

            if (c instanceof CompteCourant cc) {
                System.out.println("   Découvert autorisé: " + cc.getDecouvertAutorisé());
                System.out.println("   Frais: " + cc.getFrais());
            } else if (c instanceof CompteEpargne ce) {
                System.out.println("   Taux d'intérêt: " + ce.getTaux_interet() + "%");
            }
        }
    }

    public void deposer(int compteId, double montant) {
        try {
            double soldeAvant = compteService.consulterSolde(compteId);
            System.out.println("Ancien Solde : " + soldeAvant);

            compteService.deposer(compteId, montant);

            double nouveauxSolde = compteService.consulterSolde(compteId);
            System.out.println("Nouveau Solde : " + nouveauxSolde);
        } catch (Exception e) {
            System.out.println("Erreur depot: " + e.getMessage());
        }
    }
    public void afficherHistorique(int compteId) {
        try {
            List<Operation> operations = operationService.listerOperations(compteId);

            if (operations.isEmpty()) {
                System.out.println("Pas d'operation trouvé");
            }

            for (Operation op : operations) {
                System.out.println(op.getDate().toLocalDate() + " " + op.getType() + " " + op.getMontant() + " €");
            }

        } catch (Exception e) {
            System.out.println("Erreur: " + e.getMessage());
        }
    }

}
