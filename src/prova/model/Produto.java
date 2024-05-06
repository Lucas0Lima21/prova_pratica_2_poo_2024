package prova.model;

/*- Prova
    - Ler arquivo de produto, compra ou estoque.
    - Gravar a tabela no banco de dados.
    - Ler o banco de dados
    - Gravar no arquivo.
    - Tudo coberto no teste.*/
public class Produto {
	private int id;
	private String nome;
	private Estoque estoque;
	private double valor;
	
	public Produto() {
		
	}
	
	public Produto(int id, String nome, Estoque estoque, double valor) {
		this.id = id;
		this.nome = nome;
		this.estoque = estoque;
		this.valor = valor;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Estoque getEstoque() {
		return estoque;
	}
	public void setEstoque(Estoque estoque) {
		this.estoque = estoque;
	}
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
}