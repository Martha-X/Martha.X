package martha.X.service.impl;

import java.util.Date;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import martha.X.mapper.TbItemDescMapper;
import martha.X.mapper.TbItemMapper;
import martha.X.pojo.TbItem;
import martha.X.pojo.TbItemDesc;
import martha.X.pojo.TbItemExample;
import martha.X.service.TbItemService;
import martha.X.utils.EsayUIDataGridResult;
import martha.X.utils.FjnyResult;
import martha.X.utils.IDUtils;

@Service
public class TbItemServiceImpl implements TbItemService {
	@Autowired
	private TbItemMapper tbItemMapper;
	@Autowired
	private TbItemDescMapper tbItemDescMapper;

	@Override
	public EsayUIDataGridResult getTbItemList(Integer page, Integer rows) {
		// 分页插件
		PageHelper.startPage(page, rows);
		TbItemExample example = new TbItemExample();
		example.createCriteria().andStatusNotEqualTo((byte) 3);
		List<TbItem> list = tbItemMapper.selectByExample(example);
		PageInfo<TbItem> pageInfo = new PageInfo<>(list);
		long total = pageInfo.getTotal();
		EsayUIDataGridResult esayUIDataGridResult = new EsayUIDataGridResult(total, list);
		return esayUIDataGridResult;
	}

	@Override
	public FjnyResult saveItem(TbItem tbItem, String desc) {
		long itemId = IDUtils.getItemId();
		tbItem.setId(itemId);
		tbItem.setCreated(new Date());
		tbItem.setUpdated(new Date());
		tbItem.setStatus((byte) 1);
		int insertSelective = tbItemMapper.insertSelective(tbItem);
		TbItemDesc record = new TbItemDesc();
		record.setItemId(tbItem.getId());
		record.setItemDesc(desc);
		record.setCreated(new Date());
		record.setUpdated(new Date());
		tbItemDescMapper.insertSelective(record);
		System.out.println(record);
		if (insertSelective < 0) {
			return FjnyResult.build(500, "添加商品失败！");
		}
		return FjnyResult.ok();
	}

	@Override
	public FjnyResult updateTbItem(TbItem tbItem, String desc) {
		// 更新商品信息
		tbItem.setUpdated(new Date());
		tbItemMapper.updateByPrimaryKeySelective(tbItem);
		// 更新商品描述信息
		TbItemDesc record = new TbItemDesc();
		record.setItemId(tbItem.getId());
		record.setItemDesc(desc);
		record.setUpdated(new Date());
		tbItemDescMapper.updateByPrimaryKeySelective(record);
		return FjnyResult.ok();
	}

	@Override
	public FjnyResult operateTbItem(List<Long> ids, List<String> optionsId) {
		try {
			TbItem record = new TbItem();
			record.setStatus((byte) Integer.parseInt(optionsId.get(0)));
			TbItemExample example = new TbItemExample();
			example.createCriteria().andIdIn(ids);
			tbItemMapper.updateByExampleSelective(record, example);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return FjnyResult.ok();
	}
}
