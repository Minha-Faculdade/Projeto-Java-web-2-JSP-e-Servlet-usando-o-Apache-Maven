package controle;


import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.LivroDAO;
import modelo.Livro;


/**
 * Servlet implementation class IndexControle
 */
@WebServlet("/publica")
public class IndexControleLivro extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private LivroDAO LivroDAO;
       
    public IndexControleLivro() {
        super();
    }
    
    public void init() {
    	LivroDAO = new LivroDAO();
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
				cadastroLivro(request, response);
				break;
			case "inserir":
				gravarLivro(request, response);
				break;
			}
		} catch (Exception ex) {
			throw new ServletException(ex);
		}
		
	}
	

	
	private void cadastroLivro(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("publica/publica-cadastro-livro.jsp");
		dispatcher.forward(request, response);
	}
	
	private void gravarLivro(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {		
		
		String isbn = request.getParameter("isbn");
		String titulo = request.getParameter("titulo");
		String edicao = request.getParameter("edicao");
		String publicacao = request.getParameter("publicacao");
		String descricao = request.getParameter("descricao");		
			
		
		Livro livro= new Livro(isbn, titulo, edicao, publicacao, descricao);
		
			Livro livroGravado =  LivroDAO.inserirLivro(livro);
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("publica/publica-cadastro-livro.jsp");
			request.setAttribute("mensagem", "Livro cadastrado com sucesso");
			dispatcher.forward(request, response);


	}


}