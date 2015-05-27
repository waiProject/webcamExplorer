package model;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

public class Image {
 
	private long img_id;
	private long cam_id;
	private Timestamp datetime;
	private String datum; // von datetime extrahiert
	private String uhrzeit; // von datetime extrahiert
	private String localPath;
	private String localPathThumb;	
	
	public void setCamId(long id){
		this.cam_id=id;
	}
	
	public long getCamId(){
		return cam_id;
	}
	public String getlocalPath(){
		return localPath;
	}
	
	public void setlocalPath(String localPath){
		this.localPath=localPath;
	}
	
	
	public void setlocalPathThumb(String localPathThumb){
		this.localPathThumb=localPathThumb;
	}
	
	public String getlocalPathThumb(){
		return localPathThumb;
	}

	public long getImg_id() {
		return img_id;
	}

	public void setImg_id(long img_id) {
		this.img_id = img_id;
	}

	public Timestamp getDatetime() {
		return datetime;
	}

	public void setDatetime(Timestamp datetime) {
		this.datetime = datetime;
		SimpleDateFormat date = new SimpleDateFormat("dd MM yyyy");
		SimpleDateFormat time = new SimpleDateFormat("HH:mm:ss");
		this.datum = date.format(datetime);
		this.uhrzeit = time.format(datetime);
	}

	public String getDatum() {
		return datum;
	}

	public void setDatum(String datum) {
		this.datum = datum;
	}

	public String getUhrzeit() {
		return uhrzeit;
	}

	public void setUhrzeit(String uhrzeit) {
		this.uhrzeit = uhrzeit;
	}
}
