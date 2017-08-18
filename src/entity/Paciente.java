package entity;

import java.util.ArrayList;
import java.util.List;

import type.EnumPerfil;
import type.EnumSexo;

public class Paciente extends Pessoa {

	// paciente possui convênio
	private List<Convenio> convenios;

	
	public List<Convenio> getConvenios() {
		return convenios;
	}

	public void setConvenios(List<Convenio> convenios) {
		this.convenios = convenios;
	}

	public void adicionarConvenio(Convenio convenio){
		if(convenios == null){
			convenios = new ArrayList<Convenio>();
		}
		convenios.add(convenio);
	}

	public Paciente() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Paciente(Integer idPessoa, String nome, String email, EnumSexo sexo, EnumPerfil perfil) {
		super(idPessoa, nome, email, sexo, perfil);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Paciente [lista_convenio=" + convenios + ", getIdPessoa()=" + getIdPessoa() + ", getNome()="
				+ getNome() + ", getEmail()=" + getEmail() + ", getSexo()=" + getSexo() + ", getPerfil()=" + getPerfil()
				+ ", getLista_telefones()=" + getLista_telefones() + ", getEndereco()=" + getEndereco()
				+ ", getSenha()=" + getSenha() + "]";
	}



}
