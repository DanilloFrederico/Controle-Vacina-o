package TabelasDeVacinacao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoBancoDados {
	
	public Connection ObtenhaConexao() 
	{
		try 
		{
			return DriverManager.getConnection("jdbc:sqlserver://localhost:1433; databaseName=BancoVacinacao;user=teste;password=123");
		} 
		catch (SQLException e) 
		{
			throw new RuntimeException(e);
		}
		
		
	}
}

	

	
	
	
	
		
	

