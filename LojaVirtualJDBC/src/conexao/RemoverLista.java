package conexao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class RemoverLista {
	public static void main(String[] args) throws SQLException {
		ConnectionFactory fac = new ConnectionFactory();
		Connection con = fac.recuperarConexao();
		
		Statement st = con.createStatement();
		st.execute("DELETE FROM PRODUTO WHERE ID > 4");
		
		Integer linhasAlteradas = st.getUpdateCount();
		
		System.out.println(linhasAlteradas);
		
	}

}
