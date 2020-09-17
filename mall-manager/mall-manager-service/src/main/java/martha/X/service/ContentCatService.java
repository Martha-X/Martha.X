package martha.X.service;

import java.util.List;

import martha.X.pojo.EasyUITreeNodeBean;

public interface ContentCatService {
	//获取内容分类列表
	public List<EasyUITreeNodeBean> getContentCatList(long parentId);
}
