package teste;

import dao.Dao;
import dao.DaoEspecialidade;
import entity.Especialidade;

public class Testar_Especialidade {

	public static void main(String[] args) {
		try {
			
			Especialidade e = new Especialidade();
			e.setDescricaoEspecialidade("NUTRICIONISTA");
			e.setValorConsulta(100.);
			
			DaoEspecialidade de = new DaoEspecialidade();
			System.out.println("Inserindo");
			de.create(e);
			System.out.println("Listando");
			System.out.println(de.findAll());
			
			System.out.println("BUSCANDO POR CODIGO = 2");
			System.out.println(de.findByCode(2));
			
			System.out.println("ALTERANDO VALOR = 2");
			e.setDescricaoEspecialidade("PSIQUIATRA");
			e.setIdEspecialidade(2);
			e.setValorConsulta(110.);
			de.update(e);
			System.out.println(de.findByCode(2));
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
