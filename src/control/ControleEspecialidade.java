package control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.DaoEspecialidade;
import entity.Especialidade;

@WebServlet("/ControleEspecialidade")
public class ControleEspecialidade extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ControleEspecialidade() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession(false);
		if (session != null) {

			request.getRequestDispatcher("especialidade.jsp").forward(request, response);

		} else {

			request.getRequestDispatcher("index.html").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String acao = request.getParameter("acao");

		if (acao.equalsIgnoreCase("cadastro")) {
			cadastroEspecialidade(request, response);
		} else if (acao.equalsIgnoreCase("alterar")) {
			alterarEspecialidade(request, response);
		} else if (acao.equalsIgnoreCase("excluir")) {
			excluirEspecialidade(request, response);
		}
	}

	protected void cadastroEspecialidade(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {

			String especialidade = request.getParameter("especialidade");
			Double valorConsulta = new Double(request.getParameter("valor_consulta"));

			Especialidade e = new Especialidade();
			e.setDescricaoEspecialidade(especialidade);
			e.setValorConsulta(valorConsulta);

			new DaoEspecialidade().create(e);

			request.setAttribute("msg", "<div class='alert alert-success'>Especialidade Cadastrada</div> ");

		} catch (Exception ex) {
			request.setAttribute("msg", "<div class='alert alert-danger'>" + ex.getMessage() + "</div> ");
			ex.printStackTrace();
		} finally {
			request.getRequestDispatcher("especialidade.jsp").forward(request, response);
		}

	}

	protected void alterarEspecialidade(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			Integer idEspecialidade = new Integer(request.getParameter("id_especialidade"));
			String especialidade = request.getParameter("especialidade");
			Double valorConsulta = new Double(request.getParameter("valor_consulta"));

			Especialidade e = new Especialidade();
			e.setIdEspecialidade(idEspecialidade);
			e.setDescricaoEspecialidade(especialidade);
			e.setValorConsulta(valorConsulta);

			new DaoEspecialidade().update(e);
			request.setAttribute("msg", "<div class='alert alert-success'>Especialidade Alterada</div> ");

		} catch (Exception ex) {
			request.setAttribute("msg", "<div class='alert alert-danger'>" + ex.getMessage() + "</div> ");
			ex.printStackTrace();
		} finally {
			request.getRequestDispatcher("especialidade.jsp").forward(request, response);
		}
	}

	protected void excluirEspecialidade(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			Integer idEspecialidade = new Integer(request.getParameter("id_especialidade"));
			String especialidade = request.getParameter("especialidade");
			Double valorConsulta = new Double(request.getParameter("valor_consulta"));

			Especialidade e = new Especialidade();
			e.setIdEspecialidade(idEspecialidade);
			e.setDescricaoEspecialidade(especialidade);
			e.setValorConsulta(valorConsulta);

			new DaoEspecialidade().delete(e);
			request.setAttribute("msg", "<div class='alert alert-success'>Especialidade Excluida</div> ");

		} catch (Exception ex) {
			request.setAttribute("msg", "<div class='alert alert-danger'>" + ex.getMessage() + "</div> ");
			ex.printStackTrace();
		} finally {
			request.getRequestDispatcher("especialidade.jsp").forward(request, response);
		}
	}

}
