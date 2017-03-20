package com.property.mgt.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.property.mgt.domain.Cart;
import com.property.mgt.domain.Product;
import com.property.mgt.service.CartService;
import com.property.mgt.service.ProductService;


@Controller
@RequestMapping(value = "/cart")
public class CartController {

	@Autowired
	private CartService cartService;

	@RequestMapping
	public String get(HttpServletRequest request) {
		return "redirect:/cart/"+request.getSession(true).getId();
	}
	
	@RequestMapping(value = "/{cartId}", method = RequestMethod.GET)
	public String getCart(@PathVariable(value = "cartId") String cartId, Model model) {
		model.addAttribute("cartId",cartId);
		Cart cart = cartService.read(cartId);
		if (cart == null) {
			cart = new Cart(cartId);
			cartService.create(cart );
		}
		model.addAttribute("cart",cart);
		
		return "cart";
	}
}
