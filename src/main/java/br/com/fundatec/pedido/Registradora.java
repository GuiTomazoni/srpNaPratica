package br.com.fundatec.pedido;

import br.com.fundatec.tabeladeentrega.TabelaDeEntrega;

public class Registradora {

	public double calculaTotal(Pedido pedido) {
		TabelaDeEntrega tabelaDeEntrega = new TabelaDeEntrega();
		Desconto desconto = new Desconto();
		Double valorTotal = 0.0;
		Double valorEntrega = 0.0;
		
		valorEntrega = tabelaDeEntrega.para(pedido.getBairro());
		valorTotal = pedido.getLanche().getPreco() + valorEntrega;
		
		if(pedido.possuiDesconto()) {
			valorTotal = desconto.aplicar(pedido) + valorEntrega;
			return valorTotal;
		}else {
			return valorTotal;
		}
	}
}
