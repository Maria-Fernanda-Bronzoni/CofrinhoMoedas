package Classes;

public class Dolar extends Moeda {
	
	
	// Construtor da classe Dólar, que chama o construtor da superclasse (Moeda)
	// Define o valor da moeda e a taxa de conversão para reais
	public Dolar(double valor) {
		super(valor, 5.0);
	}

	// Método que imprime as informações da moeda
	@Override
	public void info() {
		System.out.println("Moeda: Dólar | Valor: US$ " + valor);
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