package util;

public class Prato {

	private String nome;
	private Double valor;
	public Prato(String nome, Double valor) {
		this.nome = nome;
		this.valor = valor;
	}
	public String getNome() {
		return nome;
	}
	public Double getValor() {
		return valor;
	}
	@Override
	public String toString() {
		return "nome:" + nome + ", valor:" + valor ;
	}
	
	
	
	
	
}
