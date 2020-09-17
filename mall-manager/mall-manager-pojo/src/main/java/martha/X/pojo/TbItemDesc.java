package martha.X.pojo;

import java.util.Date;

/**
 * @Description 商品信息描述类
 * @author Martha
 * @ClassName TbItemDesc
 * @Date 2020-9-11 18:54:28
 */
public class TbItemDesc {
	private Long itemId;// 商品 id

	private Date created;

	private Date updated;

	private String itemDesc;// 商品描述

	public Long getItemId() {
		return itemId;
	}

	public void setItemId(Long itemId) {
		this.itemId = itemId;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public Date getUpdated() {
		return updated;
	}

	public void setUpdated(Date updated) {
		this.updated = updated;
	}

	public String getItemDesc() {
		return itemDesc;
	}

	public void setItemDesc(String itemDesc) {
		this.itemDesc = itemDesc == null ? null : itemDesc.trim();
	}
}