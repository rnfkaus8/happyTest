package com.happy.dto;

import java.io.Serializable;

public class AnswerBoard_DTO implements Serializable {
	
	private static final long serialVersionUID = 7400189678438849937L;
	private int seq;
	private String id;
	private String title;
	private String content;
	private int refer;
	private int step;
	private int depth;
	private int readcount;
	private String delfalg;
	private String regdate;
	private String filename;
	private String orgfile;


	public AnswerBoard_DTO() {
		
	}
	
	
	public AnswerBoard_DTO(int seq, String id, String title, String content) {
		super();
		this.seq = seq;
		this.id = id;
		this.title = title;
		this.content = content;
	}


	
	public AnswerBoard_DTO(int seq, String id, String title, String content, String delfalg) {
		super();
		this.seq = seq;
		this.id = id;
		this.title = title;
		this.content = content;
		this.delfalg = delfalg;
	}



	public AnswerBoard_DTO(int seq, String id, String title, String content, int refer, int step, int depth,
			int readcount, String delfalg, String regdate) {
		super();
		this.seq = seq;
		this.id = id;
		this.title = title;
		this.content = content;
		this.refer = refer;
		this.step = step;
		this.depth = depth;
		this.readcount = readcount;
		this.delfalg = delfalg;
		this.regdate = regdate;
	}






	public int getSeq() {
		return seq;
	}

	public void setSeq(int seq) {
		this.seq = seq;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
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

	public int getRefer() {
		return refer;
	}

	public void setRefer(int refer) {
		this.refer = refer;
	}

	public int getStep() {
		return step;
	}

	public void setStep(int step) {
		this.step = step;
	}

	public int getDepth() {
		return depth;
	}

	public void setDepth(int depth) {
		this.depth = depth;
	}

	public int getReadcount() {
		return readcount;
	}

	public void setReadcount(int readcount) {
		this.readcount = readcount;
	}

	public String getDelfalg() {
		return delfalg;
	}

	public void setDelfalg(String delfalg) {
		this.delfalg = delfalg;
	}

	public String getRegdate() {
		return regdate;
	}

	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}


	@Override
	public String toString() {
		return "AnswerBoard_DTO [seq=" + seq + ", id=" + id + ", title=" + title + ", content=" + content + ", refer="
				+ refer + ", step=" + step + ", depth=" + depth + ", readcount=" + readcount + ", delfalg=" + delfalg
				+ ", regdate=" + regdate + ", filename=" + filename + ", orgfile=" + orgfile + "]";
	}


	public String getFilename() {
		return filename;
	}


	public void setFilename(String filename) {
		this.filename = filename;
	}


	public String getOrgfile() {
		return orgfile;
	}


	public void setOrgfile(String orgfile) {
		this.orgfile = orgfile;
	}

	

}
