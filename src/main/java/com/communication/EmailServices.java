package com.communication;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class EmailServices {

	public static String sendOTP(String sendTo) {

		String OTP = String.valueOf((int) (Math.random() * 100000));
		String message ="OTP: "+OTP;
		String failed="9999999";

		String subject = "Verify Your Email";

		boolean status = sendEmail(sendTo, subject, message);
		//boolean status = true;
		
		if(status){
			return OTP;
		}else{
			return "failed";
		}
		
	}

	public static boolean sendEmail(String sendTo, String subject, String message) {

		// Senders email
		final String from = "krishisathitest@gmail.com";

		// Variable for gmail
		String host = "smtp.gmail.com";

		// get the system properties
		Properties properties = System.getProperties();
		// setting important information to properties object

		// host set
		properties.put("mail.smtp.host", host);
		properties.put("mail.smtp.port", "465");
		properties.put("mail.smtp.ssl.enable", "true");
		properties.put("mail.smtp.auth", "true");

		// Step 1: to get the session object..
		Session session = Session.getInstance(properties, new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication("krishisathitest@gmail.com", "vzpfzathqxmmdtcf");
			}
		});

		session.setDebug(true);

		// Step 2 : compose the message [text,multimedia]
		MimeMessage m = new MimeMessage(session);

		try {

			// from email
			m.setFrom(from);

			// adding recipient to message
			m.addRecipient(Message.RecipientType.TO, new InternetAddress(sendTo));

			// adding subject to message
			m.setSubject(subject);

			// adding text to message
			m.setText(message);

			// send

			// Step 3 : send the message using Transport class
			Transport.send(m);

			
		} catch (Exception e) {
			e.printStackTrace();
		}

		return true;
	}
}
