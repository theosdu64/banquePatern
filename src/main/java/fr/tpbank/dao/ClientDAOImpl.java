package fr.tpbank.dao;
import fr.tpbank.dao.interfaces.ClientDAO;
import fr.tpbank.model.Client;
import fr.tpbank.util.DatabaseConnection;

import java.sql.Connection;
import java.util.List;

public class ClientDAOImpl implements ClientDAO {
    private final Connection connection;

    public ClientDAOImpl() {
        this.connection = DatabaseConnection
                .getInstance()
                .getConnection();
    }

    @Override
    public List<Client> findAll() {
        throw new UnsupportedOperationException("non implémenté");
    }

    @Override
    public Client findById(int id) {
        throw new UnsupportedOperationException("non implementé");
    }
}
