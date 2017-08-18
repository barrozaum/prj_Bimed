package control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DaoConvenio;
import dao.DaoEspecialidade;
import dao.DaoMedico;
import dao.DaoPaciente;
import email.EnviarEmail;
import entity.Convenio;
import entity.Endereco;
import entity.Especialidade;
import entity.Medico;
import entity.Paciente;
import entity.TelefoneContato;
import type.EnumPerfil;
import type.EnumSexo;

@WebServlet("/ControlePaciente")
public class ControlePaciente extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ControlePaciente() {
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
			new DaoPaciente().delete(idPessoa);

			request.setAttribute("msg", "<div class='alert alert-success'>Paciente Deletado</div> ");

		} catch (Exception ex) {
			request.setAttribute("msg", "<div class='alert alert-danger'>" + ex.getMessage() + "</div> ");
			ex.printStackTrace();
		} finally {
			request.getRequestDispatcher("cadastro_paciente.jsp").forward(request, response);
		}

	}

	protected void cadastro(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String nome = request.getParameter("nome").toUpperCase();
		String email = request.getParameter("email").toUpperCase();
		EnumSexo sexo = EnumSexo.valueOf(request.getParameter("sexo"));
		String cep = request.getParameter("cep").toUpperCase();
		String logradouro = request.getParameter("logradouro").toUpperCase();
		String bairro = request.getParameter("bairro").toUpperCase();
		String cidade = request.getParameter("cidade").toUpperCase();
		String uf = request.getParameter("uf").toUpperCase();
		Integer numeroEndereco = new Integer(request.getParameter("numeroEndereco"));
		String complemento = request.getParameter("complemento").toUpperCase();

		try {

			// instanciando medico
			Paciente paciente = new Paciente();
			paciente.setNome(nome);
			paciente.setEmail(email);
			paciente.setSexo(sexo);
			paciente.setPerfil(EnumPerfil.PACIENTE);

			// instanciando endereco
			Endereco e = new Endereco();
			e.setBairro(bairro);
			e.setCep(cep);
			e.setCidade(cidade);
			e.setEstado(uf);
			e.setLogradouro(logradouro);
			e.setNumeroEnd(numeroEndereco);
			e.setComplemento(complemento);
			paciente.setEndereco(e);

			// Instanciando e adiciono o convenio do paciente
			String[] values = request.getParameterValues("convenios_paciente[]");
			for (int i = 0; i < values.length; i++) {
				Convenio convenio = new Convenio();
				convenio = new DaoConvenio().findByCode(new Integer(values[i]));
				paciente.adicionarConvenio(convenio);
			}

			// aplicando relacao com telefones
			if (request.getParameter("telefone1") != "") {
				String telefone1 = request.getParameter("telefone1");
				TelefoneContato t1 = new TelefoneContato();
				t1.setNumero(telefone1);
				paciente.addTelefone(t1);
			}

			if (request.getParameter("telefone2") != "") {
				String telefone2 = request.getParameter("telefone2");
				TelefoneContato t2 = new TelefoneContato();
				t2.setNumero(telefone2);
				paciente.addTelefone(t2);
			}

			new DaoPaciente().create(paciente);

//			EnviarEmail em = new EnviarEmail();
//			em.enviarEmail(paciente);

			request.setAttribute("msg", "<div class='alert alert-success'>Paciente Cadastrado</div> ");

		} catch (Exception ex) {
			request.setAttribute("msg", "<div class='alert alert-danger'>" + ex.getMessage() + "</div> ");
			ex.printStackTrace();
		} finally {
			request.getRequestDispatcher("cadastro_paciente.jsp").forward(request, response);
		}

	}

}
