package dao;

import java.util.ArrayList;
import java.util.List;

import entity.Convenio;

public class DaoConvenio extends Dao {

	public void create(Convenio c) throws Exception {
		open();
		stmt = con.prepareStatement("INSERT INTO convenio (descricaoConvenio) VALUES (?)");
		stmt.setString(1, c.getDescricaoConvenio());
		stmt.execute();
		stmt.close();
		close();
	}

	public void delete(Convenio c) throws Exception {
		open();
		stmt = con.prepareStatement("DELETE FROM convenio WHERE idConvenio = ?");
		stmt.setInt(1, c.getIdConvenio());
		stmt.execute();
		stmt.close();
		close();
	}

	public void update(Convenio c) throws Exception {
		open();
		stmt = con.prepareStatement("UPDATE convenio SET descricaoConvenio = ? WHERE idConvenio = ?");
		stmt.setString(1, c.getDescricaoConvenio());
		stmt.setInt(2, c.getIdConvenio());
		stmt.execute();
		close();
	}

	public Convenio findByCode(Integer cod) throws Exception {
		open();
		Convenio c = new Convenio();
		stmt = con.prepareStatement("SELECT * FROM convenio WHERE idConvenio = ?");
		stmt.setInt(1, cod);
		rs = stmt.executeQuery();
		if (rs.next()) {
			c.setIdConvenio(rs.getInt("idConvenio"));
			c.setDescricaoConvenio(rs.getString("descricaoConvenio"));
		}
		close();
		return c;

	}

	public List<Convenio> findAll() throws Exception {
		List<Convenio> listaConvenios = new ArrayList<Convenio>();
		open();
		stmt = con.prepareStatement("SELECT * FROM convenio");
		rs = stmt.executeQuery();
		while (rs.next()) {
			Convenio c = new Convenio();
			c.setIdConvenio(rs.getInt("idConvenio"));
			c.setDescricaoConvenio(rs.getString("descricaoConvenio"));
			listaConvenios.add(c);
		}
		close();
		return listaConvenios;
	}
}
