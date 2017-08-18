package entity;

import java.util.ArrayList;
import java.util.List;

import type.EnumPerfil;
import type.EnumSexo;

// classe nao vai ser instanciada
public abstract class Pessoa {

	private Integer idPessoa;
	private String nome;
	private String email;
	private EnumSexo sexo;
	private EnumPerfil perfil;
	private List<TelefoneContato> lista_telefones;
	private Endereco endereco;
	private String senha;

	public Pessoa() {
		// TODO Auto-generated constructor stub
	}

	public Pessoa(Integer idPessoa, String nome, String email, EnumSexo sexo, EnumPerfil perfil) {
		super();
		this.idPessoa = idPessoa;
		this.nome = nome;
		this.email = email;
		this.sexo = sexo;
		this.perfil = perfil;
	}

	public Integer getIdPessoa() {
		return idPessoa;
	}

	public void setIdPessoa(Integer idPessoa) {
		this.idPessoa = idPessoa;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public EnumSexo getSexo() {
		return sexo;
	}

	public void setSexo(EnumSexo sexo) {
		this.sexo = sexo;
	}

	public EnumPerfil getPerfil() {
		return perfil;
	}

	public void setPerfil(EnumPerfil perfil) {
		this.perfil = perfil;
	}

	public List<TelefoneContato> getLista_telefones() {
		return lista_telefones;
	}

	public void setLista_telefones(List<TelefoneContato> lista_telefones) {
		this.lista_telefones = lista_telefones;
	}

	public void addTelefone(TelefoneContato t) {
		if (lista_telefones == null) {
			lista_telefones = new ArrayList<TelefoneContato>();
		}
		lista_telefones.add(t);
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	@Override
	public String toString() {
		return "Pessoa [idPessoa=" + idPessoa + ", nome=" + nome + ", email=" + email + ", sexo=" + sexo
				+ ", lista_telefones=" + lista_telefones + ", endereco=" + endereco + "]";
	}

}
