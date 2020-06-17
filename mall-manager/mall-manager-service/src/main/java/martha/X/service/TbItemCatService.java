package martha.X.service;

import java.util.List;

import martha.X.utils.EasyUITreeNodeBean;

public interface TbItemCatService {
	List<EasyUITreeNodeBean> getTbItemCatList(Long parentId);
}
