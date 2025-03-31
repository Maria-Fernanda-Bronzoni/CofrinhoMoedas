package Classes;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		
		// Criação do cofrinho e do scanner para leitura de entrada do usuário
		Cofrinho meuCofrinho = new Cofrinho();
		Scanner scanner = new Scanner(System.in);
		
		// Loop principal para o menu do usuário
		while (true) {
			// Exibe o menu principal
			System.out.println("-------------------------------------");
            System.out.println(" 💰 Bem-vindo ao Cofrinho de Moedas 💰 ");
            System.out.println("-------------------------------------");
            System.out.println("| 1️-  Adicionar Moeda               |");
            System.out.println("| 2️-  Remover Moeda                 |");
            System.out.println("| 3️-  Listar Moedas                 |");
            System.out.println("| 4️-  Calcular valor total em Real  |");
            System.out.println("| 0️-  Saindo..                      |");
            System.out.println("-------------------------------------");
			
            int opcao = -1;
            
            // Tratamento de erro para entrada inválida
            try {
                opcao = scanner.nextInt();
            } catch (java.util.InputMismatchException e) {
                System.out.println("Entrada inválida! Por favor, digite um número.");
                scanner.nextLine(); // Limpa a entrada incorreta
                continue; // Volta ao início do loop
            }
			
         // Opção para adicionar moeda
			if (opcao == 1) { 
				// Exibe o submenu de escolha da moeda
				System.out.println("---------------------------------");
				System.out.println("  🌍 Escolha a moeda desejada:   ");
				System.out.println("---------------------------------");
				System.out.println("        1️-  Real (BRL)          |");
				System.out.println("        2️-  Dólar (USD)         |");
				System.out.println("        3️-  Euro (EUR)          |");
				System.out.println("---------------------------------");
				
				int tipoMoeda = -1;
				try {
					tipoMoeda = scanner.nextInt();
				} catch (java.util.InputMismatchException e) {
					System.out.println("Tipo de moeda inválido! Voltando ao menu.");
					scanner.nextLine();
					continue;
				}
				
				System.out.println("Digite o valor: ");
				
				double valor = 0;
				try {
					valor = scanner.nextDouble();
					if (valor <= 0) {
						System.out.println("Valor inválido! O valor deve ser maior que zero.");
						continue;
					}
				} catch (java.util.InputMismatchException e) {
					System.out.println("Valor inválido! Voltando ao menu.");
					scanner.nextLine();
					continue;
				}
				
				
				// Criação da moeda com base na escolha
				Moeda moeda = null;
				
				if (tipoMoeda == 1) {
					moeda = new Real(valor);
				} else if (tipoMoeda == 2) {
					moeda = new Dolar(valor);
				} else if (tipoMoeda == 3) {
					moeda = new Euro(valor);
				} 
				
				if (moeda != null) {
					meuCofrinho.adicionar(moeda);
					System.out.println("Moeda adicionada!");
				}else {
					System.out.println("Tipo de moeda inválido!");
				}
			} 
			else if (opcao == 2) {
				System.out.println("Escolha a moeda para remoção: ");
				System.out.println("1- Real");
				System.out.println("2- Dólar");
				System.out.println("3- Euro");
				
				int tipoMoedaRemover = -1;
				try {
					tipoMoedaRemover = scanner.nextInt();
				} catch (java.util.InputMismatchException e) {
					System.out.println("Tipo de moeda inválido! Voltando ao menu.");
					scanner.nextLine();
					continue;
				}
				
				System.out.println("Digite o valor a ser removido: ");
				
				double valor = 0;
				try {
					valor = scanner.nextDouble();
					if (valor <= 0) {
						System.out.println("Valor inválido! O valor deve ser maior que zero.");
						continue;
					}
				} catch (java.util.InputMismatchException e) {
					System.out.println("Valor inválido! Voltando ao menu.");
					scanner.nextLine();
					continue;
				}
				
				Moeda moedaARemover = null;
				for (Moeda moeda : meuCofrinho.getListaMoedas()) {
					// Verifica a moeda selecionada e o valor
					if ((tipoMoedaRemover == 1 && moeda instanceof Real) || 
						(tipoMoedaRemover == 2 && moeda instanceof Dolar) ||
						(tipoMoedaRemover == 3 && moeda instanceof Euro)) {
						
						// Verifica se o valor a ser removido não deixará a moeda negativa
						if (moeda.getValor() >= valor) {
							// Só remove se o valor for suficiente para a remoção
							moeda.setValor(moeda.getValor() - valor);
							moedaARemover = moeda;
							break;
						} else {
							System.out.println("Valor insuficiente para remoção.");
							break;
						}
					}
				}
				
				// Caso tenha removido a moeda ou se não encontrar a moeda
				if (moedaARemover != null) {
					// Se o valor da moeda for zero, remove a moeda do cofrinho
					if (moedaARemover.getValor() == 0) {
						meuCofrinho.remover(moedaARemover);  // Remove a moeda
					}
					System.out.println("Moeda removida!");
				} else {
					System.out.println("Moeda não encontrada.");
				}
			}

			// Opção para listar moedas no cofrinho
			else if (opcao == 3) {
				meuCofrinho.listagemMoedas();
			}
			// Opção para calcular o total em reais
			else if (opcao == 4) {
				System.out.printf("Total convertido para Real: R$ %.2f%n", meuCofrinho.calcularTotalConvertido());
			}
			// Finaliza o programa
			else if (opcao == 0) {
				System.out.println("Saindo...");
				break;
			}
			// Trata opções inválidas
			else {
				System.out.println("Opção inválida!");
			}
		}
		
		// Fecha o scanner
		scanner.close();
	}
}
