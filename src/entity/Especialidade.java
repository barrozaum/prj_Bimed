package entity;

public class Especialidade {

	// atributos da classe
	private Integer idEspecialidade;
	private String descricaoEspecialidade;
	private Double valorConsulta;
	// relacao
	private Medico medico;

	// métodos construtores
	public Especialidade() {

	}

	public Especialidade(Integer idEspecialidade, String descricaoEspecialidade, Double valorConsulta) {
		this.idEspecialidade = idEspecialidade;
		this.descricaoEspecialidade = descricaoEspecialidade;
		this.valorConsulta = valorConsulta;
	}

	// métodos getters e setters
	public void setIdEspecialidade(Integer idEspecialidade) {
		this.idEspecialidade = idEspecialidade;
	}

	public Integer getIdEspecialidade() {
		return idEspecialidade;
	}

	public String getDescricaoEspecialidade() {
		return descricaoEspecialidade;
	}

	public void setDescricaoEspecialidade(String descricaoEspecialidade) {
		this.descricaoEspecialidade = descricaoEspecialidade;
	}

	public Double getValorConsulta() {
		return valorConsulta;
	}

	public void setValorConsulta(Double valorConsulta) {
		this.valorConsulta = valorConsulta;
	}

	public Medico getMedico() {
		return medico;
	}

	public void setMedico(Medico medico) {
		this.medico = medico;
	}

	// toString
	@Override
	public String toString() {
		return "Especialidade [idEspecialidade=" + idEspecialidade + ", descricaoEspecialidade="
				+ descricaoEspecialidade + ", valorConsulta=" + valorConsulta + "]";
	}

}
