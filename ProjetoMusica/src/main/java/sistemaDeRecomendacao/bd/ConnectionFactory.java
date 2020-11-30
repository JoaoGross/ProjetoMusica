package sistemaDeRecomendacao.bd;
import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {
	private String usuario = "root";
	private String senha = "261199";
	private String host = "localhost";
	private String porta = "3306";
	private String bd = "projeto";

	public Connection obterConexao () throws Exception{
		Connection c = null;
		try{
			c = DriverManager.getConnection(
					"jdbc:mysql://" + host + ":" + porta + "/" + bd  + "?useTimezone=true&serverTimezone=UTC",
					usuario,
					senha
					);
			return c;
		}
		catch (Exception e){
			e.printStackTrace();
			return null;
		}
	}}
	


