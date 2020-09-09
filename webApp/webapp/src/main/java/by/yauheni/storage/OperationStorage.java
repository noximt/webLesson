package by.yauheni.storage;

import by.yauheni.domain.Operation;
import java.util.List;

public interface OperationStorage {
    boolean save(List<Operation> operation);
    Operation remove(long userId);
    List<Operation> getAll();
}
