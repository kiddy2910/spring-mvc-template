package com.duytran.sample.dto;

import java.util.List;

public class ListDTO<T> implements GenericDTO {
	private static final long serialVersionUID = -7765128377452304581L;

	private int total;
	private List<T> list;

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public List<T> getList() {
		return list;
	}

	public void setList(List<T> list) {
		this.list = list;
	}

}
