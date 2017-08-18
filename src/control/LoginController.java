package control;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.DaoLogin;
import entity.Usuario;

@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LoginController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		session.invalidate();

		request.setAttribute("msg", "LOGOUT EFETUADO");
		request.getRequestDispatcher("index.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String acao = request.getParameter("acao");
		if (acao.equalsIgnoreCase("logar")) {
			logar(request, response);
		}
	}

	protected void logar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Usuario usuario_informado = new Usuario();
		try {
			HttpSession session = request.getSession(true);

			String login_informado = request.getParameter("txtlogin");
			String senha_informada = request.getParameter("txtsenha");

			
			usuario_informado.setNomeUsuario(login_informado);
			usuario_informado.setPassword(senha_informada);
			CriptografaSenha.CriptografiaLogin(usuario_informado);

			Usuario usuario_logado = new DaoLogin().existeUsuario(usuario_informado);
			if (usuario_logado != null) {
				session.setAttribute("Usuario", usuario_logado);
				request.getRequestDispatcher("inicial.jsp").forward(request, response);
			} else {
				request.setAttribute("msg", "USUÁRIO /SENHA INVÁLIDO");
				request.getRequestDispatcher("index.jsp").forward(request, response);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
