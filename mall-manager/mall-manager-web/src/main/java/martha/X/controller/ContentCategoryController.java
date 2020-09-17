package martha.X.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import martha.X.pojo.EasyUITreeNodeBean;
import martha.X.service.ContentCatService;
@Controller
@RequestMapping("/content/category")
public class ContentCategoryController {
	@Autowired
	private ContentCatService contentCatService;
	
	@RequestMapping("/list")
	@ResponseBody
	public List<EasyUITreeNodeBean>  getContentList(@RequestParam(value = "id",defaultValue="0") long parentId){
		List<EasyUITreeNodeBean> list = contentCatService.getContentCatList(parentId);
		return list;
	}
	
}
