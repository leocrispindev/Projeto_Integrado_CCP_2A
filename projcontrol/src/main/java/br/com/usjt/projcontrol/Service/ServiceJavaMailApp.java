package br.com.usjt.projcontrol.Service;

import java.util.Properties;

import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import br.com.usjt.projcontrol.DAO.CredenciaisDAO;
import br.com.usjt.projcontrol.model.Aluno;
import br.com.usjt.projcontrol.model.RecuperarSenha;

public class ServiceJavaMailApp {
	
	public String mensagemRecuperarSenha(RecuperarSenha r1, String[] aux) {
		String urlImg = "https://i.imgur.com/JopFwWw.png";
		return 
				"<style>\r\n" + 
				"	.mcnTextContent{\r\n" + 
				"   		background-image: url(" + urlImg + ");\r\n" + 
				"      	width: 100%;\r\n" + 
				"        height: 254px;\r\n" + 
				"        background-repeat: no-repeat;\r\n" + 
				"        display:flex;\r\n" + 
				"        flex-direction:column;\r\n" + 
				"        justify-content: flex-end;\r\n" + 
				"\r\n" + 
				"    }\r\n" + 
				"    \r\n" + 
				"    .texto{\r\n" + 
				"    	color:#fff;\r\n" + 
				"        font-size:50px;\r\n" + 
				"        margin-left:10px;\r\n" + 
				"        margin-bottom:20px;\r\n" + 
				"        font-family:arial;\r\n" + 
				"    }\r\n" + 
				".abs{"
				+ " margin-top: 20vh; position: absolute;}" +
				"</style>\r\n" + 
				"<div class=\"mcnTextContent\">\r\n" + 
				"<img src='https://i.imgur.com/ExM6SYb.png'/>"+
				"   <div class='abs'>"+
				"	<h1 class=\"texto\" style=\"font-size:50px;\">Olá, " + aux[0] + "</h1>\r\n" + 
				"    <h1 class=\"texto\">Sua Senha é</h1>\r\n" + 
				"    <h1 class=\"texto\">\"" + r1.getSenha() + "\"</h1>\r\n" + 
				"    <h1 style=\"font-size:20px; color:lightblue; margin-left:10px;\">ATENÇÃO NÃO COMPARTILHE SUA SENHA COM NINGUEM!</h1>\r\n" + 
				"	</div>"+
				"</div>";
	}
	
	public String mensagemPosRegistro(Aluno a) {
		String urlImg = "https://i.imgur.com/ExM6SYb.png";
		return "<style>\r\n" + 
				"	.mcnTextContent{\r\n" + 
				"   		background: url(" + urlImg + ");\r\n" + 
				"      	width: 100%;\r\n" + 
				"        height: 760px;\r\n" + 
				"        background-repeat: no-repeat;\r\n" + 
				"        display:flex;\r\n" + 
				"        flex-direction:column;\r\n" + 
				"        justify-content: flex-end;\r\n" + 
				"\r\n" + 
				"    }\r\n" + 
				"    \r\n" + 
				"    .texto{\r\n" + 
				"    	color:#fff;\r\n" + 
				"        font-size:50px;\r\n" + 
				"        margin-left:10px;\r\n" + 
				"        margin-bottom:20px;\r\n" + 
				"        font-family:arial;\r\n" + 
				"    }\r\n" + 
				"</style>\r\n" + 
				"<div class=\"mcnTextContent\">\r\n" + 
				"	<h1 class=\"texto\" style=\"font-size:50px;\">Olá " + a.getNome() + "</h1>\r\n" + 
				"    <h1 style=\"font-size:50px; color:lightblue; margin-left:10px;\">Bem Vindo(a) ao Nosso Sistema!</h1>\r\n" + 
				"</div>";
	}
	
	

	public void enviaEmail(String email, String tipo, Aluno a){
		
		Properties props = new Properties();

		// Parâmetros de conexão com servidor Gmail
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.socketFactory.port", "465");
		props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.port", "465");

		Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication("groupdevusjt@gmail.com", "112233desenv");
			}
		});

		// Ativa Debug para sessão 
		session.setDebug(true);
		
		try {
			
			RecuperarSenha r1 = new RecuperarSenha();	
			r1.setEmail(email);
			
			
			CredenciaisDAO c = new CredenciaisDAO();
			
			c.getSenhaPorEmail(r1);
			
			String[] aux;
	    	aux = r1.getNome().split(" ");

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("groupdevusjt@gmail.com"));// Remetente

			Address[] toUser = InternetAddress // Destinatário(s)
					.parse(email);
		
			message.setRecipients(Message.RecipientType.TO, toUser);
			if(tipo == "mensagemRecuperarSenha") {
				
				message.setSubject("Recuperar Senha");// Assunto
				message.setContent(mensagemRecuperarSenha(r1,aux), "text/html");
				
			}else if(tipo == "mensagemCadastro") {
				message.setSubject("Bem Vindo!");// Assunto
				message.setContent(mensagemPosRegistro(a), "text/html");
			}

			/// Metodo para enviar a mensagem criada
			Transport.send(message);

			System.out.println("Feito!!!");

		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}
	
}
