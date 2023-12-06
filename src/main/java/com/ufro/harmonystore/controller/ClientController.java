package com.ufro.harmonystore.controller;

import com.ufro.harmonystore.models.Client;
import com.ufro.harmonystore.models.Order;
import com.ufro.harmonystore.services.OrderService;
import com.ufro.harmonystore.services.UserService;
import jakarta.servlet.http.HttpSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/clients")
public class ClientController {

	private final Logger logger = LoggerFactory.getLogger(ClientController.class);

	@Autowired
	private UserService userService;

	@Autowired
	private OrderService orderService;

	@GetMapping("/search")
	public Client getClienteByRut(@RequestParam("rut") String rut) {
		return (Client) userService.getUserByRut(rut, false);
	}

	@PostMapping("/save")
	public Client saveClient(@RequestBody Client cliente) {
		logger.info("Cliente registro: {}", cliente);
		cliente.setEmail(cliente.getEmail());
		cliente.setPassword(cliente.getPassword());
		userService.saveUsuario(cliente, false);
		return cliente;
	}

	@PostMapping("/acceder")
	public String acceder(@RequestBody Client cliente, HttpSession session) {
		logger.info("Accesos : {}", cliente);

		Optional<Client> usuario = Optional.ofNullable((Client) userService.getUserByRut(cliente.getRut(), false));
		logger.info("Usuario de db: {}", usuario.orElse(null));

		if (usuario.isPresent()) {
			session.setAttribute("idusuario", usuario.get().getRut());

			usuario.get();
			return "redirect:/";
		} else {
			logger.info("Usuario no existe");
		}

		return "redirect:/";
	}

	@GetMapping("/compras")
	public List<Order> obtenerCompras(HttpSession session) {
		Client cliente = (Client) userService.getUserByRut(session.getAttribute("idusuario").toString(), false);
		List<Order> pedidos = orderService.findOrdersByRut(cliente.getRut());
		logger.info("ordenes {}", pedidos);
		return pedidos;
	}

	@GetMapping("/detalle/{id}")
	public Order detalleCompra(@PathVariable Integer id) {
		logger.info("Id de la orden: {}", id);
		return orderService.findOrderById(id);
	}

	@GetMapping("/cerrar")
	public String cerrarSesion(HttpSession session) {
		session.removeAttribute("idusuario");
		return "redirect:/";
	}

	@DeleteMapping("/{id}")
	public void deleteClient(@PathVariable Integer id) {
		userService.deleteClient(id);
	}
}
