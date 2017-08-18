package teste;

import entity.Endereco;
import entity.Medico;
import entity.TelefoneContato;
import type.EnumSexo;

public class Testar_Relacao_Pessoa_Telefone_Endereco {

public static void main(String[] args) {

		Medico m1 = new Medico();
		m1.setIdPessoa(1);
		m1.setNome("IGOR");
		m1.setEmail("IGOR@PARVAIM.COM.BR");
		m1.setSexo(EnumSexo.M);
		
		TelefoneContato t1 = new TelefoneContato();
		t1.setIdTelefone(1);
		t1.setNumero("2127567241");
		
		TelefoneContato t2 = new TelefoneContato();
		t2.setIdTelefone(2);
		t2.setNumero("2126511048");
		
		TelefoneContato t3 = new TelefoneContato();
		t3.setIdTelefone(3);
		t3.setNumero("2126512338");
		
		Endereco endereco = new Endereco();
		endereco.setIdEndereco(1);
		endereco.setBairro("Sao Joao de Meriti");
		endereco.setCidade("Rio de Janeiro");
		endereco.setCep("2552518");
		endereco.setEstado("RJ");
		endereco.setLogradouro("RUA FRANCISCO SOARES DE OLIVEIRA");
		endereco.setPessoa(m1);
		
		m1.setEndereco(endereco);
		
		
		
		System.out.println("Medico ->  " +  m1);
		System.out.println("Telefone 1 -> " + t1);
		System.out.println("Telefone 2 -> " + t2);
		System.out.println("Telefone 3 -> " + t3);
		
//		aplicando relacionamento
//		relaciono medico -> telefone
		m1.addTelefone(t1);
		m1.addTelefone(t2);
		m1.addTelefone(t3);
		
//		relaciono telefon -> medico
		t1.setPessoa(m1);
		t2.setPessoa(m1);
		t3.setPessoa(m1);
		
		System.out.println("Medico  " +  m1);
//		System.out.println("Telefone 1 -> Medico  " +  t2.getPessoa());
		
		
	}
}
