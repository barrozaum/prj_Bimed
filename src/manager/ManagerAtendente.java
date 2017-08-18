package manager;

import java.util.ArrayList;
import java.util.List;

import dao.DaoAtendente;
import dao.DaoMedico;
import entity.Atendente;
import entity.Medico;

public class ManagerAtendente {

	private Atendente atendente;
	private List<Atendente> listar_atendente;

	public ManagerAtendente() {
		listar_atendente = new ArrayList<Atendente>();
	}

	public Atendente getAtendente() {
		return atendente;
	}

	public void setAtendente(Atendente atendente) {
		this.atendente = atendente;
	}

	public List<Atendente> getListar_atendente() {
		try {
			listar_atendente = new DaoAtendente().findAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listar_atendente;
	}

	public void setListar_atendente(List<Atendente> listar_atendente) {
		this.listar_atendente = listar_atendente;
	}

	public void findByCode(Integer cod) {
		try {
			atendente = new DaoAtendente().findByCode(cod);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
