package martha.X.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import martha.X.mapper.TbItemCatMapper;
import martha.X.pojo.TbItemCat;
import martha.X.pojo.TbItemCatExample;
import martha.X.pojo.TbItemCatExample.Criteria;
import martha.X.service.TbItemCatService;
import martha.X.utils.EasyUITreeNodeBean;
@Service
public class TbItemCatServiceImpl implements TbItemCatService{
	@Autowired
	private TbItemCatMapper tbItemCatMapper;
	@Override
	public List<EasyUITreeNodeBean> getTbItemCatList(Long parentId) {
		TbItemCatExample example = new TbItemCatExample();
		Criteria criteria = example.createCriteria();
		criteria.andParentIdEqualTo(parentId);
		List<TbItemCat> tbItemCatList = tbItemCatMapper.selectByExample(example);
		List<EasyUITreeNodeBean> list=new ArrayList<EasyUITreeNodeBean>();
		for (TbItemCat tbItemCat : tbItemCatList) {
			EasyUITreeNodeBean node=new EasyUITreeNodeBean();
			node.setId(tbItemCat.getId());
			node.setState(tbItemCat.getIsParent()?"closed":"open");
			node.setText(tbItemCat.getName());
			list.add(node);
		}
		return list;
	}

}
