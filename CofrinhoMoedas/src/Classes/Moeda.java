package Classes;

//Define uma classe abstrata chamada Moeda
public abstract class Moeda {
	// Atributos protegidos que armazenam o valor da moeda e a taxa de conversão
	protected double valor;
	protected double taxaConversao;
	
	// Construtor da classe que define o valor e a taxa de conversão ao criar uma moeda
	public Moeda(double valor, double taxaConversao) {
		// Define o valor da moeda
		this.valor = valor;
		 // Define a taxa de conversão para reais
		this.taxaConversao = taxaConversao;
	}

	// Método abstrato para exibir informações da moeda
	public abstract void info();
	
	// Método abstrato para converter a moeda para Real
	public abstract double converterParaReal();
	
	// Método para obter o valor da moeda
	public double getValor() {
		return valor;
	}
	
	 // Método para alterar o valor da moeda
	public void setValor(double novoValor) {
		this.valor = novoValor;
	}
	
}
