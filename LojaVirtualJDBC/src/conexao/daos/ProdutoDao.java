package conexao.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import conexao.models.Produto;

public class ProdutoDao {
	private Connection con;
	
	public ProdutoDao(Connection con) {
		this.con = con;
	}
	
	public void salvar(Produto produto) throws SQLException {
		String sql = "INSERT INTO PRODUTO (NOME, DESCRICAO) VALUES (?, ?)";
		
		try(PreparedStatement pstm = this.con.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)){
			pstm.setString(1, produto.getNome());
			pstm.setString(2, produto.getDescricao());
			
			pstm.execute();
			
			try(ResultSet result = pstm.getGeneratedKeys()){
				while(result.next()) {
					produto.setId(result.getInt(1));
				}
				
			}
			
		}
	}
	
	public List<Produto> listar() throws SQLException {
		List<Produto> produtos = new ArrayList<>();
		
		String sql = "SELECT * FROM PRODUTO;";
		
		try(PreparedStatement pstm = this.con.prepareStatement(sql)){
			pstm.execute();
			
			try(ResultSet result = pstm.getResultSet()){
				while(result.next()) {
					Produto produto = new Produto(result.getInt(1), result.getString(2), result.getString(3));
					produtos.add(produto);
				}
			}
		}
		return produtos;
		
	}
}
