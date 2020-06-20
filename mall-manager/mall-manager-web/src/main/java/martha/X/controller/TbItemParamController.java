package martha.X.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import martha.X.service.TbItemParamService;
import martha.X.utils.EsayUIDataGridResult;

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
}
