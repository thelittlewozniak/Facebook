package model.dao;

import model.pojo.Schooling;

import java.util.List;

public class DaoSchooling extends Dao<Schooling> {
    public DaoSchooling() {
        super();
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
