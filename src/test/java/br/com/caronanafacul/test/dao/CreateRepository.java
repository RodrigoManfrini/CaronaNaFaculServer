package br.com.caronanafacul.test.dao;

import br.com.caronanafacul.test.dao.DBTools.Acao;

public class CreateRepository {
	public static void main(String[] args) {
		DBTools.exportarBancoDados(Acao.CREATE);
	}
}