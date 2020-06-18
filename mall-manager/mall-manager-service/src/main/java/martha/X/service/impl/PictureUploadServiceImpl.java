package martha.X.service.impl;

import java.io.IOException;
import java.io.InputStream;

import org.joda.time.DateTime;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import martha.X.service.PictureUploadService;
import martha.X.utils.FtpUtil;
import martha.X.utils.IDUtils;
import martha.X.utils.PictureResult;

@Service
public class PictureUploadServiceImpl implements PictureUploadService {
	String host = "127.0.0.1";
	int port = 21;
	String username = "Martha";
	String password = "Martha";

	@Override
	public PictureResult pictureUpload(MultipartFile uploadFile) {
		InputStream in = null;
		PictureResult p = new PictureResult();
		;
		try {
			in = uploadFile.getInputStream();
			// 判断是否为空
			if (uploadFile == null || uploadFile.isEmpty()) {
				p.setError(500);
				p.setMessage("上传图片为空！");
				return p;
			}
			// 获取文件名
			String originalFileName = uploadFile.getOriginalFilename();
			String txt = originalFileName.substring(originalFileName.lastIndexOf("."));
			DateTime dateTime = new DateTime();
			String filePath = dateTime.toString("/yyyy/MM/dd");
			String fileName = IDUtils.getImageName() + txt;
			FtpUtil.uploadFile(host, port, username, password, "/", filePath, fileName, in);
			String url = "http://localhost:8383" + filePath + "/" + fileName;
			p.setError(0);
			p.setUrl(url);
			return p;
		} catch (IOException e) {
			p.setError(500);
			p.setMessage("上传图片失败！");
			e.printStackTrace();
		} finally {
			if (in != null) {
				try {
					in.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return null;
	}

}
