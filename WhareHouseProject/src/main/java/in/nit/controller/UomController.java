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

import in.nit.model.Uom;
import in.nit.service.IUomService;
import in.nit.validator.UomValidator;
@Controller
@RequestMapping("/uom")
public class UomController {
	  @Autowired(required=true)  
	private UomValidator validator;
	@Autowired 
	private IUomService service;
	
	@RequestMapping("/register")
	public String showRegPage(Model model) {
	model.addAttribute("uom", new Uom());
	return "UomRegister";
	}
	
	
	@RequestMapping(
			value = "/save",
			method =RequestMethod.POST
			)
	public String saveUom(
			@ModelAttribute Uom uom,
			Errors errors,
			ModelMap map) {
		//call validator
				validator.validate(uom, errors);
				
				if(!errors.hasErrors()) { //has no errors
					Integer id=service.saveUom(uom);
					map.addAttribute("message","Uom created with Id:"+id);
					map.addAttribute("uom",new Uom()) ;
				}else { //errors are added by validator
					map.addAttribute("message","Please check All Errors");
				}
				return "UomRegister";
			}

	
	@RequestMapping("/all")
	public String getAllUoms(Model model)
	{
		List<Uom> list=service.getAllUoms();
		model.addAttribute("list",list);
		return "UomData";
	}
	@RequestMapping("/delete")
	public String deleteUom(
			@RequestParam("umid")Integer id,
			Model model) {
		service.deleteUom(id);
		String message="Uom '"+id+"' Deleted";
		model.addAttribute("message",message);
		//----featch new data-----
		List<Uom> list=service.getAllUoms();
		model.addAttribute("list",list);
		return "UomData";   //Page Name
	}
	@RequestMapping("/edit")
	public String showEditPAge(
			@RequestParam("umid")Integer id,
			Model model) {
		Uom u=service.getOneUom(id);
		model.addAttribute("uom",u);
		return "UomEdit";
	}
	@RequestMapping(value="/update", method=RequestMethod.POST)
	public String updateUom(
			@ModelAttribute Uom uom,
			Model model) {
		service.updateUom(uom);
		String message="Uom '"+uom.getUomid()+"' update";
		model.addAttribute("message", message);
		List<Uom> list=
				service.getAllUoms();
		model.addAttribute("list", list);
		return"UomData";
	}
	@RequestMapping("/view")
	public String showOneUom(
			@RequestParam("umid")Integer id,
			Model model) {
		Uom st=service.getOneUom(id);
		model.addAttribute("ob", st);
		return "UomView";
	}
}








