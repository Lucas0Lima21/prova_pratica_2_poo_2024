package prova;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import prova.model.Produto;

public class LeitorLista {
	
	private ArrayList<Produto> produtos = new ArrayList<Produto>();

	public void ListaProdutos() {
		try {
			FileReader fr = new FileReader("produtos.txt");
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
				produtos.add(new Produto(id, nome, valor, estoque));
				ProdutoService.insereProduto(new Produto(id, nome, valor, estoque));
			}
			br.close();
			fr.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	public ArrayList<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(ArrayList<Produto> produtos) {
		this.produtos = produtos;
	}



}