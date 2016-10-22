package br.com.yuri.cerveja.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;
import org.springframework.web.multipart.MultipartFile;

import br.com.yuri.cerveja.dto.PhotoDTO;
import br.com.yuri.cerveja.storage.FotoStorageRunnable;
import br.com.yuri.cerveja.storage.local.PhotoStorage;

@RestController
@RequestMapping("/photos")
public class PhotosController {

	@Autowired
	private PhotoStorage photoStorage;

	@PostMapping
	public DeferredResult<PhotoDTO> upload(@RequestParam("files[]") MultipartFile[] files) {
		DeferredResult<PhotoDTO> result = new DeferredResult<>();

		Thread thread = new Thread(new FotoStorageRunnable(files, result, photoStorage));
		thread.start();
		return result;
	}
	
	@GetMapping("/temp/{name:.*}")
	public byte[] getTemporaryPhoto(@PathVariable String name){
		return photoStorage.getTemporaryPhoto(name);
	}
}
