package gg.cs.myapp.entity;

import java.util.Date;

public class User {
	private int user_id;
	private Date regtime;
	private String username;
	private String useremail;
	private String userpass;
	

	/**
	 * @return the regtime
	 */
	public Date getRegtime() {
		return regtime;
	}
	/**
	 * @return the user_id
	 */
	public int getUser_id() {
		return user_id;
	}
	/**
	 * @param user_id the user_id to set
	 */
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	/**
	 * @param regtime the regtime to set
	 */
	public void setRegtime(Date regtime) {
		this.regtime = regtime;
	}
	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}
	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}
	/**
	 * @return the useremail
	 */
	public String getUseremail() {
		return useremail;
	}
	/**
	 * @param useremail the useremail to set
	 */
	public void setUseremail(String useremail) {
		this.useremail = useremail;
	}
	/**
	 * @return the userpass
	 */
	public String getUserpass() {
		return userpass;
	}
	/**
	 * @param userpass the userpass to set
	 */
	public void setUserpass(String userpass) {
		this.userpass = userpass;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "User [user_id=" + user_id + ", regtime=" + regtime + ", username=" + username + ", useremail="
				+ useremail + ", userpass=" + userpass + "]";
	}
	
	
	

}
