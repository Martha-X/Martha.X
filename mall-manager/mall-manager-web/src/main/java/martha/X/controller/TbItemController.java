package martha.X.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import martha.X.service.TbItemService;
import martha.X.utils.EsayUIDataGridResult;

@Controller
@RequestMapping("/item")
public class TbItemController {
	@Autowired
	public TbItemService tbItemService;

	@RequestMapping("/getItem")
	@ResponseBody
	public EsayUIDataGridResult getTbItemList(@RequestParam(defaultValue = " 1") Integer page,
			@RequestParam(defaultValue = "10") Integer rows) {
		return tbItemService.getTbItemList(page, rows);
	}
}
