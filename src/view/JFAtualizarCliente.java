package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import model.bean.Cliente;
import model.dao.ClienteDAO;
import model.dao.FilmeDAO;

public class JFAtualizarCliente extends JFrame {

	private JPanel contentPane;
	private JTextField txtNome;
	private JTextField txtCpf;
	private JTextField txtEndereco;
	private JTextField txtEmail;
	private JTextField txtTelefone;
	private JTextField txtData;
	
	private static int id;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFAtualizarCliente frame = new JFAtualizarCliente(id);
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
	public JFAtualizarCliente(int id) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 488, 586);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Atualizar Cliente");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setBounds(15, 16, 149, 22);
		contentPane.add(lblNewLabel);
		
		ClienteDAO cdao = new ClienteDAO();
		Cliente c = cdao.read(id); //chama o metódo read que vai setar todos os atributos do objeto f com esse id
				
		JLabel lblNewLabel_7 = new JLabel("ID do filme");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_7.setBounds(174, 18, 101, 20);
		contentPane.add(lblNewLabel_7);
		
		JLabel lblID = new JLabel("New label");
		lblID.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblID.setBounds(279, 18, 101, 20);
		contentPane.add(lblID);
		
		JLabel lblNewLabel_1 = new JLabel("Nome ");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1.setBounds(15, 54, 52, 20);
		contentPane.add(lblNewLabel_1);
		
		txtNome = new JTextField();
		txtNome.setBounds(15, 77, 436, 26);
		contentPane.add(txtNome);
		txtNome.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("Data de Nascimento");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_6.setBounds(15, 119, 175, 20);
		contentPane.add(lblNewLabel_6);
		
		txtData = new JTextField();
		txtData.setBounds(15, 143, 435, 26);
		contentPane.add(txtData);
		txtData.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("CPF");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_2.setBounds(15, 175, 42, 20);
		contentPane.add(lblNewLabel_2);
		
		txtCpf = new JTextField();
		txtCpf.setBounds(15, 200, 436, 26);
		contentPane.add(txtCpf);
		txtCpf.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Endere\u00E7o");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_3.setBounds(15, 242, 89, 20);
		contentPane.add(lblNewLabel_3);
		
		txtEndereco = new JTextField();
		txtEndereco.setBounds(15, 269, 436, 26);
		contentPane.add(txtEndereco);
		txtEndereco.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Email");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_4.setBounds(15, 311, 58, 20);
		contentPane.add(lblNewLabel_4);
		
		txtEmail = new JTextField();
		txtEmail.setBounds(15, 335, 436, 26);
		contentPane.add(txtEmail);
		txtEmail.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Telefone");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_5.setBounds(15, 377, 89, 20);
		contentPane.add(lblNewLabel_5);
		
		txtTelefone = new JTextField();
		txtTelefone.setBounds(15, 402, 436, 26);
		contentPane.add(txtTelefone);
		txtTelefone.setColumns(10);
		
		// coloca os dados na tela
				lblID.setText(String.valueOf(c.getIDCliente()));
				txtNome.setText(c.getNome());
				txtData.setText(c.getData_nasc());
				txtCpf.setText(c.getCpf());
				txtEndereco.setText(c.getEndereco());
				txtEmail.setText(c.getEmail());
				txtTelefone.setText(c.getTelefone());
		
		
		JButton btnAlterar = new JButton("Alterar");
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Cliente c = new Cliente();
				ClienteDAO dao = new ClienteDAO();
				
				c.setIDCliente(Integer.parseInt(lblID.getText()));
				c.setNome(txtNome.getText());
				c.setCpf(txtCpf.getText());
				c.setData_nasc(txtData.getText());
				c.setEmail(txtEmail.getText());
				c.setEndereco(txtEndereco.getText());
				c.setTelefone(txtTelefone.getText());
				
				dao.update(c);
				dispose();
			}
		});
		
		btnAlterar.setBounds(10, 400, 89, 23);
		contentPane.add(btnAlterar);
				
		btnAlterar.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnAlterar.setBounds(15, 485, 115, 29);
		contentPane.add(btnAlterar);
		
		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtNome.setText(null);
				txtCpf.setText(null);
				txtEndereco.setText(null);
				txtEmail.setText(null);
				txtTelefone.setText(null);
				txtData.setText(null);
			}
		});
		btnLimpar.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnLimpar.setBounds(171, 485, 115, 29);
		contentPane.add(btnLimpar);
		
		JButton btnCancelar = new JButton("Cancelar ");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCancelar.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnCancelar.setBounds(335, 485, 115, 29);
		contentPane.add(btnCancelar);
		
		
	}
}
