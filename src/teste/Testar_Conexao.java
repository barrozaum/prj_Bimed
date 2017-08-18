package teste;

import dao.Dao;

public class Testar_Conexao {

	public static void main(String[] args) {
		try {
			Dao d = new Dao();
			d.open();
			System.out.println("Conectado");
			d.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
