/**
 * 
 */
package pojo;

import java.util.Date;
import java.util.List;

public class User {
	private int id;
	private String firstname;
	private String lastname;
	private String address;
	private Date birthday;
	private Date regiserDate;
	private boolean relationShip;
	private int phoneNumber;
	private boolean gender;
	private boolean interestedIn;
	private List<Friend> friendList;
	private List<Post> posts;
	private List<Schooling> schoolings;
}
