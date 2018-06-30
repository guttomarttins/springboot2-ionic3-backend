package com.guttomarttins.modeloconceitual.services;

import org.springframework.mail.SimpleMailMessage;

import com.guttomarttins.modeloconceitual.domain.Pedido;

public interface EmailService {

	void sendOrderConfirmationEmail(Pedido obj);
	
	void sendEmail(SimpleMailMessage msg);
}
