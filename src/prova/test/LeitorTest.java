package prova.test;


import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import java.io.File;


import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import prova.CompraService;
import prova.LeitorLista;
import prova.ProdutoService;
import prova.BancoDeDados.Conexao;


@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class LeitorTest {
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
	
	private LeitorLista loja = new LeitorLista();
	@Test
	@Order(3)
	void carregaProdutoTest() {
		loja.ListaProdutos();
		
		assertFalse(loja.getProdutos().size() == 0);
		assertTrue(loja.getProdutos().size() == 50);
	}
	@Test
	@Order(4)
	void carregaCompraTest() {
		

		loja.ListaCompra();
		
		assertFalse(loja.getCompras().size() == 0);
		assertTrue(loja.getCompras().size() >= 4);
		
	}
	@Test
	@Order(4)
	void carregaCompraProcessadaTest() {
	
		loja.processarCompra();
		loja.getTotalCompra();
		assertTrue(new File("Compra.txt").exists());
	}

}
