package com.ufro.harmonystore.controller;

import com.ufro.harmonystore.models.Client;
import com.ufro.harmonystore.models.Order;
import com.ufro.harmonystore.models.ProductDetail;
import com.ufro.harmonystore.models.product.Product;
import com.ufro.harmonystore.services.OrderDetailService;
import com.ufro.harmonystore.services.OrderService;
import com.ufro.harmonystore.services.ProductService;
import com.ufro.harmonystore.services.UserService;
import jakarta.servlet.http.HttpSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
@Controller
@RequestMapping("/")
public class ShopController {

	private final Logger log = LoggerFactory.getLogger(ShopController.class);

	@Autowired
	private ProductService productService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private OrderService pedidoService;
	
	@Autowired
	private OrderDetailService orderDetailService;

	List<ProductDetail> detalles = new ArrayList<>();

	Order pedido = new Order();

	@GetMapping("")
	public String home(Model model, HttpSession session) {
		
		log.info("Sesion del usuario: {}", session.getAttribute("idusuario"));
		
		model.addAttribute("productos", productService.getProducts());
		
		//session
		model.addAttribute("sesion", session.getAttribute("idusuario"));

		return "cliente/home";
	}

	@GetMapping("productohome/{id}")
	public String productoHome(@PathVariable Integer id, Model model) {
		log.info("Id producto enviado como parámetro {}", id);
		Product producto;
		Optional<Product> productoOptional = Optional.ofNullable(productService.getProductById(id));
		producto = productoOptional.get();

		model.addAttribute("producto", producto);

		return "cliente/productohome";
	}

	@PostMapping("/cart")
	public String addCart(@RequestParam Integer id, @RequestParam Integer cantidad, Model model) {
		ProductDetail productDetail = new ProductDetail();
		Product producto;
		int sumaTotal = 0;

		Optional<Product> optionalProducto = Optional.ofNullable(productService.getProductById(id));
		log.info("Producto añadido: {}", optionalProducto.get());
		log.info("Cantidad: {}", cantidad);
		producto = optionalProducto.get();

		productDetail.setCantidad(cantidad);
		productDetail.setPrecio(producto.getPrecio());
		productDetail.setNombre(producto.getMarca_id() + producto.getModelo());
		productDetail.setTotal(producto.getPrecio() * cantidad);
		productDetail.setProducto(producto);
		
		//validar que le producto no se añada 2 veces
		Integer idProducto=producto.getId();
		boolean ingresado = detalles.stream().anyMatch(p -> p.getProducto().getId()==idProducto);
		
		if (!ingresado) {
			detalles.add(productDetail);
		}
		
		sumaTotal = detalles.stream().mapToInt(ProductDetail::getTotal).sum();

		pedido.setTotal(sumaTotal);
		model.addAttribute("cart", detalles);
		model.addAttribute("orden", pedido);

		return "cliente/carrito";
	}

	// quitar un producto del carrito
	@GetMapping("/delete/cart/{id}")
	public String deleteProductoCart(@PathVariable Integer id, Model model) {

		List<ProductDetail> pedidosNuevos = new ArrayList<>();

		for (ProductDetail detalleOrden : detalles) {
			if (detalleOrden.getProducto().getId() != id) {
				pedidosNuevos.add(detalleOrden);
			}
		}
		detalles = pedidosNuevos;

		int sumaTotal = 0;
		sumaTotal = detalles.stream().mapToInt(ProductDetail::getTotal).sum();

		pedido.setTotal(sumaTotal);
		model.addAttribute("cart", detalles);
		model.addAttribute("orden", pedido);

		return "cliente/carrito";
	}
	
	@GetMapping("/getCart")
	public String getCart(Model model, HttpSession session) {
		
		model.addAttribute("cart", detalles);
		model.addAttribute("orden", pedido);
		
		//sesion
		model.addAttribute("sesion", session.getAttribute("idusuario"));
		return "/cliente/carrito";
	}
	
	@GetMapping("/order")
	public String order(Model model, HttpSession session) {
		
		Client cliente = (Client) userService.getUserByRut(session.getAttribute("idusuario").toString(), false);
		
		model.addAttribute("cart", detalles);
		model.addAttribute("orden", pedido);
		model.addAttribute("usuario", cliente);

		return "cliente/resumenorden";
	}

	@GetMapping("/saveOrder")
	public String saveOrder(HttpSession session ) {
		Date fechaCreacion = new Date();
		pedido.setFecha_creacion(userService.getActualDAte());
		Client cliente = (Client) userService.getUserByRut( session.getAttribute("idusuario").toString(), false);
		pedidoService.savePedido(pedido);

		//guardar detalles
		for (ProductDetail productDetail :detalles) {
			productDetail.setPedido(pedido);
			orderDetailService.saveDetallePedido(productDetail);
		}

		pedido = new Order();
		detalles.clear();
		
		return "redirect:/";
	}
	
	@PostMapping("/search")
	public String searchProduct(@RequestParam String modelo, Model model) {
		log.info("Nombre del producto: {}", modelo);
		List<Product> productos= productService.getProducts().stream().filter(p -> p.getModelo().contains(modelo)).collect(Collectors.toList());
		model.addAttribute("productos", productos);		
		return "cliente/home";
	}
}
