package martha.X.service;

import martha.X.utils.EsayUIDataGridResult;

public interface TbItemService {
	//获取商品列表
	public EsayUIDataGridResult getTbItemList(Integer page,Integer rows);
}
