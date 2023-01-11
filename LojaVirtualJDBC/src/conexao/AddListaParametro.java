package conexao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AddListaParametro {
	public static void main(String[] args) throws SQLException {
		
		String nome = "GELADEIRA";
		String descricao = "A Melhor Geladeira do mercado";
		ConnectionFactory fac = new ConnectionFactory();
		Connection con = fac.recuperarConexao();
		
		PreparedStatement st = con.prepareStatement("INSERT INTO PRODUTO (NOME, DESCRICAO) VALUES (?, ?)", PreparedStatement.RETURN_GENERATED_KEYS);
		st.setString(1, nome);
		st.setString(2, descricao);
		st.execute();
		
		ResultSet chaveGerada = st.getGeneratedKeys();
		
		while(chaveGerada.next()) {
			
			Integer id = chaveGerada.getInt(1);
			System.out.println("id e " + id);
			
		}
	}
}
