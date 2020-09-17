package martha.X.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import martha.X.pojo.TbItem;
import martha.X.service.TbItemCatService;
import martha.X.service.TbItemDescService;
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
	@Autowired
	public TbItemDescService tbItemDescService;

	@RequestMapping("/getItem")
	@ResponseBody
	public EsayUIDataGridResult getTbItemList(@RequestParam(defaultValue = "1") Integer page,
			@RequestParam(defaultValue = "10") Integer rows) {
		return tbItemService.getTbItemList(page, rows);
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	@ResponseBody
	public FjnyResult saveTbItem(TbItem tbItem, String desc,String itemParams) {
		System.out.println(desc);
		return tbItemService.saveItem(tbItem, desc,itemParams);
	}

	@RequestMapping("/cat/list")
	@ResponseBody
	public List<EasyUITreeNodeBean> getTbItemCat(@RequestParam(defaultValue = "0") Long id) {
		return tbItemCatService.getTbItemCatList(id);
	}

	@RequestMapping("/query/item-desc/{id}")
	@ResponseBody
	public FjnyResult getTbItemDesc(@PathVariable Long id) {
		System.out.println("itemId" + id);
		return tbItemDescService.getTbItemDesc(id);
	}

	@RequestMapping("/update")
	@ResponseBody
	public FjnyResult updateTbItem(TbItem tbItem, String desc) {
		return tbItemService.updateTbItem(tbItem, desc);
	}

	/**
	 * 结合删除、上架、下架的方法
	 * @param ids 
	 * @param optionsId
	 * @return
	 */
	@RequestMapping("/operate")
	@ResponseBody
	public FjnyResult operateTbItem(@RequestParam("itemIds") List<Long> itemIds,@RequestParam("optionsId") List<String> optionsId) {
		return tbItemService.operateTbItem(itemIds, optionsId);
	}
}
