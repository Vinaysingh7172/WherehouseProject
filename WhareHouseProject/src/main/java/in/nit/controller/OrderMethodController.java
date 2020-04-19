package in.nit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import in.nit.model.OrderMethod;
import in.nit.service.IOrderMethodService;

@Controller
@RequestMapping("/order")
public class OrderMethodController {
	
	@Autowired
	private IOrderMethodService service;
	@RequestMapping("/register")
		public String showRegPage(Model model) {
		model.addAttribute("orderMethod", new OrderMethod());
		return "OrderMethodRegister";
	}
	@RequestMapping(value="/save", method=RequestMethod.POST)
	public String saveOrder(
			@ModelAttribute OrderMethod orderMethod,
			Model model) {
		Integer id=service.saveOrderMethod(orderMethod);
		String message="OrderMethod '"+id+"'  saved";
		model.addAttribute("message", message);
		
		model.addAttribute(
				"orderMethod",new OrderMethod());
		
		return "OrderMethodRegister";
	}
	@RequestMapping("/all")
	public String getAllOrderMethods(Model model)
	{
		List<OrderMethod> list=service.getAllOrderMethods();
		model.addAttribute("list",list);
		return "OrderMethodData";
	}
	@RequestMapping("/delete")
	public String deleteOrder(
			@RequestParam("omid")Integer id,
			Model model) {
		service.deleteOrderMethod(id);
		String message="Order '"+id+"' Deleted";
		model.addAttribute("message",message);
		//----featch new data-----
		List<OrderMethod> list=service.getAllOrderMethods();
		model.addAttribute("list",list);
		return "OrderMethodData";   //Page Name
	}
	@RequestMapping("/edit")
	public String showEditPAge(
			@RequestParam("omid")Integer id,
			Model model) {
		OrderMethod om=service.getOneOrderMethod(id);
		model.addAttribute("orderMethod",om);
		return "OrderMethodEdit";
	}
	@RequestMapping(value="/update", method=RequestMethod.POST)
	public String updateOrderMethod(
			@ModelAttribute OrderMethod orderMethod,
			Model model) {
		service.updateOrderMethod(orderMethod);
		String message="OrderMethod '"+orderMethod.getOrderId()+"' update";
		model.addAttribute("message", message);
		List<OrderMethod> list=
				service.getAllOrderMethods();
		model.addAttribute("list", list);
		return"OrderMethodData";
	}
	@RequestMapping("/view")
	public String showOneOrder(
			@RequestParam("omid")Integer id,
			Model model) {
		OrderMethod st=service.getOneOrderMethod(id);
		model.addAttribute("ob", st);
		return "OrderMethodView";
	}
}








