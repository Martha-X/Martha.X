package martha.X.service;

import org.springframework.web.multipart.MultipartFile;

import martha.X.utils.PictureResult;

public interface PictureUploadService {
	public PictureResult pictureUpload(MultipartFile fileName);
}
