package teste;

import dao.DaoAtendente;
import dao.DaoMedico;
import entity.Endereco;
import entity.Medico;
import entity.Pessoa;
import entity.TelefoneContato;
import type.EnumSexo;

public class TestePessoa {

	public static void main(String[] args) {
		try {
			Medico m1 = new Medico();
			m1.setIdPessoa(1);
			m1.setNome("IGOR");
			m1.setEmail("IGOR@PARVAIM.COM.BR");
			m1.setSexo(EnumSexo.M);

			Endereco endereco = new Endereco();
			endereco.setIdEndereco(1);
			endereco.setBairro("Sao Joao de Meriti");
			endereco.setCidade("Rio de Janeiro");
			endereco.setCep("2552518");
			endereco.setEstado("RJ");
			endereco.setLogradouro("RUA FRANCISCO SOARES DE OLIVEIRA");
			endereco.setPessoa(m1);
			m1.setEndereco(endereco);

			TelefoneContato t1 = new TelefoneContato();
			t1.setIdTelefone(1);
			t1.setNumero("2127567241");

			TelefoneContato t2 = new TelefoneContato();
			t2.setIdTelefone(2);
			t2.setNumero("2126511048");
			m1.addTelefone(t1);
			m1.addTelefone(t2);

			DaoMedico dp = new DaoMedico();
			dp.create(m1);

			System.out.println("Inserido");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
