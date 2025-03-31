package Classes;
//Importa a classe ArrayList para usar listas dinâmicas
import java.util.ArrayList;


public class Cofrinho {
	 // Declara uma lista privada que armazenará objetos do tipo "Moeda"
	private ArrayList<Moeda> listaMoedas;
	
	// Construtor da classe Cofrinho (inicializa a lista vazia quando o objeto é criado)
	public Cofrinho() {
		listaMoedas = new ArrayList<>();
	}
	
	 // Método para adicionar uma moeda à lista
	public void adicionar(Moeda moeda) {
		listaMoedas.add(moeda);
	}
	
	 // Método para remover uma moeda da lista
	public void remover(Moeda moeda) {
		listaMoedas.remove(moeda);
	}
	
	// Método que retorna a lista de moedas (getter)
	public ArrayList<Moeda> getListaMoedas() {
		return listaMoedas;
		
	}
	
	 // Método para listar todas as moedas do cofrinho
	public void listagemMoedas() {
		// Verifica se o cofrinho está vazio
		if (listaMoedas.isEmpty()) {
			System.out.println("O cofrinho está vazio!");
		} else {
			System.out.println("Há moedas no cofrinho!");
			// Para cada moeda na lista, chama o método info() da moeda
			for (Moeda moeda: listaMoedas) {
				moeda.info();
			}
		}

	}
	
	// Método para calcular o total de dinheiro em Reais (convertendo todas as moedas)
	public double calcularTotalConvertido( ) {
		// Inicia o total em 0
		double total = 0;
		// Para cada moeda, soma o valor convertido para Reais
		for(Moeda moeda: listaMoedas) { 
			total += moeda.converterParaReal();
		}
		// Retorna o valor total convertido
		return total;   
		
	}
}
	
