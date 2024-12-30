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

import DAO.ClienteDAO;
import modelo.Cliente;

/**
 * Servlet implementation class AdminControle
 */
@WebServlet("/auth/admin/cliente")
public class AdminControleCliente extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	private ClienteDAO clienteDAO;
    
    public AdminControleCliente() {
        super();
    }
    
    public void init() {
    	clienteDAO = new ClienteDAO();
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
				listarCliente(request, response);
				break;
				
			case "apagar":
				apagarCliente(request, response);
				break;
			}
		} catch (Exception ex) {
			throw new ServletException(ex);
		}
		
	}


	private void listarCliente(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
		
		List<Cliente> clientes = clienteDAO.listarTodosClientes();
		
		request.setAttribute("listaClientes", clientes);
		
		String path =  request.getServletPath() + "/admin-listar-cliente.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(path);
		
		dispatcher.forward(request, response);

	}
	
	private void apagarCliente(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
		
		long id = Long.parseLong(request.getParameter("id"));
		
		Cliente cliente = new Cliente();
		cliente.setId(id);
		clienteDAO.apagarCliente(cliente);
		
		String path = request.getContextPath() + request.getServletPath() + "?acao=listar";
		response.sendRedirect(path);
		
		
	}

}


	

