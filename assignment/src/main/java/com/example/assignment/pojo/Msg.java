package com.example.assignment.pojo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name="msg")
@Component
public class Msg {
	@Id
	@GeneratedValue
private int id;
 private String subname;
 private String msgcontent;
 @ManyToOne
@JoinColumn(name="fk_fromid")
 private User user;

public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getSubname() {
	return subname;
}
public void setSubname(String subname) {
	this.subname = subname;
}
public String getMsgcontent() {
	return msgcontent;
}
public void setMsgcontent(String msgcontent) {
	this.msgcontent = msgcontent;
}
public User getUser() {
	return user;
}
public void setUser(User user) {
	this.user = user;
}
 
}
