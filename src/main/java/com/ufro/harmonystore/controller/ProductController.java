package com.ufro.harmonystore.controller;

import com.ufro.harmonystore.models.product.Brand;
import com.ufro.harmonystore.models.product.Category;
import com.ufro.harmonystore.models.product.Product;
import com.ufro.harmonystore.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

	@Autowired
	private ProductService productService;

	@GetMapping("")
	public List<Product> getAllProducts() {
		return productService.getProducts();
	}

	@GetMapping("/price")
	public List<Product> getProductByPrice(@RequestParam("min") Integer min, @RequestParam("max") Integer max) {
		return productService.getProductsByPrice(min, max);
	}

	@GetMapping("/brand")
	public List<Product> getProductByBrand(@RequestParam("min") Integer min, @RequestParam("max") Integer max) {
		return productService.getProductsByBrands(min, max);
	}

	@GetMapping("/category/{category_id}")
	public List<Product> getProductsByCategory(@PathVariable Integer category_id) {
		return productService.getProductsByCategory(category_id);
	}

	@GetMapping("/categories")
	public List<Category> getCategories() {
		return productService.getAllCategory();
	}

	@GetMapping("/brands")
	public List<Brand> getBrands() {
		return productService.getAllBrands();
	}

	@GetMapping("/{id}")
	public Product getProductById(@PathVariable Integer id) {
		return productService.getProductById(id);
	}

	@PostMapping("/save")
	public Product saveProduct(@RequestBody Product producto) {
		return productService.saveProducto(producto);
	}

	@PutMapping("/{id}")
	public Product updateProduct(@PathVariable Integer id, @RequestBody Product producto) {
		producto.setId(id);
		return productService.updateProduct(producto);
	}

	@DeleteMapping("/{id}")
	public void deleteProduct(@PathVariable Integer id) {
		productService.deleteProduct(id);
	}

	@DeleteMapping("")
	public void deleteAllProducts() {
		productService.deleteProducts();
	}
}
