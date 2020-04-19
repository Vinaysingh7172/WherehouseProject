package in.nit.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import in.nit.model.PurchaseOrder;
import in.nit.service.IPurchaseOrderService;
import in.nit.service.IShipmentTypeService;
import in.nit.service.IWHUserTypeService;
import in.nit.util.CommonUtil;

@Controller
@RequestMapping("/purchase")
public class PurchaseOrderController {
	@Autowired
	private IPurchaseOrderService service;
	
	@Autowired
	private IShipmentTypeService shipmentService;
	
	@Autowired
	private IWHUserTypeService wHUserTypeService;
	
	private void commonUi(Model model) {
		List<Object[]> shipList=shipmentService.getShipIdAndShipModel();

		Map<Integer,String> shipMap=CommonUtil.convert(shipList);

		model.addAttribute("shipMap", shipMap);

		}
	
	@SuppressWarnings("unused")
	private void commonUiVendor(Model map) {

		// UOM related code...

		List<Object[]> whVenList=wHUserTypeService.getWHUserIdAndCode("Vendor");

		Map<Integer,String> whVenMap=CommonUtil.convert(whVenList);

		map.addAttribute("whVenMap", whVenMap);

		}
	
	
	@RequestMapping("/register")
	public String showRegPage(Model model) {
		commonUi(model);
		commonUiVendor(model);
	model.addAttribute("purchaseOrder", new PurchaseOrder());
	return "PurchaseOrderRegister";
	
	}
	@RequestMapping(value="/save", method=RequestMethod.POST)
	public String savePurchase(
			@ModelAttribute PurchaseOrder purchaseOrder,
			Model model) {
		Integer id=service.savePurchaseOrder(purchaseOrder);
		String message="PurchaseOrder '"+id+"'  saved";
		model.addAttribute("message", message);
		
		model.addAttribute(
				"purchaseOrder",new PurchaseOrder());
		
		return "PurchaseOrderRegister";
	}
	@RequestMapping("/all")
	public String getAllPurchaseOrders(Model model)
	{
		List<PurchaseOrder> list=service.getAllPurchaseOrders();
		model.addAttribute("list",list);
		return "PurchaseOrderData";
	}
}








