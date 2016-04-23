package net.fantesy84.commons.bean;

import java.io.Serializable;

public final class BaseRequestDTO<T> implements Serializable{
	private static final long serialVersionUID = 1L;
	private Integer size = 10;
	private Integer index = 1;
	private T paramBean;
	
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
	
	public T getParamBean() {
		return paramBean;
	}
	public void setParamBean(T paramBean) {
		this.paramBean = paramBean;
	}
	public int calculateQueryFirstRowNum() {
		return (index-1)*size;
	}
	
	public int calculateQueryLastedRowNum() {
		return size*index;
	}
}
