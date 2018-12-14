package model.dao;

import model.pojo.User;

import java.sql.Connection;

public class DaoUser extends Dao<User> {
    public DaoUser(Connection conn) {
        super(conn);
    }

    @Override
    public boolean create(User obj) {
        return false;
    }

    @Override
    public boolean delete(User obj) {
        return false;
    }

    @Override
    public boolean update(User obj) {
        return false;
    }

    @Override
    public User find(int id) {
        return null;
    }
}
