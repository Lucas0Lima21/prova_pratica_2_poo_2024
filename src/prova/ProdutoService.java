package prova;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import prova.BancoDeDados.Conexao;
import prova.model.Produto;

public class ProdutoService {

	public static int insereProduto(Produto p) {
		try {
			Connection conn = Conexao.conectaMySql();
			String sql = "insert into Produto (id,nome,valor,estoque) values(?,?,?,?)";
			PreparedStatement pr = conn.prepareStatement(sql);
			pr.setInt(1, p.getId());
			pr.setString(2, p.getNome());
			pr.setDouble(3, p.getValor());
			pr.setInt(4, p.getEstoque());
			int total = pr.executeUpdate();
			
			conn.close();
			return total;
		}catch (Exception e) {
			e.printStackTrace();
			return -1;
		}
	}
	
	public static int alteraProduto(Produto p) {
		try {
			Connection conn = Conexao.conectaMySql();
			String sql = "update produto set id=?, nome=?, valor=?, estoque=? where id=?";
			PreparedStatement pr = conn.prepareStatement(sql);
			pr.setInt(1, p.getId());
			pr.setString(2, p.getNome());
			pr.setDouble(3, p.getValor());
			pr.setInt(4, p.getEstoque());
			pr.setInt(5, p.getId());
			int total = pr.executeUpdate();
			conn.close();
			return total;
		}catch (Exception e) {
			e.printStackTrace();
			return -1;
		}
	}
	
	public static int excluirproduto(Produto p) {
		try {
			Connection conn = Conexao.conectaMySql();
			String sql = "delete from produto where id=?";
			PreparedStatement pr = conn.prepareStatement(sql);
			pr.setInt(1, p.getId());
			int total = pr.executeUpdate();
			conn.close();
			return total;
		}catch (Exception e) {
			e.printStackTrace();
			return -1;
		}
	}
	public static int limparTabelaProduto() {
		try {
			Connection conn = Conexao.conectaMySql();
			String sql = "delete from produto where id > 0";
			PreparedStatement pr = conn.prepareStatement(sql);
			int total = pr.executeUpdate();
			
			sql = "ALTER TABLE produto AUTO_INCREMENT = 0";
			pr = conn.prepareStatement(sql);
			pr.executeUpdate();
			
			conn.close();
			return total;
		}catch (Exception e) {
			e.printStackTrace();
			return -1;
		}
	}
	
	public static ArrayList<Produto> listAll(){
		ArrayList<Produto> lista = new ArrayList<Produto>();
		try {
			String sql = "select * from produto";
			Connection conn = Conexao.conectaMySql();
			PreparedStatement pr = conn.prepareStatement(sql);
			ResultSet rs = pr.executeQuery();
			while(rs.next()) {
				Produto p = new Produto();
				p.setId(rs.getInt("id"));
				p.setNome(rs.getString("nome"));
				p.setValor(rs.getDouble("valor"));
				p.setEstoque(rs.getInt("estoque"));
				//p.setCidade(CidadeService.findById(rs.getInt("cidade")));
				lista.add(p);
			}
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lista;
	}
	public static Produto findById(int id){
		Produto p = new Produto();
		try {
			String sql = "select * from produto where id = ?";
			Connection conn = Conexao.conectaMySql();
			PreparedStatement pr = conn.prepareStatement(sql);
			ResultSet rs = pr.executeQuery();
			while(rs.next()) {
				p.setId(rs.getInt("id"));
				p.setNome(rs.getString("nome"));
				p.setValor(rs.getDouble("valor"));
				p.setEstoque(rs.getInt("estoque"));
			}
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return p;
	}

}