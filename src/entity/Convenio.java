package entity;

import java.util.ArrayList;
import java.util.List;

public class Convenio {

	private Integer idConvenio;
	private String descricaoConvenio;
	private List<Paciente> pacientes;

	public Convenio() {

	}

	public Convenio(Integer idConvenio, String descricaoConvenio) {
		this.idConvenio = idConvenio;
		this.descricaoConvenio = descricaoConvenio;
	}

	public Integer getIdConvenio() {
		return idConvenio;
	}

	public void setIdConvenio(Integer idConvenio) {
		this.idConvenio = idConvenio;
	}

	public String getDescricaoConvenio() {
		return descricaoConvenio;
	}

	public void setDescricaoConvenio(String descricaoConvenio) {
		this.descricaoConvenio = descricaoConvenio;
	}

	public List<Paciente> getPacientes() {
		return pacientes;
	}

	public void setPacientes(List<Paciente> pacientes) {
		this.pacientes = pacientes;
	}

	public void adicionarPaciente(Paciente p) {
		if (pacientes == null) {
			pacientes = new ArrayList<Paciente>();
		}
		pacientes.add(p);
	}

	@Override
	public String toString() {
		return "Convenio [idConvenio=" + idConvenio + ", descricaoConvenio=" + descricaoConvenio + "]";
	}

}
