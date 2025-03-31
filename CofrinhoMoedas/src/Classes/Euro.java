package Classes;

public class Euro extends Moeda {
	
	
	// Construtor da classe Euro, que chama o construtor da superclasse (Moeda)
	// Define o valor da moeda e a taxa de conversão para reais
	public Euro(double valor) {
		super(valor, 6.0);
	}

	// Método que imprime as informações da moeda
	@Override
	public void info() {
		System.out.println("Moeda: Euro | Valor: € " + valor);
	}

	// Método que converte o valor da moeda para reais
	@Override
	public double converterParaReal( ) {
		return this.valor * this.taxaConversao;
	}
	
	// Método para alterar o valor da moeda
	public void setValor(double novoValor) {
		this.valor = novoValor;
	}
	
}
