package in.nit.service;

import java.util.List;

import in.nit.model.PurchaseOrder;

public interface IPurchaseOrderService {
	Integer savePurchaseOrder(PurchaseOrder ob);
	List<PurchaseOrder> getAllPurchaseOrders();


}










