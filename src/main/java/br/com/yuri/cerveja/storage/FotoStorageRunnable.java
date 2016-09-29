package br.com.yuri.cerveja.storage;

import org.springframework.web.context.request.async.DeferredResult;
import org.springframework.web.multipart.MultipartFile;

public class FotoStorageRunnable implements Runnable {

	private DeferredResult<String> result;
	private MultipartFile[] files;

	public FotoStorageRunnable(MultipartFile[] files, DeferredResult<String> result) {
		this.files = files;
		this.result = result;
	}

	@Override
	public void run() {
		System.out.println("START RUN");
		try {
			Thread.sleep(10000);

			result.setResult("OK");
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("FINISH RUN");
	}

}
