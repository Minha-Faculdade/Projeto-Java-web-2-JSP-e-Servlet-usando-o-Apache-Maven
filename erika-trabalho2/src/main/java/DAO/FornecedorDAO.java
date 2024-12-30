package DAO;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


import dao.util.Conexao;
import modelo.Fornecedor;

public class FornecedorDAO {
	
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
	
	public Fornecedor inserirFornecedor(Fornecedor fornecedor) throws SQLException {
		String sql = "INSERT INTO fornecedor(nome, cnpj, telefone)"
				+ " VALUES (?, ?, ?)";		    
		
		conectar();

		PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
		statement.setString(1, fornecedor.getNome());
		statement.setString(2, fornecedor.getCnpj());
		statement.setString(3, fornecedor.getTelefone());
		
		statement.executeUpdate();
		
		ResultSet resultSet = statement.getGeneratedKeys();
		long id = 0;
		if(resultSet.next())
			id = resultSet.getInt("id");
		statement.close();

		desconectar();
		
		fornecedor.setId(id);
		return fornecedor;
	}
	
	public List<Fornecedor> listarTodosFornecedores() throws SQLException {
		
		List<Fornecedor> listaFornecedores= new ArrayList<Fornecedor>();

		String sql = "SELECT * FROM fornecedor";

		conectar();

		Statement statement = connection.createStatement();
		ResultSet resultSet = statement.executeQuery(sql);

		while (resultSet.next()) {
			long id = resultSet.getLong("id");
			String nome = resultSet.getString("nome");
			String cnpj = resultSet.getString("cnpj");
			String telefone = resultSet.getString("telefone");
			

			Fornecedor fornecedor = new Fornecedor(nome, cnpj, telefone);
			fornecedor.setId(id);
			listaFornecedores.add(fornecedor);
		}
		resultSet.close();
		statement.close();

		desconectar();

		return listaFornecedores;
	}

		public boolean apagarFornecedor(Fornecedor fornecedor) throws SQLException {
			String sql = "DELETE FROM fornecedor where id = ?";
    
			conectar();
     
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setLong(1, fornecedor.getId());
     
			boolean linhaApagada = statement.executeUpdate() > 0;
			statement.close();
    
			desconectar();
    
    return linhaApagada;     
}




}

