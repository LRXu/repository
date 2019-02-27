package com.ssm.tools;

import java.util.List;

import com.ssm.domain.Product;

public class TampVo {
	
	private Integer[] ids;
	private List<Product> products;
	

	public Integer[] getIds() {
		return ids;
	}

	public void setIds(Integer[] ids) {
		this.ids = ids;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}


}
