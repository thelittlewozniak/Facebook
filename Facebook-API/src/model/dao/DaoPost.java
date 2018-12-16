package model.dao;

import model.pojo.Post;

import java.sql.Connection;

public class DaoPost extends Dao<Post> {
    public DaoPost(Connection conn) {
        super(conn);
    }

    @Override
    public boolean create(Post obj) {
        return false;
    }

    @Override
    public boolean delete(Post obj) {
        return false;
    }

    @Override
    public boolean update(Post obj) {
        return false;
    }

    @Override
    public Post find(int id) {
        return null;
    }
}