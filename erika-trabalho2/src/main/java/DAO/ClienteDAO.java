package DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import modelo.Cliente;
import dao.util.Conexao;

public class ClienteDAO {
	 private Connection connection;
	 
	 private void conectar() throws SQLException{
		 if	(connection == null || connection.isClosed()) {
			 connection = Conexao.getConexao();
		 }
	 }
	 
	 private void desconectar() throws SQLException {
			if (connection != null && !connection.isClosed()) {
				connection.close();
			}
		}
		public Cliente inserirCliente(Cliente cliente) throws SQLException {
			String sql = "INSERT INTO cliente (nome, data_nascimento, idade)"
					+ " VALUES (?, ?, ?)";		    
			
			conectar();

			PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			statement.setString(1, cliente.getNome());
			Date nascimento= new Date(cliente.getData_nascimento().getTime());
			statement.setDate(2, nascimento);
			statement.setString(3, cliente.getIdade());
			
			
			statement.executeUpdate();
			
			ResultSet resultSet = statement.getGeneratedKeys();
			long id = 0;
			if(resultSet.next())
				id = resultSet.getInt("id");
			statement.close();

			desconectar();
			
			cliente.setId(id);
			return cliente;
		}
		
		public List<Cliente> listarTodosClientes() throws SQLException {
			
			List<Cliente> listaClientes= new ArrayList<Cliente>();

			String sql = "SELECT * FROM cliente";

			conectar();

			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);

			while (resultSet.next()) {
				long id = resultSet.getLong("id");
				String nome = resultSet.getString("nome");
				Date nascimento= new Date(resultSet.getDate("data_nascimento").getTime());
				String idade= resultSet.getString("idade");
			
				Cliente cliente= new Cliente(nome, nascimento, idade);
				cliente.setId(id);
				listaClientes.add(cliente);
			}
			resultSet.close();
			statement.close();

			desconectar();

			return listaClientes;
		}
		public boolean apagarCliente(Cliente cliente) throws SQLException {
			String sql = "DELETE FROM cliente where id = ?";
    
			conectar();
     
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setLong(1, cliente.getId());
     
			boolean linhaApagada = statement.executeUpdate() > 0;
			statement.close();
    
			desconectar();
    
    return linhaApagada;     
}

}


