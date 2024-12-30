package controle;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import DAO.FornecedorDAO;
import modelo.Fornecedor;

	/**
	 * Servlet implementation class IndexControle
	 */
	@WebServlet("/fornecedor")
	public class IndexControleFornecedor extends HttpServlet {
		private static final long serialVersionUID = 1L;
		
		private FornecedorDAO FornecedorDAO;
	       
	    public IndexControleFornecedor() {
	        super();
	    }
	    
	    public void init() {
	    	FornecedorDAO = new FornecedorDAO();
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
					cadastroFornecedor(request, response);
					break;
				case "inserir":
					gravarFornecedor(request, response);
					break;
				}
			} catch (Exception ex) {
				throw new ServletException(ex);
			}
			
		}
		

		
		private void cadastroFornecedor(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException, SQLException {
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("fornecedor/publica-cadastro-fornecedor.jsp");
			dispatcher.forward(request, response);
		}
		
		private void gravarFornecedor(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException, SQLException {		
			
			String nome = request.getParameter("nome");
			String cnpj = request.getParameter("cnpj");
			String telefone = request.getParameter("telefone");
			
							
				
			
			Fornecedor fornecedor= new Fornecedor(nome, cnpj, telefone);
			
			Fornecedor fornecedorGravado =  FornecedorDAO.inserirFornecedor(fornecedor);
				
				RequestDispatcher dispatcher = request.getRequestDispatcher("fornecedor/publica-cadastro-fornecedor.jsp");
				request.setAttribute("mensagem", "Fornecedor cadastrado com sucesso");
				dispatcher.forward(request, response);


		}


	}


