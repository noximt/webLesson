package by.yauheni.storage;

import by.yauheni.domain.Operation;

import java.util.Date;
import java.util.List;

public interface OperationStorage {
    boolean save(List<Operation> operation);
    List<Operation> getAll();
    List<Operation> getByDate(Date date, long userID);
    List<Operation> getByOperation(String opType, long userID);
    boolean clearAll();
    boolean contains(String opType, long userID);

}
