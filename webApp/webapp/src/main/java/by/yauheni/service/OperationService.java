package by.yauheni.service;

import by.yauheni.domain.Operation;
import by.yauheni.storage.OperationStorageDB;

import java.util.Date;
import java.util.List;

public class OperationService {
    private OperationStorageDB operationStorageDB = new OperationStorageDB();

    public boolean saveToDB(List<Operation> operation) {
        if (operation.get(1) != null){
            operationStorageDB.save(operation);
        }
        throw new OperationNotFoundException();
    }

    public List<Operation> getAllFromDB() {
        return operationStorageDB.getAll();
    }

    public List<Operation> getByOperationFromDB(String opType, long userID) {
        if (operationStorageDB.contains(opType, userID)){
            return operationStorageDB.getByOperation(opType, userID);
        }
        throw new OperationNotFoundException();
    }

    public List<Operation> getByDateFromDB(Date date) {
        return null;
    }

    public boolean clearAllFromDB() {
        return operationStorageDB.clearAll();
    }
}
