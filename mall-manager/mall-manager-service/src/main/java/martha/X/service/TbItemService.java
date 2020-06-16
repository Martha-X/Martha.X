package martha.X.service;

import martha.X.pojo.TbItem;
import martha.X.utils.EsayUIDataGridResult;
import martha.X.utils.FjnyResult;

public interface TbItemService {
	//获取商品列表
	public EsayUIDataGridResult getTbItemList(Integer page,Integer rows);
	//添加商品
	public FjnyResult saveItem(TbItem tbItem);
}
