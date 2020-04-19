package in.nit.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import in.nit.model.Uom;
import in.nit.service.IUomService;
@Component
public class UomValidator implements Validator{
	@Autowired
private IUomService service;
	public boolean supports(Class<?> cls) {
		return Uom.class.equals(cls);
	}

	public void validate(Object target, Errors errors) {
		//Downcast to Actual Object
		Uom user=(Uom)target;
		
		//verify userCode with DB
		if(service.isuomModelExist(user.getUomModel())) {
			errors.rejectValue("uomModel", null, " uom Model '"+user.getUomModel()+"' already exist ");
		}
	}
}
