package principal;

import java.util.Locale;
import java.util.Scanner;

import util.Pedido;
import util.Prato;
import util.Restaurante;

public class Principal {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		Integer escolha = 0;
		Restaurante restaurante = new Restaurante();

		restaurante.adicionarPrato(new Prato("feijoada", 25.00));
		restaurante.adicionarPrato(new Prato("sopa", 15.00));
		restaurante.adicionarPrato(new Prato("marmitinha", 35.00));

		System.out.println();

		while (escolha != 6) {

			System.out.println("o que vc deseja fazer:\n" + "1.Cadastrar pratos: \n"
					+ "2.Registrar pedidos de clientes: \n" + "3.Gerenciar pedidos: \n"
					+ "4.Listar pratos disponíveis no cardápio: \n" + "5.Relatórios: \n" + "6.sair \n");
			escolha = sc.nextInt();
			sc.nextLine();
			switch (escolha) {
			case 1:
				System.out.println("nome do prato: ");
				String nomeP = sc.nextLine();
				System.out.println("valor do prato: ");
				Double valor = sc.nextDouble();
				restaurante.adicionarPrato(new Prato(nomeP, valor));
				break;
			case 2:
				System.out.print("Nome do cliente: ");
				String nomeCliente = sc.nextLine();
				Pedido novoPedido = new Pedido(nomeCliente);

				boolean continuarPedido = true;
				while (continuarPedido) {
					System.out.println("\nO que deseja fazer no pedido:\n" + "1. Adicionar prato\n"
							+ "2. Remover prato\n" + "3. Finalizar pedido\n" + "4. Cancelar pedido");
					int escolhaPedido = sc.nextInt();
					sc.nextLine();

					switch (escolhaPedido) {
					case 1:
						System.out.print("Nome do prato: ");
						String nomePratoEscolhido = sc.nextLine();

						Prato pratoEncontrado = restaurante.buscarPrato(nomePratoEscolhido);
						if (pratoEncontrado != null) {
							novoPedido.adiconarPrato(pratoEncontrado);
							System.out.println("Prato " + nomePratoEscolhido + " adicionado ao pedido!");
						} else {
							System.out.println("Prato não encontrado no cardápio.");
						}
						break;

					case 2:
						System.out.print("Nome do prato: ");
						String nomePratoRemover = sc.nextLine();

						if (novoPedido.removerPrato(new Prato(nomePratoRemover, 0.0))) {
							System.out.println("Prato " + nomePratoRemover + " removido do pedido!");
						} else {
							System.out.println("Prato não encontrado no pedido.");
						}
						break;

					case 3:
						restaurante.adicinarPedido(novoPedido);
						System.out.println("Pedido finalizado e registrado!");
						continuarPedido = false;
						break;

					case 4:
						System.out.println("Pedido cancelado.");
						continuarPedido = false;
						break;

					default:
						System.out.println("Opção inválida.");
					}
				}
				break;
			case 3:
				System.out.println("o que deseja fazer:\n" + "1.vizualizar pedidos:\n" + "2.calcular total:");
				Integer oqfazer = sc.nextInt();
				switch (oqfazer) {
				case 1:
					restaurante.exibirPedidos();
					break;
				case 2:
					Double total = restaurante.valorTotal();
					System.out.println("total dos pedidos ate o momento: " + total);
					break;
				default:
					System.out.println("opção invalida");
					break;
				}

				break;

			case 4:
				restaurante.listarPratosDisp();
				break;
			case 5:
				Double total = restaurante.valorTotal();
				System.out.println("total dos pedidos ate o momento: " + total);
				System.out.println("prato mais vendido:" + restaurante.gerarRelatorioMaisPedidos());
				break;
			case 6:
				System.out.println("saindo...");
				break;
			default:
				System.out.println("opção invalida: ");
				break;

			}

		}

		sc.close();

	}

}
