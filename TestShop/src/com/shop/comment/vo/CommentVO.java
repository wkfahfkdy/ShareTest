package com.shop.comment.vo;

import java.util.Date;

public class CommentVO {
	private int rno;
	private int bno;
	private String id;
	private String comment;
	private Date regdate;
	private Date upddate;
	private String secret_com;
	
	public int getRno() {
		return rno;
	}
	public void setRno(int rno) {
		this.rno = rno;
	}
	public int getBno() {
		return bno;
	}
	public void setBno(int bno) {
		this.bno = bno;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public Date getRegdate() {
		return regdate;
	}
	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
	public Date getUpddate() {
		return upddate;
	}
	public void setUpddate(Date upddate) {
		this.upddate = upddate;
	}
	public String getSecret_com() {
		return secret_com;
	}
	public void setSecret_com(String secret_com) {
		this.secret_com = secret_com;
	}
	@Override
	public String toString() {
		return "CommentVO [rno=" + rno + ", bno=" + bno + ", id=" + id + ", comment=" + comment + ", regdate=" + regdate
				+ ", upddate=" + upddate + ", secret_com=" + secret_com + "]";
	}
	
}
