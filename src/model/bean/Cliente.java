package model.bean;

public class Cliente {
	private String nome;
	private String cpf;
	private String endereco;
	private String email;
	private String telefone;
	private String data_nasc;
	private int IDCliente;
	
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public void setData_nasc(String data_nasc) {
		this.data_nasc = data_nasc;
	}
	
	public String getData_nasc() {
		return data_nasc;
	}
	public int getIDCliente() {
		return IDCliente;
	}
	public void setIDCliente(int IDCliente) {
		this.IDCliente= IDCliente;
	}
}