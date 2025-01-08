package util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Restaurante {
	private Pedido pedido;
	private Prato prato;
	private List<Prato> listaDePratos = new ArrayList<>();
	private List<Pedido> listaDepedidos = new ArrayList<>();

	public Pedido getPedido() {
		return pedido;
	}

	public Prato getPrato() {
		return prato;
	}

	public List<Prato> getListaDePratos() {
		return listaDePratos;
	}

	public List<Pedido> getListaDepedidos() {
		return listaDepedidos;
	}

	public void listarPratosDisp() {
		for (Prato p : listaDePratos) {
			System.out.println(p);
		}
	}

	public void adicionarPrato(Prato prato) {
		listaDePratos.add(prato);
	}

	public void adicinarPedido(Pedido pedido) {
		listaDepedidos.add(pedido);
	}

	public Double valorTotal() {
		Double total = 0.0;
		for (Pedido p : listaDepedidos) {
			total += p.getValor();
		}
		return total;
	}

	public void exibirPedidos() {
		for (Pedido p : listaDepedidos) {
			System.out.println(p);
		}
	}

	public Prato buscarPrato(String nomeP) {

		for (Prato p : listaDePratos) {
			if (p.getNome().equals(nomeP)) {

				return p;
			}
		}
		return null;

	}

	public Map<Prato, Integer> gerarRelatorioMaisPedidos() {
	    Map<Prato, Integer> maisPedido = new HashMap<>();

	    for (Pedido pedido : listaDepedidos) {
	        for (Prato prato : pedido.getListPedido()) {
	            maisPedido.put(prato, maisPedido.getOrDefault(prato, 0) + 1);
	        }
	    }

	    return maisPedido;
	}

}
