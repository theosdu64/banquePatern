package fr.tpbank.service;

import fr.tpbank.dao.interfaces.ClientDAO;
import fr.tpbank.model.Client;

import java.util.List;

public class ClientService {

    private final ClientDAO clientDAO;

    public ClientService(ClientDAO clientDAO) {
        this.clientDAO = clientDAO;
    }

    public List<Client> findAll() {
        return clientDAO.findAll();
    }

    public Client findById(int id) {
        return clientDAO.findById(id);
    }

    public void save(Client client) {
        if(client == null) {
            throw new IllegalArgumentException("Client invalide");
        }
        clientDAO.save(client);
    }

    public void update(Client client) {
        if(client == null) {
            throw new IllegalArgumentException("Client invalide");
        }
        clientDAO.update(client);
    }

    public void deleteById(int id) {
        clientDAO.delete(id);
    }

}
