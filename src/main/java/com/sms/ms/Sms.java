package com.sms.ms;

import java.util.HashSet;
import java.util.Set;

import lombok.Data;

@Data
//@AllArgsConstructor
public class Sms {	
		
	private String idCliente;
	
	private String usuario;	
	
	private String senha;
	
	private Set<Requisicao> requisicao =  new HashSet<>();

	

}
