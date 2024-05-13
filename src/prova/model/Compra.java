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
	
	public boolean podeVender() {
		return produto.getEstoque() >= quantidade;
	}
	public double subTotal() {
		return produto.getValor() * quantidade;
	}
	
	@Override
	public String toString() {
		return produto.getNome()+","+
				quantidade +","+
				produto.getValor()+","+
				subTotal()+"\n";
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	public Produto getProduto() {
		return produto;
	}
	public void setProduto(Produto produto) {
		this.produto = produto;
	}
}