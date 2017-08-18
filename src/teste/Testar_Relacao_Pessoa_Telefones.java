package teste;

import entity.Medico;
import entity.Pessoa;
import entity.TelefoneContato;
import type.EnumSexo;

public class Testar_Relacao_Pessoa_Telefones {

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
		
//		System.out.println("Medico -> Telefones  " +  m1);
		System.out.println("Telefone 1 -> Medico  " +  t2.getPessoa());
		
		for (TelefoneContato telefone : m1.getLista_telefones()) {
			System.out.println("Telefone" + telefone.getNumero());
			
		}
		
		
	}
}
