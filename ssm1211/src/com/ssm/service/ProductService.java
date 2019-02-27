package com.ssm.service;

import java.util.List;

import com.ssm.domain.Product;

public interface ProductService {
	
	/* 获取商品 */
	public List<Product> getProduct();
	
	/* 通过id获取商品 */
	public Product getProductById(Integer id);
	
	/* 修改商品 */
	public int updateProduct(Product product);
	
	/* 批量修改商品 */
	public Integer updateProductAll(Product products);
	
	/* 模糊查询 */
	public List<Product> queryProductList(String name);
	

}
