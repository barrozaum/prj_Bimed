package manager;

import java.util.ArrayList;
import java.util.List;

import dao.DaoEspecialidade;
import entity.Especialidade;


public class ManagerEspecialidade {

	private List<Especialidade> lista_especialidade;
	private Especialidade especialidade;
	
	
	
	public ManagerEspecialidade() {
		lista_especialidade = new ArrayList<Especialidade>();
	}

	public List<Especialidade> getLista_especialidade() {
		try {
			lista_especialidade = new DaoEspecialidade().findAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lista_especialidade;
	}

	public void setLista_especialidade(List<Especialidade> lista_especialidade) {
		this.lista_especialidade = lista_especialidade;
	}

	public Especialidade getEspecialidade() {
		
		return especialidade;
	}

	public void setEspecialidade(Especialidade especialidade) {
		this.especialidade = especialidade;
	}
	
	public Especialidade findByCode(Integer cod) {
		try {
			especialidade = new DaoEspecialidade().findByCode(cod);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return especialidade;
	}

	
}
