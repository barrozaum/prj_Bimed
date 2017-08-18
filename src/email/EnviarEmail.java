package email;

import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

import control.CriptografaSenha;
import entity.Pessoa;

public class EnviarEmail {

	private static final String HOSTNAME = "smtp.gmail.com";
	
//	seu ou da sua empresa
	private static final String USERNAME = "cotiexemplo@gmail.com";
	private static final String PASSWORD = "@coticoti@";
	
	public static Email conectaEmail() throws EmailException{
		Email email = new SimpleEmail();
		email.setHostName(HOSTNAME);
		email.setSmtpPort(45);
		email.setAuthentication(USERNAME, PASSWORD);
		email.setTLS(true);
		email.setSSL(true);
		email.setFrom(USERNAME, USERNAME);
		return email;
	}
	
	public static String enviarEmail(Pessoa p) throws EmailException{
		Email email = new SimpleEmail();
		email = conectaEmail();
		email.setSubject("MÉDICO CADASTRADO COM SUCESSO !!! " + p.getNome());
		email.addTo(p.getEmail());
		email.setMsg("Olá senhor(a) = " + p.getNome()+ ". \n Seu usuário de acesso é : " + p.getEmail() + " \n sua senha de acesso é : " + p.getPerfil().toString());
		email.send();
		return "email enviado";
	}
	
	
	
}
