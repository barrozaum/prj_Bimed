package control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DaoAtendente;
import dao.DaoConvenio;
import dao.DaoPaciente;
import entity.Atendente;
import entity.Convenio;
import entity.Endereco;
import entity.Paciente;
import entity.TelefoneContato;
import type.EnumPerfil;
import type.EnumSexo;

@WebServlet("/ControleAtendente")
public class ControleAtendente extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ControleAtendente() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

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
			Integer idPessoa = new Integer(request.getParameter("id_pessoa"));
			new DaoAtendente().delete(idPessoa);

			request.setAttribute("msg", "<div class='alert alert-success'>Atendente Deletado</div> ");

		} catch (Exception ex) {
			request.setAttribute("msg", "<div class='alert alert-danger'>" + ex.getMessage() + "</div> ");
			ex.printStackTrace();
		} finally {
			request.getRequestDispatcher("cadastro_atendente.jsp").forward(request, response);
		}

	}

	protected void cadastro(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String nome = request.getParameter("nome").toUpperCase();
		String email = request.getParameter("email").toUpperCase();
		EnumSexo sexo = EnumSexo.valueOf(request.getParameter("sexo"));
		String matricula = request.getParameter("matricula").toUpperCase();
		String cep = request.getParameter("cep").toUpperCase();
		String logradouro = request.getParameter("logradouro").toUpperCase();
		String bairro = request.getParameter("bairro").toUpperCase();
		String cidade = request.getParameter("cidade").toUpperCase();
		String uf = request.getParameter("uf").toUpperCase();
		Integer numeroEndereco = new Integer(request.getParameter("numeroEndereco"));
		String complemento = request.getParameter("complemento").toUpperCase();
		

		try {

			// instanciando medico
			Atendente atendente = new Atendente();
			atendente.setNome(nome);
			atendente.setEmail(email);
			atendente.setSexo(sexo);
			atendente.setPerfil(EnumPerfil.ATENDENTE);
			atendente.setMatricula(matricula);

			// instanciando endereco
			Endereco e = new Endereco();
			e.setBairro(bairro);
			e.setCep(cep);
			e.setCidade(cidade);
			e.setEstado(uf);
			e.setLogradouro(logradouro);
			e.setNumeroEnd(numeroEndereco);
			e.setComplemento(complemento);
			atendente.setEndereco(e);

			// aplicando relacao com telefones
			if (request.getParameter("telefone1") != "") {
				String telefone1 = request.getParameter("telefone1");
				TelefoneContato t1 = new TelefoneContato();
				t1.setNumero(telefone1);
				atendente.addTelefone(t1);
			}

			if (request.getParameter("telefone2") != "") {
				String telefone2 = request.getParameter("telefone2");
				TelefoneContato t2 = new TelefoneContato();
				t2.setNumero(telefone2);
				atendente.addTelefone(t2);
			}

			
			
			
			new DaoAtendente().create(atendente);

			// EnviarEmail em = new EnviarEmail();
			// em.enviarEmail(atendente);

			request.setAttribute("msg", "<div class='alert alert-success'>Atendente Cadastrado</div> ");

		} catch (Exception ex) {
			request.setAttribute("msg", "<div class='alert alert-danger'>" + ex.getMessage() + "</div> ");
			ex.printStackTrace();
		} finally {
			request.getRequestDispatcher("cadastro_atendente.jsp").forward(request, response);
		}

	}

}
