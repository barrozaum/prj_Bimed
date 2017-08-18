package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import control.CriptografaSenha;
import entity.Atendente;
import entity.Endereco;
import entity.Especialidade;
import entity.Medico;
import entity.TelefoneContato;
import type.EnumPerfil;
import type.EnumSexo;

public class DaoAtendente extends Dao {

	public void create(Atendente atendente) throws Exception {
		open();
		con.setAutoCommit(false);
		stmt = con.prepareStatement("INSERT INTO pessoa (nome,email,sexo, perfil) VALUES (?,?,?,?)",
				PreparedStatement.RETURN_GENERATED_KEYS);
		stmt.setString(1, atendente.getNome());
		stmt.setString(2, atendente.getEmail());
		stmt.setString(3, atendente.getSexo().toString());
		stmt.setString(4, atendente.getPerfil().toString());
		stmt.execute();
		rs = stmt.getGeneratedKeys();
		rs.next();
		int idPessoa = rs.getInt(1);
		// inserindo na tabela endereco
		stmt = con.prepareStatement(
				"INSERT INTO endereco (logradouro, bairro, cidade, estado, cep, numeroEndereco, complemento, idPessoa) VALUES (?,?,?,?,?,?,?,?)");
		stmt.setString(1, atendente.getEndereco().getLogradouro());
		stmt.setString(2, atendente.getEndereco().getBairro());
		stmt.setString(3, atendente.getEndereco().getCidade());
		stmt.setString(4, atendente.getEndereco().getEstado());
		stmt.setString(5, atendente.getEndereco().getCep());
		stmt.setInt(6, atendente.getEndereco().getNumeroEnd());
		stmt.setString(7, atendente.getEndereco().getComplemento());
		stmt.setInt(8, idPessoa);
		stmt.execute();

		if (atendente.getLista_telefones() != null) {
			for (TelefoneContato telefone : atendente.getLista_telefones()) {
				System.out.println("Telefone" + telefone.getNumero());
				stmt = con.prepareStatement("INSERT INTO telefonecontato (numero, idPessoa) VALUES (?,?) ");
				stmt.setString(1, telefone.getNumero());
				stmt.setInt(2, idPessoa);
				stmt.execute();
			}
		}

		// inserindo na tabela de atendentes
		stmt = con.prepareStatement("INSERT INTO atendente (idAtendente, matricula) VALUES (?,?)");
		stmt.setInt(1, idPessoa);
		stmt.setString(2, atendente.getMatricula());
		stmt.execute();

		// inserindo usuario
		String senha = CriptografaSenha.CriptografiaLogin(atendente.getPerfil().toString());
		stmt = con.prepareStatement("INSERT INTO usuario (idUsuario, login, password, perfil) VALUES (?,?,?,?)");
		stmt.setInt(1, idPessoa);
		stmt.setString(2, atendente.getEmail());
		stmt.setString(3, senha);
		stmt.setString(4, atendente.getPerfil().toString());
		stmt.execute();

		con.commit();
		stmt.close();
		close();
	}

	public Atendente findByCode(Integer cod) throws Exception {
		open();
		Atendente atendente = new Atendente();
		stmt = con.prepareStatement(
				"SELECT * FROM pessoa p, endereco e, atendente a WHERE p.idPessoa = ? AND p.idPessoa = e.idPessoa AND p.idPessoa = a.idAtendente");
		stmt.setInt(1, cod);
		rs = stmt.executeQuery();
		if (rs.next()) {
			atendente.setIdPessoa(rs.getInt("idPessoa"));
			atendente.setNome(rs.getString("nome"));
			atendente.setEmail(rs.getString("email"));
			atendente.setMatricula(rs.getString("matricula"));
			atendente.setPerfil(EnumPerfil.valueOf(rs.getString("perfil")));
			atendente.setSexo(EnumSexo.valueOf(rs.getString("sexo")));
			atendente.setEndereco(new Endereco(rs.getInt("idEndereco"), rs.getString("logradouro"),
					rs.getString("bairro"), rs.getString("cidade"), rs.getString("estado"), rs.getString("cep"),
					rs.getInt("numeroEndereco"), rs.getString("complemento")));

			// telefone contato
			stmt = con.prepareStatement("SELECT * FROM telefonecontato WHERE idPessoa = ?");
			stmt.setInt(1, atendente.getIdPessoa());
			rs = stmt.executeQuery();
			while (rs.next()) {
				TelefoneContato t = new TelefoneContato();
				t.setIdTelefone(rs.getInt("idTelefone"));
				t.setNumero(rs.getString("numero"));
				t.setPessoa(atendente);
				atendente.addTelefone(t);
			}

		}

		stmt.close();
		close();
		return atendente;
	}

	public List<Atendente> findAll() throws Exception {
		open();
		List<Atendente> lista_atendentes = new ArrayList<Atendente>();
		stmt = con.prepareStatement(
				"SELECT * FROM pessoa p, endereco e, atendente a WHERE p.idPessoa = e.idPessoa AND p.idPessoa = a.idAtendente AND p.perfil = ?");
		stmt.setString(1, "ATENDENTE");
		rs = stmt.executeQuery();
		while (rs.next()) {
			Atendente atendente = new Atendente();
			atendente.setIdPessoa(rs.getInt("idPessoa"));
			atendente.setNome(rs.getString("nome"));
			atendente.setEmail(rs.getString("email"));
			atendente.setMatricula(rs.getString("matricula"));
			atendente.setPerfil(EnumPerfil.valueOf(rs.getString("perfil")));
			atendente.setSexo(EnumSexo.valueOf(rs.getString("sexo")));
			atendente.setEndereco(new Endereco(rs.getInt("idEndereco"), rs.getString("logradouro"),
					rs.getString("bairro"), rs.getString("cidade"), rs.getString("estado"), rs.getString("cep"),
					rs.getInt("numeroEndereco"), rs.getString("complemento")));

			// telefone contato
			stmt = con.prepareStatement("SELECT * FROM telefonecontato WHERE idPessoa = ?");
			stmt.setInt(1, atendente.getIdPessoa());
			rs = stmt.executeQuery();
			while (rs.next()) {
				TelefoneContato t = new TelefoneContato();
				t.setIdTelefone(rs.getInt("idTelefone"));
				t.setNumero(rs.getString("numero"));
				t.setPessoa(atendente);
				atendente.addTelefone(t);
			}
			lista_atendentes.add(atendente);

		}
		stmt.close();
		close();
		return lista_atendentes;
	}

	public void delete(Integer cod) throws Exception {
		open();
		stmt = con.prepareStatement("DELETE FROM pessoa WHERE idPessoa = ? AND perfil = ?");
		stmt.setInt(1, cod);
		stmt.setString(2, EnumPerfil.ATENDENTE.toString());
		stmt.execute();
		stmt.close();
		close();
	}
}
