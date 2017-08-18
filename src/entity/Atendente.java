package entity;

import type.EnumPerfil;
import type.EnumSexo;

public class Atendente extends Pessoa{

	private String matricula;

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public Atendente() {
		super();
	}

	public Atendente(Integer idPessoa, String nome, String email, EnumSexo sexo, EnumPerfil perfil) {
		super(idPessoa, nome, email, sexo, perfil);
	}

	@Override
	public String toString() {
		return "Atendente [matricula=" + matricula + ", getIdPessoa()=" + getIdPessoa() + ", getNome()=" + getNome()
				+ ", getEmail()=" + getEmail() + ", getSexo()=" + getSexo() + ", getPerfil()=" + getPerfil()
				+ ", getLista_telefones()=" + getLista_telefones() + ", getEndereco()=" + getEndereco() + "]";
	}
	
	
}
