package manager;

import java.util.ArrayList;
import java.util.List;

import dao.DaoPaciente;
import entity.Paciente;

public class ManagerPaciente {

	private Paciente paciente;
	private List<Paciente> listar_paciente;

	public ManagerPaciente() {
		listar_paciente = new ArrayList<Paciente>();
	}

	public Paciente getpaciente() {
		return paciente;
	}

	public void setpaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	public List<Paciente> getListar_paciente() {
		try {
			listar_paciente = new DaoPaciente().findAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listar_paciente;
	}

	public void setListar_paciente(List<Paciente> listar_paciente) {
		this.listar_paciente = listar_paciente;
	}

	public void findByCode(Integer cod) {
		try {
			 paciente = new DaoPaciente().findByCode(cod);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
