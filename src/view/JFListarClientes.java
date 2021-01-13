package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import model.bean.Cliente;
import model.bean.Filme;
import model.dao.ClienteDAO;
import model.dao.FilmeDAO;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class JFListarClientes extends JFrame {

	private JPanel contentPane;
	private JTable JTClientes;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFListarClientes frame = new JFListarClientes();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public JFListarClientes() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 743, 420);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Listar Clientes");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setBounds(15, 16, 124, 20);
		contentPane.add(lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(15, 52, 668, 235);
		contentPane.add(scrollPane);
		
		JTClientes = new JTable();
		JTClientes.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
			},
			new String[] {
				"IDCliente", "Nome", "CPF", "Endere\u00E7o", "Email", "Telefone", "Data de Nascimento"
			}
		));
		JTClientes.getColumnModel().getColumn(0).setPreferredWidth(76);
		JTClientes.getColumnModel().getColumn(1).setPreferredWidth(54);
		JTClientes.getColumnModel().getColumn(2).setPreferredWidth(45);
		JTClientes.getColumnModel().getColumn(4).setPreferredWidth(54);
		JTClientes.getColumnModel().getColumn(6).setPreferredWidth(156);
		scrollPane.setViewportView(JTClientes);
		
		JButton btnCadastrar = new JButton("Cadastrar Cliente");
		btnCadastrar.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnCadastrar.setBounds(15, 319, 198, 29);
		contentPane.add(btnCadastrar);
		
		JButton btnExcluir = new JButton("Excluir Cliente");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(JTClientes.getSelectedRow() != -1) {
					
					int opcao = JOptionPane.showConfirmDialog(null, "Você deseja excluir o cliente selecionado?", "Exclusão", JOptionPane.YES_NO_OPTION); // janela de confirmação de exclusão
					
					if(opcao == 0) {
						ClienteDAO dao = new ClienteDAO();
						Cliente c = new Cliente();
						c.setIDCliente((int) JTClientes.getValueAt(JTClientes.getSelectedRow(),0));
						dao.delete(c);
					}
					//operacao do botao
				} else {
					JOptionPane.showMessageDialog(null, "Selecione um cliente!");
				}
				readJTCliente();
			}
		});
		btnExcluir.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnExcluir.setBounds(401, 319, 163, 29);
		contentPane.add(btnExcluir);
		
		JButton btnEditar = new JButton("Editar Cliente");
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// verificar se uma linha foi selecionada
				if(JTClientes.getSelectedRow() != -1) {
					JFAtualizarCliente at = new JFAtualizarCliente(
					(int)JTClientes.getValueAt(JTClientes.getSelectedRow(), 0)); 
					// passo o id do filme que quero editar
					at.setVisible(true); // deixa a tela de edição visível
				} else {
					JOptionPane.showMessageDialog(null, "Selecione um cliente!");
				}
				readJTCliente();// dá um refresh na tabela com os dados atualizados
			}
		});
				
		btnEditar.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnEditar.setBounds(228, 319, 153, 29);
		contentPane.add(btnEditar);
		
		readJTCliente();
}
	
	
	public void readJTCliente() {
	DefaultTableModel modelo = (DefaultTableModel) JTClientes.getModel(); // pega o modelo da tabela
	modelo.setNumRows(0); // número inicial de linhas
	ClienteDAO cdao = new ClienteDAO();	
	for(Cliente c : cdao.read()) {
		modelo.addRow(new Object[] {
				c.getIDCliente(),
				c.getNome(),
				c.getCpf(),
				c.getEndereco(),
				c.getEmail(),
				c.getTelefone(),
				c.getData_nasc()
		});
	}
	
	}
	
}
		
		


