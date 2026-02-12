package fr.tpbank.dao;
import fr.tpbank.dao.helper.DaoHelper;
import fr.tpbank.dao.interfaces.ClientDAO;
import fr.tpbank.model.Client;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class ClientDAOImpl extends DaoHelper implements ClientDAO {

    @Override
    public List<Client> findAll() {
        throw new UnsupportedOperationException("non implémenté");
    }

    @Override
    public Client findById(int id) {
        String sql = "select * from client where client_id = ?";
        return executeQuerySingle(sql, this::mapRow,id);
    }

    @Override
    public void save(Client client) {
        String sql = "INSERT INTO client (name, surname, email, password) VALUES (?, ?, ?, ?)";

        int generatedId = executeInsert(sql,
                client.getName(),
                client.getSurname(),
                client.getEmail(),
                client.getPassword());

        client.setId_client((int) generatedId);
    }


    @Override
    public void delete(int id) {
        throw new UnsupportedOperationException("non implementé");
    }

    @Override
    public void update(Client client) {
        throw new UnsupportedOperationException("non implementé");
    }

    private Client mapRow(ResultSet rs) throws SQLException {
        return new Client(
                rs.getInt("client_id"),
                rs.getString("name"),
                rs.getString("surname"),
                rs.getString("email"),
                rs.getString("password")
        );
    }
    }

