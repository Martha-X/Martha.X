package martha.X.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import martha.X.mapper.TbItemCatMapper;
import martha.X.mapper.TbItemDescMapper;
import martha.X.mapper.TbItemParamMapper;
import martha.X.pojo.TbItem;
import martha.X.pojo.TbItemCat;
import martha.X.pojo.TbItemDesc;
import martha.X.pojo.TbItemExample;
import martha.X.pojo.TbItemParam;
import martha.X.pojo.TbItemParamExample;
import martha.X.pojo.TbItemParamExample.Criteria;
import martha.X.service.TbItemParamService;
import martha.X.utils.EsayUIDataGridResult;
import martha.X.utils.ExceptionUtil;
import martha.X.utils.FjnyResult;
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

	@Override
	public FjnyResult checkParam(Long itemCatId) {
		try {
			TbItemParamExample example = new TbItemParamExample();
			Criteria createCriteria = example.createCriteria();
			createCriteria.andItemCatIdEqualTo(itemCatId);
			List<TbItemParam> list = tbItemParamMapper.selectByExampleWithBLOBs(example);
			if(list == null || list.isEmpty()) {
				return FjnyResult.ok();
			}
			return FjnyResult.ok(list.get(0));
		}catch(Exception e) {
			return FjnyResult.build(500,ExceptionUtil.getStackTrace(e));
		}
	}

	@Override
	public FjnyResult addItemParam(Long itemCatId, String paramData) {
		try {
			TbItemParam record = new TbItemParam();
			record.setItemCatId(itemCatId);
			record.setParamData(paramData);
			record.setCreated(new Date());
			record.setUpdated(new Date());
			tbItemParamMapper.insert(record);
			return FjnyResult.ok();
		}catch(Exception e) {
			return FjnyResult.build(500,ExceptionUtil.getStackTrace(e));
		}
	}

	@Override
	public FjnyResult getTbItemParamList(Long id) {
		TbItemParam itemParamList = tbItemParamMapper.selectByPrimaryKey(id);
		System.out.println(itemParamList);
		return FjnyResult.ok(itemParamList);
	}

	@Override
	public FjnyResult updateItemParam(Long itemCatId, Long id,String paramData) {
		try {
			TbItemParam record = new TbItemParam();
			record.setId(id);
			record.setItemCatId(itemCatId);
			record.setParamData(paramData);
			record.setCreated(new Date());
			record.setUpdated(new Date());
			System.out.println(record);
			int i = tbItemParamMapper.updateByPrimaryKeySelective(record);
			System.out.println(i);
			return FjnyResult.ok();
		}catch(Exception e) {
			return FjnyResult.build(500,ExceptionUtil.getStackTrace(e));
		}
	}

	@Override
	public FjnyResult operateItemParam(List<Long> ids) {
		try {
			for(Long id : ids) {
				System.out.println(id);
				tbItemParamMapper.deleteByPrimaryKey(id);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return FjnyResult.ok();
	}
}
