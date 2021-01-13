package model.dao;

import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import connection.ConnectionFactory;
import model.bean.Filme;

public class FilmeDAO {
	
	public void create(Filme f) {
		Connection con = ConnectionFactory.getConnection(); // cria uma conexão
		PreparedStatement stmt = null; // conexão que informa os comandos sql
		
		try {
			stmt = con.prepareStatement("INSERT INTO FILME (titulo, categoria, sinopse, tempo, imagem3d, classificacao, status_filme, dublado) VALUES"
					+ "(?,?,?,?,?,?,?,?)");
			stmt.setString(1, f.getTitulo());
			stmt.setString(2, f.getCategoria());
			stmt.setString(3, f.getSinopse());
			stmt.setInt(4, f.getTempo());
			stmt.setBoolean(5, f.isImagem3d());
			stmt.setString(6, f.getClassificacao());
			stmt.setBoolean(7, f.isStatus_filme());
			stmt.setBoolean(8, f.isDublado());
			
			stmt.executeUpdate();
			JOptionPane.showMessageDialog(null, "Filme cadastrado com sucesso!");
		} catch(SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro ao salvar: "+ e);
		}finally{
			ConnectionFactory.closeConnection(con, stmt);
		}
	}
	
	public List<Filme> read() { // classe que irá buscar os dados no banco
		Connection con = ConnectionFactory.getConnection(); // cria conexão
		PreparedStatement stmt = null; // sql
		ResultSet rs = null; // dados serão retornados aqui
		List<Filme> filmes = new ArrayList(); // estrutura onde os dados serão armazendados
		
		try {
		stmt = con.prepareStatement("SELECT * FROM filme;"); // sql 
		rs = stmt.executeQuery(); // executa sql
		while(rs.next()) { // cria os objetos da classe Filme conforme os registros do banco
			Filme f = new Filme();
			f.setIdFilme(rs.getInt("IdFilme"));
			f.setTitulo(rs.getString("titulo"));
			f.setTempo(rs.getInt("tempo"));
			f.setSinopse(rs.getString("sinopse"));
			f.setCategoria(rs.getString("categoria"));
			f.setImagem3d(rs.getBoolean("imagem3d"));
			f.setDublado(rs.getBoolean("dublado"));
			f.setClassificacao(rs.getString("classificacao"));
			f.setStatus_filme(rs.getBoolean("status_filme"));
			filmes.add(f); // adiciona os resgistros do banco nesse array
		}
	} catch (SQLException e) {
		JOptionPane.showMessageDialog(null, "Erro ao buscar as informações do BD: " + e); // caso der errado
		e.printStackTrace();
	} finally {
		ConnectionFactory.closeConnection(con, stmt, rs); // fecha a conexão
	}
	return filmes; // retorna o array com os registros
  }

	public Filme read(int IdFilme) { // lista um filme
		Connection con = ConnectionFactory.getConnection();// estabelece conexão
		PreparedStatement stmt = null; // sql
		ResultSet rs = null; // executa a query
		Filme f = new Filme(); // objeto que vai receber o filme
	
			try {
				stmt = con.prepareStatement("SELECT * FROM filme WHERE idFilme=? LIMIT 1;");
				stmt.setInt(1, IdFilme);
				rs = stmt.executeQuery();// executa o comando sql
				if(rs != null && rs.next()) {
					f.setIdFilme(rs.getInt("idFilme"));
					f.setTitulo(rs.getString("titulo"));
					f.setTempo(rs.getInt("tempo"));
					f.setSinopse(rs.getString("sinopse"));
					f.setCategoria(rs.getString("categoria"));
					f.setImagem3d(rs.getBoolean("imagem3d"));
					f.setDublado(rs.getBoolean("dublado"));
					f.setClassificacao(rs.getString("classificacao"));
					f.setStatus_filme(rs.getBoolean("status_filme"));
				}		
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				ConnectionFactory.closeConnection(con, stmt, rs); // fecha a conexão
			}
			return f; // retorna o filme
		}
		
	public void update(Filme f) { // atualiza um filme
		Connection con = ConnectionFactory.getConnection(); // estabelece conexão
		PreparedStatement stmt = null; // sql
		
		try {
			stmt = con.prepareStatement("UPDATE filme SET titulo=?, categoria=?, sinopse=?,"
					+ "tempo=?, imagem3d=?, dublado=?, status_filme=?, classificacao=? WHERE idFilme=?;");
			stmt.setString(1, f.getTitulo());
			stmt.setString(2, f.getCategoria());
			stmt.setString(3, f.getSinopse());
			stmt.setInt(4, f.getTempo());
			stmt.setBoolean(5, f.isImagem3d());
			stmt.setBoolean(6, f.isDublado());
			stmt.setBoolean(7, f.isStatus_filme());
			stmt.setString(8, f.getClassificacao());
			stmt.setInt(9, f.getIdFilme());
			stmt.executeUpdate();
			JOptionPane.showMessageDialog(null, "Filme atualizado com sucesso!");
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro ao atualizar: "+ e);
		}finally {
			ConnectionFactory.closeConnection(con, stmt);
		}
	  }
	
	public void delete(Filme f) { // método que deleta um filme
		Connection con = ConnectionFactory.getConnection(); // estabelece a conexão
		PreparedStatement stmt = null; // armazena o sql
		
		try {
			stmt = con.prepareStatement("DELETE FROM filme WHERE IdFilme=?");
			stmt.setInt(1,f.getIdFilme()); // seta o id
			stmt.executeUpdate(); // executa o sql
			JOptionPane.showMessageDialog(null, "Filme excluído com sucesso!");
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro ao exlcuir filme: " + e);
		} finally {
			ConnectionFactory.closeConnection(con, stmt);
		}
		
       }
	}