package fr.tpbank.dao.interfaces;
import fr.tpbank.model.Client;

import java.util.List;

public interface ClientDAO {
    List<Client> findAll();
    Client findById(int id);
    void save(Client client);
    void update(Client client);
    void delete(int id);
}
