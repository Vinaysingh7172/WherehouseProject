package in.nit.dao;

import java.util.List;

import in.nit.model.WHUserType;

public interface IWHUserTypeDao {

	Integer saveWHUserType(WHUserType ob);
	List<WHUserType> getAllWHUserTypes();
	public void deleteWHUserType(Integer id);
	WHUserType getOneWHUserType(Integer id);
	void updateWHUserType(WHUserType ob);
	List<Object[]> getWHUserIdAndCode(String mode);	
	boolean isUserCodeExist(String userCode);

}






