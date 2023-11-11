package com.httt.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.httt.dao.CategoryDAO;
import com.httt.dao.ProductDAO;
import com.httt.dto.PagingResponse;
import com.httt.entities.Category;
import com.httt.entities.ProductLog;
import com.httt.util.PagingUtil;
import com.httt.util.SessionUtil;

@Controller
public class ProductController {
	@Value("${pageSize}")
    private Integer pageSize;
	
	@Value("${rootPath}")
	private String rootPath;
	
	@Value("${imageResource}")
	private String imageResource;
	
	@Value("${numberOfBestSaleProds}")
	private Integer numberOfBestSaleProds;
	
	@Value("${numberOfNewestProducts}")
	private Integer numberOfNewestProducts;
	
	@Autowired
	private ProductDAO productDAO;

	@Autowired
	private CategoryDAO categoryDAO;
	
	@RequestMapping(value = { "/" })
	public String homePage(HttpServletRequest req, Model model) {
		List<ProductLog> allProducts = productDAO.getProducts();
		List<Category> categories = categoryDAO.getCategories();
		
		model.addAttribute("products", allProducts);
		model.addAttribute("categories", categories);
		model.addAttribute("rootPath", rootPath);
		model.addAttribute("account", SessionUtil.getInstance().getValue(req, "ACCOUNT"));
		model.addAttribute("currentMenu", "homePage");
		
		return "index";
	}
	
	@RequestMapping(value = { "/products/paging" })
	public String getByPaging(HttpServletRequest req, @RequestParam(required = false, name = "page") Integer page, Model model) {
		List<ProductLog> allProducts = productDAO.getProducts();
		List<Category> categories = categoryDAO.getCategories();
		
		PagingResponse response = PagingUtil.getPagingResponse(allProducts, pageSize, page);
		
		model.addAttribute("pageInfo", response.getPageInfo());
		model.addAttribute("products", response.getProducts());
		model.addAttribute("categories", categories);
		model.addAttribute("pageName", "paging");
		model.addAttribute("rootPath", rootPath);
		model.addAttribute("account", SessionUtil.getInstance().getValue(req, "ACCOUNT"));
		model.addAttribute("currentMenu", "productPage");

		return "product";
	}

	
	@RequestMapping(value = { "/products/category" })
	public String getProductsByCategory(@RequestParam(required = false, name = "categoryId") Integer categoryId, 
			@RequestParam(required = false, name = "page") Integer page, Model model) {
		
		int currentcategoryId = categoryId;
		
		List<ProductLog> allProducts = productDAO.getByCategory(categoryId);
		List<Category> categories = categoryDAO.getCategories();
		
		PagingResponse response = PagingUtil.getPagingResponse(allProducts, pageSize, page);

		model.addAttribute("pageInfo", response.getPageInfo());
		model.addAttribute("products", response.getProducts());
		model.addAttribute("currentcategoryId", currentcategoryId);
		model.addAttribute("categories", categories);
		model.addAttribute("pageName", "category");
		model.addAttribute("rootPath", rootPath);
		model.addAttribute("currentMenu", "productPage");

		return "product";
	}

	@RequestMapping(value = { "/products/newest" })
	public String getNewestProducts(HttpServletRequest req, @RequestParam(required = false, name = "page") Integer page, Model model) {
		List<ProductLog> allProducts = productDAO.getNewestProducts(numberOfNewestProducts);
		List<Category> categories = categoryDAO.getCategories();
		
		PagingResponse response = PagingUtil.getPagingResponse(allProducts, pageSize, page);

		model.addAttribute("products", response.getProducts());
		model.addAttribute("pageInfo", response.getPageInfo());
		model.addAttribute("categories", categories);
		model.addAttribute("pageName", "newest");
		model.addAttribute("rootPath", rootPath);
		model.addAttribute("account", SessionUtil.getInstance().getValue(req, "ACCOUNT"));
		model.addAttribute("currentMenu", "productPage");

		return "product";
	}
	
