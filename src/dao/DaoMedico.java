package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import control.CriptografaSenha;
import entity.Endereco;
import entity.Especialidade;
import entity.Medico;
import entity.TelefoneContato;
import entity.Usuario;
import type.EnumPerfil;
import type.EnumSexo;

public class DaoMedico extends Dao {

	public void create(Medico medico) throws Exception {
		open();
		con.setAutoCommit(false);
		// inserindo na tabela pessoa
		stmt = con.prepareStatement("INSERT INTO pessoa (nome,email,sexo, perfil) VALUES (?,?,?,?)",
				PreparedStatement.RETURN_GENERATED_KEYS);
		stmt.setString(1, medico.getNome());
		stmt.setString(2, medico.getEmail());
		stmt.setString(3, medico.getSexo().toString());
		stmt.setString(4, medico.getPerfil().toString());
		stmt.execute();
		rs = stmt.getGeneratedKeys();
		rs.next();
		int idPessoa = rs.getInt(1);
		// inserindo na tabela endereco
		stmt = con.prepareStatement(
				"INSERT INTO endereco (logradouro, bairro, cidade, estado, cep, numeroEndereco, complemento, idPessoa) VALUES (?,?,?,?,?,?,?,?)");
		stmt.setString(1, medico.getEndereco().getLogradouro());
		stmt.setString(2, medico.getEndereco().getBairro());
		stmt.setString(3, medico.getEndereco().getCidade());
		stmt.setString(4, medico.getEndereco().getEstado());
		stmt.setString(5, medico.getEndereco().getCep());
		stmt.setInt(6, medico.getEndereco().getNumeroEnd());
		stmt.setString(7, medico.getEndereco().getComplemento());
		stmt.setInt(8, idPessoa);
		stmt.execute();
		if (medico.getLista_telefones() != null) {
			// insrindo na tabela telefonecontato
			for (TelefoneContato telefone : medico.getLista_telefones()) {
				stmt = con.prepareStatement("INSERT INTO telefonecontato (numero, idPessoa) VALUES (?,?) ");
				stmt.setString(1, telefone.getNumero());
				stmt.setInt(2, idPessoa);
				stmt.execute();
			}
		}
		// inserindo na tabela de medicos
		stmt = con.prepareStatement("INSERT INTO medico (idMedico, crmMedico) VALUES (?,?)");
		stmt.setInt(1, idPessoa);
		stmt.setString(2, medico.getCrm());
		stmt.execute();

		// inserindo na tabela de especialidade
		if (medico.getEspecialidades() != null) {
			for (Especialidade especialidade : medico.getEspecialidades()) {
				stmt = con.prepareStatement("INSERT INTO especialidademedica (idEspecialidade, idMedico) VALUES (?,?)");
				stmt.setInt(1, especialidade.getIdEspecialidade());
				stmt.setInt(2, idPessoa);
				stmt.execute();
			}
		}

		// inserindo usuario
		String senha = CriptografaSenha.CriptografiaLogin(medico.getPerfil().toString());
		stmt = con.prepareStatement("INSERT INTO usuario (idUsuario, login, password, perfil) VALUES (?,?,?,?)");
		stmt.setInt(1, idPessoa);
		stmt.setString(2, medico.getEmail());
		stmt.setString(3, senha);
		stmt.setString(4, medico.getPerfil().toString());
		stmt.execute();

		con.commit();
		stmt.close();
		close();
	}

	public Medico findByCode(Integer cod) throws Exception {
		open();
		Medico medico = new Medico();
		stmt = con.prepareStatement(
				"SELECT * FROM pessoa p, endereco e, medico m WHERE p.idPessoa = ? AND p.idPessoa = e.idPessoa AND p.idPessoa = m.idMedico");
		stmt.setInt(1, cod);
		rs = stmt.executeQuery();
		if (rs.next()) {
			medico.setIdPessoa(rs.getInt("idPessoa"));
			medico.setNome(rs.getString("nome"));
			medico.setEmail(rs.getString("email"));
			medico.setCrm(rs.getString("crmMedico"));
			medico.setPerfil(EnumPerfil.valueOf(rs.getString("perfil")));
			medico.setSexo(EnumSexo.valueOf(rs.getString("sexo")));
			medico.setEndereco(new Endereco(rs.getInt("idEndereco"), rs.getString("logradouro"), rs.getString("bairro"),
					rs.getString("cidade"), rs.getString("estado"), rs.getString("cep"), rs.getInt("numeroEndereco"),
					rs.getString("complemento")));

			// telefone contato
			stmt = con.prepareStatement("SELECT * FROM telefonecontato WHERE idPessoa = ?");
			stmt.setInt(1, medico.getIdPessoa());
			rs = stmt.executeQuery();
			while (rs.next()) {
				TelefoneContato t = new TelefoneContato();
				t.setIdTelefone(rs.getInt("idTelefone"));
				t.setNumero(rs.getString("numero"));
				t.setPessoa(medico);
				medico.addTelefone(t);
			}
			// especialidade medico
			stmt = con.prepareStatement(
					"SELECT * FROM especialidademedica es, especialidade e WHERE es.idMedico = ? AND es.idEspecialidade = e.idEspecialidade");
			stmt.setInt(1, medico.getIdPessoa());
			rs = stmt.executeQuery();
			while (rs.next()) {
				Especialidade e = new Especialidade();
				e.setIdEspecialidade(rs.getInt("idEspecialidade"));
				e.setValorConsulta(rs.getDouble("valorConsulta"));
				e.setDescricaoEspecialidade(rs.getString("descricaoEspecialidade"));
				e.setMedico(medico);
				medico.adicionaEspecialidade(e);
			}
		}

		stmt.close();
		close();
		return medico;
	}

