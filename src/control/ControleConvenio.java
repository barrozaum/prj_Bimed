package control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DaoConvenio;
import entity.Convenio;

@WebServlet("/ControleConvenio")
public class ControleConvenio extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ControleConvenio() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String acao = request.getParameter("acao");
		if (acao.equalsIgnoreCase("cadastro")) {
			cadastroConvenio(request, response);
		} else if (acao.equalsIgnoreCase("alterar")) {
			alterarConvenio(request, response);
		} else if (acao.equalsIgnoreCase("excluir")) {
			excluirConvenio(request, response);
		}
	}

	protected void cadastroConvenio(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			String convenio = request.getParameter("convenio").toUpperCase();
			
			Convenio c = new Convenio();
			c.setDescricaoConvenio(convenio);
			
			new DaoConvenio().create(c);
			
			request.setAttribute("msg", "<div class='alert alert-success'>Convênio Cadastrado</div> ");

		} catch (Exception ex) {
			request.setAttribute("msg", "<div class='alert alert-danger'>" + ex.getMessage() + "</div> ");
			ex.printStackTrace();
		} finally {
			request.getRequestDispatcher("convenio.jsp").forward(request, response);
		}

	}
	
	protected void alterarConvenio(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			Integer idConvenio = new Integer(request.getParameter("id_convenio"));
			String convenio = request.getParameter("convenio");
			
			Convenio c = new Convenio();
			c.setIdConvenio(idConvenio);
			c.setDescricaoConvenio(convenio);
			
			new DaoConvenio().update(c);
			
			request.setAttribute("msg", "<div class='alert alert-success'>Convênio Alterado</div> ");

		} catch (Exception ex) {
			request.setAttribute("msg", "<div class='alert alert-danger'>" + ex.getMessage() + "</div> ");
			ex.printStackTrace();
		} finally {
			request.getRequestDispatcher("convenio.jsp").forward(request, response);
		}

	}
	
	protected void excluirConvenio(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			Integer idConvenio = new Integer(request.getParameter("id_convenio"));
			String convenio = request.getParameter("convenio");
			
			Convenio c = new Convenio();
			c.setIdConvenio(idConvenio);
			c.setDescricaoConvenio(convenio);
			
			new DaoConvenio().delete(c);
			
			request.setAttribute("msg", "<div class='alert alert-success'>Convênio Excluido</div> ");

		} catch (Exception ex) {
			request.setAttribute("msg", "<div class='alert alert-danger'>" + ex.getMessage() + "</div> ");
			ex.printStackTrace();
		} finally {
			request.getRequestDispatcher("convenio.jsp").forward(request, response);
		}

	}

}
