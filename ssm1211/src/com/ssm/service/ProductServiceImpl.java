package com.ssm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssm.dao.ProductMapper;
import com.ssm.domain.Product;
import com.ssm.domain.ProductExample;
import com.ssm.domain.ProductExample.Criteria;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductMapper productMapper;
	
	/* 获取商品列表 */
	@Override
	public List<Product> getProduct() {
		
		ProductExample example = new ProductExample();
		List<Product> product = productMapper.selectByExampleWithBLOBs(example);
		return product;
	}

	/* 获取选定商品  */
	@Override
	public Product getProductById(Integer id) {
		
		Product product = productMapper.selectByPrimaryKey(id);
		return product;
	}

	/* 修改商品 */
	@Override
	public int updateProduct(Product product) {
		
		int result = productMapper.updateByPrimaryKey(product);
		return result;
	}

	/* 批量修改商品 */
	@Override
	public Integer updateProductAll(Product products) {
		int result = productMapper.updateByPrimaryKey(products);
		return result;
	}

	/**
	 * 模糊查询
	 */
	@Override
	public List<Product> queryProductList(String name) {
		
		ProductExample example = new ProductExample();
		Criteria criteria = example.createCriteria();
		criteria.andNameLike("%"+name+"%");
		List<Product> products = productMapper.selectByExampleWithBLOBs(example);
		
		return products;
	}
	



}
