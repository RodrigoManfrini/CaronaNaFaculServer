package br.com.caronanafacul.test.dao;

import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;

public class DBTools {

	public static void exportarBancoDados(Acao acao) {
		acao.execute(new Configuration());
	}

	enum Acao {
		DROP {
			@Override
			public void execute(Configuration configuration) {
				configuration.configure();
				new SchemaExport(configuration).drop(true, true);

			}
		},
		CREATE {
			@Override
			public void execute(Configuration configuration) {
				configuration.configure();
				new SchemaExport(configuration).create(true, true);
			}
		};

		public abstract void execute(Configuration configuration);
	}
}
