package br.com.dao;

import org.apache.log4j.Logger;

import br.com.log.Usuario;

public class UsuarioDAO {
	Logger logger = Logger.getLogger(UsuarioDAO.class);

	public void save(Usuario user) {
		logger.info("usuario salvo no banco com sucesso");
	}

}
