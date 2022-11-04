package com.sms.ms;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;


@Component
public class SmsConsumer {
	
	@Value(value = "${spring.kafka.consumer.group-id}")
	private String groupId;

	@Value(value = "${spring.kafka.template.default-topic}")
	private String topic;

    @Autowired
    SmsClient smsClient;   
    

    @KafkaListener(topics = "${spring.kafka.template.default-topic}", groupId = "${spring.kafka.consumer.group-id}",
    		containerFactory = "concurrentKafkaListenerContainerFactory")
    public void listen(@Payload SmsDto smsDto) {    	
    	
    	  Sms sms = new Sms();
		  BeanUtils.copyProperties(smsDto, sms); 	
		  
		 sms.getRequisicao().forEach(e -> System.out.println("Mensagem: " + e.getMensagem()));
		  
    	   smsClient.enviarSms(sms); 	  
    	    	
         
    }
}
