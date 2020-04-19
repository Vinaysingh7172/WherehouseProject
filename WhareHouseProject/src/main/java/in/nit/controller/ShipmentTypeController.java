package in.nit.controller;

import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import in.nit.model.ShipmentType;
import in.nit.service.IShipmentTypeService;
import in.nit.util.ShipmentTypeUtil;
import in.nit.view.ShipmentTypeExcelView;
import in.nit.view.ShipmentTypePdfView;

@Controller
@RequestMapping("/shipment")
public class ShipmentTypeController {
	@Autowired
	private IShipmentTypeService service;
	
	@Autowired
	private ServletContext context;
	
	@Autowired
	private ShipmentTypeUtil util;
	
	@RequestMapping("/register")
	public String showRegPage(Model model) {
		//from backing object
		model.addAttribute(
				"shipmentType",new ShipmentType());
		return "ShipmentTypeRegister";
	
	}
	
	
	@RequestMapping(value="/save", method=RequestMethod.POST)
	public String saveShipment(
			@ModelAttribute ShipmentType shipmentType,
			Model model) {
		Integer id=service.saveShipmentType(shipmentType);
		String message="ShipmentType '"+id+"'  saved";
		model.addAttribute("message", message);
		
		model.addAttribute(
				"shipmentType",new ShipmentType());
		
		return "ShipmentTypeRegister";
	}
	@RequestMapping("/all")
	public String getAllShipmentTypes(Model model)
	{
		List<ShipmentType> list=service.getAllShipmentTypes();
		model.addAttribute("list",list);
		return "ShipmentTypeData";
	}
	
	@RequestMapping("/delete")
	public String deleteShipment(
			@RequestParam("sid")Integer id,
			Model model) {
		service.deleteShipmentType(id);
		String message="Shipment '"+id+"' Deleted";
		model.addAttribute("message",message);
		//----featch new data-----
		List<ShipmentType> list=service.getAllShipmentTypes();
		model.addAttribute("list",list);
		return "ShipmentTypeData";   //Page Name
	}
	
	@RequestMapping("/edit")
	public String showEditPAge(
			@RequestParam("sid")Integer id,
			Model model) {
		ShipmentType st=service.getOneShipmentType(id);
		model.addAttribute("shipmentType",st);
		return "ShipmentTypeEdit";
	}
	
	@RequestMapping(value="/update", method=RequestMethod.POST)
	public String updateShipmentType(
			@ModelAttribute ShipmentType shipmentType,
			Model model) {
		service.updateShipmentType(shipmentType);
		String message="ShipmentType '"+shipmentType.getShipId()+"' update";
		model.addAttribute("message", message);
		List<ShipmentType> list=
				service.getAllShipmentTypes();
		model.addAttribute("list", list);
		return"ShipmentTypeData";
	}
	@RequestMapping("/view")
	public String showOneShipment(
			@RequestParam("sid")Integer id,
			Model model) {
		ShipmentType st=service.getOneShipmentType(id);
		model.addAttribute("ob", st);
		return "ShipmentTypeView";
	}
	
	@RequestMapping("/excel")
	public ModelAndView showExcel(
			@RequestParam(value="id",required=false)Integer id) {
		ModelAndView m=new ModelAndView();
		m.setView(new ShipmentTypeExcelView());
		//Fetching data from DB
		if(id==null) {//export all rows
		List<ShipmentType> list=service.getAllShipmentTypes();
		m.addObject("list",list);
		}
		else {//export one row by id
			ShipmentType st=service.getOneShipmentType(id);
			m.addObject("list",Arrays.asList(st));
			
		}
		return m;
	}
	@RequestMapping("/pdf")
	public ModelAndView showPdf(
			@RequestParam(value="id",
			required=false)Integer id) {
		ModelAndView m=new ModelAndView();
		m.setView(new ShipmentTypePdfView());
		
		if(id==null) {
			
		//show all
		
		List<ShipmentType> list=service.getAllShipmentTypes();
		
		//sent Data to PDF file
		m.addObject("list",list);
		}else {//show one
			ShipmentType st=service.getOneShipmentType(id);
			m.addObject("list",Arrays.asList(st));
		}
		return m;
	}
	@RequestMapping("/charts")
	public String showCharts() {
		List<Object[]> list=service.getShipmentModeCount();
		String path=context.getRealPath("/");
		util.generatedPie(path, list);
		util.generateBar(path, list);
		return "ShipmentTypesCharts";
	}
}









