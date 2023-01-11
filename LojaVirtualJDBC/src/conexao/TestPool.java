package conexao;

import java.sql.SQLException;

public class TestPool {
	 public static void main(String[] args) throws SQLException {
		ConnectionFactory con = new ConnectionFactory();
		
		for (int i = 0; i < 20; i++) {
			con.recuperarConexao();
			System.out.println("Essa conexao foi a de numero " + i);
		}
	}
}
