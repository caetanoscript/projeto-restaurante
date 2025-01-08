package util;

import java.util.ArrayList;
import java.util.List;

public class Pedido {

	private String nomeCliente;
	private List<Prato> listPedido;
	
	public Pedido(String nomeCliente) {
		this.nomeCliente = nomeCliente;
		this.listPedido = new ArrayList<>();
	}
	public Pedido() {
		  this.listPedido = new ArrayList<>();
	}
	
	public String getNomeCliente() {
		return nomeCliente;
	}


	public List<Prato> getListPedido() {
		return listPedido;
	}

	public void adiconarPrato(Prato prato) {
		listPedido.add(prato);
	}

	public boolean removerPrato(Prato prato) {
		return listPedido.remove(prato);
	}
	
	private String exibirListaDePratos() {
	    if (listPedido == null || listPedido.isEmpty()) {
	        return "Nenhum prato adicionado";
	    }

	    StringBuilder sb = new StringBuilder();
	    for (Prato prato : listPedido) {
	        sb.append(prato.getNome()).append(" (R$ ").append(String.format("%.2f", prato.getValor())).append("), ");
	    }
	    sb.setLength(sb.length() - 2);
	    return sb.toString();
	}
	
	
	@Override
	public String toString() {
		return "Pedido: nome: " + nomeCliente + ", listPedido=" + exibirListaDePratos() ;
	}
	public Double getValor() {
		Double total = 0.0;
		for(Prato p : listPedido) {
			total += p.getValor();
		}
		return total;

	}
	
	
	
	
	
}
