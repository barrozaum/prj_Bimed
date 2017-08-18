package manager;

import java.util.ArrayList;
import java.util.List;

import dao.DaoConvenio;
import dao.DaoMedico;
import entity.Medico;

public class ManagerMedico {

	private Medico medico;
	private List<Medico> listar_medico;

	public ManagerMedico() {
		listar_medico = new ArrayList<Medico>();
	}

	public Medico getMedico() {
		return medico;
	}

	public void setMedico(Medico medico) {
		this.medico = medico;
	}

	public List<Medico> getListar_medico() {
		try {
			listar_medico = new DaoMedico().findAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listar_medico;
	}

	public void setListar_medico(List<Medico> listar_medico) {
		this.listar_medico = listar_medico;
	}
	
	public void findByCode(Integer cod) {
		try {
			medico = new DaoMedico().findByCode(cod);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
