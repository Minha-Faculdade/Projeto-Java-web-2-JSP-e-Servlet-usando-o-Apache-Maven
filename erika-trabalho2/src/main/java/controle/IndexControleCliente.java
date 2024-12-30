package controle;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controle.util.ManipulacaoData;
import DAO.ClienteDAO;
import modelo.Cliente;

	/**
	 * Servlet implementation class IndexControle
	 */
	@WebServlet("/cliente")
	public class IndexControleCliente extends HttpServlet {
		private static final long serialVersionUID = 1L;
		
		private ClienteDAO ClienteDAO;
	       
	    public IndexControleCliente() {
	        super();
	    }
	    
	    public void init() {
	    	ClienteDAO = new ClienteDAO();
	    }

		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			processarRequisicao(request, response);
		}

		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			processarRequisicao(request, response);
		}
		
		private void processarRequisicao(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			String acao = request.getParameter("acao");
			try {
				switch (acao) {
				case "cadastro":
					cadastroCliente(request, response);
					break;
				case "inserir":
					gravarCliente(request, response);
					break;
				}
			} catch (Exception ex) {
				throw new ServletException(ex);
			}
			
		}
		

		
		private void cadastroCliente(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException, SQLException {
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("cliente/publica-cadastro-cliente.jsp");
			dispatcher.forward(request, response);
		}
		
		private void gravarCliente(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException, SQLException {		
			
			String nome = request.getParameter("nome");
			String data = request.getParameter("nascimento");
			String idade = request.getParameter("idade");
			
				
			
			ManipulacaoData manipulacaoData = new ManipulacaoData();
			Date dataNascimento= manipulacaoData.converterStringData(data);		
				
			
			Cliente cliente= new Cliente(nome, dataNascimento, idade);
			
			Cliente clienteGravado =  ClienteDAO.inserirCliente(cliente);
				
				RequestDispatcher dispatcher = request.getRequestDispatcher("cliente/publica-cadastro-cliente.jsp");
				request.setAttribute("mensagem", "Cliente cadastrado com sucesso");
				dispatcher.forward(request, response);


		}


	}


