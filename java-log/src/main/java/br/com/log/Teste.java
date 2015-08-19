package br.com.log;

import org.apache.log4j.Logger;

import br.com.dao.UsuarioDAO;

public class Teste {
	public static void main(String[] args) {
		Logger logger = Logger.getLogger(Teste.class);
		logger.info("iniciando aplicação");
		logger.debug("debug here");
		
		
		Usuario usuario = new Usuario();
		usuario.nome = "user";
		usuario.email = "email";
		
		UsuarioDAO usuarioDao = new UsuarioDAO();
		usuarioDao.save(usuario);

	}
}
