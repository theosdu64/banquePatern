package fr.tpbank.dao;

import fr.tpbank.dao.helper.DaoHelper;
import fr.tpbank.dao.interfaces.CompteDAO;
import fr.tpbank.model.Client;
import fr.tpbank.model.Compte;
import fr.tpbank.model.CompteCourant;
import fr.tpbank.model.CompteEpargne;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class CompteDAOImpl extends DaoHelper implements CompteDAO {

    @Override
    public Compte findByID(int client_id) {
        String sql = """
                SELECT *
                FROM compte c 
                inner join client cl ON c.client_id = cl.client_id
                where c.compte_id = ?
        """;
        return executeQuerySingle(sql, this::mapRow,client_id);
    }

    @Override
    public List<Compte> findAllComptesByClient(int client_id) {
        String sql = """
        SELECT 
            c.compte_id, c.solde, c.type, c.decouvert_autorise, c.frais, c.taux_interet,
            cl.client_id, cl.name, cl.surname, cl.email
        FROM compte c
        INNER JOIN client cl ON c.client_id = cl.client_id
        WHERE c.client_id = ?
    """;

        return executeQuery(sql, this::mapRow, client_id);
    }

    @Override
    public void save(Compte compte) {
        String sql;

        if (compte instanceof CompteCourant cc) {
            sql = """
            INSERT INTO compte (solde, type, client_id, decouvert_autorise, frais)
            VALUES (?, 'COURANT', ?, ?, ?)
        """;
            executeInsert(sql,
                    cc.getSolde(),
                    cc.getClient().getId_client(),
                    cc.getDecouvertAutorisé(),
                    cc.getFrais()
            );

        } else if (compte instanceof CompteEpargne ce) {
            sql = """
            INSERT INTO compte (solde, type, client_id, taux_interet)
            VALUES (?, 'EPARGNE', ?, ?)
        """;
            executeInsert(sql,
                    ce.getSolde(),
                    ce.getClient().getId_client(),
                    ce.getTaux_interet()
            );
        }
    }

    @Override
    public void updateSolde(int idCompte, double montant) {
        String sql = "UPDATE compte SET solde = ? Where compte_id = ?";
        int rowsAffected = executeUpdate(sql, montant, idCompte);
        if (rowsAffected == 0) {
            throw new IllegalStateException("Compte n'exite pas ID : " + idCompte);
        }
    }

    private Compte mapRow(ResultSet rs) throws SQLException {
        int id = rs.getInt("compte_id");
        double solde = rs.getDouble("solde");
        String type  = rs.getString("type");
        Client client = new Client(
                rs.getInt("client_id"),
                rs.getString("name"),
                rs.getString("surname"),
                rs.getString("email"),
                null
        );

        if ("COURANT".equalsIgnoreCase(type)) {
            double decouvert = rs.getDouble("decouvert_autorise");
            double frais = rs.getDouble("frais");
            return new CompteCourant(id, solde, client, decouvert, frais);
        } else if ("EPARGNE".equalsIgnoreCase(type)) {
            double taux = rs.getDouble("taux_interet");
            return new CompteEpargne(id, solde, client, taux);
        } else {
            throw new IllegalStateException("Erreur Compte MapRow type : " + type);
        }
    }

}
