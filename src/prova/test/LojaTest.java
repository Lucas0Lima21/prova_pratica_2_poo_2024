package prova.test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

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
		Produto p1 = new Produto(1, "Camisa", 200.5, 10);
		assertEquals(1, ProdutoService.excluirproduto(p1));
	}

	private LeitorLista loja = new LeitorLista();
	@Test
	@Order(6)
	void carregaProdutoTest() {
		ProdutoService.limparTabelaProduto();
		loja.ListaProdutos();
		
		assertFalse(loja.getProdutos().size() == 0);
		assertTrue(loja.getProdutos().size() == 50);
	}
	@Test
	@Order(7)
	void listaProdutoTest() {
		ArrayList<Produto> lista = ProdutoService.listAll();
		for(Produto p : lista) {
			System.out.println(p);
		}
	}
	
	 @Test
	    public void testGerarArquivoTxt() {
	        ProdutoService.gerarArquivoTxt();

	        assertTrue(Files.exists(Paths.get("produtos.txt")));
	    }	

}
