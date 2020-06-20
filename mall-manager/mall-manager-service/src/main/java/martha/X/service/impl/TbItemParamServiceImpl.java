package martha.X.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import martha.X.mapper.TbItemCatMapper;
import martha.X.mapper.TbItemParamMapper;
import martha.X.pojo.TbItemCat;
import martha.X.pojo.TbItemParam;
import martha.X.pojo.TbItemParamExample;
import martha.X.service.TbItemParamService;
import martha.X.utils.EsayUIDataGridResult;
@Service
public class TbItemParamServiceImpl implements TbItemParamService{
	@Autowired
	private TbItemParamMapper tbItemParamMapper;
	@Autowired
	private TbItemCatMapper tbItemCatMapper;
	@Override
	public EsayUIDataGridResult getItemParamList(Integer page, Integer rows) {
		TbItemParamExample exam = new TbItemParamExample();
		PageHelper.startPage(page, rows);
		List<TbItemParam> list = tbItemParamMapper.selectByExampleWithBLOBs(exam);
		for(TbItemParam tbItemparam:list) {
			if(tbItemparam.getItemCatId() != null) {
				String tbItemCatName = geItemCatName(tbItemparam.getItemCatId());
				tbItemparam.setItemCatName(tbItemCatName);
			}
		}
		PageInfo<TbItemParam> pageInfo = new PageInfo<>(list);
		long total = pageInfo.getTotal();
		EsayUIDataGridResult esayUIDataGridResult = new EsayUIDataGridResult(total, list);
		return esayUIDataGridResult;
	}
	
	public String geItemCatName(Long cid) {
		TbItemCat cat = tbItemCatMapper.selectByPrimaryKey(cid);
		return cat.getName();
	}
}
