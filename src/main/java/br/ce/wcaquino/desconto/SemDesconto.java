package br.ce.wcaquino.desconto;

public class SemDesconto extends CalcularDesconto {

	public SemDesconto(CalcularDesconto proximo) {
		super(proximo);
		// TODO Auto-generated constructor stub
	}


	@Override
	protected double calcular(double valorTotal) {
		
			return 0;
		
		
		

	}
}
