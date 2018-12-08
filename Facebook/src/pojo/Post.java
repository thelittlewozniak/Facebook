package pojo;

import java.util.Date;
import java.util.List;

public class Post {
	private int id;
	private User user;
	private String data;
	private String type;
	private Date postDate;
	private List<Comment> comments;
	private List<Like> likes;

}
