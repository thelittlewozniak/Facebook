package model.dao;

import model.pojo.Work;

import java.sql.Connection;
import java.util.List;

public class DaoWork extends Dao<Work> {
    public DaoWork(Connection conn) {
        super(conn);
    }

    @Override
    public boolean create(Work obj) {
        return false;
    }

    @Override
    public boolean delete(Work obj) {
        return false;
    }

    @Override
    public boolean update(Work obj) {
        return false;
    }

    @Override
    public Work find(int id) {
        return null;
    }

    @Override
    public List<Work> getAll() {
        return null;
    }
}