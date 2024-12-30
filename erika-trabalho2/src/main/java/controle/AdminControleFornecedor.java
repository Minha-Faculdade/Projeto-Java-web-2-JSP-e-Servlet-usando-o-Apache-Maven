package controle;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.FornecedorDAO;
import modelo.Fornecedor;

/**
 * Servlet implementation class AdminControle
 */
@WebServlet("/auth/admin/fornecedor")
public class AdminControleFornecedor extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	private FornecedorDAO fornecedorDAO;
    
    public AdminControleFornecedor() {
        super();
    }
    
    public void init() {
    	fornecedorDAO = new FornecedorDAO();
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
			case "listar":
				listarFornecedor(request, response);
				break;
				
			case "apagar":
				apagarFornecedor(request, response);
				break;
			}
		} catch (Exception ex) {
			throw new ServletException(ex);
		}
		
	}


	private void listarFornecedor(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
		
		List<Fornecedor> fornecedores = fornecedorDAO.listarTodosFornecedores();
		
		request.setAttribute("listaFornecedores", fornecedores);
		
		String path =  request.getServletPath() + "/admin-listar-fornecedor.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(path);
		
		dispatcher.forward(request, response);

	}
	
	private void apagarFornecedor(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
		
		long id = Long.parseLong(request.getParameter("id"));
		
		Fornecedor fornecedor= new Fornecedor();
		fornecedor.setId(id);
		fornecedorDAO.apagarFornecedor(fornecedor);
		
		String path = request.getContextPath() + request.getServletPath() + "?acao=listar";
		response.sendRedirect(path);
		
		
	}

}


	

