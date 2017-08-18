package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import control.CriptografaSenha;
import entity.Convenio;
import entity.Endereco;
import entity.Especialidade;
import entity.Medico;
import entity.Paciente;
import entity.TelefoneContato;
import type.EnumPerfil;
import type.EnumSexo;

public class DaoPaciente extends Dao {

	public void create(Paciente paciente) throws Exception {
		open();
		con.setAutoCommit(false);
		// inserindo na tabela pessoa
		stmt = con.prepareStatement("INSERT INTO pessoa (nome,email,sexo, perfil) VALUES (?,?,?,?)",
				PreparedStatement.RETURN_GENERATED_KEYS);
		stmt.setString(1, paciente.getNome());
		stmt.setString(2, paciente.getEmail());
		stmt.setString(3, paciente.getSexo().toString());
		stmt.setString(4, paciente.getPerfil().toString());
		stmt.execute();
		rs = stmt.getGeneratedKeys();
		rs.next();
		int idPessoa = rs.getInt(1);
		// inserindo na tabela endereco
		stmt = con.prepareStatement(
				"INSERT INTO endereco (logradouro, bairro, cidade, estado, cep, numeroEndereco, complemento, idPessoa) VALUES (?,?,?,?,?,?,?,?)");
		stmt.setString(1, paciente.getEndereco().getLogradouro());
		stmt.setString(2, paciente.getEndereco().getBairro());
		stmt.setString(3, paciente.getEndereco().getCidade());
		stmt.setString(4, paciente.getEndereco().getEstado());
		stmt.setString(5, paciente.getEndereco().getCep());
		stmt.setInt(6, paciente.getEndereco().getNumeroEnd());
		stmt.setString(7, paciente.getEndereco().getComplemento());
		stmt.setInt(8, idPessoa);
		stmt.execute();
		if (paciente.getLista_telefones() != null) {
			// insrindo na tabela telefonecontato
			for (TelefoneContato telefone : paciente.getLista_telefones()) {
				stmt = con.prepareStatement("INSERT INTO telefonecontato (numero, idPessoa) VALUES (?,?) ");
				stmt.setString(1, telefone.getNumero());
				stmt.setInt(2, idPessoa);
				stmt.execute();
			}
		}
		// inserindo convenio do paciente
		if (paciente.getConvenios() != null) {
			// insrindo na tabela telefonecontato
			for (Convenio convenio : paciente.getConvenios()) {
				stmt = con.prepareStatement("insert into conveniopaciente (id_convenio,id_paciente) VALUES (?,?)");
				stmt.setInt(1, convenio.getIdConvenio());
				stmt.setInt(2, idPessoa);
				stmt.execute();
			}
		}

		// inserindo usuario
		String senha = CriptografaSenha.CriptografiaLogin(paciente.getPerfil().toString());
		stmt = con.prepareStatement("INSERT INTO usuario (idUsuario, login, password, perfil) VALUES (?,?,?,?)");
		stmt.setInt(1, idPessoa);
		stmt.setString(2, paciente.getEmail());
		stmt.setString(3, senha);
		stmt.setString(4, paciente.getPerfil().toString());
		stmt.execute();

		con.commit();
		stmt.close();
		close();
	}

