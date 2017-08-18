package control;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DaoEspecialidade;
import dao.DaoMedico;
import email.EnviarEmail;
import entity.Endereco;
import entity.Especialidade;
import entity.Medico;
import entity.TelefoneContato;
import type.EnumPerfil;
import type.EnumSexo;

@WebServlet("/ControleMedico")
public class ControleMedico extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ControleMedico() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String acao = request.getParameter("acao");
		if (acao.equalsIgnoreCase("cadastro")) {
			cadastro(request, response);
		} else if (acao.equalsIgnoreCase("excluir")) {
			excluir(request, response);
		}

	}

	protected void excluir(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			Integer idMedico = new Integer(request.getParameter("id_pessoa"));
			new DaoMedico().delete(idMedico);

			request.setAttribute("msg", "<div class='alert alert-success'>Medico Deletado</div> ");

		} catch (Exception ex) {
			request.setAttribute("msg", "<div class='alert alert-danger'>" + ex.getMessage() + "</div> ");
			ex.printStackTrace();
		} finally {
			request.getRequestDispatcher("cadastro_medico.jsp").forward(request, response);
		}

	}

	protected void cadastro(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String nome = request.getParameter("nome").toUpperCase();
		String email = request.getParameter("email").toUpperCase();
		EnumSexo sexo = EnumSexo.valueOf(request.getParameter("sexo"));
		String crm = request.getParameter("crm").toUpperCase();
		String cep = request.getParameter("cep").toUpperCase();
		String logradouro = request.getParameter("logradouro").toUpperCase();
		String bairro = request.getParameter("bairro").toUpperCase();
		String cidade = request.getParameter("cidade").toUpperCase();
		String uf = request.getParameter("uf").toUpperCase();
		Integer numeroEndereco = new Integer(request.getParameter("numeroEndereco"));
		String complemento = request.getParameter("complemento").toUpperCase();

		try {

			// instanciando medico
			Medico m = new Medico();
			m.setNome(nome);
			m.setEmail(email);
			m.setCrm(crm);
			m.setSexo(sexo);
			m.setPerfil(EnumPerfil.MEDICO);

			// instanciando endereco
			Endereco e = new Endereco();
			e.setBairro(bairro);
			e.setCep(cep);
			e.setCidade(cidade);
			e.setEstado(uf);
			e.setLogradouro(logradouro);
			e.setNumeroEnd(numeroEndereco);
			e.setComplemento(complemento);

			// Instanciando e adiciono a especialidade no medico

			String[] values = request.getParameterValues("especialidade_medica[]");

			for (int i = 0; i < values.length; i++) {
				Especialidade es = new Especialidade();
				es = new DaoEspecialidade().findByCode(new Integer(values[i]));
				m.adicionaEspecialidade(es);

			}

			// aplicando relacao com endereco
			m.setEndereco(e);

			// aplicando relacao com telefones
			if (request.getParameter("telefone1") != "") {
				String telefone1 = request.getParameter("telefone1");
				TelefoneContato t1 = new TelefoneContato();
				t1.setNumero(telefone1);
				m.addTelefone(t1);
			}

			if (request.getParameter("telefone2") != "") {
				String telefone2 = request.getParameter("telefone2");
				TelefoneContato t2 = new TelefoneContato();
				t2.setNumero(telefone2);
				m.addTelefone(t2);
			}

			new DaoMedico().create(m);

//			EnviarEmail em = new EnviarEmail();
//			em.enviarEmail(m);

			request.setAttribute("msg", "<div class='alert alert-success'>Medico Cadastrado</div> ");

		} catch (Exception ex) {
			request.setAttribute("msg", "<div class='alert alert-danger'>" + ex.getMessage() + "</div> ");
			ex.printStackTrace();
		} finally {
			request.getRequestDispatcher("cadastro_medico.jsp").forward(request, response);
		}

	}
}
