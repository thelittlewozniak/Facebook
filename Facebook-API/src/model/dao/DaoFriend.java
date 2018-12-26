package model.dao;

import model.pojo.Friend;

import java.sql.Connection;
import java.util.List;

public class DaoFriend extends Dao<Friend> {
    public DaoFriend(Connection conn) {
        super(conn);
    }

    @Override
    public boolean create(Friend obj) {
        return false;
    }

    @Override
    public boolean delete(Friend obj) {
        return false;
    }

    @Override
    public boolean update(Friend obj) {
        return false;
    }

    @Override
    public Friend find(int id) {
        return null;
    }

    @Override
    public List<Friend> getAll() {
        return null;
    }
}