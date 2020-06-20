package martha.X.service;

import martha.X.utils.EsayUIDataGridResult;
import martha.X.utils.FjnyResult;

public interface TbItemParamService {
	public EsayUIDataGridResult getItemParamList(Integer page,Integer rows);
	public FjnyResult checkParam(Long itemCatId);
	public FjnyResult addItemParam(Long itemCatId, String paramData);
	public FjnyResult getTbItemParamList(Long id);
}
