package com.ufro.harmonystore.controller;

import com.ufro.harmonystore.models.Admin;
import com.ufro.harmonystore.models.Order;
import com.ufro.harmonystore.models.product.Product;
import com.ufro.harmonystore.services.OrderService;
import com.ufro.harmonystore.services.ProductService;
import com.ufro.harmonystore.services.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admins")
public class AdminController {

	@Autowired
	private ProductService productService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private OrderService orderService;
	
	private Logger logg= LoggerFactory.getLogger(AdminController.class);

	@GetMapping("")
	public String home(Model model) {
		List<Product> productos = productService.getProducts();
		model.addAttribute("productos", productos);
		return "/home";
	}

	@GetMapping("/search")
	public Admin getAdminByRut(@RequestParam("rut") String rut) {
		return (Admin) userService.getUserByRut(rut, true);
	}

	@PostMapping("/save")
	public Admin saveClient(@RequestBody Admin admin) {
		admin.setEmail(admin.getEmail());
		admin.setPassword(admin.getPassword());
		userService.saveUsuario(admin, true);
		return admin;
	}
	
	@GetMapping("/users")
	public String usuarios(Model model) {
		model.addAttribute("users", userService.obtenerClientes());
		return "/users";
	}
	
	@GetMapping("/orders")
	public String ordenes(Model model) {
		model.addAttribute("orders", orderService.findOrders());
		return "/orders";
	}
	
	@GetMapping("/detail/{id}")
	public String detail(Model model, @PathVariable Integer id) {
		logg.info("Id de la orden {}",id);
		Order order = orderService.findOrderById(id);
		model.addAttribute("detail", order.getDetalles());
		return "/detail";
	}

	@DeleteMapping("/{id}")
	public void deleteAdmin(@PathVariable Integer id) {
		userService.deleteAdmin(id);
	}

}
