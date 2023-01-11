package conexao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConexaoListagem {
public static void main(String[] args) throws SQLException {
		
		ConnectionFactory fac = new ConnectionFactory();
		
		Connection con = fac.recuperarConexao();
		
		Statement sta = con.createStatement();
		
		sta.execute("SELECT ID, NOME, DESCRICAO FROM PRODUTO");
		
		ResultSet result = sta.getResultSet();
		
		while(result.next()) {
			Integer id = result.getInt("ID");
			System.out.println(id);
			String nome = result.getString("NOME");
			System.out.println(nome);
			String descricao = result.getString("DESCRICAO");
			System.out.println(descricao);
		}
		
		
		con.close();		
	}
}
