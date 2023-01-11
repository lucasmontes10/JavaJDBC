package conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Teste {
	public static void main(String[] args) throws SQLException {
		
		Connection connection = DriverManager.
				getConnection("jdbc:mysql://localhost/loja_virtual?useTimezone=true&serverTimezone=UTC", "root", "011011");
		System.out.println("Fechando a comunicacao");
		connection.close();
				
	}
}
