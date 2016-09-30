package br.com.yuri.cerveja.storage;

import org.springframework.web.context.request.async.DeferredResult;
import org.springframework.web.multipart.MultipartFile;

import br.com.yuri.cerveja.dto.PhotoDTO;
import br.com.yuri.cerveja.storage.local.PhotoStorage;

public class FotoStorageRunnable implements Runnable {

	private DeferredResult<PhotoDTO> result;
	private MultipartFile[] files;
	private PhotoStorage photoStorage;

	public FotoStorageRunnable(MultipartFile[] files, DeferredResult<PhotoDTO> result, PhotoStorage photoStorage) {
		this.files = files;
		this.result = result;
		this.photoStorage = photoStorage;
	}

	@Override
	public void run() {
		String uniquePhotoName = photoStorage.saveTemporaryPhoto(files);
		String contentType = files[0].getContentType();

		result.setResult(new PhotoDTO(uniquePhotoName, contentType));
	}

}
