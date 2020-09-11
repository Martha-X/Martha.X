package martha.X.service;

import java.util.List;

import martha.X.pojo.TbItem;
import martha.X.utils.EsayUIDataGridResult;
import martha.X.utils.FjnyResult;

public interface TbItemService {
	//获取商品列表
	public EsayUIDataGridResult getTbItemList(Integer page,Integer rows);
	//添加商品
	public FjnyResult saveItem(TbItem tbItem,String desc, String itemParams);
	//更新商品信息
	public FjnyResult updateTbItem(TbItem tbItem,String desc);
	//删除商品
	public FjnyResult operateTbItem(List<Long> ids,List<String> optionsId);
}
