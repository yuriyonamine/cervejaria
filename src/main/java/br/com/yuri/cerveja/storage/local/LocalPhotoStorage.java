package br.com.yuri.cerveja.storage.local;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;

public class LocalPhotoStorage implements PhotoStorage {
	private static final Logger logger = LoggerFactory.getLogger(LocalPhotoStorage.class);

	private Path local;
	private Path tempLocal;

	public LocalPhotoStorage() {
		this(FileSystems.getDefault().getPath(System.getProperty("user.home"), "brewerPhotos"));
	}

	public LocalPhotoStorage(Path local) {
		this.local = local;
		createFolders();
	}

	private void createFolders() {
		try {
			Files.createDirectories(this.local);
			this.tempLocal = FileSystems.getDefault().getPath(local.toString(), ".temp");
			Files.createDirectories(this.tempLocal);

			logger.debug("The photo was uploaded to a temporary folder");
			logger.debug("Folder: " + local.toString());
			logger.debug("Temporary Folder: " + tempLocal.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void saveTemporaryPhoto(MultipartFile[] files) {
		// TODO Auto-generated method stub

	}

}
