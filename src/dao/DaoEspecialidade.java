package dao;

import java.util.ArrayList;
import java.util.List;

import entity.Especialidade;

public class DaoEspecialidade extends Dao {

	public void create(Especialidade e) throws Exception {
		open();
		stmt = con.prepareStatement("INSERT INTO especialidade (descricaoEspecialidade, valorConsulta) VALUES (?,?)");
		stmt.setString(1, e.getDescricaoEspecialidade());
		stmt.setDouble(2, e.getValorConsulta());
		stmt.execute();
		stmt.close();
		close();
	}

	public List<Especialidade> findAll() throws Exception {
		open();
		List<Especialidade> especialidades = new ArrayList<Especialidade>();
		stmt = con.prepareStatement("SELECT * FROM especialidade");
		rs = stmt.executeQuery();
		while (rs.next()) {
			Especialidade e = new Especialidade();
			e.setIdEspecialidade(rs.getInt("idEspecialidade"));
			e.setDescricaoEspecialidade(rs.getString("descricaoEspecialidade"));
			e.setValorConsulta(rs.getDouble("valorConsulta"));
			especialidades.add(e);
		}
		close();
		return especialidades;

	}

	public Especialidade findByCode(Integer cod) throws Exception {
		open();
		Especialidade e = new Especialidade();
		stmt = con.prepareStatement("SELECT * FROM especialidade WHERE idEspecialidade = ?");
		stmt.setInt(1, cod);
		rs = stmt.executeQuery();
		if (rs.next()) {
			e.setIdEspecialidade(rs.getInt("idEspecialidade"));
			e.setDescricaoEspecialidade(rs.getString("descricaoEspecialidade"));
			e.setValorConsulta(rs.getDouble("valorConsulta"));
		}
		close();
		return e;
	}
	
	public void update(Especialidade e) throws Exception{
		open();
		stmt = con.prepareStatement("UPDATE especialidade SET descricaoEspecialidade = ?, valorConsulta = ? WHERE idEspecialidade = ?");
		stmt.setString(1, e.getDescricaoEspecialidade());
		stmt.setDouble(2, e.getValorConsulta());
		stmt.setInt(3, e.getIdEspecialidade());
		stmt.execute();
		stmt.close();
		close();
	}
	
	public void delete(Especialidade e) throws Exception{
		open();
		stmt = con.prepareStatement("DELETE FROM especialidade WHERE idEspecialidade = ?");
		stmt.setInt(1, e.getIdEspecialidade());
		stmt.execute();
		stmt.close();
		close();
	}
	
}
