package br.com.yuri.cerveja.storage.local;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.UUID;

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
	public String saveTemporaryPhoto(MultipartFile[] files) {
		String uniquePhotoName = null;

		if (files != null && files.length > 0) {
			MultipartFile file = files[0];
			uniquePhotoName = generateUniqueFileName(file.getOriginalFilename());

			File to = new File(this.tempLocal.toAbsolutePath() + FileSystems.getDefault().getSeparator() + uniquePhotoName);
			try {
				file.transferTo(to);
			} catch (IOException e) {
				throw new RuntimeException("Error when trying to save the photo in the temporary local");
			}
		}

		return uniquePhotoName;
	}

	private String generateUniqueFileName(String originalName) {
		String uniquePhotoName = UUID.randomUUID() + "_" + originalName;

		if (logger.isDebugEnabled()) {
			logger.debug(String.format("Original name: %s", originalName));
			logger.debug(String.format("Generated unique name: %s", uniquePhotoName));
		}

		return uniquePhotoName;
	}

	@Override
	public byte[] getTemporaryPhoto(String name) {
		try {
			return Files.readAllBytes(this.tempLocal.resolve(name));
		} catch (IOException e) {
			throw new RuntimeException("Error reading the photo.");
		}
	}

}
