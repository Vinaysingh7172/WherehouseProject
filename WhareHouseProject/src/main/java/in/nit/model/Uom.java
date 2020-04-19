package in.nit.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="uomtab")
public class Uom {
	@Id
	@GeneratedValue
	@Column(name="umid")
	private Integer uomid;
	@Column(name="umtyp")
	private String uomType;
	@Column(name="ummdl")
	private String uomModel;
	@Column(name="umdesc")
	private String note;
	public Uom() {
		super();
	}
	public Uom(Integer uomid) {
		super();
		this.uomid = uomid;
	}
	public Integer getUomid() {
		return uomid;
	}
	public void setUomid(Integer uomid) {
		this.uomid = uomid;
	}
	public String getUomType() {
		return uomType;
	}
	public void setUomType(String uomType) {
		this.uomType = uomType;
	}
	public String getUomModel() {
		return uomModel;
	}
	public void setUomModel(String uomModel) {
		this.uomModel = uomModel;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	@Override
	public String toString() {
		return "Uom [uomid=" + uomid + ", uomType=" + uomType + ", uomModel=" + uomModel + ", note=" + note + "]";
	}
	
}






