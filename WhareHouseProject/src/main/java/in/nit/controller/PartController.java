package in.nit.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import in.nit.model.Part;
import in.nit.service.IOrderMethodService;
import in.nit.service.IPartService;
import in.nit.service.IUomService;
import in.nit.util.CommonUtil;

@Controller
@RequestMapping("/part")
public class PartController {
	
	@Autowired
	private IPartService service;
	
	@Autowired
	private IUomService uomService;
	
	@Autowired
	private IOrderMethodService orderMethodService;
	
	//add below method
	@SuppressWarnings("unused")
	private void commonUi(Model model) {
		List<Object[]> uomList=uomService.getUomIdAndUomModel();
		Map<Integer,String> uomMap=CommonUtil.convert(uomList);
		model.addAttribute("uomMap",uomMap);
	}
	@SuppressWarnings("unused")
	private void commonUiSale(Model map) {

		// UOM related code...

		List<Object[]> omSaleList=orderMethodService.getOrderIdAndCode("Sale");

		Map<Integer,String> omSaleMap=CommonUtil.convert(omSaleList);

		map.addAttribute("omSaleMap", omSaleMap);

		}
	@SuppressWarnings("unused")
	private void commonUiPurchase(Model map) {

		// UOM related code...

		List<Object[]> omPurchaseList=orderMethodService.getOrderIdAndCode("Purchase");

		Map<Integer,String> omPurchaseMap=CommonUtil.convert(omPurchaseList);

		map.addAttribute("omPurchaseMap", omPurchaseMap);

		}
	
	@RequestMapping("/register")
	public String showRegPage(Model model) {
	commonUi(model);
	commonUiSale(model);
	commonUiPurchase(model);
	model.addAttribute("part", new Part());
	return "PartRegister";
	}
	@RequestMapping(value="/save", method=RequestMethod.POST)
	public String savePart(
			@ModelAttribute Part part,
			Model model) {
		Integer id=service.savePart(part);
		String message="part '"+id+"'  saved";
		model.addAttribute("message", message);
		
		model.addAttribute(
				"part",new Part());
		
		return "PartRegister";
	}
	@RequestMapping("/all")
	public String getAllParts(Model model)
	{
		List<Part> list=service.getAllParts();
		model.addAttribute("list",list);
		return "PartData";
	}
	@RequestMapping("/delete")
	public String deletePart(
			@RequestParam("partId")Integer id,
			Model model) {
		service.deletePart(id);
		String message="Part '"+id+"' Deleted";
		model.addAttribute("message",message);
		//----featch new data-----
		List<Part> list=service.getAllParts();
		model.addAttribute("list",list);
		return "PartData";   //Page Name
	}
	@RequestMapping("/edit")
	public String showEditPAge(
			@RequestParam("partId")Integer id,
			Model model) {
		commonUi(model);
		commonUiPurchase(model);
		commonUiSale(model);
		Part p=service.getOnePart(id);
		model.addAttribute("part",p);
		return "PartEdit";
	}
	@RequestMapping(value="/update", method=RequestMethod.POST)
	public String updatePart(
			@ModelAttribute Part part,
			Model model) {
		service.updatePart(part);
		String message="Part '"+part.getPartId()+"' update";
		model.addAttribute("message", message);
		List<Part> list=
				service.getAllParts();
		model.addAttribute("list", list);
		return"PartData";
	}
	@RequestMapping("/view")
	public String showOnePart(
			@RequestParam("partId")Integer id,
			Model model) {
		Part st=service.getOnePart(id);
		model.addAttribute("ob", st);
		return "PartView";
	}

}








