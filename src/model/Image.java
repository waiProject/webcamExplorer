package model;

import java.sql.Date;

public  class Image {

	private Date datetime = null;
	
	private String filepath=null;
	private Long img_id = null;
	
	
	

	public String getFilepath() {
		return filepath;
	}

	public void setFilepath(String filepath) {
		this.filepath = filepath;
	}

	public Date getDatetime() {
		return datetime;
	}

	public void setDatetime(Date datetime) {
		this.datetime = datetime;
	}

	public Long getImg_id() {
		return img_id;
	}

	public void setImg_id(Long img_id) {
		this.img_id = img_id;
	}
	
	
	
}


