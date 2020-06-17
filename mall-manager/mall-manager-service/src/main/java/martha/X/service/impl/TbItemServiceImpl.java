package martha.X.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import martha.X.mapper.TbItemMapper;
import martha.X.pojo.TbItem;
import martha.X.pojo.TbItemExample;
import martha.X.service.TbItemService;
import martha.X.utils.EsayUIDataGridResult;
import martha.X.utils.FjnyResult;
import martha.X.utils.IDUtils;

@Service
public class TbItemServiceImpl implements TbItemService {
	@Resource
	private TbItemMapper tbItemMapper;

	@Override
	public EsayUIDataGridResult getTbItemList(Integer page, Integer rows) {
		// 分页插件
		PageHelper.startPage(page, rows);
		TbItemExample exam = new TbItemExample();
		List<TbItem> list = tbItemMapper.selectByExample(exam);
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i).toString());
		}
		PageInfo<TbItem> pageInfo = new PageInfo<>(list);
		long total = pageInfo.getTotal();
		EsayUIDataGridResult esayUIDataGridResult = new EsayUIDataGridResult(total, list);
		return esayUIDataGridResult;
	}

	@Override
	public FjnyResult saveItem(TbItem tbItem,String desc) {
		System.out.println(tbItem.getImage());
		long itemId = IDUtils.getItemId();
		System.out.println(itemId);
		tbItem.setId(itemId);
		tbItem.setCid(560);
		tbItem.setCreated(new Date());
		tbItem.setUpdated(new Date());
		tbItem.setStatus((byte)1);
		System.out.println(tbItem);
		int insertSelective = tbItemMapper.insertSelective(tbItem);
		//TbItemDesc record = new TbItemDesc();
		/*
		 * if (insertSelective < 0) { return FjnyResult.build(500, "添加商品失败！"); }
		 */
		return FjnyResult.ok();
	}

}
