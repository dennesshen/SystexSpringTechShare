package com.springboot.demo.util.validationUtil;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.springboot.demo.lesson2.dto.DtoInfo;
import com.springboot.demo.lesson2.dto.PersonInfoRecieveData;


@Component
public class IdNumberValdator implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		return PersonInfoRecieveData.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {

		PersonInfoRecieveData targetObject = (PersonInfoRecieveData) target;
		List<DtoInfo> detailData = targetObject.getDetaildata();
		
		for (int i = 0; i< detailData.size() ; i++) {
			
			String idNumber = detailData.get(i).getIdNumber();
			String field = "detaildata["+ i +"].idNumber";

			
			if ( idNumber == null || idNumber.equals("")) {
				errors.rejectValue(field, "idNumber.NotNullBlank", "idNumber cannot be null or Blank");
				return;
			}
			

			String regex = "^[A-Z][1289]{1}[0-9]{8}$";
			
			
			if (!idNumber.matches(regex)) {
				errors.rejectValue(field, 
								   "idNumber.formateNotAllow",
								   "idNumber格式不合");
				return;
			}
			
			
		}
		
	}

}
