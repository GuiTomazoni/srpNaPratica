package br.com.fundatec.srpNaPratica;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import br.com.fundatec.pedido.Bairro;
import br.com.fundatec.pedido.Desconto;
import br.com.fundatec.pedido.Lanche;
import br.com.fundatec.pedido.Pedido;
import br.com.fundatec.pedido.Registradora;
import br.com.fundatec.tabeladeentrega.TabelaDeEntrega;

public class LancheTest {

	@Test
	public void deveRegistrarUmPedido() {
		Desconto desconto = new Desconto(false);
		Registradora registradora = new Registradora();
		Lanche lanche = new Lanche("Xis-Coração", 18.00);
		Pedido pedido = new Pedido(lanche, desconto, Bairro.CAMPO_NOVO);

		double valorCalculado = registradora.calculaTotal(pedido);
		double valorFinalEsperado = calculaValorTotalEsperado(pedido);

		assertEquals("Xis-Coração", lanche.getNome());
		assertEquals(new Double(18.00), lanche.getPreco());
		assertEquals(Bairro.CAMPO_NOVO, pedido.getBairro());
		assertEquals(false, pedido.possuiDesconto());
		assertEquals(valorFinalEsperado, valorCalculado, 0);

	}

	@Test
	public void deveAplicarDesconto() {
		Desconto desconto = new Desconto(true);
		Registradora registradora = new Registradora();
		Lanche lanche = new Lanche("Xis-Coração", 18.00);
		Pedido pedido = new Pedido(lanche, desconto, Bairro.CAVALHADA);
	
		double valorCalculado = registradora.calculaTotal(pedido);
		double valorFinalEsperado = calculaValorTotalEsperado(pedido);

		assertEquals("Xis-Coração", lanche.getNome());
		assertEquals(true, pedido.possuiDesconto());
		assertEquals(valorFinalEsperado, valorCalculado, 0);
	}
	
	@Test
	public void deveManterApenasUmDescontoCasoTentemAplicarNovamente() {
		Desconto desconto = new Desconto(true);
		Registradora registradora = new Registradora();
		Lanche lanche = new Lanche("Xis-Coração", 18.00);
		Pedido pedido = new Pedido(lanche, desconto, Bairro.VILA_NOVA);
	
		double valorCalculado = registradora.calculaTotal(pedido) - desconto.aplicar(pedido);
		double valorFinalEsperado = calculaValorTotalEsperado(pedido);

		assertEquals("Xis-Coração", lanche.getNome());
		assertEquals(true, pedido.possuiDesconto());
		assertEquals(valorFinalEsperado, valorCalculado, 0);
	}

	private double calculaValorTotalEsperado(Pedido pedido) {
		Desconto desconto = new Desconto();
		pedido.getDesconto().setAplicado(false);
		double entregaEsperada = calculaValorDeEntregaEsperado(pedido.getBairro());
		double valorTotalEsperado = entregaEsperada + pedido.getLanche().getPreco();
		if (pedido.possuiDesconto()) {
			return valorTotalEsperado = entregaEsperada + desconto.aplicar(pedido);
		} else {
			return valorTotalEsperado;
		}
	}

	private double calculaValorDeEntregaEsperado(Bairro bairro) {
		switch (bairro) {
		case VILA_NOVA:
			return new TabelaDeEntrega().para(bairro);
		case CAMPO_NOVO:
			return new TabelaDeEntrega().para(bairro);
		case CAVALHADA:
			return new TabelaDeEntrega().para(bairro);
		default:
			return 0;
		}
	}
}
