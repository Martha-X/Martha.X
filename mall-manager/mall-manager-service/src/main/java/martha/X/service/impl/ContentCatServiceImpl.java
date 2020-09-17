package martha.X.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import martha.X.mapper.TbContentCategoryMapper;
import martha.X.pojo.EasyUITreeNodeBean;
import martha.X.pojo.TbContentCategory;
import martha.X.pojo.TbContentCategoryExample;
import martha.X.pojo.TbContentCategoryExample.Criteria;
import martha.X.service.ContentCatService;
@Service
public class ContentCatServiceImpl implements ContentCatService {
	@Autowired
	private TbContentCategoryMapper tbContentCategoryMapper;

	@Override
	public List<EasyUITreeNodeBean> getContentCatList(long parentId) {
		TbContentCategoryExample example = new TbContentCategoryExample();
		Criteria criteria = example.createCriteria();
		criteria.andParentIdEqualTo(parentId);
		List<TbContentCategory> list = tbContentCategoryMapper.selectByExample(example);
		List<EasyUITreeNodeBean> resultList = new ArrayList<>();
		for (TbContentCategory tbContentCategory : list) {
			EasyUITreeNodeBean node = new EasyUITreeNodeBean(tbContentCategory.getId(), tbContentCategory.getName(),
					tbContentCategory.getIsParent() ? "closed" : "open");
			resultList.add(node);
		}
		for(EasyUITreeNodeBean result : resultList) {
			System.out.println(result);
		}
		return resultList;
	}

}
