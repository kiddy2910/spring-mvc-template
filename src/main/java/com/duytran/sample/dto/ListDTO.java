package com.duytran.sample.dto;

import java.util.List;

public class ListDTO<T> extends BaseDTO {
	private static final long serialVersionUID = -2678161269414619015L;

	private int total;
	private List<T> list;

	public ListDTO(StatusCode status) {
		super(status);
	}

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
