package com.sms.ms;

import java.util.HashSet;
import java.util.Set;

import lombok.Data;

@Data
public class SmsDto {	
	
	private String usuario;
	
	private String senha;
	
	private Set<Requisicao> requisicao =  new HashSet<>();

}