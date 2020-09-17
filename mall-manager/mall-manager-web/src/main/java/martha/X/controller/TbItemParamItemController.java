package martha.X.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


import martha.X.service.TbItemParamItemService;
@RequestMapping("/itemParamInfo")
@Controller
public class TbItemParamItemController {
	@Autowired
	private TbItemParamItemService tbItemParamItemService;
	
	@RequestMapping("/showParam/{itemId}")
	public String showParam(@PathVariable Long itemId,Model model) {
		String html = tbItemParamItemService.getTbItemParamByItemId(itemId);
		model.addAttribute("html",html);
		return "item-param";
	}
}
