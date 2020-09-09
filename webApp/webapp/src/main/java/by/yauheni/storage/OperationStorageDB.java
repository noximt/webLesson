package by.yauheni.storage;

import by.yauheni.domain.Operation;

import java.util.List;

public class OperationStorageDB implements OperationStorage {
    @Override
    public boolean save(List<Operation> operation) {
        return false;
    }

    @Override
    public Operation remove(long userId) {
        return null;
    }

    @Override
    public List<Operation> getAll() {
        return null;
    }
}
