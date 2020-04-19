package in.nit.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="parttab")
public class Part {

	@Id
	@GeneratedValue
	private Integer partId;
	private String partCode;
	private Double partLen;
	private Double partWid;
	private Double partHgt;
	
	@ManyToOne
	@JoinColumn(name="uomIdFK")
	private Uom uomOb;    //HAS-A
	
	@ManyToOne
	@JoinColumn(name="orderSaleIdFk")
	private OrderMethod omSaleOb; //HAS-A
	
	@ManyToOne
	@JoinColumn(name="orderPurchaseIdFk")
	private OrderMethod omPurchaseOb; //HAS-A
	
	private Double baseCost;
	private String baseCurrency;
	private String note;
	public Part() {
		super();
	}
	public Part(Integer partId) {
		super();
		this.partId = partId;
	}
	public Integer getPartId() {
		return partId;
	}
	public void setPartId(Integer partId) {
		this.partId = partId;
	}
	public String getPartCode() {
		return partCode;
	}
	public void setPartCode(String partCode) {
		this.partCode = partCode;
	}
	public Double getPartLen() {
		return partLen;
	}
	public void setPartLen(Double partLen) {
		this.partLen = partLen;
	}
	public Double getPartWid() {
		return partWid;
	}
	public void setPartWid(Double partWid) {
		this.partWid = partWid;
	}
	public Double getPartHgt() {
		return partHgt;
	}
	public void setPartHgt(Double partHgt) {
		this.partHgt = partHgt;
	}
	public Uom getUomOb() {
		return uomOb;
	}
	public void setUomOb(Uom uomOb) {
		this.uomOb = uomOb;
	}
	public OrderMethod getOmSaleOb() {
		return omSaleOb;
	}
	public void setOmSaleOb(OrderMethod omSaleOb) {
		this.omSaleOb = omSaleOb;
	}
	public OrderMethod getOmPurchaseOb() {
		return omPurchaseOb;
	}
	public void setOmPurchaseOb(OrderMethod omPurchaseOb) {
		this.omPurchaseOb = omPurchaseOb;
	}
	public Double getBaseCost() {
		return baseCost;
	}
	public void setBaseCost(Double baseCost) {
		this.baseCost = baseCost;
	}
	public String getBaseCurrency() {
		return baseCurrency;
	}
	public void setBaseCurrency(String baseCurrency) {
		this.baseCurrency = baseCurrency;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	@Override
	public String toString() {
		return "Part [partId=" + partId + ", partCode=" + partCode + ", partLen=" + partLen + ", partWid=" + partWid
				+ ", partHgt=" + partHgt + ", uomOb=" + uomOb + ", omSaleOb=" + omSaleOb + ", omPurchaseOb="
				+ omPurchaseOb + ", baseCost=" + baseCost + ", baseCurrency=" + baseCurrency + ", note=" + note + "]";
	}
	
	
}







