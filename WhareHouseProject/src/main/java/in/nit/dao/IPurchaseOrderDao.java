package in.nit.dao;

import java.util.List;

import in.nit.model.PurchaseOrder;

public interface IPurchaseOrderDao {
	Integer savePurchaseOrder(PurchaseOrder ob);
	List<PurchaseOrder> getAllPurchaseOrders();
}
