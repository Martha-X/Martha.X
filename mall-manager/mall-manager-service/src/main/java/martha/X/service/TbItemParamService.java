package martha.X.service;

import java.util.List;

import martha.X.utils.EsayUIDataGridResult;
import martha.X.utils.FjnyResult;

public interface TbItemParamService {
	public EsayUIDataGridResult getItemParamList(Integer page,Integer rows);
	public FjnyResult checkParam(Long itemCatId);
	public FjnyResult addItemParam(Long itemCatId, String paramData);
	public FjnyResult getTbItemParamList(Long id);
	public FjnyResult updateItemParam(Long itemCatId, Long id,String paramData);
	//执行删除操作
	public FjnyResult operateItemParam(List<Long> ids); 
}
