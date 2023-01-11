package conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class ConnectionFactory {
	
	public DataSource dataSource;
	
	public ConnectionFactory() {
		ComboPooledDataSource comboPool = new ComboPooledDataSource();
		comboPool.setJdbcUrl("jdbc:mysql://localhost/loja_virtual?useTimezone=true&serverTimezone=UTC");
		comboPool.setUser("root");
		comboPool.setPassword("011011");
		
		comboPool.setMaxPoolSize(15);
		
		this.dataSource = comboPool;
	}
	
	public Connection recuperarConexao() throws SQLException {
		return this.dataSource.getConnection();
	}
}
