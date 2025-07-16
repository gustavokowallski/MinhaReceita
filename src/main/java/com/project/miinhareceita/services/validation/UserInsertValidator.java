package com.project.miinhareceita.services.validation;

import java.util.ArrayList;
import java.util.List;

import com.project.miinhareceita.controllers.exceptions.FieldMessage;
import com.project.miinhareceita.dtos.UserInsertDTO;
import com.project.miinhareceita.entities.User;
import com.project.miinhareceita.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;



import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class UserInsertValidator implements ConstraintValidator<UserInsertValid, UserInsertDTO> {
	
	@Autowired
	private UserRepository repository;
	
	@Override
	public void initialize(UserInsertValid ann) {
	}

	@Override
	public boolean isValid(UserInsertDTO dto, ConstraintValidatorContext context) {
		
		List<FieldMessage> list = new ArrayList<>();
		
		User user = repository.findByEmail(dto.getEmail());
		if (user != null) {
			list.add(new FieldMessage("email", "Email já existe"));
		}

		for (FieldMessage e : list) {
			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate(e.getMessage()).addPropertyNode(e.getFieldName())
					.addConstraintViolation();
		}
		return list.isEmpty();
	}
}
