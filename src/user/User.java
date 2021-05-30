package user;

import java.io.Serializable;

public class User implements Serializable{
	private String id;
	private String pwd;
	private String email;
	private String tel;
	private String nickName;
	
	public User() {
		
	}
	
	public User(String i, String p,String e,String t,String n) {
		id			=	i; 
		pwd			=	p; 
		email		=	e; 
		tel			=	t; 
		nickName	=	n;
	}
	
	public String getId() {
		return this.id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPwd() {
		return this.pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getEmail() {
		return this.email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTel() {
		return this.tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getNickName() {
		return this.nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	
	
}
