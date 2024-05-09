package prova.model;

public class Compra {
	private int id;
	private int quantidade;
	private Produto produto;
	
	public Compra() {
		
	}
	
	public Compra(int id, int quantidade, Produto produto) {
		this.id = id;
		this.quantidade = quantidade;
		this.produto = produto;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Produto getProduto() {
		return produto;
	}
	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	public int getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
}
