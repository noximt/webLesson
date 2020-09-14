package by.yauheni.storage;

import by.yauheni.domain.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserStorageDB implements UserStorage {
    private User user;
    Connection connection;

    {
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "root");
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean save(User user) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("insert into users values ( default, ?, ?, ? )");
            preparedStatement.setString(1, user.getLogin());
            preparedStatement.setString(2, user.getPassword());
            preparedStatement.setString(3, user.getName());
            preparedStatement.execute();
        } catch (SQLException throwable) {
            throwable.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public User remove(long id) {
        try {
            connection.setAutoCommit(false);
            prepareUser(id);
            PreparedStatement preparedStatement1 = connection.prepareStatement("delete from users where id = ?");
            preparedStatement1.setLong(1, id);
            preparedStatement1.execute();
            connection.commit();
            connection.setAutoCommit(true);
        } catch (SQLException throwable) {
            try {
                connection.rollback();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            throwable.printStackTrace();
        }
        return user;
    }

    @Override
    public User remove(String login) {
        try {
            connection.setAutoCommit(false);
            prepareUser(login);
            PreparedStatement preparedStatement1 = connection.prepareStatement("delete from users where login = ?");
            preparedStatement1.setString(1, login);
            preparedStatement1.execute();
            connection.commit();
            connection.setAutoCommit(true);
        } catch (SQLException throwable) {
            try {
                connection.rollback();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            throwable.printStackTrace();
        }
        return user;
    }

    @Override
    public String updateName(String newName, long id) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("update users set name = ? where id = ?");
            preparedStatement.setString(1, newName);
            preparedStatement.setLong(2, id);
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return newName;
    }

    @Override
    public String updatePassword(String pass, long id) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("update users set password = ? where id = ?");
            preparedStatement.setString(1, pass);
            preparedStatement.setLong(2, id);
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return pass;
    }

    @Override
    public List<User> getAll() {
        List<User> users = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from users");
            while (resultSet.next()) {
                long id = resultSet.getLong(1);
                String login = resultSet.getString(2);
                String pass = resultSet.getString(3);
                String name = resultSet.getString(4);
                user = new User(id, login, pass, name);
                users.add(user);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return users;
    }

    @Override
    public List<User> getAllByName(String name) {
        List<User> users = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select * from users where name = ?");
            preparedStatement.setString(1, name);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                long id = resultSet.getLong(1);
                String login = resultSet.getString(2);
                String pass = resultSet.getString(3);
                user = new User(id, login, pass, name);
                users.add(user);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return users;
    }

    @Override
    public User getUserById(long id) {
        try {
            prepareUser(id);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return user;
    }

    @Override
    public User getUserByLogin(String login) {
        try {
            return prepareUser(login);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean contains(User user) {
        List<User> users = getAll();
        for (int i = 0; i < users.size(); i++) {
            if (user.equals(users.get(i))) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean contains(long id) {
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select id from users");
            while (resultSet.next()) {
                if (resultSet.getLong(1) == id) {
                    return true;
                }
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean contains(String login) {
        try {
            PreparedStatement statement = connection.prepareStatement("select * from users where login = ?");
            statement.setString(1, login);
            ResultSet resultSet = statement.executeQuery();
            return resultSet.next();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }

    private User prepareUser(String login) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("select * from users where login = ?");
        preparedStatement.setString(1, login);
        ResultSet resultSet = preparedStatement.executeQuery();
        resultSet.next();
        User user = new User(resultSet.getLong(1), resultSet.getString(2), resultSet.getString(3), resultSet.getString(4));
        return user;
    }

    private User prepareUser(long id) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("select * from users where id = ?");
        preparedStatement.setLong(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();
        resultSet.next();
        User user = new User(resultSet.getLong(1), resultSet.getString(2), resultSet.getString(3), resultSet.getString(4));
        return user;
    }

}
