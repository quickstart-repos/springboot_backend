package com.quickstart.backend.exception;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseBody
	public Map<String, ObjectErrorMsg> objectNotValid(MethodArgumentNotValidException ex) {
		Map<String, ObjectErrorMsg> map = new HashMap<String, ObjectErrorMsg>();
		
		for(FieldError fe : ex.getBindingResult().getFieldErrors()) {
			String objectName = fe.getClass().getName();
			String fieldName = fe.getField();
			String errorMessage = fe.getDefaultMessage();
			
			FieldErrorMsg fmsg = new FieldErrorMsg(fieldName, errorMessage);
			if(map.containsKey(objectName))map.get(objectName).getMessages().add(fmsg);
			else {
				ObjectErrorMsg oMsg = new ObjectErrorMsg();
				oMsg.getMessages().add(fmsg);
				map.put(objectName, oMsg);
			}
		}
		
		return map;
	}
	
	@ExceptionHandler(Exception.class)
	@ResponseBody
	public Map<String, String> genericError(Exception ex){
		Map<String, String> map = new HashMap<String, String>();
		
		map.put("error", ex.getMessage());
		
		return map;
	}
	
	@AllArgsConstructor
	@NoArgsConstructor
	class FieldErrorMsg{
		@Getter @Setter private String fieldName;
		@Getter @Setter private String errorMessage;
	}
	
	@AllArgsConstructor
	class ObjectErrorMsg{
		@Getter @Setter private List<FieldErrorMsg> messages;
		
		public ObjectErrorMsg() {
			this.messages = new ArrayList<FieldErrorMsg>();
		}
	}
}
