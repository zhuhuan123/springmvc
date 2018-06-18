package com.std.model;

public class Tree {
	private Long id;
	private Long pid;
	private String text;
	private String url;
	private Byte resourceType;
	
	public Byte getResourceType() {
		return resourceType;
	}
	public void setResourceType(Byte resourceType) {
		this.resourceType = resourceType;
	}
	private boolean ischecked;
	
	public boolean isIschecked() {
		return ischecked;
	}
	public void setIschecked(boolean ischecked) {
		this.ischecked = ischecked;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getPid() {
		return pid;
	}
	public void setPid(Long pid) {
		this.pid = pid;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	
	
}
