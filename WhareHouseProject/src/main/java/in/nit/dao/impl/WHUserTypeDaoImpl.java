package in.nit.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import in.nit.dao.IWHUserTypeDao;
import in.nit.model.WHUserType;

@Repository
public class WHUserTypeDaoImpl 
implements IWHUserTypeDao{

	@Autowired
	private HibernateTemplate ht;

	public Integer saveWHUserType(WHUserType ob) {
		return (Integer)ht.save(ob);
	}
	public List<WHUserType> getAllWHUserTypes(){
		return ht.loadAll(WHUserType.class);
	}
	public void deleteWHUserType(Integer id) {
		ht.delete(new WHUserType(id));
	}
	public WHUserType getOneWHUserType(Integer id) {
		return ht.get(WHUserType.class, id);
	}
	public void updateWHUserType(WHUserType ob) {
		ht.update(ob);
	}
	public List<Object[]> getWHUserIdAndCode(String mode) {

		String hql=" select whuId,userCode from in.nit.model.WHUserType where userType=? ";

		@SuppressWarnings({ "unchecked", "deprecation" })
		List<Object[]> list=(List<Object[]>) ht.find(hql, mode);

		return list;
	}
	@SuppressWarnings({ "deprecation", "unchecked" })
	@Override
	public 	boolean isUserCodeExist(String userCode) {

		boolean flag=false;
		//SQL: select count(usrcode) from whusertypetab where usrcode=?;

		String hql="select count(userCode) from in.nit.model.WHUserType  where userCode=?0";

		List<Long> list=(List<Long>) ht.find(hql,userCode);
		if(list!=null && !list.isEmpty()) {
			long count= list.get (0);
			if(count==0)//data not Exist
				flag=false;
			else
				flag =true;

		}
		return flag;
	}

}




