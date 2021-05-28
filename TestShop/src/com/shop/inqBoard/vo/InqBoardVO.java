package com.shop.inqBoard.vo;

import java.util.Date;

public class InqBoardVO {

	private int id;
	private String title;
	private String content;
	private String writer;
	private int likeIt;
	private Date regDate;
	private int hit;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public int getLikeIt() {
		return likeIt;
	}
	public void setLikeIt(int likeIt) {
		this.likeIt = likeIt;
	}
	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	public int getHit() {
		return hit;
	}
	public void setHit(int hit) {
		this.hit = hit;
	}
	
	
	@Override
	public String toString() {
		return "RevBoardVO [id=" + id + ", title=" + title + ", content=" + content + ", writer=" + writer + ", likeIt="
				+ likeIt + ", regDate=" + regDate + ", hit=" + hit + "]";
	}
	
}
