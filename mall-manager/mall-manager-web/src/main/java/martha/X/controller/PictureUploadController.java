package martha.X.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class PictureUploadController {
	@RequestMapping("/pic/upload")
	@ResponseBody
	public String PictureUpload(MultipartFile fileName) {
		//放到ftp
		return null;
	}
}
