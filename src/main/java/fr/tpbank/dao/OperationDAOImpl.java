package fr.tpbank.dao;

import fr.tpbank.dao.helper.DaoHelper;
import fr.tpbank.dao.interfaces.OperationDAO;
import fr.tpbank.factory.CompteFactory;
import fr.tpbank.model.Client;
import fr.tpbank.model.Compte;
import fr.tpbank.model.Operation;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

public class OperationDAOImpl extends DaoHelper implements OperationDAO {

    @Override
    public List<Operation> findByCompteId(int compteId) {
        String sql = """
            SELECT 
                o.operation_id, o.type, o.montant, o.date_operation,
                c.compte_id, c.solde, c.type as compte_type, 
                c.decouvert_autorise, c.frais, c.taux_interet,
                cl.client_id, cl.name, cl.surname, cl.email
            FROM operation o
            INNER JOIN compte c ON o.compte_id = c.compte_id
            INNER JOIN client cl ON c.client_id = cl.client_id
            WHERE o.compte_id = ?
            ORDER BY o.date_operation DESC
        """;

        return executeQuery(sql, this::mapRow, compteId);
    }

    @Override
    public void save(Operation operation) {
        String sql = """
            INSERT INTO operation (type, montant, date_operation, compte_id)
            VALUES (?, ?, ?, ?)
        """;

        executeInsert(sql,
                operation.getType(),
                operation.getMontant(),
                Timestamp.valueOf(operation.getDate()),
                operation.getCompte().getId()
        );
    }

    private Operation mapRow(ResultSet rs) throws SQLException {
        Client client = new Client(
                rs.getInt("client_id"),
                rs.getString("name"),
                rs.getString("surname"),
                rs.getString("email"),
                null
        );
        Compte compte = CompteFactory.creerCompte(
                rs.getString("compte_type"),
                rs.getInt("compte_id"),
                rs.getDouble("solde"),
                client,
                rs.getDouble("decouvert_autorise"),
                rs.getDouble("taux_interet"),
                rs.getInt("frais")
        );
        return new Operation(
                rs.getInt("operation_id"),
                rs.getString("type"),
                rs.getDouble("montant"),
                rs.getTimestamp("date_operation").toLocalDateTime(),
                compte
        );
    }
}
