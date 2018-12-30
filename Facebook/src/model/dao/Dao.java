package model.dao;

import java.sql.Connection;
import java.util.List;

public abstract class Dao<T> {
    protected Connection connect = null;

    public Dao(Connection conn){
        this.connect = conn;
    }

    /**
     * @param obj
     * @return boolean
     */
    public abstract boolean create(T obj);

    /**
     * @param obj
     * @return boolean
     */
    public abstract boolean delete(T obj);

    /**
     * @param obj
     * @return boolean
     */
    public abstract boolean update(T obj);

    /**
     * @param id
     * @return T
     */
    public abstract T find(int id);

    public abstract List<T> getAll();
}