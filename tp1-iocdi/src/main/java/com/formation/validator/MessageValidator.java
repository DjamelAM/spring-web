package com.formation.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.formation.model.MessageDto;

public class MessageValidator implements Validator {

	@Override
	public boolean supports(Class<?> arg0) {
		return MessageDto.class.isAssignableFrom(arg0);
	}

	@Override
	public void validate(Object target, Errors errors) {

		ValidationUtils.rejectIfEmpty(errors, "user", "required", "Le nom est obligatoire");

		ValidationUtils.rejectIfEmpty(errors, "toUser", "required", "Le nom du deuxième est obligatoire");

		ValidationUtils.rejectIfEmpty(errors, "message", "required", "Le message est obligatoire");

		MessageDto messageDto = (MessageDto) target;
		if (!(messageDto.getUser().isEmpty()) && !(Character.isUpperCase(messageDto.getUser().charAt(0)))) {

			errors.rejectValue("user", "negativeValue", new Object[] { "'user'" }, "user a besoin d'une majuscule");

		}
	}

}
