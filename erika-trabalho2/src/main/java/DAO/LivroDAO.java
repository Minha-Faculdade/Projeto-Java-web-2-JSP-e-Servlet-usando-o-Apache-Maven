package DAO;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


import dao.util.Conexao;
import modelo.Livro;

public class LivroDAO {
	
	private Connection connection;
	
	private void conectar() throws SQLException {
		if (connection == null || connection.isClosed()) {
			connection = Conexao.getConexao();
		}
	}

	private void desconectar() throws SQLException {
		if (connection != null && !connection.isClosed()) {
			connection.close();
		}
	}
	
	public Livro inserirLivro(Livro livro) throws SQLException {
		String sql = "INSERT INTO livro (isbn, titulo, edicao, publicacao, descricao)"
				+ " VALUES (?, ?, ?, ?, ?)";		    
		
		conectar();

		PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
		statement.setString(1, livro.getIsbn());
		statement.setString(2, livro.getTitulo());
		statement.setString(3, livro.getEdicao());
		statement.setString(4, livro.getPublicacao());
		statement.setString(5, livro.getDescricao());
		
		
		statement.executeUpdate();
		
		ResultSet resultSet = statement.getGeneratedKeys();
		long id = 0;
		if(resultSet.next())
			id = resultSet.getInt("id");
		statement.close();

		desconectar();
		
		livro.setId(id);
		return livro;
	}
	
	public List<Livro> listarTodosLivros() throws SQLException {
		
		List<Livro> listaLivros= new ArrayList<Livro>();

		String sql = "SELECT * FROM livro";

		conectar();

		Statement statement = connection.createStatement();
		ResultSet resultSet = statement.executeQuery(sql);

		while (resultSet.next()) {
			long id = resultSet.getLong("id");
			String isbn = resultSet.getString("isbn");
			String titulo = resultSet.getString("titulo");
			String edicao = resultSet.getString("edicao");
			String publicacao= resultSet.getString("publicacao");
			String descricao = resultSet.getString("descricao");
			

			Livro livro = new Livro(isbn, titulo, edicao, publicacao, descricao);
			livro.setId(id);
			listaLivros.add(livro);
		}
		resultSet.close();
		statement.close();

		desconectar();

		return listaLivros;
	}

		public boolean apagarLivro(Livro livro) throws SQLException {
			String sql = "DELETE FROM livro where id = ?";
    
			conectar();
     
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setLong(1, livro.getId());
     
			boolean linhaApagada = statement.executeUpdate() > 0;
			statement.close();
    
			desconectar();
    
    return linhaApagada;     
}




}

