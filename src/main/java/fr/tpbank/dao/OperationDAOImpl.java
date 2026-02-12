package fr.tpbank.dao;

import fr.tpbank.dao.interfaces.OperationDAO;
import fr.tpbank.model.Operation;
import fr.tpbank.util.DatabaseConnection;

import java.sql.Connection;
import java.util.List;

public class OperationDAOImpl implements OperationDAO {
    private final Connection connection;

    public OperationDAOImpl() {
        this.connection = DatabaseConnection
                .getInstance()
                .getConnection();
    }

    @Override
    public List<Operation> findByCompteId(int compteId) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void save(Operation operation) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
