package com.shop.comment.vo;

import java.util.Date;

public class CommentVO {
	private int bno;
	private int rno;
	private int rnoch;
	private String writer; 
	private String content;
	private int depth;
	private Date regdate;
	private Date upddate;
	private String dele;
	
	
	public int getRnoch() {
		return rnoch;
	}
	public void setRnoch(int rnoch) {
		this.rnoch = rnoch;
	}
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
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getDepth() {
		return depth;
	}
	public void setDepth(int depth) {
		this.depth = depth;
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
	public String getDele() {
		return dele;
	}
	public void setDele(String dele) {
		this.dele = dele;
	}
	
	@Override
	public String toString() {
		return "CommentVO [bno=" + bno + ", rno=" + rno + ", rnoch=" + rnoch + ", writer=" + writer + ", content="
				+ content + ", depth=" + depth + ", regdate=" + regdate + ", upddate=" + upddate + ", dele=" + dele
				+ "]";
	}
}
