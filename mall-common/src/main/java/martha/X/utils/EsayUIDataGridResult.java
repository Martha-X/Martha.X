package martha.X.utils;

import java.util.List;
/**
 * @Description 要求的数据格式
 * @author Martha
 * @ClassName EsayUIDataGridResult
 * @Date 2020年6月13日 上午10:50:33
 */
public class EsayUIDataGridResult {
	private long total;
	private List<?> rows;
	public EsayUIDataGridResult() {
		super();
	}
	public long getTotal() {
		return total;
	}
	public void setTotal(long total) {
		this.total = total;
	}
	public List<?> getRows() {
		return rows;
	}
	public void setRows(List<?> rows) {
		this.rows = rows;
	}
	public EsayUIDataGridResult(long total, List<?> rows) {
		super();
		this.total = total;
		this.rows = rows;
	}
	@Override
	public String toString() {
		return "EsayUIDataGridResult [total=" + total + ", rows=" + rows + "]";
	}
}
