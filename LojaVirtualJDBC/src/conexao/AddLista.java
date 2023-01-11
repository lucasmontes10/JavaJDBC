package conexao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AddLista {
	public static void main(String[] args) throws SQLException {
		ConnectionFactory fac = new ConnectionFactory();
		Connection con = fac.recuperarConexao();
		
		Statement st = con.createStatement();
		st.execute("INSERT INTO PRODUTO (NOME, DESCRICAO) VALUES ('mouse', 'Mouse sem fio')", Statement.RETURN_GENERATED_KEYS);
		
		ResultSet chaveGerada = st.getGeneratedKeys();
		
		while(chaveGerada.next()) {
			
			Integer id = chaveGerada.getInt(1);
			System.out.println("id e " + id);
			
		}
		
		
	}
}
