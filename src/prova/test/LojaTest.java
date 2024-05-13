package prova.test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.util.ArrayList;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import prova.CompraService;
import prova.LeitorLista;
import prova.ProdutoService;
import prova.BancoDeDados.Conexao;
import prova.model.Compra;
import prova.model.Produto;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class LojaTest {
	
	@BeforeAll
	@Order(1)
	static void inicializa() {
		CompraService.limparTabelaCompra();
		ProdutoService.limparTabelaProduto();
	}
	
	@Test
	@Order(2)
	void conexaoTest() {
		assertNotNull(Conexao.conectaMySql());
	}
	
	@Test
	@Order(3)
	void insereProdutotest__Inexistente() {
		Produto p1 = new Produto(0, "Mochila", 200.5, 10);
		assertEquals(1, ProdutoService.insereProduto(p1));
		Produto p2 = new Produto(2, "Oculos", 550.8, 15);
		assertEquals(1, ProdutoService.insereProduto(p2));
		Produto p3 = new Produto(3, "jogo", 100, 15);
		assertEquals(1, ProdutoService.insereProduto(p3));
		//Inexistente
		Produto p4 = new Produto(1, "jogo", 50.8, 15);
		assertEquals(-1, ProdutoService.insereProduto(p4));
	}
	@Test
	@Order(4)
	void alterarProdutotest() {
		Produto p1 = new Produto(1, "Camisa", 200.5, 10);
		assertEquals(1,ProdutoService.alteraProduto(p1));
	}
	
	@Test
	@Order(5)
	void excluirProdutotest() {
		Produto p2 = new Produto(2, "Oculos", 550.8, 15);
		assertEquals(1, ProdutoService.excluirproduto(p2));
	}

	
	@Test
	@Order(6)
	void listaProdutoTest() {
		ArrayList<Produto> lista = ProdutoService.listAll();
		for(Produto p : lista) {
			System.out.println(p);
		}
	}

	@Test
	@Order(7)
	void insereCompratest() {
		Produto p1 = new Produto(1, "Camisa", 200.5, 10);
		Compra c1 = new Compra(0, 1, p1);
		assertEquals(1, CompraService.insereCompra(c1));
		Compra c2 = new Compra(2, 10, new Produto(3, "jogo", 100, 15));
		assertEquals(1, CompraService.insereCompra(c2));

	}

	@Test
	@Order(8)
	void alterarCompra() {
		Compra c1 = new Compra(1, 8, new Produto(1, "Camisa", 200.5, 10));
		assertEquals(1, CompraService.alteraCompra(c1));
		
	}
	@Test
	@Order(9)
	void ExcluirCompra() {
		Compra c2 = new Compra(2, 10, new Produto(3, "jogo", 100, 15));
		assertEquals(1, CompraService.excluirCompra(c2));
		
	}
	@Test
	@Order(10)
	void listaCompraTest() {
		ArrayList<Compra> lista = CompraService.listAll();
		for(Compra c : lista) {
			System.out.println(c);
		}
	}
	private LeitorLista loja = new LeitorLista();
	@Test
	@Order(11)
	void carregaProdutoTest() {
		loja.ListaProdutos();
		
		assertFalse(loja.getProdutos().size() == 0);
		assertTrue(loja.getProdutos().size() == 50);
	}
//	@Test
//	@Order(14)
//	void carregaCompraTest() {
//		
//
//		loja.ListaCompra();
//		
//		assertFalse(loja.getCompras().size() == 0);
//		assertTrue(loja.getCompras().size() >= 4);
//		
//	}
//	@Test
//	@Order(15)
//	void carregaCompraProcessadaTest() {
//	
//		loja.processarCompra();
//		loja.getTotalCompra();
//		assertTrue(new File("Compra.txt").exists());
//	}

}
