package martha.X.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import martha.X.pojo.TbItem;
import martha.X.service.TbItemCatService;
import martha.X.service.TbItemService;
import martha.X.utils.EasyUITreeNodeBean;
import martha.X.utils.EsayUIDataGridResult;
import martha.X.utils.FjnyResult;

@Controller
@RequestMapping("/item")
public class TbItemController {
	@Autowired
	public TbItemService tbItemService;
	@Autowired
	public TbItemCatService tbItemCatService;

	@RequestMapping("/getItem")
	@ResponseBody
	public EsayUIDataGridResult getTbItemList(@RequestParam(defaultValue = " 1") Integer page,
			@RequestParam(defaultValue = "10") Integer rows) {
		return tbItemService.getTbItemList(page, rows);
	}
	
	@RequestMapping(value="/save",method=RequestMethod.POST)
	@ResponseBody
	public FjnyResult saveTbItem(TbItem tbItem,String desc) {
		System.out.println(desc);
		return tbItemService.saveItem(tbItem,desc);
	}
	
	@RequestMapping("/cat/list")
	@ResponseBody
	public List<EasyUITreeNodeBean> getTbItemCat(@RequestParam(defaultValue="0")Long id) {
		return tbItemCatService.getTbItemCatList(id);
	}
}
