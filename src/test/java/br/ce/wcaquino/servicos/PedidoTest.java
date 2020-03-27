package br.ce.wcaquino.servicos;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import br.ce.wcaquino.desconto.Calcular1Desconto;
import br.ce.wcaquino.desconto.Calcular2Desconto;
import br.ce.wcaquino.desconto.Calcular3Desconto;
import br.ce.wcaquino.desconto.CalcularDesconto;
import br.ce.wcaquino.desconto.SemDesconto;
import br.ce.wcaquino.servicos.Pedido;

public class PedidoTest {
	
	private Pedido pedido;
	
	@Before
	public void setUp() {
		CalcularDesconto calcDesc=
				new Calcular3Desconto(
						new Calcular2Desconto( 
									new Calcular1Desconto( 
											new SemDesconto(null))));
						
		pedido = new Pedido(calcDesc);
	

	}

	protected void assertResumoPedido(double valorTotal, double desconto) {
		ResumoPedido resumoPedido = pedido.resumo();
		assertEquals(valorTotal,  resumoPedido.getValorTotal(), 0.0001);
		assertEquals(desconto, resumoPedido.getDesconto(), 0.001);
	}
	
	@Test
	public void devePermitirAddItem()throws Exception{
		pedido.adicionarItem(new ItemPedido("Sabonete", 3.0, 10));
		
	}
	
	
	@Test
	public void deveCalcularValorTotalEDescontoParaPedidoVazio() throws Exception{
		assertResumoPedido(0.0, 0.0);
		
	}

	
	@Test
	public void deveCalcularResumoParaItemSemDesconto() throws Exception{
		pedido.adicionarItem(new ItemPedido("Sabonete", 5.0, 5));
		assertResumoPedido(25.0, 0.0);
	}
	
	@Test
	public void deveCalcularResumoParaDoisItensSemDesconto()throws Exception{
		pedido.adicionarItem(new ItemPedido("Sabonete", 3.0, 3));
		pedido.adicionarItem(new ItemPedido("Creme Dental", 7.0, 3));
		
		assertResumoPedido(30.0, 0.0);

	}
	
	@Test
	public void deveAplicarDescontoNa1aFaixa() throws Exception{
		pedido.adicionarItem(new ItemPedido("Creme", 20.0, 20));
		assertResumoPedido(400.0, 16.0);
	}
	
	@Test
	public void deveAplicarDescontoNa2aFaixa() throws Exception{
		pedido.adicionarItem(new ItemPedido("Shampoo", 15.0, 30));
		pedido.adicionarItem(new ItemPedido("Óleo", 15.0, 30));
		assertResumoPedido(900.0, 54.0);
		
	}
	@Test
	public void deveAplicarDescontoNa3aFaixa() throws Exception{
		pedido.adicionarItem(new ItemPedido("Shampoo", 15.0, 30));
		pedido.adicionarItem(new ItemPedido("Óleo", 15.0, 30));
		pedido.adicionarItem(new ItemPedido("Sabonete", 10.0, 30));
		assertResumoPedido(1200.0, 96.0);
		
	}
	
	
	
}
