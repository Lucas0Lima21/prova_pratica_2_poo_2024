package prova;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import prova.model.Compra;
//import prova.model.Estoque;
import prova.model.Produto;

public class LeitorLista {
	
	private ArrayList<Produto> produtos = new ArrayList<Produto>();
//	private ArrayList<Estoque> estoque = new ArrayList<Estoque>();
	private ArrayList<Compra> compras = new ArrayList<Compra>();

	public double getTotalCompra() {
		double total = 0;
		try {
			FileReader fr = new FileReader("compra.txt");
			BufferedReader br = new BufferedReader(fr);
			String linha = "";
			while((linha = br.readLine())!=null) {
				String parts[] = linha.split(",");
				total += Double.parseDouble(parts[3]);
			}
			br.close();
			fr.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return total;
	}
	
	public void processarCompra() {
		try {
			FileWriter fw = new FileWriter("compra.txt");
			BufferedWriter bw = new BufferedWriter(fw);
//			for (Estoque estoquee : estoque) {
//				if(estoque.podeVender()) {
//					bw.append(estoque.toString());
//				}
//			}
			bw.close();
			fw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void ListaProdutos() {
		try {
			FileReader fr = new FileReader("lista_produtos.txt");
			BufferedReader br = new BufferedReader(fr);
			String linha = "";
			while((linha = br.readLine())!=null) {
				String parts[] = linha.split(",");
				int id = Integer.parseInt(parts[0]);
				String nome = parts[1];
				String vlStr = parts[2] +"."+ parts[3];
				vlStr = vlStr.replace("R$ ", "").trim();
				double valor = Double.parseDouble(vlStr);
				int  estoque = Integer.parseInt(parts[4]);
//				Estoque e = buscaEstoque(Integer.parseInt(parts[4]));
				produtos.add(new Produto(id, nome, valor, estoque));
				ProdutoService.insereProduto(new Produto(id, nome, valor, estoque));
			}
			br.close();
			fr.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void ListaCompra() {
		try {
			FileReader fr = new FileReader("lista_compras.txt");
			BufferedReader br = new BufferedReader(fr);
			String linha = "";
			while((linha = br.readLine())!=null) {
				String parts[] = linha.split(",");
				int id = Integer.parseInt(parts[0]);
				int quantidade = Integer.parseInt(parts[1]);
				Produto p = buscaProduto(parts[2]);
				compras.add(new Compra(id, quantidade, p));
				CompraService.insereCompra(new Compra(id, quantidade, p));

			}
			br.close();
			fr.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
//	public void ListaEstoque() {
//		try {
//			FileReader fr = new FileReader("lista_estoque.txt");
//			BufferedReader br = new BufferedReader(fr);
//			String linha = "";
//			while((linha = br.readLine())!=null) {
//				String parts[] = linha.split(",");
//				int id = Integer.parseInt(parts[0]);
//				Produto p = buscaProduto(parts[1]);
//				if(p != null) {
//					compra.add(new Compra(id, p, Integer.parseInt(parts[2])));
//				}
//			}
//			br.close();
//			fr.close();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
	
	private Produto buscaProduto(String nome) {
		for (Produto p : produtos) {
			if(p.getNome().equals(nome)) {
				return p;
			}
		}
		return null;
	}
	
//	private Estoque buscaEstoque(int id) {
//		for (Estoque q : estoque) {
//			if(q.getId() == id) {
//				return q;
//			}
//		}
//		return null;
//	}

	public ArrayList<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(ArrayList<Produto> produtos) {
		this.produtos = produtos;
	}

	public ArrayList<Compra> getCompras() {
		return compras;
	}

	public void setCompras(ArrayList<Compra> Compras) {
		this.compras = Compras;
	}

}