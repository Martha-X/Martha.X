package martha.X.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import martha.X.service.PictureUploadService;
import martha.X.utils.PictureResult;

@Controller
public class PictureUploadController {
	@Autowired
	private PictureUploadService pictureUploadService;

	@RequestMapping("/pic/upload")
	@ResponseBody
	public PictureResult PictureUpload(MultipartFile uploadFile) {
		// 放到ftp
		PictureResult pictureUpload = pictureUploadService.pictureUpload(uploadFile);
		return pictureUpload;
	}
}
