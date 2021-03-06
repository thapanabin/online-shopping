package com.nabin.onlineshopping.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.nabin.onlineshopping.service.CartService;

@Controller
@RequestMapping("/cart")
public class CartController {
	
	@Autowired
	CartService cartService;
	
	@RequestMapping("/show")
	public ModelAndView showCart(@RequestParam(name = "result",required = false) String result) {
		ModelAndView mv = new ModelAndView("page");
		
		if(result !=null) {
			switch(result) {
			case "updated":
				mv.addObject("message","CartLine has been updated Successfully.");
				break;
			case "deleted":
				mv.addObject("message","CartLine has been deleted Successfully.");
				break;
			case "added":
				mv.addObject("message","CartLine has been added Successfully.");
				break;
			case "maximum":
				mv.addObject("message","Cartline has reached to maximum count!");
				break;
			case "unavailable":
				mv.addObject("message","Product quantity is not available!");
				break;
			case "error":
				mv.addObject("message","Something went wrong!");
			}
		}
		mv.addObject("title","User Cart");
		mv.addObject("userClickShowCart",true);
		mv.addObject("cartLines",cartService.getCartLines());
		return mv;
	}
	
	@RequestMapping("/{cartLineId}/update")
	public String updateCart(@PathVariable int cartLineId,@RequestParam int count) {
		
		String response = cartService.manageCartLine(cartLineId,count);
		return "redirect:/cart/show?"+response;
	}
	
	@RequestMapping("/{cartLineId}/delete")
	public String deleteCartLine(@PathVariable int cartLineId) {
		String response = cartService.deleteCartLine(cartLineId);
		return "redirect:/cart/show?"+response;
	}
	
	@RequestMapping("/add/{productId}/product")
	public String addCart(@PathVariable int productId) {
		String response = cartService.addCartLine(productId);
		return "redirect:/cart/show?"+response;
	}

}
