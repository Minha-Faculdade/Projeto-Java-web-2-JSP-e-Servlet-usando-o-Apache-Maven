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

import DAO.LivroDAO;
import modelo.Livro;

/**
 * Servlet implementation class AdminControle
 */
@WebServlet("/auth/admin/livro")
public class AdminControleLivro extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	private LivroDAO livroDAO;
    
    public AdminControleLivro() {
        super();
    }
    
    public void init() {
    	livroDAO = new LivroDAO();
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
				listarLivro(request, response);
				break;
				
			case "apagar":
				apagarLivro(request, response);
				break;
			}
		} catch (Exception ex) {
			throw new ServletException(ex);
		}
		
	}


	private void listarLivro(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
		
		List<Livro> livros = livroDAO.listarTodosLivros();
		
		request.setAttribute("listaLivros", livros);
		
		String path =  request.getServletPath() + "/admin-listar-livro.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(path);
		
		dispatcher.forward(request, response);

	}
	
	private void apagarLivro(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
		
		long id = Long.parseLong(request.getParameter("id"));
		
		Livro livro = new Livro();
		livro.setId(id);
		livroDAO.apagarLivro(livro);
		
		String path = request.getContextPath() + request.getServletPath() + "?acao=listar";
		response.sendRedirect(path);
		
		
	}

}


	

