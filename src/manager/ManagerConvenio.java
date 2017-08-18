package manager;

import java.util.ArrayList;
import java.util.List;

import dao.DaoConvenio;
import entity.Convenio;

public class ManagerConvenio {

	private List<Convenio> listar_convenio;
	private Convenio convenio;

	public ManagerConvenio() {
		listar_convenio = new ArrayList<Convenio>();
	}

	public List<Convenio> getListar_convenio() {
		try{
			listar_convenio = new DaoConvenio().findAll();
		}catch(Exception e){
			e.printStackTrace();
		}
		return listar_convenio;
	}

	public void setListar_convenio(List<Convenio> listar_convenio) {
		this.listar_convenio = listar_convenio;
	}

	public Convenio getConvenio() {
		return convenio;
	}

	public void setConvenio(Convenio convenio) {
		this.convenio = convenio;
	}

	public void findByCode(Integer cod) {
		try {
			convenio = new DaoConvenio().findByCode(cod);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	

}
