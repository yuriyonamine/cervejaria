package br.com.yuri.cerveja.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;
import org.springframework.web.multipart.MultipartFile;

import br.com.yuri.cerveja.storage.FotoStorageRunnable;

@RestController
@RequestMapping("/photos")
public class PhotosController {

	@PostMapping
	public DeferredResult<String> upload(@RequestParam("files[]") MultipartFile[] files) {
		DeferredResult<String> result = new DeferredResult<>();
		System.out.println("START UPLOAD");

		Thread thread = new Thread(new FotoStorageRunnable(files, result));
		System.out.println("FINISH MIDDLE UPLOAD");

		thread.start();
		System.out.println("FINISH UPLOAD");
		return result;
	}
}
