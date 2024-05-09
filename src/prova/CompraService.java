package prova;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import prova.BancoDeDados.Conexao;
import prova.model.Compra;
public class CompraService {

	public static int insereCompra(Compra c) {
		try {
			Connection conn = Conexao.conectaMySql();
			String sql = "insert into compra (id,quantidade,produto) values(?,?,?)";
			PreparedStatement pr = conn.prepareStatement(sql);
			pr.setInt(1, c.getId());
			pr.setInt(2, c.getQuantidade());
			pr.setInt(3, c.getProduto().getId());
			int total = pr.executeUpdate();
			conn.close();
			return total;
		}catch (Exception e) {
			e.printStackTrace();
			return -1;
		}
	}
	
	public static int alteraCompra(Compra c) {
		try {
			Connection conn = Conexao.conectaMySql();
			String sql = "update compra set id=?, quantidade=?, produto=? where id=?";
			PreparedStatement pr = conn.prepareStatement(sql);
			pr.setInt(1, c.getId());
			pr.setInt(5, c.getId());
			pr.setInt(4, c.getQuantidade());
			pr.setInt(5, c.getId());
			int total = pr.executeUpdate();
			conn.close();
			return total;
		}catch (Exception e) {
			e.printStackTrace();
			return -1;
		}
	}
	
	public static int excluirproduto(Compra c) {
		try {
			Connection conn = Conexao.conectaMySql();
			String sql = "delete from compra where id=?";
			PreparedStatement pr = conn.prepareStatement(sql);
			pr.setInt(1, c.getId());
			int total = pr.executeUpdate();
			conn.close();
			return total;
		}catch (Exception e) {
			e.printStackTrace();
			return -1;
		}
	}
	public static int limparTabelaCompra() {
		try {
			Connection conn = Conexao.conectaMySql();
			String sql = "delete from compra where id > 0";
			PreparedStatement pr = conn.prepareStatement(sql);
			int total = pr.executeUpdate();
			
			sql = "ALTER TABLE compra AUTO_INCREMENT = 0";
			pr = conn.prepareStatement(sql);
			pr.executeUpdate();
			
			conn.close();
			return total;
		}catch (Exception e) {
			e.printStackTrace();
			return -1;
		}
	}
	
	public static ArrayList<Compra> listAll(){
		ArrayList<Compra> lista = new ArrayList<Compra>();
		try {
			String sql = "select * from produto";
			Connection conn = Conexao.conectaMySql();
			PreparedStatement pr = conn.prepareStatement(sql);
			ResultSet rs = pr.executeQuery();
			while(rs.next()) {
				Compra c = new Compra();
				c.setId(rs.getInt("id"));
				c.setQuantidade(rs.getInt("quantidade"));
				c.setProduto(ProdutoService.findById(rs.getInt("produto")));
				lista.add(c);
			}
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lista;
	}

}