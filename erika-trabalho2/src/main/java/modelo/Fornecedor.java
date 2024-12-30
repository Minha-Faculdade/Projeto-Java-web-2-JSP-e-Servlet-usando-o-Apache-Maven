package modelo;


public class Fornecedor {
	
	private Long id;
	private String nome;
	private String cnpj;
	private String telefone;
	
	public Fornecedor() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Fornecedor(String nome, String cnpj, String telefone) {
		super();
		this.nome = nome;
		this.cnpj = cnpj;
		this.telefone = telefone;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	@Override
	public String toString() {
		return "Fornecedor [id=" + id + ", nome=" + nome + ", cnpj=" + cnpj + ", telefone=" + telefone + "]";
	}
	
	
}
