package model.dao;

import model.pojo.Comment;

import java.sql.Connection;

public class DaoComment extends Dao<Comment> {
    public DaoComment(Connection conn) {
        super(conn);
    }

    @Override
    public boolean create(Comment obj) { return false; }

    @Override
    public boolean delete(Comment obj) {
        return false;
    }

    @Override
    public boolean update(Comment obj) {
        return false;
    }

    @Override
    public Comment find(int id) {
        return null;
    }
}