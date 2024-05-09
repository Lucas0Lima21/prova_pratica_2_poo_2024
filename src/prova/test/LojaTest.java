package prova.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import prova.CompraService;
import prova.LeitorLista;
import prova.ProdutoService;
import prova.BancoDeDados.Conexao;
import prova.model.Produto;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class LojaTest {
	
	@BeforeAll
	@Order(1)
	static void inicializa() {
		ProdutoService.limparTabelaProduto();
		CompraService.limparTabelaCompra();
	}
	
	@Test
	@Order(2)
	void conexaoTest() {
		assertNotNull(Conexao.conectaMySql());
	}
	
	@Test
	@Order(3)
	void insereProdutotest() {
		Produto p1 = new Produto(0, "Mochila", 200.5, 10);
		assertEquals(1, ProdutoService.insereProduto(p1));
		Produto p2 = new Produto(2, "Oculos", 550.8, 15);
		assertEquals(1, ProdutoService.insereProduto(p2));
	}
	@Test
	@Order(4)
	void alterarProdutotest() {
		Produto p = new Produto(1, "Camisa", 200.5, 10);
		assertEquals(1,ProdutoService.alteraProduto(p));
	}
	
	@Test
	@Order(5)
	void alterarProdutoInexiste() {
		Produto p = new Produto(25, "Camisa", 200.5, 10);
		assertEquals(0,ProdutoService.alteraProduto(p));
	}
	private LeitorLista loja = new LeitorLista();

	@Test
	void carregaProdutoTest() {
		loja.ListaProdutos();
		
		assertFalse(loja.getProdutos().size() == 0);
		assertTrue(loja.getProdutos().size() == 50);
		
		loja.ListaCompra();
		
		assertFalse(loja.getCompras().size() == 0);
		//assertTrue(loja.getCompras().size() == 20);
	}
	
//	@Test
//	@Order(6)
//	void excluirCidadetestnexiste() {
//		Cidade c = new Cidade(1,"","");
//		assertEquals(0,CidadeService.excluirCidade(c));
//	}
//	
//	@Test
//	@Order(7)
//	void listaCidadeTest() {
//		ArrayList<Cidade> lista = CidadeService.listall();
//		for(Cidade c : lista) {
//			System.out.println(c);
//		}
//	}
//	@Test
//	@Order(8)
//	void insereCliente() {
//		Cliente c = new Cliente(0, "A", 11,"M",new Cidade(1,"Orleans","SC"));
//		assertEquals(1, ClienteService.insereCliente(c));
//		
//	}
//	@Test
//	@Order(9)
//	void alterarCliente() {
//		Cliente c = new Cliente(1, "A", 11,"M",new Cidade(1,"Sao Paulo","SC"));
//		assertEquals(1, ClienteService.alteraCliente(c));
//		
//	}
//	@Test
//	@Order(10)
//	void listaClienteTest() {
//		ArrayList<Cliente> lista = ClienteService.listall();
//		for(Cliente c : lista) {
//			System.out.println(c);
//		}
//	}

}

