package conexao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AddListaParametro {
	public static void main(String[] args) throws SQLException {
		
		ConnectionFactory fac = new ConnectionFactory();
		Connection con = fac.recuperarConexao();
		
		con.setAutoCommit(false);
		
		try {
			PreparedStatement st = con.prepareStatement("INSERT INTO PRODUTO (NOME, DESCRICAO) VALUES (?, ?)", PreparedStatement.RETURN_GENERATED_KEYS);
			
			adicionarProduto("TV", "A melhor tv do mercado", st);
			adicionarProduto("Notebook", "O notebook mais rápido do mercado", st);
			
			con.commit();
			
			st.close();
			con.close();
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("ROOLBACK EXECUTADO");
			con.rollback();
		}
		
	}

	private static void adicionarProduto(String nome, String descricao, PreparedStatement st) throws SQLException {
		st.setString(1, nome);
		st.setString(2, descricao);
		
		if(nome.equals("TV")) {
			throw new RuntimeException("Não foi possivel add");
		}
		
		st.execute();
		
		ResultSet chaveGerada = st.getGeneratedKeys();
		
		
		while(chaveGerada.next()) {
			
			Integer id = chaveGerada.getInt(1);
			System.out.println("id e " + id);
			
		}
		chaveGerada.close();
	}
}
