package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

import connection.ConnectionFactory;
import model.bean.Cliente;
import model.bean.Filme;


public class ClienteDAO {
	
	public void create(Cliente f) {
		Connection con = ConnectionFactory.getConnection(); // cria uma conexão
		PreparedStatement stmt = null; // conexão que informa os comandos sql
		
		try {
			stmt = con.prepareStatement("INSERT INTO CLIENTE (nome, cpf, endereco, email, telefone, data_nasc) VALUES"
					+ "(?,?,?,?,?,?)");
			stmt.setString(1, f.getNome());
			stmt.setString(2, f.getCpf());
			stmt.setString(3, f.getEndereco());
			stmt.setString(4, f.getEmail());
			stmt.setString(5, f.getTelefone());
			stmt.setString(6, f.getData_nasc());
			
			
			stmt.executeUpdate();
			JOptionPane.showMessageDialog(null, "Cliente cadastrado com sucesso!");
		} catch(SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro ao cadastrar cliente: "+ e);
		}finally{
			ConnectionFactory.closeConnection(con, stmt);
		}
	}
	public List<Cliente> read() { // classe que irá buscar os dados no banco
		Connection con = ConnectionFactory.getConnection(); // cria conexão
		PreparedStatement stmt = null; // sql
		ResultSet rs = null; // dados serão retornados aqui
		List<Cliente> clientes = new ArrayList(); // estrutura onde os dados serão armazendados
		
		try {
		stmt = con.prepareStatement("SELECT * FROM cliente;"); // sql 
		rs = stmt.executeQuery(); // executa sql
		while(rs.next()) { // cria os objetos da classe Filme conforme os registros do banco
			Cliente c = new Cliente();
			c.setIDCliente(rs.getInt("IDCliente"));
			c.setNome(rs.getString("nome"));
			c.setCpf(rs.getString("cpf"));
			c.setEndereco(rs.getString("endereco"));
			c.setEmail(rs.getString("email"));
			c.setTelefone(rs.getString("telefone"));
			c.setData_nasc(rs.getString("data_nasc"));
			clientes.add(c); // adiciona os resgistros do banco nesse array
		}
	} catch (SQLException e) {
		JOptionPane.showMessageDialog(null, "Erro ao buscar as informações do BD: " + e); // caso der errado
		e.printStackTrace();
	} finally {
		ConnectionFactory.closeConnection(con, stmt, rs); // fecha a conexão
	}
	return clientes; // retorna o array com os registros
  }
	
	public Cliente read(int IdCliente) { // método que lista um cliente
		Connection con = ConnectionFactory.getConnection();// estabelece conexão
		PreparedStatement stmt = null; // sql
		ResultSet rs = null; // executa a query
		Cliente c = new Cliente(); // objeto que vai receber o cliente
	
			try {
				stmt = con.prepareStatement("SELECT * FROM cliente WHERE idCliente=? LIMIT 1;");
				stmt.setInt(1, IdCliente); // recebe a variável do método
				rs = stmt.executeQuery();// executa o comando sql
				if(rs != null && rs.next()) { // se não está nulo e se existe alguém além só retorna um único valor
					c.setIDCliente(rs.getInt("IdCliente"));
					c.setNome(rs.getString("nome"));
					c.setEndereco(rs.getString("endereco"));
					c.setCpf(rs.getString("cpf"));
					c.setEmail(rs.getString("email"));
					c.setTelefone(rs.getString("telefone"));
					c.setData_nasc(rs.getString("data_nasc"));
				}		
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				ConnectionFactory.closeConnection(con, stmt, rs); // fecha a conexão
			}
			return c; // retorna o cliente
		}
	
	public void update(Cliente c) { // método que atualiza os dados do cliente
		Connection con = ConnectionFactory.getConnection(); // estabelece conexão
		PreparedStatement stmt = null; // sql
		
		try {
			stmt = con.prepareStatement("UPDATE cliente SET nome=?, cpf=?, endereco=?,"
					+ "email=?, telefone=?, data_nasc=? WHERE idCliente=?;");
			stmt.setString(1, c.getNome());
			stmt.setString(2, c.getCpf());
			stmt.setString(3, c.getEndereco());
			stmt.setString(4, c.getEmail());
			stmt.setString(5, c.getTelefone());
			stmt.setString(6, c.getData_nasc());
			stmt.setInt(7, c.getIDCliente());
			stmt.executeUpdate();
			JOptionPane.showMessageDialog(null, "Cliente atualizado com sucesso!");
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro ao atualizar: "+ e);
		}finally {
			ConnectionFactory.closeConnection(con, stmt);
		}
	  }
	
	

}