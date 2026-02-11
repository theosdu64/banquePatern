package fr.tpbank.dao;
import fr.tpbank.dao.interfaces.ClientDAO;
import fr.tpbank.model.Client;
import java.util.List;

public class ClientDAO implements ClientDAO {

    @Override
    public List<Client> findAll() {
        throw new UnsupportedOperationException("non implémenté");
    }
}
