package modelo;

import java.util.Date;

public class Cliente {
	
	private Long id;
	private String nome;
	private Date data_nascimento;
	private String idade;
	public Cliente() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Cliente(String nome, Date data_nascimento, String idade) {
		super();
		this.nome = nome;
		this.data_nascimento = data_nascimento;
		this.idade = idade;
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
	public Date getData_nascimento() {
		return data_nascimento;
	}
	public void setData_nascimento(Date data_nascimento) {
		this.data_nascimento = data_nascimento;
	}
	public String getIdade() {
		return idade;
	}
	public void setIdade(String idade) {
		this.idade = idade;
	}
	@Override
	public String toString() {
		return "Cliente [id=" + id + ", nome=" + nome + ", data_nascimento=" + data_nascimento + ", idade=" + idade
				+ "]";
	}
	
	

}
