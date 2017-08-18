package dao;

import entity.Usuario;

public class DaoLogin extends Dao {

	public Usuario existeUsuario(Usuario u) throws Exception {
		open();
		Usuario usuario_logado = null;
		
		stmt = con.prepareStatement("SELECT * FROM usuario WHERE login = ? AND password = ?");
		stmt.setString(1, u.getNomeUsuario());
		stmt.setString(2, u.getPassword());
		rs = stmt.executeQuery();
		if(rs.next()){
			usuario_logado = new Usuario();
			usuario_logado.setIdUsuario(rs.getInt("idUsuario"));
			usuario_logado.setNomeUsuario(rs.getString("login"));
			usuario_logado.setPassword(rs.getString("password"));
			
		}
		close();
		return usuario_logado;
	}
}
