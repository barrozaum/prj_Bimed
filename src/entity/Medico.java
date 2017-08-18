package entity;

import java.util.ArrayList;
import java.util.List;

import type.EnumPerfil;
import type.EnumSexo;

public class Medico extends Pessoa {
	// atributos de medico
	private String crm;
	private List<Especialidade> especialidades;

	// construtor
	public Medico() {
		super();
	}

	public Medico(Integer idPessoa, String nome, String email, EnumSexo sexo) {
		super(idPessoa, nome, email, sexo, EnumPerfil.MEDICO);
	}

	public Medico(Integer idPessoa, String nome, String email, EnumSexo sexo, String crm) {
		super(idPessoa, nome, email, sexo, EnumPerfil.MEDICO);
		this.crm = crm;
	}

	// getts and setters
	public List<Especialidade> getEspecialidades() {
		return especialidades;
	}

	public void setEspecialidades(List<Especialidade> especialidades) {
		this.especialidades = especialidades;
	}

	public String getCrm() {
		return crm;
	}

	public void setCrm(String crm) {
		this.crm = crm;
	}

	// adicionando especialidades do médico
	public void adicionaEspecialidade(Especialidade e) {
		if (especialidades == null) {
			especialidades = new ArrayList<>();
		}
		especialidades.add(e);
	}

	// to string
	@Override
	public String toString() {
		return "Medico [getIdPessoa()=" + getIdPessoa() + ", getNome()=" + getNome() + ", getEmail()=" + getEmail()
				+ ", getSexo()=" + getSexo() + ", getPerfil()=" + getPerfil() + ", getCrmMedico()" + getCrm()
				+ ", getespecialidades()=" + getEspecialidades() + ", getLista_telefones()=" + getLista_telefones() + ", getEndereco()=" + getEndereco() + "]";
	}

}
