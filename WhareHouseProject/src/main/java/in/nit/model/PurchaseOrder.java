package in.nit.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="potab")
public class PurchaseOrder {
	@Id
	@GeneratedValue
	@Column(name="poid")
	private Integer porderId;

	private String porderCode;
	
	@ManyToOne
	@JoinColumn(name="shipIdFK")
	private ShipmentType shipOb;    //HAS-A
	
	@ManyToOne
	@JoinColumn(name="whVendorIdFk")
	private WHUserType whVendorOb; //HAS-A
	
	private String refNum;
	private String qltyCheck;
	private String defStatus;
	private String description;
	public PurchaseOrder() {
		super();
	}
	public PurchaseOrder(Integer porderId) {
		super();
		this.porderId = porderId;
	}
	public Integer getPorderId() {
		return porderId;
	}
	public void setPorderId(Integer porderId) {
		this.porderId = porderId;
	}
	public String getPorderCode() {
		return porderCode;
	}
	public void setPorderCode(String porderCode) {
		this.porderCode = porderCode;
	}
	public ShipmentType getShipOb() {
		return shipOb;
	}
	public void setShipOb(ShipmentType shipOb) {
		this.shipOb = shipOb;
	}
	public WHUserType getWhVendorOb() {
		return whVendorOb;
	}
	public void setWhVendorOb(WHUserType whVendorOb) {
		this.whVendorOb = whVendorOb;
	}
	public String getRefNum() {
		return refNum;
	}
	public void setRefNum(String refNum) {
		this.refNum = refNum;
	}
	public String getQltyCheck() {
		return qltyCheck;
	}
	public void setQltyCheck(String qltyCheck) {
		this.qltyCheck = qltyCheck;
	}
	public String getDefStatus() {
		return defStatus;
	}
	public void setDefStatus(String defStatus) {
		this.defStatus = defStatus;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@Override
	public String toString() {
		return "PurchaseOrder [porderId=" + porderId + ", porderCode=" + porderCode + ", shipOb=" + shipOb
				+ ", whVendorOb=" + whVendorOb + ", refNum=" + refNum + ", qltyCheck=" + qltyCheck + ", defStatus="
				+ defStatus + ", description=" + description + "]";
	}
	
    	
}








