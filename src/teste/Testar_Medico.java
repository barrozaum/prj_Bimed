package teste;

import dao.DaoEspecialidade;
import dao.DaoMedico;
import dao.DaoAtendente;
import entity.Endereco;
import entity.Especialidade;
import entity.Medico;
import entity.TelefoneContato;
import type.EnumPerfil;
import type.EnumSexo;

public class Testar_Medico {

	public static void main(String[] args) {
		try {

			DaoMedico dm = new DaoMedico();
			// dm.delete(4);
			Medico medico = new Medico();
			medico.setEmail("THAYNA@gmail.com");
			medico.setNome("THAYNA");
			medico.setPerfil(EnumPerfil.MEDICO);
			medico.setSexo(EnumSexo.F);
			medico.setCrm("457557 bd");
			// Endereco
			medico.setEndereco(new Endereco(null, "francisco", "Teste", "cidade", "rf", "25525180", 18, ""));

			// Especialidade
			Especialidade e = new Especialidade();
			DaoEspecialidade de = new DaoEspecialidade();
			e = de.findByCode(1);
			medico.adicionaEspecialidade(e);
			e = de.findByCode(2);
			medico.adicionaEspecialidade(e);
			// System.out.println(medico);
			// telefone

			TelefoneContato t1 = new TelefoneContato();
			t1.setNumero("2127567241");

			TelefoneContato t2 = new TelefoneContato();
			t2.setNumero("2126511048");
			medico.addTelefone(t1);
			medico.addTelefone(t2);
			// dm.create(medico);

			// System.out.println("Criado");
			// //
			// medico = dm.findByCode(6);
			// System.out.println("medico" + medico);
			//

			//
			// System.out.println("deletando");
			//// dm.delete(7);
			//
			// dm.update(medico);
			// System.out.println("COM TELEFONE " + dm.findByCode(9));
			for (Medico medicoF : dm.findAll()) {
				System.out.println(medicoF);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
