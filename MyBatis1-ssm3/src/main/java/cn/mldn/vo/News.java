package cn.mldn.vo;

import java.io.Serializable;

public class News implements Serializable {

	private Long nid;
	private String title;
	@Override
	public String toString() {
		return "News [nid=" + nid + ", title=" + title + ", note=" + note + "]";
	}
	public Long getNid() {
		return nid;
	}
	public void setNid(Long nid) {
		this.nid = nid;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	private String note;
}
