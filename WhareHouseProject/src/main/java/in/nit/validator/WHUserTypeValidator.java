package in.nit.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import in.nit.model.WHUserType;
import in.nit.service.IWHUserTypeService;
@Component
public class WHUserTypeValidator implements Validator{
	@Autowired
private IWHUserTypeService service;
	@Override
	public boolean supports(Class<?> cls) {
		
		return WHUserType.class.equals(cls);
	}

	@Override
	public void validate(Object target, Errors errors) {
		//Downcast to actual object
		WHUserType whuser=(WHUserType)target;
		//verify the code with DB
		if(service.isUserCodeExist(whuser.getUserCode())) {
			errors.rejectValue("WHUserType", null, " user Code'"+whuser.getUserCode()+"' already exist ");
		}
		
	}
}
	