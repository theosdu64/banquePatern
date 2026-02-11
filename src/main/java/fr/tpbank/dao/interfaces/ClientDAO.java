package fr.tpbank.dao.interfaces;
import fr.tpbank.model.Client;

import java.util.List;

public interface ClientDAO {
    List<Client> findAll();
}
