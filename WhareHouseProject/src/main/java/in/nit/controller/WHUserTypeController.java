package in.nit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import in.nit.model.WHUserType;
import in.nit.service.IWHUserTypeService;
import in.nit.validator.WHUserTypeValidator;

@Controller
@RequestMapping("/whuser")
public class WHUserTypeController {
	
	
	@Autowired
	private WHUserTypeValidator validator;
	@Autowired
	private IWHUserTypeService service;

	@RequestMapping("/register")
	public String showRegPage(Model model) {
	model.addAttribute("wHUserType", new WHUserType());
	return "WHUserTypeRegister";
	}
	@RequestMapping(
			value = "/save",
			method =RequestMethod.POST
			)
	public String saveWhUserType(
			@ModelAttribute WHUserType whUserType, 
			Errors errors, 
			ModelMap map) {
		
		//call validator
		validator.validate(whUserType, errors);
		
		if(!errors.hasErrors()) { //has no errors
			Integer id=service.saveWHUserType(whUserType);
			map.addAttribute("message","WhUserType created with Id:"+id);
			map.addAttribute("whUserType",new WHUserType()) ;
		}else { //errors are added by validat
			map.addAttribute("message","Please check All Errors");
		}
		return "WhUserTypeRegister";
	}
	
	@RequestMapping("/all")
	public String getAllWHUserTypes(Model model)
	{
		List<WHUserType> list=service.getAllWHUserTypes();
		model.addAttribute("list",list);
		return "WHUserTypeData";
	}
	@RequestMapping("/delete")
	public String deleteWHUser(
			@RequestParam("wid")Integer id,
			Model model) {
		service.deleteWHUserType(id);
		String message="WHUser '"+id+"' Deleted";
		model.addAttribute("message",message);
		//----featch new data-----
		List<WHUserType> list=service.getAllWHUserTypes();
		model.addAttribute("list",list);
		return "WHUserTypeData";   //Page Name
	}
	@RequestMapping("/edit")
	public String showEditPAge(
			@RequestParam("wid")Integer id,
			Model model) {
		WHUserType st=service.getOneWHUserType(id);
		model.addAttribute("wHUserType",st);
		return "WHUserTypeEdit";
	}
	@RequestMapping(value="/update", method=RequestMethod.POST)
	public String updateWHUserType(
			@ModelAttribute WHUserType wHUserType,
			Model model) {
		service.updateWHUserType(wHUserType);
		String message="WHUserType '"+wHUserType.getWhuId()+"' update";
		model.addAttribute("message", message);
		List<WHUserType> list=
				service.getAllWHUserTypes();
		model.addAttribute("list", list);
		return"WHUserTypeData";
	}
	@RequestMapping("/view")
	public String showOneWHUser(
			@RequestParam("wid")Integer id,
			Model model) {
		WHUserType st=service.getOneWHUserType(id);
		model.addAttribute("ob", st);
		return "WHUserTypeView";
	}
}









