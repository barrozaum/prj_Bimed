package entity;

public class TelefoneContato {

	// atributos
	private Integer idTelefone;
	private String numero;
	private Pessoa pessoa;
	
	

	// construtores
	public TelefoneContato() {

	}

	public TelefoneContato(Integer idTelefone, String numero) {
		super();
		this.idTelefone = idTelefone;
		this.numero = numero;
	}

	
	public TelefoneContato(Integer idTelefone, String numero, Pessoa pessoa) {
		super();
		this.idTelefone = idTelefone;
		this.numero = numero;
		this.pessoa = pessoa;
	}

	// gettes e setters

	public Integer getIdTelefone() {
		return idTelefone;
	}

	public void setIdTelefone(Integer idTelefone) {
		this.idTelefone = idTelefone;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}
	
	

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	@Override
	public String toString() {
		return "TelefoneContato [idTelefone=" + idTelefone + ", numero=" + numero + "]";
	}

	
}
