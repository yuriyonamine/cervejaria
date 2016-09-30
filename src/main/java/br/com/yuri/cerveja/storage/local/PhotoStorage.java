package br.com.yuri.cerveja.storage.local;

import org.springframework.web.multipart.MultipartFile;

public interface PhotoStorage {
	public String saveTemporaryPhoto(MultipartFile[] files);
}
