package br.com.caronanafacul.test.dao;

import br.com.caronanafacul.test.dao.DBTools.Acao;

public class DropRepository {
	public static void main(String[] args) {
		DBTools.exportarBancoDados(Acao.DROP);
	}
}	