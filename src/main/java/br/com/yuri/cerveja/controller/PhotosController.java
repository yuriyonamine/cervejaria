package br.com.yuri.cerveja.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;
import org.springframework.web.multipart.MultipartFile;

import br.com.yuri.cerveja.dto.PhotoDTO;
import br.com.yuri.cerveja.storage.FotoStorageRunnable;

@RestController
@RequestMapping("/photos")
public class PhotosController {

	@PostMapping
	public DeferredResult<PhotoDTO> upload(@RequestParam("files[]") MultipartFile[] files) {
		DeferredResult<PhotoDTO> result = new DeferredResult<>();

		Thread thread = new Thread(new FotoStorageRunnable(files, result));
		thread.start();
		return result;
	}
}
