package pojo;

import java.util.Date;
import java.util.List;

public class Comment {
	private int id;
	private String data;
	private String type;
	private Date postDate;
	private Post post;
	private User user;
	private List<Like> likes;
}
