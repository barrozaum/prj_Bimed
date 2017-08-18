package control;

import org.jcommon.encryption.SimpleMD5;

import entity.Pessoa;
import entity.Usuario;

public class CriptografaSenha {

	public static String CriptografiaLogin(String senha) {
		
		SimpleMD5 md5 = new SimpleMD5(senha.toUpperCase(), "igor@parvaim.com");
		return md5.toHexString();
	}

	public static void CriptografiaLogin(Usuario u) {
		SimpleMD5 md5 = new SimpleMD5(u.getPassword().toUpperCase(), "igor@parvaim.com");
		u.setPassword(md5.toHexString());
	}
}