	@RequestMapping(value = { "/products/feature" })
	public String getFeatureProducts(HttpServletRequest req, @RequestParam(required = false, name = "page") Integer page, Model model) {
		List<ProductLog> allProducts = productDAO.getFeatureProducts();
		List<Category> categories = categoryDAO.getCategories();
		
		PagingResponse response = PagingUtil.getPagingResponse(allProducts, pageSize, page);

		model.addAttribute("products", response.getProducts());
		model.addAttribute("pageInfo", response.getPageInfo());
		model.addAttribute("categories", categories);
		model.addAttribute("pageName", "newest");
		model.addAttribute("rootPath", rootPath);
		model.addAttribute("account", SessionUtil.getInstance().getValue(req, "ACCOUNT"));
		model.addAttribute("currentMenu", "productFeaturePage");

		return "product";
	}
	
	@RequestMapping(value = { "/products/discount" })
	public String getDiscountProducts(HttpServletRequest req, @RequestParam(required = false, name = "page") Integer page, Model model) {
		List<ProductLog> allProducts = productDAO.getDiscountProducts();
		List<Category> categories = categoryDAO.getCategories();
		
		PagingResponse response = PagingUtil.getPagingResponse(allProducts, pageSize, page);

		model.addAttribute("products", response.getProducts());
		model.addAttribute("pageInfo", response.getPageInfo());
		model.addAttribute("categories", categories);
		model.addAttribute("pageName", "discount");
		model.addAttribute("rootPath", rootPath);
		model.addAttribute("account", SessionUtil.getInstance().getValue(req, "ACCOUNT"));
		model.addAttribute("currentMenu", "productPage");

		return "product";
	}
	
	@RequestMapping(value = { "/products/bestsale" })
	public String getBestSaleProducts(HttpServletRequest req, @RequestParam(required = false, name = "page") Integer page, Model model) {
		List<ProductLog> allProducts = productDAO.getBestSaleProducts(numberOfBestSaleProds);
		List<Category> categories = categoryDAO.getCategories();
		
		PagingResponse response = PagingUtil.getPagingResponse(allProducts, pageSize, page);

		model.addAttribute("products", response.getProducts());
		model.addAttribute("pageInfo", response.getPageInfo());
		model.addAttribute("categories", categories);
		model.addAttribute("pageName", "bestsale");
		model.addAttribute("rootPath", rootPath);
		model.addAttribute("account", SessionUtil.getInstance().getValue(req, "ACCOUNT"));
		model.addAttribute("currentMenu", "productPage");

		return "product";
	}
	
	@RequestMapping(value = { "/products/search" })
	public String getBestSaleProducts(HttpServletRequest req, @RequestParam(required = false, name = "key") String key,
			@RequestParam(required = false, name = "page") Integer page, Model model) {
		List<ProductLog> allProducts = productDAO.search(key);
		if(!allProducts.isEmpty()) {
			PagingResponse response = PagingUtil.getPagingResponse(allProducts, pageSize, page);

			model.addAttribute("products", response.getProducts());
			model.addAttribute("pageInfo", response.getPageInfo());
			model.addAttribute("pageName", "search");
		}
		
		List<Category> categories = categoryDAO.getCategories();
		model.addAttribute("categories", categories);
		model.addAttribute("rootPath", rootPath);
		model.addAttribute("account", SessionUtil.getInstance().getValue(req, "ACCOUNT"));
		model.addAttribute("currentMenu", "productPage");
		return "product";
	}
	
	
	@RequestMapping(value = { "/productDetail" })
	public String getProductId(HttpServletRequest req, @RequestParam(required = false, name = "prodId") Integer prodId, Model model) {
		List<Category> categories = categoryDAO.getCategories();
		if(prodId != null) {
			ProductLog product = productDAO.getProductDetail(prodId);
			
			List<ProductLog> relatedProds = productDAO.getRelatedProducts(product.getCategoryId());
			
			model.addAttribute("product", product);
			
			String imagePath = product.getPicture();
			String[] splitedPath = imagePath.split("/");
			String picture = splitedPath[splitedPath.length - 1];
			String pictureName = FilenameUtils.removeExtension(picture);
			
			model.addAttribute("pictureName", pictureName);
			model.addAttribute("imageResource", imageResource);
			model.addAttribute("relatedProds", relatedProds);
		}
		model.addAttribute("categories", categories);
		model.addAttribute("rootPath", rootPath);
		model.addAttribute("account", SessionUtil.getInstance().getValue(req, "ACCOUNT"));
		return "product_detail";
	}
}