	public void delete(Integer cod) throws Exception {
		open();
		stmt = con.prepareStatement("DELETE FROM pessoa WHERE idPessoa = ? AND perfil = ?");
		stmt.setInt(1, cod);
		stmt.setString(2, EnumPerfil.MEDICO.toString());
		stmt.execute();
		stmt.close();
		close();
	}

	public void update(Medico medico) throws Exception {
		open();
		con.setAutoCommit(false);
		// pessoa
		stmt = con.prepareStatement("UPDATE pessoa SET nome = ?, email = ?, sexo =  ? WHERE idPessoa = ?");
		stmt.setString(1, medico.getNome());
		stmt.setString(2, medico.getEmail());
		stmt.setString(3, medico.getSexo().toString());
		stmt.setInt(4, medico.getIdPessoa());
		stmt.execute();
		// endereco
		stmt = con.prepareStatement(
				"UPDATE endereco SET logradouro = ?, bairro = ?, cidade = ?, estado = ?, cep =? WHERE idPessoa = ?");
		stmt.setString(1, medico.getEndereco().getLogradouro());
		stmt.setString(2, medico.getEndereco().getBairro());
		stmt.setString(3, medico.getEndereco().getCidade());
		stmt.setString(4, medico.getEndereco().getEstado());
		stmt.setString(5, medico.getEndereco().getCep());
		stmt.setInt(6, medico.getIdPessoa());
		stmt.execute();
		// limpando telefone
		stmt = con.prepareStatement("DELETE FROM telefonecontato WHERE idPessoa = ?");
		stmt.setInt(1, medico.getIdPessoa());
		// inserindo novos telefones
		if (medico.getLista_telefones() != null) {
			for (TelefoneContato telefone : medico.getLista_telefones()) {
				System.out.println("Telefone" + telefone.getNumero());
				stmt = con.prepareStatement("INSERT INTO telefonecontato (numero, idPessoa) VALUES (?,?) ");
				stmt.setString(1, telefone.getNumero());
				stmt.setInt(2, medico.getIdPessoa());
				stmt.execute();
			}
		}
		con.commit();
		stmt.close();
		close();
	}

	public List<Medico> findAll() throws Exception {
		open();
		List<Medico> lista_medicos = new ArrayList<Medico>();
		stmt = con.prepareStatement(
				"SELECT * FROM pessoa p, endereco e, medico m WHERE p.idPessoa = e.idPessoa AND p.idPessoa = m.idMedico AND p.perfil = ?");
		stmt.setString(1, "MEDICO");
		rs = stmt.executeQuery();
		while (rs.next()) {
			Medico medico = new Medico();
			medico.setIdPessoa(rs.getInt("idPessoa"));
			medico.setNome(rs.getString("nome"));
			medico.setEmail(rs.getString("email"));
			medico.setCrm(rs.getString("crmMedico"));
			medico.setPerfil(EnumPerfil.valueOf(rs.getString("perfil")));
			medico.setSexo(EnumSexo.valueOf(rs.getString("sexo")));
			medico.setEndereco(new Endereco(rs.getInt("idEndereco"), rs.getString("logradouro"), rs.getString("bairro"),
					rs.getString("cidade"), rs.getString("estado"), rs.getString("cep"), rs.getInt("numeroEndereco"),
					rs.getString("complemento")));

			stmt = con.prepareStatement("SELECT * FROM telefonecontato WHERE idPessoa = ?");
			stmt.setInt(1, medico.getIdPessoa());
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				TelefoneContato t = new TelefoneContato();
				t.setIdTelefone(rs.getInt("idTelefone"));
				t.setNumero(rs.getString("numero"));
				t.setPessoa(medico);
				medico.addTelefone(t);
			}

			// especialidade medico
			stmt = con.prepareStatement(
					"SELECT * FROM especialidademedica es, especialidade e WHERE es.idMedico = ? AND es.idEspecialidade = e.idEspecialidade");
			stmt.setInt(1, medico.getIdPessoa());
			rs = stmt.executeQuery();
			while (rs.next()) {
				Especialidade e = new Especialidade();
				e.setIdEspecialidade(rs.getInt("idEspecialidade"));
				e.setValorConsulta(rs.getDouble("valorConsulta"));
				e.setDescricaoEspecialidade(rs.getString("descricaoEspecialidade"));
				e.setMedico(medico);
				medico.adicionaEspecialidade(e);
			}
			lista_medicos.add(medico);

		}
		stmt.close();
		close();
		return lista_medicos;
	}

}
