package martha.X.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import martha.X.mapper.TbItemDescMapper;
import martha.X.pojo.TbItemDesc;
import martha.X.service.TbItemDescService;
import martha.X.utils.FjnyResult;
@Service
public class TbItemDescServiceImpl implements TbItemDescService{
	@Autowired
	private TbItemDescMapper tbItemDescMapper;
	@Override
	public FjnyResult getTbItemDesc(Long itemId) {
		TbItemDesc itemDesc = tbItemDescMapper.selectByPrimaryKey(itemId);
		return FjnyResult.ok(itemDesc);
	}

}
