package model.dao;

import java.sql.Connection;
import java.util.List;

abstract class Dao<T> {
  final Connection connect;

  Dao(Connection conn) {
    this.connect = conn;
  }

  /**
   * @param obj the object of the DAO
   * @return boolean
   */
  public abstract boolean create(T obj);

  /**
   * @param obj the object of the DAO
   * @return boolean
   */
  public abstract boolean delete(T obj);

  /**
   * @param obj the object of the DAO
   * @return boolean
   */
  public abstract boolean update(T obj);

  /**
   * @param id the id od the object of the DAO
   * @return T
   */
  public abstract T find(int id);

  public abstract List<T> getAll();
}