	public Paciente findByCode(Integer cod) throws Exception {
		open();
		Paciente paciente = new Paciente();
		stmt = con.prepareStatement(
				"SELECT * FROM pessoa p, endereco e  WHERE p.idPessoa = ? AND p.idPessoa = e.idPessoa ");
		stmt.setInt(1, cod);
		rs = stmt.executeQuery();
		if (rs.next()) {
			paciente.setIdPessoa(rs.getInt("idPessoa"));
			paciente.setNome(rs.getString("nome"));
			paciente.setEmail(rs.getString("email"));
			paciente.setPerfil(EnumPerfil.valueOf(rs.getString("perfil")));
			paciente.setSexo(EnumSexo.valueOf(rs.getString("sexo")));
			paciente.setEndereco(new Endereco(rs.getInt("idEndereco"), rs.getString("logradouro"),
					rs.getString("bairro"), rs.getString("cidade"), rs.getString("estado"), rs.getString("cep"),
					rs.getInt("numeroEndereco"), rs.getString("complemento")));

			// telefone contato
			stmt = con.prepareStatement("SELECT * FROM telefonecontato WHERE idPessoa = ?");
			stmt.setInt(1, paciente.getIdPessoa());
			rs = stmt.executeQuery();
			while (rs.next()) {
				TelefoneContato t = new TelefoneContato();
				t.setIdTelefone(rs.getInt("idTelefone"));
				t.setNumero(rs.getString("numero"));
				t.setPessoa(paciente);
				paciente.addTelefone(t);
			}
			// convenio do paciente
			stmt = con.prepareStatement(
					"SELECT * FROM conveniopaciente cp, convenio c WHERE cp.id_paciente = ? AND cp.id_convenio = c.idConvenio");
			stmt.setInt(1, paciente.getIdPessoa());
			rs = stmt.executeQuery();
			while (rs.next()) {
				Convenio convenio = new Convenio();
				convenio.setIdConvenio(rs.getInt("idConvenio"));
				convenio.setDescricaoConvenio(rs.getString("descricaoConvenio"));
				convenio.adicionarPaciente(paciente);
				paciente.adicionarConvenio(convenio);
			}
		}

		stmt.close();
		close();
		return paciente;
	}

	public List<Paciente> findAll() throws Exception {
		open();
		List<Paciente> lista_pacientes = new ArrayList<Paciente>();
		stmt = con
				.prepareStatement("SELECT * FROM pessoa p, endereco e WHERE p.idPessoa = e.idPessoa AND p.perfil = ?");
		stmt.setString(1, "PACIENTE");
		rs = stmt.executeQuery();
		while (rs.next()) {
			Paciente paciente = new Paciente();
			paciente.setIdPessoa(rs.getInt("idPessoa"));
			paciente.setNome(rs.getString("nome"));
			paciente.setEmail(rs.getString("email"));
			paciente.setPerfil(EnumPerfil.valueOf(rs.getString("perfil")));
			paciente.setSexo(EnumSexo.valueOf(rs.getString("sexo")));
			paciente.setEndereco(new Endereco(rs.getInt("idEndereco"), rs.getString("logradouro"),
					rs.getString("bairro"), rs.getString("cidade"), rs.getString("estado"), rs.getString("cep"),
					rs.getInt("numeroEndereco"), rs.getString("complemento")));

			PreparedStatement stmt1 = con.prepareStatement("SELECT * FROM telefonecontato WHERE idPessoa = ?");
			stmt1.setInt(1, paciente.getIdPessoa());
			ResultSet rs1 = stmt1.executeQuery();
			while (rs1.next()) {
				TelefoneContato t = new TelefoneContato();
				t.setIdTelefone(rs1.getInt("idTelefone"));
				t.setNumero(rs1.getString("numero"));
				t.setPessoa(paciente);
				paciente.addTelefone(t);
			}

			// convenio do paciente
			stmt1 = con.prepareStatement(
					"SELECT * FROM conveniopaciente cp, convenio c WHERE cp.id_paciente = ? AND cp.id_convenio = c.idConvenio");
			stmt1.setInt(1, paciente.getIdPessoa());
			rs1 = stmt1.executeQuery();
			while (rs1.next()) {
				Convenio convenio = new Convenio();
				convenio.setIdConvenio(rs1.getInt("idConvenio"));
				convenio.setDescricaoConvenio(rs1.getString("descricaoConvenio"));
				convenio.adicionarPaciente(paciente);
				paciente.adicionarConvenio(convenio);
			}
			lista_pacientes.add(paciente);

		}
		stmt.close();
		close();
		return lista_pacientes;
	}

	public void delete(Integer cod) throws Exception {
		open();
		stmt = con.prepareStatement("DELETE FROM pessoa WHERE idPessoa = ? AND perfil = ?");
		stmt.setInt(1, cod);
		stmt.setString(2, EnumPerfil.PACIENTE.toString());
		stmt.execute();
		stmt.close();
		close();
	}
}
