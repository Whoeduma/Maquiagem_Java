package crud;

import java.sql.*;
import java.util.*;


public class MaquiagemCrud {
	//salvar a maquiagem no banco
	public static void criar(Maquiagem m) {
		try {
			// CONEXÃO: chama o "telefone" para o banco
			Connection conn = conexao.conectar();
			
			// COMANDO SQL: o que vamos falar pro banco fazer
			String sql = "INSERT INTO maquiagem (marca, tipo, cor) VALUES (?, ?, ?)";
			
			//PREPAREDSTATEMENT: prepara o que vai ser enviado
			PreparedStatement stmt = conn.prepareStatement(sql);
			
			
			//// DIZENDO os valores para cada ?
			stmt.setString(1, m.getMarca());
			stmt.setString(2, m.getTipo());
			stmt.setString(3, m.getCor());
			
			// ENVIA o comando pro banco
			stmt.executeUpdate();
			
			//fecha tudo 
			stmt.close();
			conn.close();
			
			System.out.println("✅ Maquiagem salva no banco!");
		} catch (Exception e) {
			System.out.println("❌ Erro ao salvar: " + e.getMessage());
		}
		
	}
	// LER todas as maquiagens do banco
	public static List<Maquiagem> lerMaquiagens() throws Exception {
		List<Maquiagem> lista = new ArrayList<>();
		
		// Liga pro banco
		Connection conn = conexao.conectar();
		
		//Pede todas as maquiagens
		String sql = "SELECT * FROM maquiagem";
		PreparedStatement stmt = conn.prepareStatement(sql);
		
		//Recebe o resultado
		ResultSet rs = stmt.executeQuery();
		
		//Enquanto tiver maquiagem, adiciona na lista
		while (rs.next()) {
			int id = rs.getInt("id");
			String marca = rs.getString("marca");
			String tipo = rs.getString("tipo");
			String cor = rs.getString("cor");
			
			Maquiagem m = new Maquiagem(id, marca, tipo, cor);
			lista.add(m);
		}
		rs.close();
		stmt.close();
	return lista;	
	}

    //ATUALIZAR uma maquiagem já existente
	public static void atualizarMaquiagem(int id, Maquiagem nova) throws Exception {
		// Liga pro banco
			Connection conn = conexao.conectar();
		// ✏️ Diz o que vamos atualizar
			String sql = "UPDATE maquiagem SET marca = ?, tipo = ?, cor = ? WHERE id = ?";
			PreparedStatement stmt = conn.prepareStatement(sql);
			
		//Preenche os"?"
			stmt.setString(1, nova.getMarca());
			stmt.setString(2, nova.getTipo());
			stmt.setString(3, nova.getCor());
			stmt.setInt(4, id); //usa o ID certo
			
			// 📤 Envia pro banco
			stmt.executeUpdate();
			
			// Fecha tudo
	        stmt.close();
	        conn.close();
			
	}
	
	//Deletar uma maquiagem com base no ID
	public static void deletarMaquiagem(int id) throws Exception {
		//liga pro banco
		Connection conn = conexao.conectar();
		
		//diz pro banco deletar a maquiagem
		String sql = "DELETE FROM maquiagem WHERE id = ?";
		PreparedStatement stmt = conn.prepareStatement(sql);
		
		//preenche o ?
		stmt.setInt(1, id);
		
		//envia pro banco 
		stmt.executeUpdate();
		
		//fecha tudo 
		stmt.close();
		conn.close();
	}
}