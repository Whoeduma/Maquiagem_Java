package crud;

import java.sql.Connection;
import java.sql.DriverManager;

public class conexao {
	public static Connection conectar() {
		Connection conn = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/duda_coiffeur",
					"root",
					""
					);
			System.out.println("✅ Conectado com sucesso!");
		} catch (Exception e) {
			System.out.println("❌ Erro ao conectar: " + e.getMessage());
		}
		return conn;
	}

}
