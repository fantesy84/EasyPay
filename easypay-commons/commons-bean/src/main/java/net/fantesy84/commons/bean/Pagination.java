package net.fantesy84.commons.bean;

import java.io.Serializable;
import java.util.List;

public class Pagination<E extends Serializable> implements Serializable{
	private static final long serialVersionUID = -2627765481697925258L;
	private Integer total;
	private Integer size;
	private Integer index;
	private List<E> rows;
	public Integer getTotal() {
		return total;
	}
	public void setTotal(Integer total) {
		this.total = total;
	}
	public Integer getSize() {
		return size;
	}
	public void setSize(Integer size) {
		this.size = size;
	}
	public Integer getIndex() {
		return index;
	}
	public void setIndex(Integer index) {
		this.index = index;
	}
	public List<E> getRows() {
		return rows;
	}
	public void setRows(List<E> rows) {
		this.rows = rows;
	}
	
}
