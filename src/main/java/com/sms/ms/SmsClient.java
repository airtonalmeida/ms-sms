package com.sms.ms;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class SmsClient {
	
	@Autowired
	private RestTemplate restTemplate = new RestTemplate();	
	
	private final String url = "https://sms.maxx.mobi/ws/maxxmobi/envios/";	
	
	public void enviarSms(Sms sms){
				
		URI resourceUri = URI.create(url);
		
		sms.getRequisicao().forEach(e -> e.setIdCliente("T1210901"));
		sms.setUsuario("");
		sms.setSenha("");
		
		restTemplate.postForObject(
				resourceUri, sms, RetornoEnvioSms.class);
		
	
		
	}
	

}
