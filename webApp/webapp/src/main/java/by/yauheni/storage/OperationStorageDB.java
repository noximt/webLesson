package by.yauheni.storage;

import by.yauheni.domain.Operation;


import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OperationStorageDB implements OperationStorage {
    private SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
    Connection connection;
    {
        try {
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "root");
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
    }

    @Override
    public boolean save(List<Operation> operation) {
        try {
            for (int i = 0; i < operation.size(); i++) {
                PreparedStatement preparedStatement = connection.prepareStatement("insert into operations values ( default, ?, ?, ?, ?, ?, ? )");
                preparedStatement.setString(1,String.valueOf(operation.get(i).getUserID()));
                preparedStatement.setString(2,String.valueOf(operation.get(i).getX()));
                preparedStatement.setString(3,operation.get(i).getOpType());
                preparedStatement.setString(4,String.valueOf(operation.get(i).getY()));
                preparedStatement.setString(5,String.valueOf(operation.get(i).getResult()));
                preparedStatement.setDate(6, java.sql.Date.valueOf(formatter.format(operation.get(i).getDate())));
                preparedStatement.execute();
            }
        } catch (SQLException throwable) {
            throwable.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public List<Operation> getAll() {
        List<Operation> operations = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from operations");
            CreateNewOperation(operations, resultSet);
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
        return operations;
    }

    @Override
    public List<Operation> getByDate(Date date, long userID) {
        List<Operation> operations = new ArrayList<>();
        SimpleDateFormat formatter = new SimpleDateFormat("dd");
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select * from operations where date = ?, user_id = ?");
            //preparedStatement.setDate(1, formatter.format(date));
            preparedStatement.setLong(1,userID);
            ResultSet resultSet = preparedStatement.executeQuery();
            CreateNewOperation(operations, resultSet);
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
        return operations;
    }

    @Override
    public List<Operation> getByOperation(String opType, long userID) {
        List<Operation> operations = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select * from operations where operation_type = ?, user_id = ?");
            preparedStatement.setString(1,opType);
            preparedStatement.setLong(1,userID);
            ResultSet resultSet = preparedStatement.executeQuery();
            CreateNewOperation(operations, resultSet);
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
        return operations;
    }

    @Override
    public boolean clearAll() {
        try (Statement statement = connection.createStatement()) {
            statement.execute("delete from operations where id > 0");
        } catch (SQLException throwable) {
            throwable.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public boolean contains(String opType, long userID) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select * from operations where operation_type = ?, user_id = ?");
            preparedStatement.setString(1,opType);
            preparedStatement.setLong(1,userID);
            ResultSet resultSet = preparedStatement.executeQuery();
            return resultSet.next();
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
        return false;
    }

    private void CreateNewOperation(List<Operation> operations, ResultSet resultSet) throws SQLException {
        while  (resultSet.next()){
            long id = resultSet.getLong(1);
            long userID = resultSet.getLong(2);
            double x = resultSet.getDouble(3);
            String opType = resultSet.getString(4);
            double y = resultSet.getDouble(5);
            double result = resultSet.getDouble(6);
            Date date = resultSet.getDate(7);
            Operation operation = new Operation(id, userID, x, opType, y, result, date);
            operations.add(operation);
        }
    }
}
