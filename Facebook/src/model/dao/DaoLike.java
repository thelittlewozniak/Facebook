package model.dao;

import model.pojo.Like;

import java.sql.Connection;

public class DaoLike extends Dao<Like> {
    public DaoLike(Connection conn) {
        super(conn);
    }

    @Override
    public boolean create(Like obj) {
        return false;
    }

    @Override
    public boolean delete(Like obj) {
        return false;
    }

    @Override
    public boolean update(Like obj) {
        return false;
    }

    @Override
    public Like find(int id) {
        return null;
    }
}
