package br.com.yuri.cerveja.dto;

public class PhotoDTO {
	private String photoName;
	private String contentType;

	public PhotoDTO(String name, String contentType) {
		super();
		this.photoName = name;
		this.contentType = contentType;
	}

	public String getPhotoName() {
		return photoName;
	}

	public void setPhotoName(String name) {
		this.photoName = name;
	}

	public String getContentType() {
		return contentType;
	}

	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

}
