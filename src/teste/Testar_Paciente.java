package teste;

import dao.DaoMedico;
import dao.DaoPaciente;
import dao.DaoAtendente;
import entity.Endereco;
import entity.Medico;
import entity.Paciente;
import type.EnumPerfil;
import type.EnumSexo;

public class Testar_Paciente {

	public static void main(String[] args) {
		try {

			DaoPaciente dp= new DaoPaciente();
			Paciente paciente = new Paciente();
			paciente.setEmail("paulo14@gmail.com");
			paciente.setNome("paulo1");
			paciente.setPerfil(EnumPerfil.PACIENTE);
			paciente.setSexo(EnumSexo.M);
			paciente.setLista_telefones(null);
		
			paciente.setEndereco(new Endereco(24, "teste", "Teste", "cidade", "rf", "25525180", 18, "casa"));
			dp.create(paciente);
			System.out.println("Criado" );
			
//			System.out.println( dp.findByCode(14));
			System.out.println("DELETEADO");
			dp.delete(14);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
