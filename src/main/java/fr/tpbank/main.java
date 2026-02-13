package fr.tpbank;

import fr.tpbank.business.BankingBusiness;
import fr.tpbank.dao.ClientDAOImpl;
import fr.tpbank.dao.CompteDAOImpl;
import fr.tpbank.dao.OperationDAOImpl;
import fr.tpbank.dao.interfaces.ClientDAO;
import fr.tpbank.dao.interfaces.CompteDAO;
import fr.tpbank.dao.interfaces.OperationDAO;
import fr.tpbank.model.Client;
import fr.tpbank.model.Compte;
import fr.tpbank.model.CompteCourant;
import fr.tpbank.model.Operation;
import fr.tpbank.service.ClientService;
import fr.tpbank.service.CompteService;
import fr.tpbank.util.DatabaseConnection;

import java.time.LocalDateTime;
import java.util.List;

public class main {
    public static void main(String[] args) {
        DatabaseConnection db1 = DatabaseConnection.getInstance();
        DatabaseConnection db2 = DatabaseConnection.getInstance();
        BankingBusiness business = new BankingBusiness();

        System.out.println(db1 == db2);
        System.out.println("////////// Modifie solde /////////////////");
        testMofieSolde();
        System.out.println("------ Commpte User id : 1 -----------------");
        business.afficherResume(1);
        System.out.println("///////////////////////////////////////////////////////");
        System.out.println("------ Faire un depot sur User id : 1 , 500 euros -----------------");
        business.deposer(1, 500);
        System.out.println("///////////////////////////////////////////////////////");
        System.out.println("------ Obtenir Opearion User id : 1 -----------------");
        business.afficherHistorique(1);
    }




    private static void testMofieSolde() {
        try {
            CompteDAO compteDAO = new CompteDAOImpl();
            ClientDAO clientDAO = new ClientDAOImpl();
            OperationDAO operationDAO = new OperationDAOImpl();

            CompteService compteService = new CompteService(compteDAO, clientDAO, operationDAO);

            System.out.println("Ancien solde");
            System.out.println(compteService.consulterSolde(1));
            compteService.deposer(1,200);
            System.out.println("Nouveau solde");
            System.out.println(compteService.consulterSolde(1));


        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Erreur Client");
        }
    }

}
