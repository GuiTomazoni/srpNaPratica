package br.com.fundatec.srpNaPratica;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import br.com.fundatec.srpnapratica.Bairro;
import br.com.fundatec.srpnapratica.Lanche;
import br.com.fundatec.tabeladeentrega.TabelaDeEntrega;

public class LancheTest {

	@Test
	public void deveRegistrarUmPedido() {
		Lanche lanche = new Lanche("Xis-Coração", 18.00, Bairro.CAMPO_NOVO, false);

		double valorCalculado = lanche.calculaTotal(lanche);
		double valorFinalEsperado = calculaValorTotalEsperado(lanche);

		assertEquals("Xis-Coração", lanche.getNome());
		assertEquals(new Double(18.00), lanche.getPreco());
		assertEquals(Bairro.CAMPO_NOVO, lanche.getBairro());
		assertEquals(false, lanche.getDesconto());
		assertEquals(valorFinalEsperado, valorCalculado, 0);

	}

	@Test
	public void deveAplicarDesconto() {
		Lanche lanche = new Lanche("Xis-Coração", 18.00, Bairro.VILA_NOVA, true);
		lanche.aplicaDesconto();
	
		double valorCalculado = lanche.calculaTotal(lanche);
		double valorFinalEsperado = calculaValorTotalEsperado(lanche);

		assertEquals("Xis-Coração", lanche.getNome());
		assertEquals(true, lanche.getDesconto());
		assertEquals(valorFinalEsperado, valorCalculado, 0);
	}
	
	@Test
	public void deveManterOPrecoCasoApliqueDescontoSemPossuir() {
		Lanche lanche = new Lanche("Xis-Coração", 18.00, Bairro.CAVALHADA, false);
		lanche.aplicaDesconto();
	
		double valorCalculado = lanche.calculaTotal(lanche);
		double valorFinalEsperado = calculaValorTotalEsperado(lanche);

		assertEquals("Xis-Coração", lanche.getNome());
		assertEquals(false, lanche.getDesconto());
		assertEquals(valorFinalEsperado, valorCalculado, 0);
	}

	private double calculaValorTotalEsperado(Lanche lanche) {
		double entregaEsperada = calculaValorDeEntregaEsperado(lanche.getBairro());
		double valorTotalEsperado = entregaEsperada + lanche.getPreco();
		if (lanche.getDesconto()) {
			return valorTotalEsperado = valorTotalEsperado - lanche.aplicaDesconto();
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
