package model.dao;

import model.pojo.Schooling;

import java.sql.Connection;
import java.util.List;

public class DaoSchooling extends Dao<Schooling> {
    public DaoSchooling(Connection conn) {
        super(conn);
    }

    @Override
    public boolean create(Schooling obj) {
        return false;
    }

    @Override
    public boolean delete(Schooling obj) {
        return false;
    }

    @Override
    public boolean update(Schooling obj) {
        return false;
    }

    @Override
    public Schooling find(int id) {
        return null;
    }

    @Override
    public List<Schooling> getAll() {
        return null;
    }
}
