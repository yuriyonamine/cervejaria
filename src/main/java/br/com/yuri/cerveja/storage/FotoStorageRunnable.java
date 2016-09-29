package br.com.yuri.cerveja.storage;

import org.springframework.web.context.request.async.DeferredResult;
import org.springframework.web.multipart.MultipartFile;

import br.com.yuri.cerveja.dto.PhotoDTO;

public class FotoStorageRunnable implements Runnable {

	private DeferredResult<PhotoDTO> result;
	private MultipartFile[] files;

	public FotoStorageRunnable(MultipartFile[] files, DeferredResult<PhotoDTO> result) {
		this.files = files;
		this.result = result;
	}

	@Override
	public void run() {
		String name = files[0].getOriginalFilename();
		String contentType = files[0].getContentType();

		result.setResult(new PhotoDTO(name, contentType));
	}

}
