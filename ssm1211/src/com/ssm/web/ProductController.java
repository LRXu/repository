package com.ssm.web;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.ssm.domain.Product;
import com.ssm.service.ProductService;
import com.ssm.tools.QueryItem;
import com.ssm.tools.TampVo;
import com.ssm.tools.UUIDUtils;
import com.sun.corba.se.spi.orbutil.fsm.Action;

@Controller
@RequestMapping(value="/products")
public class ProductController {

	@Autowired
	private ProductService productService;
	
	/* 商品列表 */
	@RequestMapping(value="/productlist")
	public String getProductList(Model model) {
		List<Product> product = productService.getProduct();
		model.addAttribute("productList", product);
		return "productList";
	}
	
	
	/* 查询被修改商品  */
	@RequestMapping(value="/itemEdit/{id}")
	public ModelAndView getProductById(@PathVariable("id") Integer id) {
		Product product = productService.getProductById(id);
		ModelAndView mView = new ModelAndView();
		mView.setViewName("productItem");
		mView.addObject("item",product);
		return mView;
	}
	
//	/* 修改商品1 */
//	@RequestMapping(value="/updateitem")
//	public String updateProduct(Product product, Model model) {
//		
//		System.out.println("121212"+product.getName());
//		int result = productService.updateProduct(product);
//		
//		if (result>0) {
//			List<Product> products = productService.getProduct();
//			model.addAttribute("productList",products);
//		}
//		return "productList";
//	}
	
	/** 修改商品 
	 * 上传文件模块
	 *图片需要摄像图片服务器以及本地存放区
	 * @throws IOException 
	 * @throws IllegalStateException 
	 */
	@RequestMapping(value="/updateitem")
	public String updateProduct(MultipartFile pictureFile, Product product, Model model) throws IllegalStateException, IOException {
		
		/* 判断文件是否为空 */
		if (!pictureFile.isEmpty()) {
			
			/* 获取上传文件的完整路径 */
			String originalFilename = pictureFile.getOriginalFilename();
			/* 修改文件名格式 随机数加后缀名 */
			String uuids = UUIDUtils.getUUIDS();
			String newFileName = uuids+originalFilename.substring(originalFilename.lastIndexOf("."));
			/* 将本地文件上传到服务器 本地磁盘中 */
			pictureFile.transferTo(new File("F:\\Program Files\\image\\"+newFileName));
			product.setPic(newFileName);
			
			int result = productService.updateProduct(product);
			if (result>0) {
				List<Product> products = productService.getProduct();
				model.addAttribute("productList",products);
			}
		}
		return "productList";
	}
	
	/* 批量修改商品 */
	@RequestMapping(value="/query")
	public String updateProductAll(Model model,String action,QueryItem queryItem,TampVo vo) {
		
		if (action.equals("查询")) {
			System.out.println("查询。。。。。");
			String name = queryItem.getProduct().getName();
			Product productList = queryItem.getProduct();
			if (productList!=null) {
				List<Product> products = productService.queryProductList(name);

				model.addAttribute("productList",products);
			}
		}else if (action.equals("修改")) {
			System.out.println("修改。。。。。");
			List<Product> products = vo.getProducts();
			for (Product product : products) {
				Integer result = productService.updateProductAll(product);
				if (result>0) {
					List<Product> product1 = productService.getProduct();
					model.addAttribute("productList",product1);
				}
			}
		}else {
			System.out.println("删除。。。。。");
			System.out.println("product id..."+vo.getIds());
		}
		return "productList";
	}
	
	/* ajax接收json*/
	@RequestMapping(value="/sendjson")
	@ResponseBody
	public String sendjson(@RequestBody Product product) {
		System.out.println("product："+product.getName());
		return null;
	}

}
