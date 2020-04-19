package in.nit.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import in.nit.dao.IUomDao;
import in.nit.model.Uom;
@Repository
public class UomDaoImpl implements IUomDao {
	@Autowired
	private HibernateTemplate ht;
	
	public Integer saveUom(Uom ob) {
		return (Integer)ht.save(ob);
	}
	public List<Uom> getAllUoms(){
		return ht.loadAll(Uom.class);
	}
	public void deleteUom(Integer id) {
		ht.delete(new Uom(id));
	}
	public Uom getOneUom(Integer id) {
		return ht.get(Uom.class, id);
	}
	public void updateUom(Uom ob) {
		ht.update(ob);
	}
	public List<Object[]> getUomIdAndUomModel(){
		String hql=" select id, uomModel from in.nit.model.Uom";
		@SuppressWarnings({ "unchecked", "deprecation" })
		List<Object[]> list=(List<Object[]>)ht.find(hql);
		return list;
	}

	@SuppressWarnings({ "deprecation", "unchecked" })
	@Override
	public boolean isuomModelExist(String uomModel)
	{
         boolean flag=false;
		
		//SQL: select count(usrcode) from whusertypetab where usrcode=?;
		String hql="SELECT COUNT(uomModel) FROM in.nit.model.Uom WHERE uomModel=?0";
		
		List<Long> list=(List<Long>) ht.find(hql, uomModel);
		if(list!=null && !list.isEmpty()) {
			long count=list.get(0);
			if(count==0) flag= false; // data not exist
			else flag= true; //data exist
		}
		
		return flag;
	}
}
	

	






