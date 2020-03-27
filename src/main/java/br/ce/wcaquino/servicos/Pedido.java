package br.ce.wcaquino.servicos;

import java.util.ArrayList;
import java.util.List;

import br.ce.wcaquino.desconto.CalcularDesconto;

public class Pedido {
	

	private List<ItemPedido> itens = new ArrayList<>();
	
	private CalcularDesconto calcularDesconto;
	
	public Pedido(CalcularDesconto calcularDesconto) {
		this.calcularDesconto = calcularDesconto;
	}
			
	public void adicionarItem(ItemPedido itemPedido) {
		itens.add(itemPedido);
		
	}
	
	public ResumoPedido resumo() {
		double valorTotal =  itens.stream().mapToDouble(i -> i.getValorUnitario() * i.getQuantidade()).sum();
		double desconto = calcularDesconto.desconto(valorTotal);
		
		
		
		
		
		return new ResumoPedido(valorTotal, desconto);
	}
	

	

}
