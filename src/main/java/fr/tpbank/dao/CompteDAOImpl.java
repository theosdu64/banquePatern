package fr.tpbank.dao;

import fr.tpbank.dao.interfaces.CompteDAO;
import fr.tpbank.model.Compte;
import fr.tpbank.util.DatabaseConnection;

import java.sql.Connection;
import java.util.List;

public class CompteDAOImpl implements CompteDAO {
    private final Connection connection;

    public CompteDAOImpl() {
        this.connection = DatabaseConnection
                .getInstance()
                .getConnection();
    }

    @Override
    public Compte findByID(int id) {
        throw  new UnsupportedOperationException("non implémenté");
    }

    @Override
    public List<Compte> findAllComptesByClient(int client_id) {
        throw  new UnsupportedOperationException("non implémenté");
    }

    @Override
    public void save(Compte compte) {
        throw  new UnsupportedOperationException("non implémenté");
    }

    @Override
    public void updateSolde(int idCompte, double montant) {
        throw  new UnsupportedOperationException("non implémenté");
    }

}
