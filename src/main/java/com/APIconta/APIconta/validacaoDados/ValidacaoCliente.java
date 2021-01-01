package com.APIconta.APIconta.validacaoDados;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import org.springframework.stereotype.Service;
import br.com.caelum.stella.validation.CPFValidator;

@Service
public class ValidacaoCliente {
	public boolean dataIsValid(String date) {
		try {
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	        @SuppressWarnings("unused")
			LocalDate d = LocalDate.parse(date, formatter);
	        return true;
	     } catch (DateTimeParseException e) {
	    	return false;
	     }   
	  }
	
	public boolean cpfIsValid(String cpf) {
		 CPFValidator cpfValidator = new CPFValidator(); 
		 
		 try { 
			cpfValidator.assertValid(cpf); 
		 	return true; 
		 } catch (Exception e){ 
		    return false; 
		   } 
	}
	
	public boolean emailIsValid(String email) {
		try {
			String regex = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
		    return email.matches(regex);
		} catch (Exception e) {
			return false;
		}
	}


}
