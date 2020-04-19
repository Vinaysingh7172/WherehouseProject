package in.nit.service.impl;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import in.nit.dao.IWHUserTypeDao;
import in.nit.model.WHUserType;
import in.nit.service.IWHUserTypeService;
@Service
public class WHUserTypeServiceImpl implements IWHUserTypeService {

	@Autowired
	private IWHUserTypeDao dao;
	@Transactional
	public Integer saveWHUserType(WHUserType ob) {
		
		return dao.saveWHUserType(ob);
	}
	@Transactional(readOnly=true)
	public List<WHUserType> getAllWHUserTypes(){
		List<WHUserType> list= dao.getAllWHUserTypes();
		Collections.sort(list,
				(o1,o2)->o1.getWhuId()-o2.getWhuId());
		return list;
	}
	@Transactional
	public void deleteWHUserType(Integer id) {
		dao.deleteWHUserType(id);
	}
	@Transactional(readOnly=true)
	public WHUserType getOneWHUserType(Integer id) {
		return dao.getOneWHUserType(id);
	}
	@Transactional
	public void updateWHUserType(WHUserType ob) {
		dao.updateWHUserType(ob);
	}
	@Transactional(readOnly=true)
	public List<Object[]> getWHUserIdAndCode(String mode) {
		// TODO Auto-generated method stub
		return dao.getWHUserIdAndCode(mode);
	}
	public boolean isUserCodeExist(String userCode) {
		return dao.isUserCodeExist(userCode);
	}

}






