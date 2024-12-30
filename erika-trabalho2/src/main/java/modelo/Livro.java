package modelo;


public class Livro {
	
	 private Long id;
	 private String isbn;
	 private String titulo;
	 private String edicao;
	 private String publicacao;
	 private String descricao;
	public Livro() {
		super();
		// TODO Auto-generated constructor stub
	}

	 
	 
public Livro(String isbn, String titulo, String edicao, String publicacao, String descricao) {
		super();
		this.isbn = isbn;
		this.titulo = titulo;
		this.edicao = edicao;
		this.publicacao = publicacao;
		this.descricao = descricao;
	}



public Long getId() {
	return id;
}

public void setId(Long id) {
	this.id = id;
}

public String getIsbn() {
	return isbn;
}

public void setIsbn(String isbn) {
	this.isbn = isbn;
}

public String getTitulo() {
	return titulo;
}

public void setTitulo(String titulo) {
	this.titulo = titulo;
}

public String getEdicao() {
	return edicao;
}

public void setEdicao(String edicao) {
	this.edicao = edicao;
}

public String getPublicacao() {
	return publicacao;
}

public void setPublicacao(String publicacao) {
	this.publicacao = publicacao;
}

public String getDescricao() {
	return descricao;
}

@Override
public String toString() {
	return "Livro [id=" + id + ", isbn=" + isbn + ", titulo=" + titulo + ", edicao=" + edicao + ", publicacao="
			+ publicacao + ", descricao=" + descricao + "]";
}

	
}
