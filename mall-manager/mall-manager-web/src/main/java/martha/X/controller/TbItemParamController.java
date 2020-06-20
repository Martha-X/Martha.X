package martha.X.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import martha.X.service.TbItemParamService;
import martha.X.utils.EsayUIDataGridResult;
import martha.X.utils.FjnyResult;
@Controller
@RequestMapping("/item/param")
public class TbItemParamController {
	@Autowired
	public TbItemParamService tbItemParamService;
	@RequestMapping("/list")
	@ResponseBody
	public EsayUIDataGridResult getItemParamList(@RequestParam(defaultValue="1")Integer page,@RequestParam(defaultValue="30")Integer rows) {
		return tbItemParamService.getItemParamList(page, rows);
	}
	//查询类目是否存在规格模板
	@RequestMapping("/query/itemcatid/{itemCatId}")
	@ResponseBody
	public FjnyResult checkParam(@PathVariable Long itemCatId) {
		System.out.println("checkParam");
		return tbItemParamService.checkParam(itemCatId);
	}
	
	//保存添加的规格模板
	@RequestMapping("/save/{itemCatId}")
	@ResponseBody
	public FjnyResult addItemParam(@PathVariable Long itemCatId,String paramData) {
		return tbItemParamService.addItemParam(itemCatId,paramData);
	}
	@RequestMapping("/query/itemParamList/{id}")
	@ResponseBody
	public FjnyResult getTbItemParamList(@PathVariable Long id) {
		System.out.println("itemId" + id);
		return tbItemParamService.getTbItemParamList(id);
	}
}
