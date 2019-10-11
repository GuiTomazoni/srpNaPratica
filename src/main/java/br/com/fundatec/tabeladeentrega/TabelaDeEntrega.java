package br.com.fundatec.tabeladeentrega;

import br.com.fundatec.pedido.Bairro;

public class TabelaDeEntrega {

	public double para(Bairro bairro) {

		switch (bairro) {

			case VILA_NOVA:
				return 5;
			case CAMPO_NOVO:
				return 8;
			case CAVALHADA:
				return 10;
			default:
				break;
		}
		return 15;
	}
}
