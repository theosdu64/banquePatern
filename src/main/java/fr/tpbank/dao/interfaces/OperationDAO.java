package fr.tpbank.dao.interfaces;
import fr.tpbank.model.Operation;

import java.util.List;

public interface OperationDAO {
    List<Operation> findByCompteId(int compteId);
    void save(Operation operation);
}
